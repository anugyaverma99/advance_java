package com.test.spring.hibernate_mapping;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.*;

public class Main {

    public static void main(String[] args) {

        Configuration cfg = new Configuration().configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        
        Department dept = new Department(1, "Computer Science");

    
        Student_class s1 = new Student_class(101, "Rahul");
        Student_class s2 = new Student_class(102, "Priya");


        s1.setDepartment(dept);
        s2.setDepartment(dept);

        dept.getStudents().add(s1);
        dept.getStudents().add(s2);

        
        Student_ID_Card card1 = new Student_ID_Card(1, 5001);
        Student_ID_Card card2 = new Student_ID_Card(2, 5002);

        s1.setIdCard(card1);
        s2.setIdCard(card2);

       
        Course c1 = new Course(201, "Java");
        Course c2 = new Course(202, "Hibernate");

        
        s1.setCourses(Arrays.asList(c1, c2));
        s2.setCourses(Arrays.asList(c1));

       
        session.persist(dept);
        session.persist(c1);
        session.persist(c2);

        tx.commit();
        session.close();
        factory.close();

        System.out.println("All data saved successfully!");
    }
}