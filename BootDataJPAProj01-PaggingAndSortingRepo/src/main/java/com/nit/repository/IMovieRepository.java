package com.nit.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.nit.entity.Movie;

public interface IMovieRepository extends PagingAndSortingRepository<Movie, Integer> {

}
