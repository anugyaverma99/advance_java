package com.test.hibernate.hibernate;

import org.hibernate.Session;
import java.util.Scanner;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Student;

public class App {

    public static void main(String[] args) {

        // 1️⃣ Build SessionFactory
        SessionFactory factory = new Configuration()
                .configure() // loads hibernate.cfg.xml
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        App app = new App();
        Scanner sc=new Scanner(System.in);
       while(true) {
    	   System.out.println("Which operation do you want to perform?");
    	   System.out.print("1. Insert the student data \n2. Read the student data\n3. Update the student data\n4.Delete the student data\n5. exit\n Enter your choice: ");
    	   int n=sc.nextInt();
    	   switch(n) {
    	   case 1:
    		   app.createStudent(factory, sc);
    		   break;    		   
    	   
    	   case 2:
    		   app.readStudentById(factory,sc);
    		   break;
    	   case 3:
    		   app.updateStudent(factory, sc);
    		   break;
    	   case 4:
    		   app.deleteStudent(factory, sc);
    		   break;
    	   case 5:
    		   factory.close();
    		   System.out.println("Exiting...");
    		    return;
    		 default:
    			 System.out.println("Invalid choice");
    		   
    	   }
    	   
    		   
       }
        //app.createStudent(factory,sc);
        //app.readStudentById(factory);
        //app.updateStudent(factory, sc);
        //app.deleteStudent(factory, sc);


       // factory.close();
    }

    public void createStudent(SessionFactory factory,Scanner sc) {

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            
        	
        	 System.out.print("Enter Student ID: ");
             int id = sc.nextInt();
             sc.nextLine(); // consume newline

             System.out.print("Enter Student Name: ");
             String name = sc.nextLine();

             System.out.print("Enter Student Age: ");
             int age = sc.nextInt();
            Student student = new Student(id,name,age);

            // 3️⃣ Save
            session.persist(student);
           // 4️⃣ Commit
            transaction.commit();

            System.out.println("Student saved successfully!");

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();

        } finally {
            session.close();
        }
        
    }
    
    public void readStudentById(SessionFactory factory,Scanner scanner) {

        

        Session session = factory.openSession();

        try {

            System.out.print("Enter Student ID to fetch: ");
            int id = scanner.nextInt();

            // get() method fetches immediately from DB
            Student student = session.get(Student.class, id);
            
            System.out.println("Fetching second time...");
            Student student2 = session.get(Student.class, id);

            if (student != null) {
                System.out.println("Student Found:");
                System.out.println("ID: " + student.getId());
                System.out.println("Name: " + student.getName());
                System.out.println("Age: " + student.getAge());
            } else {
                System.out.println("Student not found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            
        }
    }
    
    public void updateStudent(SessionFactory factory, Scanner sc) {

        Session session = factory.openSession();
        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();

            System.out.print("Enter Student ID to update: ");
            int id = sc.nextInt();
            sc.nextLine(); // consume newline

            Student student = session.get(Student.class, id);

            if (student != null) {
            	System.out.print("Which data you want to update(1.student's name 2. student's age 3. both \n Enter your choice: ");
            	
            	int n1=sc.nextInt();
            	sc.nextLine();
            	switch(n1) {
            	case 1:
            		System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();
            		student.setName(newName);
            		break;
            	case 2:
            		System.out.print("Enter New Age: ");
                    int newAge = sc.nextInt();
                    student.setAge(newAge);
                    
                    break;
            		
            	case 3:
            	
            		
                System.out.print("Enter New Name: ");
                String name = sc.nextLine();

                System.out.print("Enter New Age: ");
                int age = sc.nextInt();
                
                // Update values
                student.setName(name);
                student.setAge(age);
            	}

              

                transaction.commit();

                System.out.println("Student updated successfully!");

            } else {
                System.out.println("Student not found!");
            }

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();

        } finally {
            session.close();
        }
    }
    public void deleteStudent(SessionFactory factory, Scanner sc) {

        Session session = factory.openSession();
        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();

            System.out.print("Enter Student ID to delete: ");
            int id = sc.nextInt();

            Student student = session.get(Student.class, id);

            if (student != null) {

                session.remove(student);

                transaction.commit();

                System.out.println("Student deleted successfully!");

            } else {
                System.out.println("Student not found!");
            }

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();

        } finally {
            session.close();
        }
    }


}
