package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.entity.Country;  // ✅ import the Country class
import com.cognizant.ormlearn.repository.CountryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    public List<Country> findByNameContaining(String keyword) {
        return countryRepository.findByNameContaining(keyword);
    }

    public List<Country> findByNameContainingOrderByNameAsc(String keyword) {
        return countryRepository.findByNameContainingOrderByNameAsc(keyword);
    }

    public List<Country> findByNameStartingWith(String prefix) {
        return countryRepository.findByNameStartingWith(prefix);
    }
}
