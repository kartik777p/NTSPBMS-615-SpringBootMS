package com.nit.runners;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.document.Tourist;
import com.nit.service.ITouristMgmtService;

@Component
public class MongoDbCrudOperationTestRunner implements CommandLineRunner {
 
	@Autowired
	private ITouristMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		//create 1 tourist obj having all details
	/*	System.out.println("==========Add single Tourist ==================");
		//if we provide id explicitly our id will come
		//Tourist tr=new Tourist("101","kpkartik","pune",8007275703L,"2222333334444",true);
		 //if we do not give id then mongodb will internly genrate id (instread of id we are sending null bcz all args cons)
		Tourist tr=new Tourist(null,"kpkartik","pune",8007275703L,"2222333334444",true);
		//use service class
		System.out.println(service.registerTourist(tr));
    */
		/*--------------------------------------------------------------------------------------------------*/ 
		//create 1 tourist obj having some details (Scalar docs)
	/*	Tourist tr1=new Tourist();
		tr1.setTName("Mahesh");
		tr1.setAddrs("Mumbai");
		tr1.setMoNumber(8007275703L);
		//use service class
		System.out.println(service.registerTourist(tr1));  */
		/*--------------------------------------------------------------------------------------------------*/
		/*
		System.out.println("==========fetch All Tourist ==================");
		service.fetchAllTourist().forEach(System.out::println);
		*/
		/*--------------------------------------------------------------------------------------------------*/
		/*System.out.println("==========fetch  Tourist By Id ==================");
		 System.out.println(service.fetchTouristById("6204b49d266eb66794811770")); //id is type string   */
		/*--------------------------------------------------------------------------------------------------*/
		/*System.out.println("==========fetch All Tourist using  Example Obj ==================");
		//create a tourist with some details for the matching
		Tourist tr=new Tourist();
		//tr.setTNo("101");
		//tr.setTName("kpkartik");
		//tr.setAddrs("akola");
		tr.setMoNumber(8007275703L);  //2 docs will display bcz 2 docs contains this number (show  more(tourist) like this which is like amazon)
		//user service by passing this obj
		service.fetchAllByExample(tr).forEach(System.out::println);  */
		/*--------------------------------------------------------------------------------------------------*/
	/*	System.out.println("==========fetch All Tourist using  Example Obj And With Sorting ==================");
		//create a tourist with some details for the matching
				Tourist tr=new Tourist();
				tr.setMoNumber(8007275703L);  //2 docs will display bcz 2 docs contains this number (show  more(tourist) like this which is like amazon)
				//user service by passing this obj and sort details
				service.fetchAllByExampleAndSort(tr,false,"tName").forEach(System.out::println);  */
				/*--------------------------------------------------------------------------------------------------*/
	/*	System.out.println("==========fetch All Tourist  With Sorting ==================");
		service.fetchAllBySort(true,"addrs").forEach(System.out::println);  */
		/*--------------------------------------------------------------------------------------------------*/
		/*System.out.println("==============Update Tourist mobileNumber  ==================");
		System.out.println(service.ModifyTourist("6204b9b6fda2374b102e4e96",860121026L));  */
		
		/*--------------------------------------------------------------------------------------------------*/
	/*	System.out.println("==============Delete Tourist by Id  ==================");
		System.out.println(service.removeTouristById("6204c0b55a66831bef54a194"));   */
		
		System.out.println("==============Save Multiple Tourist by group  ==================");
		//create arraylist obj to hold list of tourist
		List<Tourist> list=new ArrayList();
		//create 3 tourist obj
		Tourist tourist1=new Tourist(null,"maddy", "mumbai", 9766667674L," 111122223333", false);
		Tourist tourist2=new Tourist(null,"shivam", "washim", 9764677674L," 12346789012", true);
		Tourist tourist3=new Tourist(null,"rishabh", "tumsar", 9789877674L," 00987643212", false);
		//add to arraylist
		list.add(tourist1);
		list.add(tourist2);
		list.add(tourist3);
		//use service by sending list of Tourist
		System.out.println(service.registerTouristByGroup(list));
	}//run
}//class