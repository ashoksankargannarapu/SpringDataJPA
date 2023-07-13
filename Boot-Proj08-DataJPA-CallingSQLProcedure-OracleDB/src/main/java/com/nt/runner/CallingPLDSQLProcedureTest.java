package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IDoctorMgmtService;

@Component
public class CallingPLDSQLProcedureTest implements CommandLineRunner {
	
	@Autowired
	private IDoctorMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		//invoke the b.method of service
		service.showDoctorsByIncomeRange(10000.0, 45000.0).forEach(System.out::println);
		
	}

}
