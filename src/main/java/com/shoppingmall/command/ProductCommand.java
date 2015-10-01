package com.shoppingmall.command;

import java.util.Arrays;

import com.shoppingmall.model.Product;

public class ProductCommand {
	int car_id;
	String car_name;
	int price;
	String efficiency;
	String[] fuel;
	String company;
	String gubun;
	String year;
	String car_image;
	int stock;
	String car_desc;
	
	public Product getProduct(){
		Product p = new Product();
		p.setCar_id(this.car_id);
		p.setCar_name(this.car_name);
		p.setPrice(this.price);
		p.setEfficiency(this.efficiency);
		p.setFuel(Arrays.toString(fuel));
		System.out.println(p.getFuel());
		p.setCompany(this.company);
		p.setGubun(this.gubun);
		p.setYear(this.year);
		p.setCar_image(this.car_image);
		p.setStock(this.stock);
		p.setCar_desc(this.car_desc);
		return p;
	}
	
	public int getCar_id() {
		return car_id;
	}
	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}
	public String getCar_name() {
		return car_name;
	}
	public void setCar_name(String car_name) {
		this.car_name = car_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getEfficiency() {
		return efficiency;
	}
	public void setEfficiency(String efficiency) {
		this.efficiency = efficiency;
	}
	
	public String[] getFuel() {
		return fuel;
	}
	public void setFuel(String[] fuel) {
		this.fuel = fuel;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getGubun() {
		return gubun;
	}
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getCar_image() {
		return car_image;
	}
	public void setCar_image(String car_image) {
		this.car_image = car_image;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getCar_desc() {
		return car_desc;
	}
	public void setCar_desc(String car_desc) {
		this.car_desc = car_desc;
	}
	
	

}
