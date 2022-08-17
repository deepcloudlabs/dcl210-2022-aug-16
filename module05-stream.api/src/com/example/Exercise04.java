package com.example;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.example.domain.Genre;
import com.example.domain.Movie;
import com.example.service.InMemoryMovieService;

public class Exercise04 {

	public static void main(String[] args) {
		var movies = InMemoryMovieService.getInstance().findAllMovies();

		var genreMovieCounts =
		movies.stream()                  // Stream<Movie>
		      .map(Movie::getGenres)     // Stream<List<Genre>> 
		      .flatMap(List::stream)     // Stream<Genre>
		      .map(Genre::getName)       // Stream<String>
		      .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		genreMovieCounts.forEach( (genre,count) -> System.out.println("%24s: %3d".formatted(genre,count)) );
	}

}

