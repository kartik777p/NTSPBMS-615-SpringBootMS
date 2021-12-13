package com.nit.beans;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("pInfo")
@Data
@ConfigurationProperties("person.info")
public class PersonInfo {
	//simple type Property
   private int pId;
   private String pName;
   //String Array type Props
   private String[] favColor;
   //List Type Props
   private List<String> studies;
   //set Type Props
   private Set<Long> phoneNumber;
   //map type Props
   private Map<String,Object> idDetails;
   //HAS-A property
   @Autowired
   private JobDeteails jobDetails;
   
   
}
