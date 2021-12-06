package com.gyq.api;

import com.alibaba.fastjson.JSONObject;
import com.gyq.entity.Student;
import com.gyq.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/test")
public class StudentApiController {

    @Autowired
    private StudentService studentService;
    @PostMapping("/query")
    public Map<String,Object> query(String name,Integer page,Integer rows){
        return studentService.query(name,page,rows);
    }

    @DeleteMapping("{id}")
    public String deleteById(@PathVariable("id") Long id){
        studentService.deleteById(id);
        return "删除成功";
    }

    @GetMapping("{id}")
    public Student findById(@PathVariable("id") Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("/save")
    public String updateStudent(Student student){
        studentService.updateStudent(student);
        return "保存成功";
    }
}
