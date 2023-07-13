package com.nt.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepository;

@Service
public class DoctorMgmtServiceImpl implements IDoctorMgmtService {
	
	@Autowired
	private IDoctorRepository doctorRepo;

	@Override
	public List<Doctor> showDoctorsByIncomeRange(double startRange, double endRange) {
		return doctorRepo.searchDoctorsByIncomeRange(startRange, endRange);
	}
	@Override
	public List<Doctor> searchDoctorsBySpecialization(String sp1, String sp2) {
		//use repo
		List<Doctor> list=doctorRepo.searchDoctorBySpecialization(sp1, sp2);
		return list;
	}
	@Override
	public List<Object[]> showDoctorsDataByIncome(double start, double end) {
		List<Object[]> list=doctorRepo.searchDoctorDataByIncome(start, end);
		return list;
		
	}
	@Override
	public List<String> showAllDoctorNamesByIncomeRange(double min, double max) {
		List<String> list=doctorRepo.searchAllDoctorNamesByIncomeRange(min, max);
		return list;
	}
	@Override
	public Doctor searchDoctorByNameDocName(String docName) {
		Doctor doc=doctorRepo.showDoctorInfoByName(docName).orElseThrow(()-> new IllegalArgumentException("Doctor not found"));
		return doc;
	}
	@Override
	public Object searchDoctorDataByName(String docName) {
		Object object=doctorRepo.showDoctorDataByName(docName);
		return object;
	}
	@Override
	public String searchSpecializationByName(String docName) {
		String result=doctorRepo.showSpecializationByName(docName);
		return result;
	}
	@Override
	public int showDoctorNamesCount() {
		int count=doctorRepo.fetchDoctorsNameCount();
		return count;
	}
	@Override
	public Object showAggregateData() {
		Object obj=doctorRepo.fetchAggregateData();
		return obj;
	}

	/*@Override
	public int appraiseDoctorsIncomeBySpecialization(String specialization, double hikePercentage) {
		int count=doctorRepo.hikeDoctorsIncomeBySpecialization(specialization, hikePercentage);
		return count;
	}*/
	@Override
	public int fireDoctorsByIncomeRange(double start, double end) {
		return doctorRepo.removeDoctorsByIncomeRange(start, end);
	}
	
	
	

}
