package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.Employee;

public interface IEmployeeInfoRepository extends JpaRepository<Employee, Integer> {

}
