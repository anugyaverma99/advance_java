package com.test.hibernate.hibernation;

import org.hibernate.annotations.Cache;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="menu_item")

public class MenuItems {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private double price;
	private String category;
	private boolean available;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public MenuItems(String name, double price, String category, boolean available) {
		super();
		this.name = name;
		this.price = price;
		this.category = category;
		this.available = available;
	}
	public MenuItems(int id, String name, double price, String category, boolean available) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
		this.available = available;
	}
	public MenuItems() { }
	@Override
	public String toString() {
	    return "ID: " + id +
	           ", Name: " + name +
	           ", Price: " + price +
	           ", Category: " + category +
	           ", Available: " + available;
	}

	
	
	
	

}
