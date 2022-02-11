package com.nit.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "PERSON_INFO")
@Data
public class Person {
    
	@Id
	@GeneratedValue   //(strategy = GenerationType.AUTO)
	private Integer pid;
	private String pname;
	private Float page;
	private LocalDate dob;
	private LocalTime  tob;
	private LocalDateTime doj;
}//Person
