package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.nt.entity.Employee_Info;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Service("doctorService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private EntityManager manager;

	@Override
	public List<Employee_Info> showEmployeesBySalaryRange(double start, double end) {
		// Create storedProcedureQuery object pointing pl/SQL procedure
		StoredProcedureQuery query = manager.createStoredProcedureQuery("p_emp_details_by_salaryRange",
				Employee_Info.class);
		// register both in,out params by specifying their mode
		query.registerStoredProcedureParameter(1, Double.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, Double.class, ParameterMode.IN);
		// set values to in params
		query.setParameter(1, start);
		query.setParameter(2, end);
		// call PL/SQL procedure
		List<Employee_Info> list = query.getResultList();
		return list;
	}

}
