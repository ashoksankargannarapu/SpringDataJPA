package com.nt.service;

import java.util.List;



import com.nt.entity.Doctor;

public interface IDoctorMgmtService {
	public String insertDoctor(String name,double income,String specialization);
	public String showSystemDate();
	public String createTempDBTable();
}
