package com.nit.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.entity.Movie;
import com.nit.repository.IMovieRepository;

@Component
public class FinderMethodTestRunner implements CommandLineRunner {

	@Autowired
	private IMovieRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		//========================Finder method=======================================
	/*	System.out.println("=========FindBymNameEquals()Case-Sensetive===========");
		repo.findBymNameEquals("Pushpa").forEach(System.out::println);
		System.out.println("=========FindBymNameIs()Case-Sensetive===========");
		repo.findBymNameIs("Pushpa").forEach(System.out::println);
		//System.out.println("=========FindBymName()Case-Sensetive===========");
		//repo.findBymName("Pushpa").forEach(System.out::println);
		System.out.println("=========findBymNameEqualsIgnoreCase()Case-InSensetive===========");
		repo.findBymNameEqualsIgnoreCase("pushpa").forEach(System.out::println);
		System.out.println();
		
		System.out.println("=========FindBymNameStartingWith()Case-Sensetive===========");
		repo.findBymNameStartingWith("8").forEach(System.out::println);
		System.out.println("=========FindBymNameEndingWith()Case-Sensetive===========");
		repo.findBymNameEndingWith("a").forEach(System.out::println);
		System.out.println();
		
		System.out.println("=========FindBymNameContaining()Case-Sensetive===========");
		repo.findBymNameContaining("sh").forEach(System.out::println);
		System.out.println("=========findBymNameContainingIgnoreCase()Case-InSensetive===========");
		repo.findBymNameContainingIgnoreCase("K").forEach(System.out::println);
		System.out.println("=========FindBymNameNotContaining()Case-Sensetive===========");
		repo.findBymNameNotContaining("sanak").forEach(System.out::println);
		System.out.println("=========FindBymNameNotContainingIgnoreCase()Case-In-Sensetive===========");
		repo.findBymNameNotContainingIgnoreCase("SANAK").forEach(System.out::println);
		System.out.println();
		
		System.out.println("=========FindBymNameLike() Starting with ===========");
		repo.findBymNameLike("R%").forEach(System.out::println);  //here we have to pass %  explicitly....
		repo.findBymNameLikeIgnoreCase("R%").forEach(System.out::println);  //here we have to pass %  explicitly....
		System.out.println();
		System.out.println("=========FindBymName() Exact 3 latter in name===========");
		repo.findBymNameLike("___").forEach(System.out::println);
		System.out.println();
		System.out.println("=========FindBymNameLike() Containing===========");
		repo.findBymNameLike("%R%").forEach(System.out::println);
		repo.findBymNameLikeIgnoreCase("%R%").forEach(System.out::println);
		System.out.println();
		System.out.println("=========FindBymNameLike() EndingWith===========");
		repo.findBymNameLike("%R").forEach(System.out::println);
		repo.findBymNameLikeIgnoreCase("%R").forEach(System.out::println);
		System.out.println();
		 */
		System.out.println("=============Finder method with multiple property based condiction===========");
		System.out.println();
		System.out.println("=========findByMidGreaterThanAndRatingLessThan() ===========");
		repo.findByMidGreaterThanAndRatingLessThan(50, 4.5f).forEach(System.out::println);
		System.out.println("=========findBymNameStartingWithAndYearGreaterThan() ===========");
		repo.findBymNameStartingWithAndYearGreaterThan("R", "2010").forEach(System.out::println);
		System.out.println("=========findBymNameContainingAndYearBetween() ===========");
		repo.findBymNameContainingOrYearBetween("R", "2001","2015").forEach(System.out::println);
	/*	 //here is the some problem bcz of camalcase
	  System.out.println("=========findByYearInOrMNameContainingAndRatingBetween() ===========");
		repo.findByYearInOrMNameContainingAndRatingBetween(List.of("2016","2017","2018","2019","2021"), "R",3.1f,5.0f).forEach(System.out::println);
		*/
		System.out.println("=========findBymNameContainingAndRatingBetweenOrYearIn()Case Sensative ===========");
		repo.findBymNameContainingAndRatingBetweenOrYearIn("A",3.1f,5.0f,List.of("2016","2017","2018","2019","2021")).forEach(System.out::println);
		System.out.println();
		System.out.println("=========findBymNameContainingIgnoreCaseAndRatingBetweenOrYearIn()Case InSensative ===========");
		repo.findBymNameContainingIgnoreCaseAndRatingBetweenOrYearIn("A",3.1f,5.0f,List.of("2016","2017","2018","2019","2021")).forEach(System.out::println);
		System.out.println();
		System.out.println("=========findBymNameNotContainingOrYearInOrderByYearAsc()CaseSensative ===========");
		repo.findBymNameNotContainingOrYearInOrderByYearAsc("F", List.of("2021","2017","2018","2019")).forEach(System.out::println);
	}//run
}//class
