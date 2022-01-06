package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nit.entity.Movie;
import com.nit.repository.IMovieRepository;

@Service("movieService")
public class MoviemgmtServiceImpl implements IMovieMgmtService {
     
	@Autowired     //injects the dynamically inmemory proxy class obj
	private IMovieRepository repo;

	@Override
	public Iterable<Movie> sortByName(Boolean order, String... props) {
		//prepared sort object
		Sort sort=Sort.by(order?Direction.ASC:Direction.DESC, props);   //domain pckg
		//use findAll method for Sorting data by sending sort obj(sorting details)
		Iterable<Movie> itr=repo.findAll(sort);
		return itr;
	}
		@Override
		public Page<Movie> getDetailsByPegination(int pageNumber, int pageSize) {
			//prepared pageable obj bcz findAll(pageable)
			Pageable pageable=PageRequest.of(pageNumber, pageSize);  //pageReq gives us pageable obj having pageNumber,PageSize
			//use Repo here now
		Page<Movie> page=repo.findAll(pageable);
			return page;
		}
	@Override
	public Page<Movie> genratePageReport(int pageNo, int pageSize, Boolean order, String... props) {
		//prepare Pageable obj having all 3 details (pageNo,pageSize,Sort)
		Pageable pageable=PageRequest.of(pageNo, pageSize,Sort.by(order?Direction.ASC :Direction.DESC, props));
		//get req page record
		Page<Movie> page=repo.findAll(pageable);
		return page;
	}
	@Override
	public void genratePageReportWithDyanmicPagesCount(int pageSize) {
		long pagesCount=0;
		//get record count
		long recordsCount=repo.count();
		//decide number of pages (pageCount)
		         //here 	1 problem is there  ....pageCount=No.of records/pagesize ....but here problm is that if we have   
		        //record is 21 are we try to get pageCount by using  20/5 =4...we will loss last one record 
		//bcz 5*4=20.. but we have 21 record...but pagesize will be set as 4 based on record...
		//there is a one solution for this problem..... that is if No.ofRecords/pageSize==0 (then take pagecounts which we got
		//if no.of record/pageSize !=0  then...  increase one page for the remaining record...so we will not loss any record)
		if(pageSize>0) {   //if page size 0 will get Divided by Zero exceptio we must handle it (for this we are using this one)
		 pagesCount=recordsCount/pageSize;    
		 //get exact pagesCount based on records size
		pagesCount=recordsCount%pageSize==0?pagesCount :++pagesCount; //here we are doing some trick like if no.of records is extactly divisible by pageSize(remainder 0) then pagesCount is same
		                                                                                       //but  if no of pages is not exactly divided by pageSize (Remiander is there other than 0) then increase pageSize by 1(so rest record can come on that increased page)
		}//if
		else {
			throw new IllegalArgumentException("Page size must be Greater than 0 ");
		}
		//now use for to print 1 page to last page record printing
		//start for loop from page no 0 and to till last page (pagesCount)
		for(int pageNo=0;pageNo<pagesCount;++pageNo) {
			 //prepare pageable obj having pageNo and pageSize
			Pageable pageable=PageRequest.of(pageNo, pageSize);
			//use repo class here  to get records
			Page page=repo.findAll(pageable);
			//print details of the size and pageNumber pagesCount
			System.out.println("page no:- "+(pageNo+1)+" pageSize :-"+pageSize+ " pagesCount :- "+pagesCount+" Total No of elements presents in the given page :- "+page.getNumberOfElements());
			//now get the list of records that we got in page obj
			List<Movie> list=page.getContent();
			//traverse the list to display elements
			list.forEach(movie->{
				System.out.println(movie);
			});//foreach
		}//for
	}//method
	
	@Override
	public void genratePageReportWithDyanmicPagesCountWithSorting(int pageSize, Boolean order, String... props) {
		//get total number of record count
		long recordsCount=repo.count();
		long pagesCount=0;
		if(pageSize>0) {   //to Avoid dividedby Zero exception if pageSize is 0
		//get pagesCount
		 pagesCount=recordsCount/pageSize;   
		//get exact pages count
		pagesCount=recordsCount%pageSize==0?pagesCount:++pagesCount;
		}//if
		else
			throw new IllegalArgumentException("pageSize must be greater than 0");
		//print each page record from pageNo 1 to last page(pageCount)
		for(int pageNo=0;pageNo<pagesCount;++pageNo) {
			//1st prepare sort obj bcz we need sorting bcz we have to give sort obj to pageReq to Create Pageable obj
			Sort sort=Sort.by(order?Direction.ASC:Direction.DESC, props); //props contains field name which data we want to sort
			//prepare pagable obj having all details
			Pageable pageable=PageRequest.of(pageNo, pageSize, sort);
			//use repo class here by sending pageable obj
			Page<Movie> page=repo.findAll(pageable);
			//print some details about page obj
			System.out.println("PageNo :- "+(pageNo+1)+" PageSize :- "+pageSize+" PagesCount :- "+pagesCount+" Curent page elements is:- "+page.getNumberOfElements());
			//get list of movie obj that is present in page obj having pagination
			List<Movie> list=page.getContent();
			//traverse each of the page record usng for Each +Static method ref
			list.forEach(System.out::println);	
		}//for
	}//method
}//class
