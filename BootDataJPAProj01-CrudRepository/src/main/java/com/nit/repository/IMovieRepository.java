package com.nit.repository;

import org.springframework.data.repository.CrudRepository;

import com.nit.entity.Movie;

public interface IMovieRepository extends CrudRepository<Movie, Integer> {

}
