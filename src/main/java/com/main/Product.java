package com.main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pid")
	private int pid;
	@Column(name = "title")
	private String title;
	@Column(name = "quantity")
	private String quantity;
	@Column(name = "size")
	private String size;
	@Column(name="image")
	private String image;
	@Column(name="username")
	private String user;
	Product(){
		
	}
	public Product(String title, String quantity, String size, String image, String user) {
		super();
		this.title = title;
		this.quantity = quantity;
		this.size = size;
		this.image = image;
		this.user = user;
	}
	public void setId(int pid) {
		this.pid = pid;
	}
	public int getId() {
		return pid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	
}
