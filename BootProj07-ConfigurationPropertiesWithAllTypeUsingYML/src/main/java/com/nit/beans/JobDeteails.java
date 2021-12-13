package com.nit.beans;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component("jDetails")
public class JobDeteails {
	//dont take it as private  so we can acess it directly
	 String desc;
	 String CompanyName;
	 Integer deptNo;

}
