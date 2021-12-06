package com.gyq.controller;

import com.alibaba.fastjson.JSONObject;
import com.gyq.entity.Student;
import com.gyq.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping ("/list")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/queryByName")
    public List<Student> queryByName(@RequestParam("name") String name){
        return studentService.findByNameLike("%"+name+"%");
    }

    @DeleteMapping ("/delete")
    public String deleteAll() {
        studentService.delete();
        return "删除成功";
    }

    @RequestMapping("/find/{id}")
    public String findById(@PathVariable("id") Long id) {
        Student stu = studentService.getStudentById(id);
        return stu == null ? "查无此人" : JSONObject.toJSONString(stu);
    }

    @PostMapping("/add")
    public String add(@RequestBody Student student){
        return studentService.addStudent(student) != null ? "添加成功" : "添加失败";
    }

    @PostMapping("/update")
    public String updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
        return "更新成功";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") Long id){
        studentService.deleteById(id);
        return "删除成功";
    }
}
