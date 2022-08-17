package com.example;

import java.util.Comparator;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.example.dao.InMemoryWorldDao;
import com.example.domain.City;
import com.example.domain.Country;

public class Exercise02 {

	public static void main(String[] args) {
		// Stream API Capabilities
		// Filtering: filter(), distinct(), limit(10), dropWhile(), takeWhile()
		// Mapping: map(), flatMap(), sorted()
		// Reduce:  reduce(), min(), max(), count(), toList(), 
        //          partitioning, grouping
		var worldDao = InMemoryWorldDao.getInstance();
		var countries = worldDao.findAllCountries();
		
		var orderByPopulationAsc = Comparator.comparing(City::getPopulation);
		var orderByPopulationDesc = orderByPopulationAsc.reversed();
		
		var capitals =  countries.stream()
	                             .map(Country::getCapital) // Class method
	                             .map(worldDao::findCityById) // Object method
	                             .filter(Objects::nonNull) // Class static method
	                             .sorted(orderByPopulationDesc)
	                             .toList();
		capitals.forEach(System.out::println);
		
		var highPopCapital =  countries.stream()
									   .map(Country::getCapital) // Class method
									   .map(worldDao::findCityById) // Object method
									   .filter(Objects::nonNull) // Class static method
									   .max(orderByPopulationAsc);
		highPopCapital.ifPresent(System.out::println);
		Predicate<Country> capitalPartitioner =
				country -> Objects.nonNull(worldDao.findCityById(country.getCapital())); 
		var capitalPartition = countries.stream()
				                        .collect(Collectors.partitioningBy(capitalPartitioner));
		
		capitalPartition.get(true)
		                .forEach(System.out::println);
				
		System.err.println(capitalPartition);

		Predicate<Country> wealthPartitioner =
				country -> country.getGnp() > 250_000.; 
		var wealthPartition = countries.stream()
				                       .collect(Collectors.partitioningBy(wealthPartitioner));
		
		wealthPartition.get(true)
		               .forEach(System.out::println);
	}

}
