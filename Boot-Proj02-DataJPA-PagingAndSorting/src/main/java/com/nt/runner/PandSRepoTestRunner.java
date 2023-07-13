package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.service.IDoctorMgmtService;

@Component
public class PandSRepoTestRunner implements CommandLineRunner {
	
	@Autowired
	private IDoctorMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		/*service.showDoctorsBySorting(true, "docName").forEach(System.out::println);
		System.out.println("_____________________________");
		service.showDoctorsBySorting(false, "income","docName").forEach(System.out::println);
		*/
		
		/*Page<Doctor> page=service.showDoctorsInfoByPageNo(1, 3, true, "docName");
		System.out.println("Page Number::"+page.getNumber());
		System.out.println("Pages count::"+page.getTotalPages());
		System.out.println("Is it first page::"+page.isFirst());
		System.out.println("Is it last page::"+page.isLast());
		System.out.println("Page Size::"+page.getSize());
		System.out.println("page elements count::"+page.getNumberOfElements());
		if(!page.isEmpty()) {
			List<Doctor> list=page.getContent();
			list.forEach(System.out::println);
		}else {
			System.out.println("No page found");
		}*/
		
		service.showDataThroughPagination(3);
	}

}
