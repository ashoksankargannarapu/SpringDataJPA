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
		service.showDoctorsByIncomeRange(25000.0, 35000.0).forEach(System.out::println);
		System.out.println("--------------------------------------------");
		service.searchDoctorsBySpecialization("physician","cardio").forEach(System.out::println);
		System.out.println("-----------------------------------------");
		System.out.println("------select-Entity Projection Query -(specific multiple col values)__");
		service.showDoctorsDataByIncome(20000.0,40000.0).forEach(row->{
			for(Object obj:row) {
				System.out.println(obj+" ");
			}
			System.out.println();
		});
		System.out.println("---------------------------------------------");
		System.out.println("_______select --Entity Projection Query__(specific single col value___");
		service.showAllDoctorNamesByIncomeRange(20000.0, 30000.0).forEach(System.out::println);
		System.out.println("-----Single record value-------");
		Doctor doctor=service.searchDoctorByNameDocName("ashok");
		System.out.println("Doctor info::"+doctor);
		System.out.println("-------------------------------");
		Object object=service.searchDoctorDataByName("ashok");
		Object data[]=(Object[])object;
		for(Object o:data) {
			System.out.println(o+" ");
		}
		System.out.println("__________________________________________");
		System.out.println("Result is:"+Arrays.toString(data));
		System.out.println("------------------------------");
		String result=service.searchSpecializationByName("ashok");
		System.out.println("Specialization is::"+result);
		System.out.println("------------------------");
		System.out.println("Unique doctor names count::"+service.showDoctorNamesCount());
		System.out.println("_______________________________________________");
		Object[] results=(Object[])service.showAggregateData();
		System.out.println("records count::"+results[0]);
		System.out.println("max income value::"+results[1]);
		System.out.println("min income value::"+results[2]);
		System.out.println("Avg of income::"+results[3]);
		System.out.println("Sum of income::"+results[4]);
		System.out.println("____________________________________________");
		System.out.println("_______non-select operations____________");
       // int count=service.appraiseDoctorsIncomeBySpecialization("cardio", 10.0);
        //System.out.println("No.of records that are effected::"+count);
        System.out.println("-----------------------------------------");
        System.out.println("deleted doctors count::"+service.fireDoctorsByIncomeRange(10000.0, 35000.0));
	}
	

}
