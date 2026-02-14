package com.test.hibernate.hibernate;

import org.hibernate.cfg.Configuration;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Student;

public class TestCache {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory factory = cfg.buildSessionFactory();

        Session s1 = factory.openSession();
        Student st1 = s1.get(Student.class, 1);
        s1.close();

        System.out.println("---- Second Session ----");

        Session s2 = factory.openSession();
        Student st2 = s2.get(Student.class, 1);
        s2.close();

        factory.close();
    }

}
