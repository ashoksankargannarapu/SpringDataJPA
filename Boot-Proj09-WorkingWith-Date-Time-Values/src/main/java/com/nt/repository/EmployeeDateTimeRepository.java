package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Employee_Date_Time;

public interface EmployeeDateTimeRepository extends JpaRepository<Employee_Date_Time, Integer> {
	
	@Query(nativeQuery = true,value = "SELECT YEAR(CURRENT_TIMESTAMP)-YEAR(DOB)FROM EMPLOYEE_DATE_TIME WHERE DESG=?1")
	public List<Integer> getEmployeeAgesByDesg(String job);
}
