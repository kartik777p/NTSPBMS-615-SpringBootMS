package com.nt.runners;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.time.LocalDateTime;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.PersonInfo;
import com.nt.service.IPersonInfoMgmtService;

@Component
public class LobsTestRunner implements CommandLineRunner {
	@Autowired
	private IPersonInfoMgmtService service;

	@Override
	public void run(String... args) throws Exception {
	//save the object
		//gather details from endUser
		Scanner sc=new Scanner(System.in);
		System.out.println("enter name::");
		String name=sc.next();
		System.out.println("Is MArried::?");
		 boolean married=sc.nextBoolean();
		 System.out.println("Enter  photoPath");
		 String photoPath=sc.next();
		 System.out.println(photoPath);
		 System.out.println("Enter  resume Path");
		 String resumePath=sc.next();
		 System.out.println(resumePath);
		 
		 // create byte[]  representing photo file content
		 //collect photo using fileInputstream
		  InputStream is=new FileInputStream(photoPath);
		  //create byte[] array having photo size(length)
		  byte[] photoContent=new byte[is.available()];
		  //save the content to photoCentent by collecting from InputStream
		  photoContent=is.readAllBytes();
		 
		// create char[]  representing resume file content
		  //1.read file using file reader
			 Reader reader=new FileReader(resumePath);
			 // char[] resumeContent=new char[reader.available]; //in reader there is no available method to get length..thats why we are using 2nd technique
			 //2. create file obj having the file to get the length of a file
			 File file=new File(resumePath);
			 //3. create char[] array having file length 
			 char[] resumeContent=new char[(int)file.length()];
			 //read resume from reader
			 reader.read(resumeContent);
			 
		  
		 //prepare with Entity  object with	 data
			 PersonInfo info=new PersonInfo(-1, name, LocalDateTime.of(1990, 10, 20, 11, 23),
					                                                          married, photoContent, resumeContent);
			 try {
				 System.out.println(service.registerPErson(info));
			 }
			 catch(Exception e) {
				 e.printStackTrace();
			 } 
			 /*
		System.out.println("===================================");
		try {
		//Logic to retrieve the object
		PersonInfo info=service.fetchPersonDetailsById(3);
		 if(info!=null) {
			  System.out.println(info.getPid()+"  "+info.getPname()+"  "+info.getDob());
			  byte[] photoContent=info.getPhoto();
			  OutputStream os=new FileOutputStream("retrieve_photo.gif");
			  os.write(photoContent);
			  os.flush();
			  os.close();
			  System.out.println("Photo retrieved from db table col");
			  char[]  resumeContent=info.getResume();
			  Writer writer=new FileWriter("retrive_resume.txt");
			  writer.write(resumeContent);
			  writer.flush();
			  writer.close();
			  System.out.println("Resume retrieved from db table col");
    	 }//if
		 else {
			 System.out.println("record not found");
		 }
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}  */
	}

}
