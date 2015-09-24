package com.shoppingmall.command;

import java.util.Date;

public class ProductCommand {
	String productCode;
	String productName;
	String price;
	String mileage;
	String[] fuel;
	String company;
	String divide;
	Date showday;
	
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getMileage() {
		return mileage;
	}
	public void setMileage(String mileage) {
		this.mileage = mileage;
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
	public String getDivide() {
		return divide;
	}
	public void setDivide(String divide) {
		this.divide = divide;
	}
	public Date getShowday() {
		return showday;
	}
	public void setShowday(Date showday) {
		this.showday = showday;
	}
}
