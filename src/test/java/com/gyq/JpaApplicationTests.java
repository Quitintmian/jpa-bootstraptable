package com.gyq;

import com.gyq.entity.Student;
import com.gyq.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;


@SpringBootTest
class JpaApplicationTests {

    @Resource
    StudentService studentService;

    @Test
    public void findAllTest(){
        List<Student> studentList = studentService.findAll();
        Assert.notNull(studentList);
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Test
    public void findById(){
        Long id = 6L;
        Student student = studentService.getStudentById(id);
        System.out.println(student);
    }

    @Test
    public void addTest(){
        Student student = new Student();
        student.setName("胡廷炜");
        student.setPassword("2019131205");
        student.setSex(0);
        student.setAge(20);
        studentService.addStudent(student);
    }

    @Test
    public void addTest2(){
        Student student = new Student();
        student.setName("new Person");
        student.setPassword("XMl6149494");
        student.setSex(1);
        student.setAge(22);
        studentService.addStudent(student);
    }

    @Test
    public void updateTest(){
        Long id = 2L;
        Student student = studentService.getStudentById(id);
        student.setName("小刚");
        student.setPassword("951753");
        studentService.updateStudent(student);
    }

    @Test
    public void deleteTest(){
        Long id = 5L;
        studentService.deleteById(id);
    }

    @Test
    public void LikeTest(){
        List<Student> studentList = studentService.findByNameLike("%胡%");
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Test
    public void QueryTest(){
        List<Student> studentList = studentService.find2("胡");
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Test
    public void MaxAgeTest(){
        List<Student> studentList = studentService.findMaxAgeStudent();
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}
