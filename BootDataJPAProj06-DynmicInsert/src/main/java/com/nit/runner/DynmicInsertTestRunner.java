package com.nit.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.entity.Movie;
import com.nit.repository.IMovieRepository;

@Component
public class DynmicInsertTestRunner implements CommandLineRunner {

	@Autowired
	private IMovieRepository repo;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("===============Ways to store Partial Data Into DataBase==================");
		/*	System.out.println("1:- Here if you want to store only 2 details of the entity class...but it will genrate sql query having all the details/columns");
		//Version 1  -- default values null will be taken 
		//create movie obj having some details
		Movie m=new Movie();
		m.setMName("Mirzapur");/here explicitly pass null values are not allowed bcz we have taken all those property as nonNull in entity class,
															//if we didt pass any values by default it will take null only
		//m.setRating(4.6f);  
		m.setYear("2016");
		//save movie obj to db
		System.out.println(repo.save(m).getMid()+" id based Object is Stored..");   */
	/*	System.out.println(" 2 :- Here if you want to store only 2 details of the entity class...then here query will genrate using that 2 details only.");
		//Version 2  - @Transient on the top of the entity property
				//create movie obj having all details,but pass null values in some of the details
				Movie m=new Movie();
				m.setMName("Jay Bhim");
				m.setRating(4.3f);  // this values will not store bcz  of @Transient on the to of Entity class Property
			   m.setYear("2011");    //
				//save movie obj to db
				System.out.println(repo.save(m).getMid()+" id based Object is Stored..");   */
		
		System.out.println(" 3 :- Here if you want to store only 2 details of the entity class...then here query will genrate using that 2 details only.");
		//Version 3  - @DynmicInsert on the top of the entity class
				//create movie obj having all details,but pass null values in some of the details
				Movie m=new Movie();
				m.setMName("Khuda Hafiz");
				//m.setRating(4.3f);  // this property will not participate in SQL query bcz we have not set values to it
			 //  m.setYear("2015");    //
				//save movie obj to db
				System.out.println(repo.save(m).getMid()+" id based Object is Stored..");
		
		
		}// run
}// class
