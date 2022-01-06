package com.nit.service;

import org.springframework.data.domain.Page;

import com.nit.entity.Movie;

public interface IMovieMgmtService {
	// sorting with one props
	public Iterable<Movie> sortByName(Boolean order, String... props);

	// Pagination //here we are giving pagesize and pageNumber manually..
	public Page<Movie> getDetailsByPegination(int pageNumber, int pageSize);

	// pagination with sorting obj
	public Page<Movie> genratePageReport(int pageNo, int pageSize, Boolean order, String... props);

	//number of pages will be decide at dyamic time based on record count
	public void genratePageReportWithDyanmicPagesCount(int pageSize);

	// number of pages will be decide at dyamic time based on record count +sorting
	public void genratePageReportWithDyanmicPagesCountWithSorting(int pageSize,Boolean order,String... props);

}
