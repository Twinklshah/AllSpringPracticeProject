package com.example.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Country;
@Repository
public interface CountryRepository extends PagingAndSortingRepository<Country, Long>{

}
