package com.nt.runner;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.model.prod.Product;
import com.nt.model.promotions.Offers;
import com.nt.repository.prod.IProductRepo;
import com.nt.repository.promotions.IOfferRepo;
@Component
public class MultiDataSourceRunner implements CommandLineRunner {
	@Autowired
	private IProductRepo prodRepo;
	
	@Autowired
	private IOfferRepo offerRepo;

	@Override
	public void run(String... args) throws Exception {
		/*//save objects
		prodRepo.saveAll(Arrays.asList(new Product("table",100.0,60000.0),
									   new Product("chair",10.0,6000.0), 
									   new Product("sofa",11.0,62000.0)));
		System.out.println("Products are saved");
		System.out.println("===================================================");
		offerRepo.saveAll(Arrays.asList(new Offers("Buy-1-Get-1","B1G1",100.0,LocalDate.of(2023, 04, 10)),
				                        new Offers("Buy-1-Get-2","B1G2",200.0,LocalDate.of(2023, 03, 25)),
				                        new Offers("Buy-2-Get-2","B2G2",100.0,LocalDate.of(2023, 04, 15))));
		System.out.println("Offers are saved");*/
		System.out.println("==========================================");
		System.out.println("=========display records(Products)=============");
		 prodRepo.findAll().forEach(System.out::println);
		System.out.println("-------------------------------------");
		System.out.println("=========display records(Offers)=============");
		offerRepo.findAll().forEach(System.out::println);
		

	}

}
