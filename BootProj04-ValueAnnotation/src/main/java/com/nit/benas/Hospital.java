package com.nit.benas;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("hsptl")
@Data
public class Hospital {
	//@Value("101")       -> not good bcz if we want to change the value we need to touch the source code 
	@Value("${hsptl.id}")
	private int id;
	
	//@Value("kokilaben")    -> not good bcz if we want to change the value we need to touch the source code
  @Value("${hsptl.name}")
  private String name;
	
	//@Value("mumbai")       -> not good bcz if we want to change the value we need to touch the source code
  @Value("${hsptl.addrs}")
  private String addrs;
  
  /*******************Some predefined keys ************************************/
  @Value("${Path}")
  private String path;
  
  @Value("${os.name}")
  private String osName;
  
	
   //autowired LabTest
   //@Autowired
 // @Value("#{labTst}")     //using SPEL we can perfrom injection   if we want to use SPEL we have to use #{ } here
   private  LabTests lbtst;
   
 //calculate bill amt SPEL expression language
 @Value("#{labTst.urinTst+labTst.bloodTst+labTst.bpTst}")
 private  Double calcLabTestAmt;

	@Override
	public String toString() {
		return "Hospital [id=" + id + ", name=" + name + ", addrs=" + addrs + ", path=" + path + ", osName=" + osName
				+ ", lbtst=" + lbtst + ", calcLabTestAmt=" + calcLabTestAmt + "]";
	}
    


}
