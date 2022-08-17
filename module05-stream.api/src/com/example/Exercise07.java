package com.example;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.mapping;

import com.example.dao.InMemoryWorldDao;
import com.example.domain.Country;

public class Exercise07 {

	public static void main(String[] args) {
		var worldDao = InMemoryWorldDao.getInstance();
		var countries = worldDao.findAllCountries();
		var continentCountriesWithNames =
		countries.stream()
		         .collect(
		        		groupingBy(
		        		   Country::getContinent,
		        		   mapping(Country::getName,joining(",","'","'"))
		        		)
		          );
		continentCountriesWithNames.forEach(
			(continent,names) -> System.out.println("%16s: %s".formatted(continent,names))
		);
	}

}
