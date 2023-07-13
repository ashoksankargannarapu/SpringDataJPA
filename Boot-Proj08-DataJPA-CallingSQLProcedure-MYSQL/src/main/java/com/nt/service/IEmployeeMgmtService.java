package com.nt.service;

import java.util.List;

import com.nt.entity.Employee_Info;





public interface IEmployeeMgmtService {
	public List<Employee_Info> showEmployeesBySalaryRange(double start,double end);
}
