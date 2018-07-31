package com.edu.domain;

public class Address {
    private Integer id;

    private String provice;

    private String city;

    private String conuty;

    private Integer detail;

    private Integer type;

    private Integer flag;

    private String mail;

    private String no;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvice() {
        return provice;
    }

    public void setProvice(String provice) {
        this.provice = provice == null ? null : provice.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getConuty() {
        return conuty;
    }

    public void setConuty(String conuty) {
        this.conuty = conuty == null ? null : conuty.trim();
    }

    public Integer getDetail() {
        return detail;
    }

    public void setDetail(Integer detail) {
        this.detail = detail;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no == null ? null : no.trim();
    }
}