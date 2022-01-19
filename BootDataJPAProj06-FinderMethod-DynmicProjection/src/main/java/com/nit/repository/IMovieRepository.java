package com.nit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.Movie;
import com.nit.projection.ResultView1;
import com.nit.projection.ResultView2;
import com.nit.projection.View;

public interface IMovieRepository extends JpaRepository<Movie, Integer> {

	public <T extends View>List<T> findByYearIn(List<String> years, Class<T> clazz );
	
	//public <T extends View>List<ResultView2> findBymNameIn(List<String> movies,Class<T> clazz);
		

}
