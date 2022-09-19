package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Country;
import com.example.demo.service.CountryService;

@RestController
@RequestMapping("/Country")
public class CountryController {
    @Autowired
	CountryService countryService;
    
    @PostMapping("/save")
    public ResponseEntity<Country> saveCountry(@RequestBody Country country){
    	return new ResponseEntity<Country>(countryService.saveCountry(country),HttpStatus.CREATED);
    }
    
    
    @GetMapping("/getEmployeeByPage")
    public  ResponseEntity<List<Country>> getCountry(@RequestParam(name = "page", defaultValue = "0") int page,@RequestParam(name = "size", defaultValue = "5") int size) {
    	return new ResponseEntity<List<Country>>(countryService.getCountry(page, size),HttpStatus.OK);
    }
    
    @GetMapping("/getCountryByPage")
    public  ResponseEntity<Page<Country>> getCountryByPage(@RequestParam(name = "page", defaultValue = "0") int page,@RequestParam(name = "size", defaultValue = "5") int size) {
    	return new ResponseEntity<Page<Country>>(countryService.getCountryByPage(page, size),HttpStatus.OK);
    }
}
