package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.entity.Doctor;
import com.nt.service.IDoctorService;

@SpringBootApplication
public class BootProj1DataJpaApplication {

	public static void main(String[] args) {
		// get IOC container
		ApplicationContext ctx = SpringApplication.run(BootProj1DataJpaApplication.class, args);
		// get service class obj
		IDoctorService service = ctx.getBean("doctorService", IDoctorService.class);

		/*	try {
				//create Doctor class object
				Doctor doctor=new Doctor();
				doctor.setDocName("ramu");
				doctor.setSpecialization("MBBS");
				doctor.setIncome(650000.0);
				//invoke the b.method
				String resultMsg=service.registerDoctor(doctor);
				System.out.println(resultMsg);
				
			}
			catch (Exception e) {
				e.printStackTrace();
			}*/
		/*	
		try {
			//create Doctor class object
			Doctor doc1=new Doctor();
			doc1.setDocName("ramu");
			doc1.setSpecialization("MBBS");
			doc1.setIncome(650000.0);
			
			Doctor doc2=new Doctor();
			doc2.setDocName("ashok");
			doc2.setSpecialization("physician");
			doc2.setIncome(550000.0);
			
			Doctor doc3=new Doctor();
			doc3.setDocName("valmiki");
			doc3.setSpecialization("ortho");
			doc3.setIncome(450000.0);
			//invoke the b.method
			String resultMsg=service.registerGroupOfObjects(List.of(doc1,doc2,doc3));
			System.out.println(resultMsg);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}*/
		
		//count the no.of records
		/*try {
			System.out.println("count of records::"+service.fetchDoctorsCount());
		}catch (Exception e) {
			e.printStackTrace();
		}*/
		
		//exists by Id
		/*try {
			System.out.println("Id doctor exists?::"+service.checkDoctorAvailability(13));
		}catch (Exception e) {
			e.printStackTrace();
		}*/
		
		//find all the records
		/*try {
			Iterable<Doctor> itr=service.showAllDoctors();
			itr.forEach(System.out::println);
		}catch (Exception e) {
			e.printStackTrace();
		}*/
		
		//find all records by ids
		/*try {
			service.showAllRecordsByIds(List.of(1,3,4,6,10)).forEach(System.out::println);
		}
		catch (Exception e) {
			e.printStackTrace();
		}*/
		
		//find record by id
		/*try {
			Doctor doctor=service.showDoctorById(8);
			System.out.println(doctor);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}*/
		//update the record
		/*try {
			System.out.println("10 doctor info::"+service.showDoctorById(10));
			System.out.println(service.updateDoctorIncomeById(101, 20.0f));
			System.out.println("10 doctor info::"+service.showDoctorById(10));
		}
		catch (Exception e) {
			e.printStackTrace();
		}*/
		/*try {
			Doctor doc=new Doctor();
			doc.setDocId(9);
			doc.setDocName("Sankar");
			doc.setIncome(49000.0);
			doc.setSpecialization("MBBS");
			System.out.println(service.registerOrUpdateDoctor(doc));
		}
		catch (Exception e) {
			e.printStackTrace();
		}*/
		
		//delete the record by id
		/*try {
			System.out.println(service.deleteDoctorById(10));
		}catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			Doctor doc=new Doctor();
			doc.setDocId(12);
			doc.setDocName("sdfsj");
			System.out.println(service.deleteDoctor(doc));
		}
		catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			System.out.println(service.removeAllDoctors());
		}catch (Exception e) {
			e.printStackTrace();
		}*/
		
		try {
			System.out.println(service.removeDoctorsByIds(List.of(23,24)));
		}catch (Exception e) {
			e.printStackTrace();
		}

		// close the IOC container
		((ConfigurableApplicationContext) ctx).close();
	}

}
