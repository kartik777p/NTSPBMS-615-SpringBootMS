package com.nit;

import java.util.Set;
import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

@SpringBootApplication
public class BootProj12RunnersLambdaApplication {
   
	//here we are giving  Implementation to Functional Interface like CommandLineRunner so it willbe called automatically
	@Bean
	@Order(-20)
	public CommandLineRunner getRunner() {
		System.out.println("Command Line Runner");
	/*	   //LAMBDA BASED IMPLEMENTATION
	     // style 1
		CommandLineRunner cmd=(String... args)->{
			//convert into string from arrays
			System.out.println(" Data is :- "+Arrays.toString(args));
		};    */
		//style 2
		//CommandLineRunner cmd=(args)->System.out.println(" Data is :- "+Arrays.toString(args));
		
		 //style 3
		   //CommandLineRunner cmd=args->System.out.println(" Data is :- "+Arrays.toString(args));
		  
		//style 4    Lambda with ForEach
		/*    CommandLineRunner cmd=args->{
		    	System.out.println("BootProj12RunnersLambdaApplication.getRunner()");
		    	for(String s: args) {
		    		System.out.println(s);
		    	}
		    };    
		  //return
			return cmd;   */
			
		//METHOD REF BASED IMPLEMENTATION  
		//Style 1
		//  Stream api+static method ref 
	/*	CommandLineRunner cmd=args->{
			Stream.of(args).forEach(System.out::println);
		};    */
		//style 2   (2  line)
		/*CommandLineRunner cmd=args->Stream.of(args).forEach(System.out::println); 
		//return cmd
		return cmd;   */
		
		//style 3 (one)
		 return args->Stream.of(args).forEach(System.out::println);
	}//method
	
	@Bean
	@Order(-10)
	public ApplicationRunner appRunner() {
		System.out.println("Application Runner");
		//style 1
	/*	ApplicationRunner ap=(ApplicationArguments args)->{
			System.out.println("Non Optional Arg values :- "+args.getNonOptionArgs());
			//optional
			System.out.println("Optional Data :- ");
			for(String name:args.getOptionNames()) {
				System.out.println(name+"----->"+args.getOptionValues(name));
			}
		};    */
		//style 2
		ApplicationRunner ap=args->{
			System.out.println("Non Optional Arg values :- "+args.getNonOptionArgs());
			//get name of the args
			Set<String> optionsArgs=args.getOptionNames();
			System.out.println("Optional Data :- ");
			//itrate 
			optionsArgs.forEach(name->{
				System.out.println(name);
				System.out.println(args.getOptionValues(name));
			});
		};
		//
		return ap;
	}//method
	
	public static void main(String[] args) {
		SpringApplication.run(BootProj12RunnersLambdaApplication.class, args);
	}//main
}//class
