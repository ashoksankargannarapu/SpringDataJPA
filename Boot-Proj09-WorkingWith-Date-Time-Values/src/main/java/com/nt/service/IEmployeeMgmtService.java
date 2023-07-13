package com.nt.service;

import java.util.List;

import com.nt.entity.Employee_Date_Time;



public interface IEmployeeMgmtService {
	
	public String saveEmployee(Employee_Date_Time emp);
	public List<Employee_Date_Time> getAllEmployees();
	public List<Integer> showEmployeeAgesByDesg(String desg);
	
}
