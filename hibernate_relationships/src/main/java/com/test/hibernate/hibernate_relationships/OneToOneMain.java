
package com.test.hibernate.hibernate_relationships;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Passport;
import entity.Person;


public class OneToOneMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Configuration cfg = new Configuration().configure();
        SessionFactory factory = cfg.buildSessionFactory();
        
        while(true) {
        	System.out.println("\n1. Add Person & Passport");
        	System.out.println("2. Exit");
        	System.out.println("Enter choice: ");
        	int choice = sc.nextInt();
        	sc.nextLine();
        	
        	switch (choice) {
            case 1:
                System.out.println("Enter Person name: ");
                String name = sc.nextLine();
                
                System.out.println("Enter Passport number: ");
                String passportNumber = sc.nextLine();
                
                System.out.println("Enter Country: ");
                String country = sc.nextLine();
                
                Session session = factory.openSession();
                Transaction tx = session.beginTransaction();
                
                Passport passport = new Passport(passportNumber, country);
                Person person = new Person(name, passport);
                
                session.persist(person);
                
                tx.commit();
                session.close();
                
                System.out.println("Person and Passport saved successfully");
                break;

            case 2:
            	factory.close();
            	sc.close();
                System.out.println("Exiting program...");
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        	}
        }
        
        
        
    }
}