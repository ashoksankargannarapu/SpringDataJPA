package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Employee_Date_Time;
import com.nt.repository.EmployeeDateTimeRepository;




@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private EmployeeDateTimeRepository empRepo;

	 @Override
	public String saveEmployee(Employee_Date_Time emp) {
		int idVal=empRepo.save(emp).getEno();
		return "Employee is saved with id::"+ idVal;
	}
	@Override
	public List<Employee_Date_Time> getAllEmployees() {
		return empRepo.findAll();
	}
	@Override
	public List<Integer> showEmployeeAgesByDesg(String desg) {
		return empRepo.getEmployeeAgesByDesg(desg);
	}
}
