package com.nt.service;

import java.util.List;

import com.nt.entity.Doctor;

public interface IDoctorService {
	
	//insert single record
	public String registerDoctor(Doctor doctor);
	
	//insert multiple records
	public String registerGroupOfObjects(Iterable<Doctor> doctors);
	
	//count the no.of records
	public long fetchDoctorsCount();
	
	//exists by id(whether id is available or not)
	public boolean checkDoctorAvailability(Integer id);
	
	//find all the records
	public Iterable<Doctor> showAllDoctors();
	
	//find the records by id(find multiple records by id)
	public  Iterable<Doctor> showAllRecordsByIds(Iterable<Integer> ids);
	
	//find the record by id
	public Doctor showDoctorById(Integer id);
	
	//update the record by id
	public String updateDoctorIncomeById(Integer id,float hikePercentage);
	
	//insert or update the doctor with id
	public String registerOrUpdateDoctor(Doctor doctor);
	
	//delete the record by id
	public String deleteDoctorById(Integer id);
	
	//delete the record using delete method(id)
	public String deleteDoctor(Doctor doctor);
	
	//delete the All records
	public String removeAllDoctors();
		
	//delete the multiple records by ids
	public String removeDoctorsByIds(List<Integer> ids);
	

	
}
