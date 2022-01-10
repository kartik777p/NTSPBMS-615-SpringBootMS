package com.nit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nit.entity.Movie;
import com.nit.repository.IMovieRepository;



@Service("movieService")
public class MoviemgmtServiceImpl implements IMovieMgmtService {

	@Autowired // injects the dynamically inMemory proxy class obj
	private IMovieRepository repo;

	@Override
	public List<Movie> getAllRecords() {
		// get all the Records from the db
		return repo.findAll();
	}// getAllRecords

	@Override
	public String deleteAllRecordsBasedOnThereIds(List<Integer> ids) {
		// get lists of records by submitting ids
		List<Movie> list = repo.findAllById(ids);
		// get count of the records that we got by submitting ids
		long RecordCount = list.size();
		//in CrudRepo DeleteAllByIds() methods uses AND Clause...at that time if one of the given record is not Available then problem/Exception has come thats why we have use if block there to solve that certain problem
		//but in JPARepo deleteByIdsInBatch() method Uses OR Clause means though some of ids not available it will delete those records whoes ids is present
		// now delete the records by Submitting ids
		repo.deleteAllByIdInBatch(ids); // genrates only one sql delete statement for all the records
		return RecordCount + " :-No of Records has been Deleted....";
	}
	
	@Override
	public List<Movie> findAllByIds(List<Integer> ids) {
		//get count of records (optional)
		long count=repo.count();
		//use service method by sending list of ids
		List<Movie> list=repo.findAllById(ids);
		//return list
		return list;
	}
	@Override
	public List<Movie> searchMoviesByMovie(Movie movie, boolean order, String... props) {
		//create Example obj having movie obj
		Example example=Example.of(movie);  //to avoid NPE
		//create sort obj having details
		Sort sort=Sort.by(order?Direction.ASC:Direction.DESC, props);
		//use repo class here by sending example and sort obj
		List<Movie> list=repo.findAll(example, sort);
		//return list which we got (Matched Record with passed Movie details)
		return list;
	}
	@Override
	public Movie findMovieById(Integer id) {
		//get movie by submitting id
		Movie movie=repo.getById(id);   //need some cfgs in Application.props
		//return movie obj which we got
		return movie;  //if record not found will Throw exception no need of throwing exception explicitly...
	}
	@Override
	public String deleteAllMovies() {
		//get all record count
		long count=repo.count();
		//check records is there or not
		if(count>0) {
		//delete all the record by calling method 
			repo.deleteAllInBatch();
			//return msg
			return count+" :- No. of record is deleted.......";
		}//if
		else
		      return "No Records are there to Delete........";
	}//method
	
	  //Version 1----
/*  @Override
	public String deleteAllMoviesInBatch(List<Movie> movies) {
	  if(movies.size()>0) {
		//now delete record by giving lists
		repo.deleteAllInBatch(movies);
		return "Objects is deleted....";
	  }else
		  return "maybe you have not paased any record to delete.....";
	}//method    */
	
	// Version 2--- if same id does not found  in db then throws exception
	@Override
	public String deleteAllMoviesInBatch(List<Movie> movies) {
			//create arraylist obj to hold list of ids
		List<Integer> ids=new ArrayList<Integer>();
		//gather ids from param and saves to ids
		for(Movie movie:movies) {
			//save every obj id to Arrayslist
			ids.add(movie.getMid());
		}//for 
		//now get the records for the given ids
		List<Movie> list=repo.findAllById(ids);
		int recordCount=list.size();
		//now delete all records by ids
		repo.deleteAllByIdInBatch(ids);
		return recordCount+":- No. of record is deleted......";
	} //method
	@Override
	public List<Movie> getAllMoviesBySort(boolean order, String... props) {
		//create sort obj
		Sort sort=Sort.by(order?Direction.ASC:Direction.DESC, props);
    List<Movie> movies=repo.findAll(sort);
		return movies;
	}//method
	@Override
	public String registerAllMovies(List<Movie> movies) {
		//check condiction
		if(movies.size()>0) {
			//save the records (call repo)
		 List<Movie> list=  repo.saveAll(movies);
		 //create ArrayList
		 List<Integer> ids=new ArrayList<Integer>();
		 list.forEach(mv->{
			 //gather values from list and save to ids list
			 ids.add(mv.getMid());
		 });
		 int saveCount=ids.size();
		 return saveCount+" Records are saved... ids of that record is :- "+ids.toString();
		}//if
		return "No records is found to save please add One or More record then try again";
	}//method
}// class
