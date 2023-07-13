package com.nt.runner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.time.LocalDateTime;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.MarriageSeeker;
import com.nt.service.IMatrimonyServiceMgmt;
//@Component
public class LOBsTestRunner implements CommandLineRunner{
	@Autowired
	private IMatrimonyServiceMgmt service;

	@Override
	public void run(String... args) throws Exception {
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter Person name::");
		String name=scn.next();
		System.out.println("Enter Person address::");
		String addrs=scn.next();
		System.out.println("Enter Person photo file complete path::");
		String photoPath=scn.next();
		System.out.println("Enter Person resume file complete path::");
		String bioDataPath=scn.next();	
		System.out.println("Is the person Indian?::");
		boolean indian=scn.nextBoolean();
		//prepare byte[] representing photo file content
		InputStream is=new FileInputStream(photoPath);
		byte[] photoData=new byte[is.available()];
		photoData=is.readAllBytes();
		//prepare char[] representing resume file content
		File file=new File(bioDataPath);
		Reader reader=new FileReader(file);
		char bioDataContent[]=new char[(int)file.length()];
		reader.read(bioDataContent);
		
		//prepare Entity Class obj
		MarriageSeeker seeker=new MarriageSeeker(name, addrs, photoData, LocalDateTime.of(1990,11,23,12,45), bioDataContent, indian);
		System.out.println(service.registerMarriageSeeker(seeker));
		
		
		
	}

}
