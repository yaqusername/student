package com.edu.web.controller;

import com.edu.domain.Student;
import com.edu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author Create By 407139407
 * @Date 2018/8/11 0011
 * @Time 10:04
 */
@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    //添加
    @RequestMapping("/add.do")
     String save(Student student){
        if (studentService.save(student)){
            System.out.print("添加成功");
        }else{
            System.out.print("添加失败");
        }return "index";
    }

    //删除
    @RequestMapping("/del.do")
    public String delete(int id){
        if(studentService.delete(id)){
            System.out.print("OK");
        }else{
            System.out.print("Error");
        }return null;
    }

    //修改
    @RequestMapping("/update.do")
    public String update(Student student){
        if(studentService.update(student)){
            System.out.print("ok");
        }else{
            System.out.print("Error");
        }return "index";
    }

    //查询列表
    @RequestMapping("/list.do")
    @ResponseBody
    public List<Student> queryAll(){
        return studentService.queryAll();
    }
}
