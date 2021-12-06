package com.gyq.controller;

import com.gyq.entity.Student;
import com.gyq.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentThymleafController {

    @Autowired
    StudentService studentService;

    @GetMapping("/1")
    public String getList(Model model){
        List<Student> studentList = studentService.findAll();
        model.addAttribute("list",studentList);
        return "list";
    }

    @GetMapping("/1queryByName")
    public String queryByName(@RequestParam("name") String name,Model model){
        List<Student> querylist = studentService.findByNameLike("%"+name+"%");
        model.addAttribute("list",querylist);
        return "list::studentInfo";
    }
}
