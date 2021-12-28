package com.nit.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "SP_DATA_MOVIE")
public class Movie implements Serializable {
	//use Wrapper type here bcz they hold null as defult value
	@Id
	@Column(name = "MID")   //no need of writing length here it is there for non numeric
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer mid;
	@Column(name = "MNAME",length = 20)
	private String mName;
	@Column(name = "YEAR",length = 20)
	private String year;
	@Column(name = "RATING")      //no need of length
	private Float rating;
	
     
}
