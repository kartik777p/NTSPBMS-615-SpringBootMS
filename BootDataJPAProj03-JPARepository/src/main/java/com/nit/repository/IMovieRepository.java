package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.nit.entity.Movie;

public interface IMovieRepository extends JpaRepository<Movie, Integer> {
 
}
