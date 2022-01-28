package com.nit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nit.entity.Movie;

public interface IMovieRepository extends JpaRepository<Movie, Integer> {
     /*------------------------------------------------ @Query method for Selecting all colms values of DB table----------------------------------------------------------------------------------------------------------------*/
	//version 1    (positional param ) 
/*	 @Query("from Movie where mid>=?1 AND mid<=?2")
	 //@Query("from Movie where mid>=?2 AND mid<=?1")  allowed strted with one and further increment by one...dont warry about placements
  List<Movie> fetchMoviesById(int startId, int endId);    */
	  
	//Not Allowed positional param must start with 1 and goes further by incremeting by 1
	/*@Query("from Movie where mid>=?2 AND mid<=?3")
	  @Query("from Movie where mid>=?1 AND mid<=?3")
	  @Query("from Movie where mid>=?0 AND mid<=?1")
	  List<Movie> fetchMoviesById(int startId, int endId);  */
	
	//version 2 (use @param if param and name named param is not matching )
		/*@Query("from Movie where mid>=:min AND mid<=:max")
	  List<Movie> fetchMoviesById(@Param("min")  int startId,@Param("max")   int endId);  */
 
	//Not Allowed (combination of named param + positional param not possible)
	/* @Query("from Movie where mid>=?1 AND mid<=:endId")
    List<Movie> fetchMoviesById( int startId, int endId);    */
	  //Not Allowed (id query exception 2 param and your giving more than 2 or less that 2 then it is not allowed)
	
	/*@Query("from Movie where mid>=?1 AND mid<=?2")
    List<Movie> fetchMoviesById( int startId, int endId,int mainId);  */
	
	  // Query kws are not allowed to pass from end user to query (only input are allowed)
	/*@Query("from ?1 where mid>=?2 AND mid<=?3")
    List<Movie> fetchMoviesById( String movie, int strtId,int endId);  */
	
	  //Some time method param name and Named param same then also not allowed..for that we have to do some settings
	   // Right click on project ---->Properties ---->java compiler  -----> select the checkbox of store info about  method param
	//version 3 (if param and Named param name matching then no need to use @param )
		//@Query("from Movie where mid>=:startId AND mid<=:endId")
		@Query("from Movie m where m.mid>=:startId AND m.mid<=:endId")   //using alias
	     List<Movie> fetchMoviesById( int startId, int endId);  

	   //version 1
	/* @Query("FROM Movie  WHERE mname in(:name1,:name2,:name3) ORDER BY mname asc ")
	 public List<Movie> searchMoviesByMovieNames(String name1, String name2, String name3);  */
	 
	 /* Version 2 problem  (Not possible with  var args/arrays/collections for multiple param not possible
	@Query("FROM Movie  WHERE mname in(?1,?2,?3) ORDER BY mname asc ") 
	 public List<Movie> searchMoviesByMovieNames(String ... args ); */
	 
	// Version 2 Solution  
		@Query("FROM Movie  WHERE mname in(?1,?2,?3) ORDER BY mname asc ") 
		 public List<Movie> searchMoviesByMovieNames(String name1, String name2, String name3 );
		
		/*------------------------------------------- Scalar @Query method for Selecting Specifics colms values of DB table-----------------------------------------------------*/
     
		@Query("SELECT mid,mName,year FROM Movie WHERE rating>=:rat AND year in(:y1,:y2,:y3)")
		public List<Object[]> getDetailsOfMoviesByRattingAndYears(Float rat,String y1,String y2,String y3);
		
		/*------------------------------------------- Scalar @Query method for Selecting Specifics One colms values of DB table-----------------------------------------------------*/
        
		@Query("SELECT mName FROM Movie WHERE year>=:start AND year<=:end ORDER BY mname DESC")
		List<Object> getMoviesByYearRange(String start, String end);

    //

}
