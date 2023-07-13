package com.nt.runner;

import java.nio.file.FileSystemNotFoundException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepository;


@Component
public class JpaRepositoryRunnerTest implements CommandLineRunner {
	@Autowired
	private IDoctorRepository doctorRepo;
	

	@Override
	public void run(String... args) throws Exception {
		//these three methods are same
		
		//doctorRepo.findByDocNameEquals("Rama").forEach(System.out::println);
		/*System.out.println("____________________________________________");
		doctorRepo.findByDocNameIs("sita").forEach(System.out::println);
		System.out.println("____________________________________________");
		doctorRepo.findByDocName("venky").forEach(System.out::println);*/
		
		//doctorRepo.findByIncomeBetween(10000, 30000).forEach(System.out::println);
		//doctorRepo.findBySpecializationIn(Arrays.asList("cardio","ortho")).forEach(System.out::println);
		
		//doctorRepo.findByDocNameLike("s%").forEach(System.out::println);
		
		//doctorRepo.findByDocNameStartingWith("va").forEach(System.out::println);
	    
		//doctorRepo.findByDocNameEndingWith("y").forEach(System.out::println);
		
		//doctorRepo.findByDocNameContaining("it").forEach(System.out::println);
		
		//doctorRepo.findByDocNameEqualsIgnoreCase("Sita").forEach(System.out::println);
		
		//doctorRepo.findByDocNameContainingIgnoreCase("sITa").forEach(System.out::println);
		
		/*Iterable<Doctor> iterable=doctorRepo.findByIncomeGreaterThanEqualAndIncomeLessThanEqual(25000.0, 40000.0);
		iterable.forEach(System.out::println)*/;
		
		doctorRepo.findBySpecializationInOrIncomeBetween(List.of("MBBS","Dentist"),3000.0,26000).forEach(System.out::println);;
	}
	
	

}
