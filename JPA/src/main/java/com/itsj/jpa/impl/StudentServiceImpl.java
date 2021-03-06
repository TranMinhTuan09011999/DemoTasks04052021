package com.itsj.jpa.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itsj.jpa.entity.Student;
import com.itsj.jpa.service.StudentService;

@Service("studentServiceImpl")
public class StudentServiceImpl implements StudentService {

    @PersistenceContext
    private EntityManager entityManger;

    @Transactional
    public Student saveStudent(Student student) {
        entityManger.persist(student);
        return student;
    }

    @Transactional
    public Student updateStudent(Student student) {
        entityManger.merge(student);
        return student;
    }

    @Transactional
    public Student deleteStudent(Student student) {
        if (entityManger.contains(student)) {
            entityManger.remove(student);
        } else {
            entityManger.remove(entityManger.merge(student));
        }

        return student;
    }

    @Transactional
    public Student getStudent(int id) {
        Student response = (Student) entityManger.find(Student.class, id);
        return response;
    }

}
