package com.nt.runner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Employee_Date_Time;

import com.nt.service.IEmployeeMgmtService;

@Component
public class RunnerTest implements CommandLineRunner {
	
	@Autowired
	private IEmployeeMgmtService service;
	@Override
	public void run(String... args) throws Exception {
		//invoke the b.method of service
		/*Employee_Date_Time emp=new Employee_Date_Time("Sankar", "clerk", 
				                LocalDate.of(2001, 1, 4) ,
				                LocalTime.of(22, 45), 
				                LocalDateTime.of(1995,10,21,15,10,3));
		System.out.println(service.saveEmployee(emp));*/
		
		//service.getAllEmployees().forEach(System.out::println);
		
		try {
		service.showEmployeeAgesByDesg("clerk").forEach(System.out::println);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
