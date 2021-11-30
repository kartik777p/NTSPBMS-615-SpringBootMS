package com.nit.model;

public class Employee {
	private long empNo;
	private String empName;
	private String job;
	private double sal;

//   cons
	public Employee() {
		System.out.println("Employee::- 0-param constuctor ");
	}

	public long getEmpNo() {
		return empNo;
	}

	public void setEmpNo(long empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empName=" + empName + ", job=" + job + ", sal=" + sal + "]";
	}
}// class
