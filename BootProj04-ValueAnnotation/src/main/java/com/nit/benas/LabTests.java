package com.nit.benas;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("labTst")
@Data
public class LabTests {
	@Value("${lb.urin}")
     private double urinTst;     //dont take it as private so we can use in SPEL
	
	@Value("${lb.blood}")
	private double bloodTst;
	
	@Value("${lb.bp}")
	private double bpTst;
}
