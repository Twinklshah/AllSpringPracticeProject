package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Country;
import com.example.demo.repository.CountryRepository;
import com.example.demo.service.CountryService;
@Service
@Transactional
public class CountryServiceImpl implements CountryService{
	
	@Autowired
	CountryRepository countryRepository;
	
	public Country saveCountry(Country country) {
		return countryRepository.save(country);
		
	}

//	public List<Country> allCountry(List<Country> country){
//		return countryRepository.saveAll(country)l
//	}
	
	public List<Country> getCountry(int page,int size) {  //0 5
		
		Pageable pageable = PageRequest.of(page, size);
		Page<Country> country = countryRepository.findAll(pageable) ;
		return country.getContent();
		
		//return countryRepository.findAll(PageRequest.of(page, size)).getContent();
	}
	
	
public Page<Country> getCountryByPage(int page,int size) {  //0 5
		
		Pageable pageable = PageRequest.of(page, size);
		return countryRepository.findAll(pageable) ;
		
	}
	
	

}

