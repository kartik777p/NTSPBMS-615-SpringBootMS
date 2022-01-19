package com.nit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.Movie;


public interface IMovieRepository extends JpaRepository<Movie, Integer> {

}
