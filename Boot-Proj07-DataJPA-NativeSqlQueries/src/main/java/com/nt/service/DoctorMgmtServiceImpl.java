package com.nt.service;


import java.util.List;

import org.hibernate.sql.ast.tree.expression.Distinct;
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
	public String insertDoctor(String name, double income, String specialization) {
		int count=doctorRepo.registerDoctor(name, specialization, income);
		return count==0?"Doctor not registered":"Doctor is registered";
	}
	@Override
	public String showSystemDate() {
		return doctorRepo.showSystemDate();
	}
	@Override
	public String createTempDBTable() {
		int count=doctorRepo.createTempTable();
		return count==0?"db table is  created":"db table is not created";
	}
	
	
	

}
