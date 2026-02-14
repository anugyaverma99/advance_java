package com.test.hibernate.hibernate_relationships;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Person;
import entity.Passport;

public class App {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Passport.class)
                .buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            Passport passport = new Passport();
            passport.setPassportNumber("IND12345");
            passport.setCountry("India");

            Person person = new Person();
            person.setName("Anugya");
            person.setPassport(passport);

            session.persist(person);

            tx.commit();

            System.out.println("Saved successfully");

        } catch (Exception e) {

            if (tx != null) {
                tx.rollback();
            }

            e.printStackTrace();

        } finally {

            session.close();
            factory.close();
        }
    }
}
