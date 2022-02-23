package com.nit.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.ListIndexBase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "EMPLOYEE_DETAILS_INFO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {

  @Id
  @GeneratedValue
    private Integer eid;
  
    private String ename;
    
    //LIST TYPE 																																	//to enable collections mapping
    @ElementCollection 				
   /* @JoinTable(name = "EMPLOYEE_CONTACT_DETAILS")  							
    @JoinColumn(name = "EMP_ID",referencedColumnName = "EID")  */ //Here problem with Foregin key Column name(No Our choise column name)
      //OUR CHOICE FK COLUMN NAME   
    @CollectionTable(name="EMPLOYEE_FRIRNDS", joinColumns = @JoinColumn(name="EMP_ID",referencedColumnName = "EID")) 
    @OrderColumn(name="FRIEND_INDEX")															//Create Column name to Store index IN Child table (Applicable only on List type)
    @ListIndexBase(value = 1)																						//Start endex From 1(Applicable only on List type)
   @Column(name="FRIENDS_NAME",length = 20)                                             //Create  FRIENDS_NAME Column in Parent table to store names
    //2nd way
    @LazyCollection(LazyCollectionOption.FALSE)  //Along with parent table child table should be loaded so no need of any cfgs in Application.properties
    private  List<String> friends;
    
    //SET TYPE 
    @ElementCollection 																									//to enable collections mapping														
    @CollectionTable(name="EMPLOYEE_CONTACT_DETAILS", joinColumns = @JoinColumn(name="EMP_ID",referencedColumnName = "EID"))
    @Column(name="PHONE_NUMBERS",length = 11)                                       //Create  Phone_Numbers Column in Parent table to store phone_Numbers
    @LazyCollection(LazyCollectionOption.FALSE)  //Along with parent table child table should be loaded so no need of any cfgs in Application.properties
    private Set<Long> phoneNumbers;
    
    @ElementCollection 					                                                       //to enable collections mapping
    @CollectionTable(name="EMPLOYEE_ID_DETAILS", joinColumns = @JoinColumn(name="EMP_ID",referencedColumnName = "EID"))
    @MapKeyColumn(name = "CARD_TYPE",length = 20)                               //Create column in Child table of Card_Type to Hold key
    @Column(name="CARD_NUMBERS",length = 20)                            //Create column in Child table of CARD_NUMBER to Hold VALUES
    @LazyCollection(LazyCollectionOption.FALSE)  //Along with parent table child table should be loaded so no need of any cfgs in Application.properties
    private Map<String,String> idDetails;
}
