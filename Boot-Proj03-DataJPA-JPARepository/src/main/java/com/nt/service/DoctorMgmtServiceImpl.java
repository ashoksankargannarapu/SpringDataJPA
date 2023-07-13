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
	public String deleteDoctorsByIdsInBatch(List<Integer> ids) {
		//load the entities
		List<Doctor> list=doctorRepo.findAllById(ids);
		//delete the entities
		doctorRepo.deleteAllByIdInBatch(ids);
		
		return list.size()+"records are deleted";
	}
	@Override
	public List<Doctor> showDoctorsByExampleData(Doctor exDoctor, boolean ascOrder, String... properties) {
		//prepare sort object
		Sort sort=Sort.by(ascOrder?Direction.ASC:Direction.DESC,properties);
		//Example object
		Example example=Example.of(exDoctor);
		//use the repo
		List<Doctor> list=doctorRepo.findAll(example,sort);
		//return the collection
		return list;
	}
	@Override
	public Doctor findDoctorById(Integer id) {
		//Doctor doctor1=doctorRepo.getById(id);
		Doctor doctor=doctorRepo.getReferenceById(id);
		return doctor;
	}
	
	
	

}
