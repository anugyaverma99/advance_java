package com.test.hibernate.hibernation;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Student;

public class App {
    public static void main(String[] args) {
    	
    	SessionFactory factory = new Configuration()
                .configure() // loads hibernate.cfg.xml
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        App app = new App();
        Scanner sc=new Scanner(System.in);
        while(true) {
        	System.out.println("Which operation do you want to perform\n1. Add Menu Item\n2. View All Items\n3.Update Price\n4.Delete Item\n5.exit");
        	int n=sc.nextInt();
        	switch(n) {
     	   case 1:
     		   app.addMenuItem(factory, sc);
     		   break;    		   
     	   
     	   case 2:
     		   app.viewAllItems(factory);
     		   break;
     	   case 3:
     		   app.updatePrice(factory, sc);
     		   break;
     	   case 4:
     		   app.deleteItem(factory, sc);
     		   break;
     	   case 5:
     		   factory.close();
     		   System.out.println("Exiting...");
     		    return;
     		 default:
     			 System.out.println("Invalid choice");
     		   
     	   }
        	
        }
        
    }
    public void addMenuItem(SessionFactory factory,Scanner sc) {
    	 Session session = factory.openSession();
         Transaction tx = session.beginTransaction();

         System.out.print("Enter item name: ");
         sc.nextLine();
         String name = sc.nextLine();

         System.out.print("Enter Price: ");
         double price = sc.nextDouble();

         System.out.print("Enter Category: ");
         sc.nextLine();
         String category = sc.nextLine();

         System.out.print("Available (true/false): ");
         boolean available = sc.nextBoolean();

         MenuItems item = new MenuItems(name, price, category, available);

         session.persist(item);
         tx.commit();
         session.close();

         System.out.println("Menu Item Added Successfully!");

            
        
    }
    public void viewAllItems(SessionFactory factory) {
    	
    	Session session = factory.openSession();

        List<MenuItems> items =
                session.createQuery("FROM MenuItems", MenuItems.class).list();

        for (MenuItems item : items) {
            System.out.println(item);
        }

        session.close();
    }
    public void updatePrice(SessionFactory factory,Scanner sc) {

    	 Session session = factory.openSession();
         Transaction tx = session.beginTransaction();

         System.out.print("Enter ID to update: ");
         int id = sc.nextInt();

         MenuItems item = session.get(MenuItems.class, id);

         if (item != null) {
             System.out.print("Enter New Price: ");
             double newPrice = sc.nextDouble();
             item.setPrice(newPrice);
             tx.commit();
             System.out.println("Price Updated!");
         } else {
             System.out.println("Item Not Found!");
         }

         session.close();
            
    }
    private void deleteItem(SessionFactory factory, Scanner sc) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();

        MenuItems item = session.get(MenuItems.class, id);

        if (item != null) {
            session.remove(item);
            tx.commit();
            System.out.println("Item Deleted!");
        } else {
            System.out.println("Item Not Found!");
        }

        session.close();
    }
}
