package com.edu.common.utils;

/**
 * twitter的一个id生成算法

Twitter-Snowflake算法产生的背景相当简单，为了满足Twitter每秒上万条消息的请求�?
每条消息都必须分配一条唯�?的id，这些id还需要一些大致的顺序（方便客户端排序），
并且在分布式系统中不同机器产生的id必须不同�?
 * 000000000000 
 * 1位标识，由于long基本类型在Java中是带符号的，最高位是符号位，正数是0，负数是1，所以id�?般是正数，最高位�?0<br>
 * 41位时间截(毫秒�?)，注意，41位时间截不是存储当前时间的时间截，�?�是存储时间截的差�?�（当前时间�? - �?始时间截)
 * 得到的�?�），这里的的开始时间截，一般是我们的id生成器开始使用的时间
 * ，由我们程序来指定的（如下下面程序IdWorker类的startTime属�?�）�?41位的时间截，可以使用69年，年T = (1L << 41) /
 * (1000L * 60 * 60 * 24 * 365) = 69<br>
 * 10位的数据机器位，可以部署�?1024个节点，包括5位datacenterId�?5位workerId<br>
 * 12位序列，毫秒内的计数�?12位的计数顺序号支持每个节点每毫秒(同一机器，同�?时间�?)产生4096个ID序号<br>
 * 加起来刚�?64位，为一个Long型�??<br>
 * SnowFlake的优点是，整体上按照时间自增排序，并且整个分布式系统内不会产生ID碰撞(由数据中心ID和机器ID作区�?)，并且效率较高，经测试，
 * SnowFlake每秒能够产生26万ID左右�?*/
public class IdGenerator {

	/** �?始时间截 (2015-01-01) */
    private final long twepoch = 1420041600000L;

    /** 机器id�?占的位数 */
    private final long workerIdBits = 5L;

    /** 数据标识id�?占的位数 */
    private final long datacenterIdBits = 5L;

    /** 支持的最大机器id，结果是31 (这个移位算法可以很快的计算出几位二进制数�?能表示的�?大十进制�?) */
    private final long maxWorkerId = -1L ^ (-1L << workerIdBits);

    /** 支持的最大数据标识id，结果是31 */
    private final long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);

    /** 序列在id中占的位�? */
    private final long sequenceBits = 12L;

    /** 机器ID向左�?12�? */
    private final long workerIdShift = sequenceBits;

    /** 数据标识id向左�?17�?(12+5) */
    private final long datacenterIdShift = sequenceBits + workerIdBits;

    /** 时间截向左移22�?(5+5+12) */
    private final long timestampLeftShift = sequenceBits + workerIdBits
            + datacenterIdBits;

    /** 生成序列的掩码，这里�?4095 (0b111111111111=0xfff=4095) */
    private final long sequenceMask = -1L ^ (-1L << sequenceBits);

    /** 工作机器ID(0~31) */
    private long workerId;

    /** 数据中心ID(0~31) */
    private long datacenterId;

    /** 毫秒内序�?(0~4095) */
    private long sequence = 0L;

    /** 上次生成ID的时间截 */
    private long lastTimestamp = -1L;

    /**
     * 构�?�函�?
     * 
     * @param workerId
     *            工作ID (0~31)
     * @param datacenterId
     *            数据中心ID (0~31)
     */
    public IdGenerator(long workerId, long datacenterId) {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format(
                    "worker Id can't be greater than %d or less than 0",
                    maxWorkerId));
        }
        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new IllegalArgumentException(String.format(
                    "datacenter Id can't be greater than %d or less than 0",
                    maxDatacenterId));
        }
        this.workerId = workerId;
        this.datacenterId = datacenterId;
    }

    public IdGenerator() {
    	 this.workerId = 0l;
         this.datacenterId = 0l;
    };

    /**
     * 获得下一个ID (该方法是线程安全�?)
     * 
     * @return SnowflakeId
     */
    public synchronized long nextId() {
        long timestamp = timeGen();

        // 如果当前时间小于上一次ID生成的时间戳，说明系统时钟回�?过这个时候应当抛出异�?
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(
                    String.format(
                            "Clock moved backwards.  Refusing to generate id for %d milliseconds",
                            lastTimestamp - timestamp));
        }

        // 如果是同�?时间生成的，则进行毫秒内序列
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            // 毫秒内序列溢�?
            if (sequence == 0) {
                // 阻塞到下�?个毫�?,获得新的时间�?
                timestamp = tilNextMillis(lastTimestamp);
            }
        }
        // 时间戳改变，毫秒内序列重�?
        else {
            sequence = 0L;
        }

        // 上次生成ID的时间截
        lastTimestamp = timestamp;

        // 移位并�?�过或运算拼到一起组�?64位的ID
        return ((timestamp - twepoch) << timestampLeftShift) //
                | (datacenterId << datacenterIdShift) //
                | (workerId << workerIdShift) //
                | sequence;
    }

    /**
     * 阻塞到下�?个毫秒，直到获得新的时间�?
     * 
     * @param lastTimestamp
     *            上次生成ID的时间截
     * @return 当前时间�?
     */
    protected long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    /**
     * 返回以毫秒为单位的当前时�?
     * 
     * @return 当前时间(毫秒)
     */
    protected long timeGen() {
        return System.currentTimeMillis();
    }

}
