package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.Country;
import com.example.demo.services.CountryService;

@RestController
public class CountryController {
	
	@Autowired
	 CountryService countryService;
	
	@GetMapping("/getcountries")
	public List<Country> getCountries()
	{
		return countryService.getAllCountries();
	}
	
	@GetMapping("/getcountries/{id}")
	public ResponseEntity<Country> getCountryById(@PathVariable (value="id")int id)
	{
		try {
		Country country = countryService.getCountryById(id);
		return new ResponseEntity<Country>(country,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<Country>(HttpStatus.NOT_FOUND);
		}
	} 

	@GetMapping("/getcountries/countryname")
	public ResponseEntity<Country> getCountryByCountryName(@RequestParam (value="name")String countryName)
	{
		 
		try {
			Country country = countryService.getCountryByName(countryName);
			return new ResponseEntity<Country>(country,HttpStatus.OK);
			}
			catch(Exception e)
			{
				return new ResponseEntity<Country>(HttpStatus.NOT_FOUND);
			}
	}
	
	@PostMapping("/addcountry")
	public Country addCountry(@RequestBody Country country)
	{
		return countryService.addCountry(country);
	}
	
	@PutMapping("/updatecountry/{id}")
	public ResponseEntity<Country> updateCountry(@PathVariable(value="id")int id,@RequestBody Country country)
	{
		try
		{
		Country existCountry= countryService.getCountryById(id);
		existCountry.setCountryName(country.getCountryName());
		existCountry.setCountryCapital(country.getCountryCapital());
		Country updatedCountry = countryService.updateCountry(existCountry);
		return new ResponseEntity<Country>(updatedCountry,HttpStatus.OK);
		}
		catch(Exception e)  
		{
			return new ResponseEntity<Country>(HttpStatus.CONFLICT);
		}
		 
	}
	
	@DeleteMapping("/deletecountry/{id}")
	public AddResponse deleteCountry(@PathVariable (value="id")int id)
	{
		return countryService.deleteCountry(id);
	}


}