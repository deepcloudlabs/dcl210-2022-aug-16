package com.example;

import java.util.Objects;

import com.example.dao.InMemoryWorldDao;
import com.example.domain.Country;

public class Exercise06 {

	public static void main(String[] args) {
		var worldDao = InMemoryWorldDao.getInstance();
		var countries = worldDao.findAllCountries();
        var isAllCountriesHasCapital = 
        		countries.stream()
        		         .map(Country::getCapital)
        		         .map(worldDao::findCityById)
        		         .noneMatch(Objects::nonNull);
				         //.allMatch(Objects::nonNull);
				         //.anyMatch(Objects::nonNull);
        System.out.println(isAllCountriesHasCapital);
        var firstCountryWithNoCapital = 
        		countries.stream()
        		         .filter(country -> Objects.isNull(worldDao.findCityById(country.getCapital()))) 
        		         .findFirst();
        firstCountryWithNoCapital.ifPresent(System.out::println);
	} 

}
