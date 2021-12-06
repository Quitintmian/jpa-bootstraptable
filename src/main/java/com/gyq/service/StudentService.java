package com.gyq.service;

import com.gyq.dao.StudentRepository;
import com.gyq.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    // 分页查询
    public Map<String, Object> query(String name,Integer page, Integer rows) {
        Pageable pageable = PageRequest.of(page-1,rows, Sort.Direction.DESC,"id");
        Page<Student> allPage;
        if (name == null || "".equals(name)){
            allPage = studentRepository.findAll(pageable);
        }else {
            allPage = studentRepository.findByNameLike("%"+name+"%",pageable);
        }
        List<Student> list = allPage.getContent();
        long total = allPage.getTotalElements();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    // 查询所有
    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    // 通过id删除
    public void deleteById(Long id){
        studentRepository.deleteById(id);
    }

    public void delete(){
        studentRepository.deleteAll();
    }

    public Student getStudentById(Long id){
        return studentRepository.findById(id).orElse(null);
    }

    // 修改
    public void updateStudent(Student student){
        studentRepository.save(student);
    }

    // 添加
    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public List<Student> findByNameLike(String name){
        List<Student> studentList = studentRepository.findByNameLike(name);
        return studentList.size() == 0 ? null : studentList;
    }

    public List<Student> find2(String name){
        return studentRepository.find2(name);
    }

    // 查询最大年龄的
    public List<Student> findMaxAgeStudent(){
        return studentRepository.findMaxAgeStudent();
    }
}
