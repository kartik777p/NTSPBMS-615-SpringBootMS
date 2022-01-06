package com.nit.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nit.entity.Movie;
import com.nit.service.IMovieMgmtService;

@Component
public class PagingAndSortingRepoRunner implements CommandLineRunner {
	
    //we have to use Service class here thats why we inject service class obj here
	@Autowired
	private IMovieMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		/*    System.out.println("==========FindAll(Sort) For mName=========");
		    try {
		    	Iterable<Movie> itr=service.sortByName(false, "mName");   //true--->ASC   False-->DESC
		    	//process the data
		    	itr.forEach(System.out::println);
		    }catch (Exception e) {
				e.printStackTrace();
			}   */
		    
		/*    System.out.println("==========FindAll(Sort) For mName,year=========");
		    try {
		    	Iterable<Movie> itr=service.sortByName(false, "mName","year");   //true--->ASC   False-->DESC
		    	//process the data
		    	itr.forEach(System.out::println);
		    }catch (Exception e) {
				e.printStackTrace();
			}   */
		    
	/*	    System.out.println("==========FindAll(PageAble) pageNumber,pageSize=========");
		    try {                                  //pageNumber is 0-based 
		    	Page<Movie> page=service.getDetailsByPegination(0, 5);   //sort by id like 55,56,57,58
		    	//process the data
		    	page.forEach(System.out::println);
		    }catch (Exception e) {
				e.printStackTrace();
			}    */
	/*	  System.out.println("==========FindAll(PageAble) pageNumber,pageSize,Sort=========");
		    try {                                  //pageNumber is 0-based 
		    	Page<Movie> page=service.genratePageReport(0, 3,true,"year");   
		    	//Page<Movie> page=service.genratePageReport(0, 10,true,"year","rating");   
		    	//process the data
		    	if(!page.isEmpty()) {
		    		//get page Content   (some other method)
		    		List<Movie> list=page.getContent();
		    		System.out.println("Current page Number is :- "+page.getNumber());
		    		System.out.println("is it the First page ? :-"+page.isFirst());
		    		System.out.println("Total Available pages is :- "+page.getTotalPages());  
		    		System.out.println("Total elements count is:- "+page.getTotalElements());
		    		System.out.println("Is it last page ? :- "+page.isLast());
		    		System.out.println("Current page elements count :- "+page.getNumberOfElements());
		    	list.forEach(System.out::println);
		    	}
		    	else
		    		System.out.println("No page Found ");
		    }catch (Exception e) {
				e.printStackTrace();
			}    */
	/*	System.out.println("========= finAll(pageable) with only pageSize(pageAcount will get dynamically)");
		try {
			service.genratePageReportWithDyanmicPagesCount(4);
		}catch (Exception e) {
			e.printStackTrace();
		}   */
		System.out.println("========= finAll(pageable) with only pageSize(pageAcount will get dynamically)+Sorting");
		try {
			service.genratePageReportWithDyanmicPagesCountWithSorting(4,true,"mName");
		}catch (Exception e) {
			e.printStackTrace();
		}  
		}// run      
}// class
