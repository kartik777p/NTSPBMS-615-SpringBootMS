package com.nit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.Movie;

public interface IMovieRepository extends JpaRepository<Movie, Integer> {
     
	//========================Finder method With  only one properties=======================================
	                                                  //ByName
	//select mid,mname,year,ratting from movie where mname='Pushpa'
	 List<Movie> findBymNameEquals(String mName);   //case sensative
	//select mid,mname,year,ratting from movie where mname='RRR'
	 List<Movie> findBymNameIs(String mName);    //case sensative
	//select mid,mname,year,ratting from movie where mname='RRR'
	 Iterable<Movie> findBymName(String mName); //Equals And Is optional to write    //case sensative
	 //
	 List<Movie> findBymNameEqualsIgnoreCase(String mName);     //case insensative
	 
     														//StartingWith +EndingWith
	 //select mid,mname,year,ratting from movie where mname like 'R%'
	 List<Movie> findBymNameStartingWith(String initChar);  //case sensative
	//select mid,mname,year,ratting from movie where mname like '%R'
	 List<Movie> findBymNameEndingWith(String endChar);  //case sensative
	 
	                                                  //Containing +NotContaining
	//select mid,mname,year,ratting from movie where mname like '%R%'
	 List<Movie> findBymNameContaining(String chars);   //case sensative
	 //
	 List<Movie> findBymNameContainingIgnoreCase(String chars);   //case In-sensative
	//select mid,mname,year,ratting from movie where mname Not like '%R%'
	 List<Movie> findBymNameNotContaining(String chars);   //case sensative
	 //
	 List<Movie> findBymNameNotContainingIgnoreCase(String chars);   //case sensative
	 
	 //i Want to get that movie obj which is having exactly 3 chars (not less than 3 or 
	//select mid,mname,year,ratting from movie where mname like 'R%'    	//get the records which is starting with R
	//select mid,mname,year,ratting from movie where mname like '___'   	//gets the movie record which have exact 3 words in his name
	//select mid,mname,year,ratting from movie where mname like '%R%' 	//Containing R chars
	//select mid,mname,year,ratting from movie where mname like 'R%' 	     //containing record which is ending with R
	 Iterable<Movie> findBymNameLike(String mName);   //pass whild card chars while calling
	 Iterable<Movie> findBymNameLikeIgnoreCase(String mName);   //case InSensative
	 
	//========================Finder method With  Two or more properties=======================================
	 //select mid,mname,year,ratting from movie where mid>? AND rating>?
	 List<Movie> findByMidGreaterThanAndRatingLessThan(int startMid, float endRating); 
	// select mid,mname,year,ratting from movie where mname like 'R%' AND year>? 
	 List<Movie> findBymNameStartingWithAndYearGreaterThan(String initChars,String startYear);
	//select mid,mname,year,ratting from movie where mname like '%R%' OR year between ? and ?
	 List<Movie> findBymNameContainingOrYearBetween(String initChars, String startYear,String endYear);
	 //here is some problem bcz we have taken mName(in entity class)
	 //List<Movie> findByYearInOrmNameContainingAndRatingBetween(List<String> year,String initChars,
			// 																															float startRating, float endRating);
	 List<Movie> findBymNameContainingAndRatingBetweenOrYearIn(String initChars,
																																			float startRating, float endRating,List<String> year);
	 //select mid,mname,year,ratting from movie where (upper(mname) like upper(?) escape ?) and (rating between ? and ?) or year in (? , ? , ? , ? , ?)
	 List<Movie> findBymNameContainingIgnoreCaseAndRatingBetweenOrYearIn(String initChars,
				float startRating, float endRating,List<String> year);
	
	 /*Ass
	 get the movie details which is not having given chars and must be relised in given year   */
	 ////select mid,mname,year,ratting from movie   where mname not like ? escape ? oryear in (? , ? , ? , ?) order by year asc
	  List<Movie> findBymNameNotContainingOrYearInOrderByYearAsc(String chars,List<String> yearList);
	  
	  //if your following some coding standerd in entity class like Property name used as CamalCase...then you may face some issue while creating finder method
	  // here also when we trying to OrderBymNameAsc we are facing that problem..but for year property we are not facing...bcz year property we have not used as camalcase
	 // List<Movie> findBymNameNotContainingOrYearInOrderBymNameAsc(String chars,List<String> yearList);
	 

	 
}
