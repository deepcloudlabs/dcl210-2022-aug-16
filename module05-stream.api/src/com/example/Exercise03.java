package com.example;

import java.util.List;

import com.example.domain.Genre;
import com.example.domain.Movie;
import com.example.service.InMemoryMovieService;

public class Exercise03 {

	public static void main(String[] args) {
		var movies = InMemoryMovieService.getInstance().findAllMovies();
		var genres =
		movies.stream()                  // Stream<Movie>
		      .map(Movie::getGenres)     // Stream<List<Genre>>
		      .flatMap(List::stream)     // Stream<Genre>
              .distinct()                // Stream<Genre> 
              .map(Genre::getName)       // Stream<String>
              .sorted()                  // Stream<String>
              .toList();                 // List<String>
		System.out.println(genres);
		
	}

}
