package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.model.Country;

public interface CountryService {

	public Country saveCountry(Country country);
	public List<Country> getCountry(int page,int size);
	public Page<Country> getCountryByPage(int page,int size);
}
