package com.example.demo.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Country;
import com.example.demo.controllers.AddResponse;
import com.example.demo.repositories.CountryRepository;

@Component
@Service

public class CountryService {
	
	@Autowired
	CountryRepository countryrep;
	
	public List<Country> getAllCountries()
	{
		return countryrep.findAll();
	}
	public Country getCountryById(int id)
	{
		return countryrep.findById(id).get();
	}
	
	public Country getCountryByName(String CountryName)
	{
		List<Country> Countries = countryrep.findAll();
		Country country = null;
		for(Country con:Countries)
		{
			if(con.getCountryName().equalsIgnoreCase(CountryName))
				country = con;
		}
		return country;
	}
	
	public Country addCountry(Country country)
	{
		country.setId(getMaxId());
		countryrep.save(country);
		return country;
	}
	
	public  int getMaxId() //in order to generate id automaticcaly we need to use some logic.
	{
		return countryrep.findAll().size()+1;
	}
	
	public Country updateCountry(Country country) 
	{
		// any java object will be automatically converted into JSON format with this spring framework , basically we use jackson API to convert any java obj yoo json format.
		countryrep.save(country);
		return country;
		
	}
	public AddResponse deleteCountry(int id)
	{
		countryrep.deleteById(id);
		AddResponse res = new AddResponse();
		res.setMsg("Country Deleted...!");
		res.setId(id);
		return res;
	}

}
