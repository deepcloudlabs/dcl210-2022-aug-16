package com.example.world.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.world.document.Country;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public interface MongoCountryRepository extends MongoRepository<Country, String> {
	Slice<Country> getByContinent(Pageable page, String continent);
	List<Country> findByContinentAndPopulationBetween(String continent,long populationFrom,long populationTo);
	Collection<Country> findTop10ByOrderByPopulationDesc();
}
