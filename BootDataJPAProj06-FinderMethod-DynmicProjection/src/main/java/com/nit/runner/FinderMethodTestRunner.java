package com.nit.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.entity.Movie;
import com.nit.projection.ResultView1;
import com.nit.projection.ResultView2;
import com.nit.projection.ResultView3;
import com.nit.repository.IMovieRepository;

@Component
public class FinderMethodTestRunner implements CommandLineRunner {

	@Autowired
	private IMovieRepository repo;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("----Dynmic  Scaler/Projection---------------");
		System.out.println();
		try {
			// use repo method here
			System.out.println("ResultView1 Containing Mid,Mname");
			List<ResultView1> list1 = repo.findByYearIn(List.of("2017", "2021", "2022", "2k21"), ResultView1.class);
			list1.forEach(mv -> {
				System.out.println("Id :-" + mv.getMid() + " MName:- " + mv.getmName());
			});
			System.out.println("---------------------------------------------------------------");

			System.out.println("ResultView2 Containing Mid,Mname,ratting");
			List<ResultView2> list2 = repo.findByYearIn(List.of("2017", "2021", "2022", "2k21"), ResultView2.class);
			list2.forEach(mv -> {
				System.out
						.println("Id :-" + mv.getMid() + " MName:- " + mv.getmName() + " Rating :- " + mv.getRating());
			});
			System.out.println("---------------------------------------------------------------");

			System.out.println("ResultView3 Containing Mid,Mname,Year");
			List<ResultView3> list3 = repo.findByYearIn(List.of("2017", "2021", "2022", "2k21"), ResultView3.class);
			list3.forEach(mv -> {
				System.out.println("Id :-" + mv.getMid() + " MName:- " + mv.getmName() + " Year :- " + mv.getYear());
			});
			System.out.println("---------------------------------------------------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// run
}// class
