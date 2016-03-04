package com.example.ordermyfood1;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Address implements Serializable{

	private String name;
	private String Phone;
	private String Streetaddress;
	private String Area;
	private String City;
	private String pincode;
	
	
	
	
	
	public Address(String name, String phone, String streetaddress,
			String area, String city, String pincode) {
		super();
		this.name = name;
		Phone = phone;
		Streetaddress = streetaddress;
		Area = area;
		City = city;
		this.pincode = pincode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getStreetaddress() {
		return Streetaddress;
	}
	public void setStreetaddress(String streetaddress) {
		Streetaddress = streetaddress;
	}
	public String getArea() {
		return Area;
	}
	public void setArea(String area) {
		Area = area;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	
	
	
	
	
}
