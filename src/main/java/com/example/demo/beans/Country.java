package com.example.demo.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "Country")
public class Country {
	
@Id
@Column(name="id")
int id;

@Column(name="Country_Name")
String CountryName;

@Column(name="Country_Capital")
String CountryCapital;
public Country()
{
	
}
public Country(int id, String countryName, String countryCapital) {
	super();
	this.id = id;
	this.CountryName = countryName;
	this.CountryCapital = countryCapital;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCountryName() {
	return CountryName;
}
public void setCountryName(String countryName) {
	CountryName = countryName;
}
public String getCountryCapital() {
	return CountryCapital;
}
public void setCountryCapital(String countryCapital) {
	CountryCapital = countryCapital;
}

}


