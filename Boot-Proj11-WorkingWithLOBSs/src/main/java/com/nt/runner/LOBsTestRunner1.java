package com.nt.runner;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.MarriageSeeker;
import com.nt.service.IMatrimonyServiceMgmt;
@Component
public class LOBsTestRunner1 implements CommandLineRunner {
	@Autowired
	private IMatrimonyServiceMgmt service;
	@Override
	public void run(String... args) throws Exception {
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter Marriage seeker id::");
		int id=scn.nextInt();
		Optional<MarriageSeeker> opt=service.searchSeekerById(id);
		if(opt.isPresent()) {
			MarriageSeeker seeker=opt.get();
			System.out.println(seeker.getId()+" "+seeker.getName()+" "+seeker.getAddrs()+" "+seeker.isIndian());
			OutputStream os=new FileOutputStream("retrieve_photo.jpeg");
			os.write(seeker.getPhoto());
			os.flush();
			Writer writer=new FileWriter("retrieve_resume.pdf");
			writer.write(seeker.getResume());
			writer.flush();
			os.close();
			writer.close();
			System.out.println("Lobs are retrieved");
			

	}else {
		System.out.println("Record not found");
	}
	}

}
