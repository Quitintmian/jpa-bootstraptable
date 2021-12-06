package com.gyq.dao;

import com.gyq.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student,Long>{

    List<Student> findByNameLike(String name);

    Page<Student> findByNameLike(String name,Pageable pageable);

    @Query("select o from tb_stu o where o.name like %?1%")
    List<Student> find2(String name);

    @Query("select o from tb_stu o where o.age = (select Max(age) from tb_stu )")
    List<Student> findMaxAgeStudent();
}
