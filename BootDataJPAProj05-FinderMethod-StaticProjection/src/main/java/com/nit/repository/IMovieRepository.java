package com.nit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.Movie;
import com.nit.projection.ResultView;

public interface IMovieRepository extends JpaRepository<Movie, Integer> {
	
	List<ResultView> findByMidGreaterThanEqualAndMidLessThanEqual(int startMid,int endMid);
}
