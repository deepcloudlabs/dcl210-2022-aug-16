package com.example;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summarizingLong;

import java.util.stream.Collectors;

import com.example.dao.InMemoryWorldDao;
import com.example.domain.Country;

public class Exercise05 {

	public static void main(String[] args) {
		var worldDao = InMemoryWorldDao.getInstance();
		var countries = worldDao.findAllCountries();
		var asianPopStat =
		countries.stream()
		         .filter(country -> "Asia".equals(country.getContinent()))
		         .collect(summarizingLong(Country::getPopulation));
		System.out.println(asianPopStat);
		var asianGnpStat =
				countries.stream()
				.filter(country -> "Asia".equals(country.getContinent()))
				.collect(Collectors.summarizingDouble(Country::getGnp));
		System.out.println(asianGnpStat);
		
		var worldPopStat = countries.stream()
			.collect(groupingBy(Country::getContinent,summarizingLong(Country::getPopulation)));
		System.out.println(worldPopStat);

	}

}
