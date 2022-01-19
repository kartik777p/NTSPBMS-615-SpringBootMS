package com.nit.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name = "SP_DATA_MOVIE")
@RequiredArgsConstructor  //which we want that only come
@NoArgsConstructor
@DynamicInsert(value = true)
public class Movie implements Serializable {
	//use Wrapper type here bcz they hold null as defult value
	@Id
	@Column(name = "MID")   //no need of writing length here it is there for non numeric
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer mid;
	@NonNull
	@Column(name = "MNAME",length = 20)
	private String mName;
	//@Transient
	@NonNull
	@Column(name = "YEAR",length = 20)
	private String year;
	//@Transient
	@NonNull
	@Column(name = "RATING")      //no need of length
	private Float rating;  
}
