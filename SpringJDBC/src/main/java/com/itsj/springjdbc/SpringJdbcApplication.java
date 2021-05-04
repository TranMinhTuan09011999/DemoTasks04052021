package com.itsj.springjdbc;


import com.itsj.springjdbc.dao.DAO;
import com.itsj.springjdbc.model.Course;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringJdbcApplication {

    private static DAO<Course> dao;

    public SpringJdbcApplication(DAO<Course> dao) {
        this.dao = dao;
    }

    public static void main(String[] args) {

        SpringApplication.run(SpringJdbcApplication.class, args);

        System.out.println("\n Create Course ---------------------------- \n");
        Course springVue = new Course("SpringBoot", "New Course", "http://springboot");
        dao.create(springVue);

        System.out.println("\n One Course ---------------------------- \n");
        Optional<Course> firstOne = dao.get(1);
        System.out.println(firstOne.get());

        springVue.setDescription("New Course Spring Boot");
        dao.update(springVue, 4);

        dao.delete(4);

        System.out.println("\n All Course ---------------------------- \n");
        List<Course> courses = dao.list();
        courses.forEach(System.out::println);
    }

}
