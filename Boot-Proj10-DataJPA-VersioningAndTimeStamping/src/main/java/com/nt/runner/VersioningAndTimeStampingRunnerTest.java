package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.CallerTuneInfo;
import com.nt.service.ICallerTuneMgmtService;
@Component
public class VersioningAndTimeStampingRunnerTest implements CommandLineRunner {

	@Autowired
	private ICallerTuneMgmtService service;
	@Override
	public void run(String... args) throws Exception {
		/*try {
			CallerTuneInfo info=new CallerTuneInfo("Natu Natu","RRR");
			System.out.println(service.saveCallerTuneInfo(info));
			
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		try {
			System.out.println(service.updateTuneInfoById(1, "Tring Tring", "JaiLavaKusa"));
			System.out.println(service.showCallerTuneDetailsById(1));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
