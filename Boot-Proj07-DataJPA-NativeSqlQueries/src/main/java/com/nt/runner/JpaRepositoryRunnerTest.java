package com.nt.runner;

import java.util.Arrays;
import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.service.IDoctorMgmtService;

@Component
public class JpaRepositoryRunnerTest implements CommandLineRunner {
	
	@Autowired
	private IDoctorMgmtService service; 

	@Override
	public void run(String... args) throws Exception {
		
		//System.out.println(service.insertDoctor("suresh", 50000.0, "physician"));
		System.out.println("system date and time::"+service.showSystemDate());
		//System.out.println(service.createTempDBTable());
	}
	

}
