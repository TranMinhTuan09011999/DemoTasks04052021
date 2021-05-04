package com.itsj.jpa.service;

import org.springframework.stereotype.Component;
import com.itsj.jpa.entity.Student;

@Component
public interface StudentService {
    public Student saveStudent(Student student);

    public Student deleteStudent(Student student);

    public Student updateStudent(Student student);

    public Student getStudent(int id);

}
