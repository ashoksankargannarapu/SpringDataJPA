package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import com.nt.service.IEmployeeMgmtService;

@Component
public class CallingPLDSQLProcedureTest implements CommandLineRunner {
	
	@Autowired
	private IEmployeeMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		//invoke the b.method of service
		service.showEmployeesBySalaryRange(1.0, 1000.0).forEach(System.out::println);
		
	}

}
