package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Doctor;

public interface IDoctorRepository extends JpaRepository<Doctor, Integer>{
	//On Entity Queries(Select all cols of the db table)
	
	//SELECT * FROM JPA_DOCTOR_INFO WHERE DOCNAME=?
	public Iterable<Doctor> findByDocNameEquals(String docName);

	//SELECT * FROM JPA_DOCTOR_INFO WHERE DOCNAME=?
	public Iterable<Doctor> findByDocNameIs(String docName);
	
	//SELECT * FROM JPA_DOCTOR_INFO WHERE DOCNAME=?
	public Iterable<Doctor> findByDocName(String docName);
	
	//SELECT * FROM JPA_DOCTOR_INFO WHERE INCOME BETWEEN ? AND ?
	public Iterable<Doctor> findByIncomeBetween(double start,double end);
	
	//SELECT * FROM JPA_DOCTOR_INFO WHERE SPECIALIZATION IN(?,?,?)
	public Iterable<Doctor> findBySpecializationIn(List<String> specialities);
	
	//SELECT * FROM JPA_DOCTOR_INFO WHERE DOCNAME LIKE?
	public Iterable<Doctor> findByDocNameLike(String cond);
	
	public Iterable<Doctor> findByDocNameStartingWith(String initchars);
	
	public Iterable<Doctor> findByDocNameEndingWith(String initchars);
	
	public Iterable<Doctor> findByDocNameContaining(String initchars);
	
	public Iterable<Doctor> findByDocNameEqualsIgnoreCase(String name);
	
	public Iterable<Doctor> findByDocNameContainingIgnoreCase(String name);
	
	public Iterable<Doctor> findByIncomeGreaterThanEqualAndIncomeLessThanEqual(double startRange,double endRange);
	
	public Iterable<Doctor> findBySpecializationInOrIncomeBetween(List<String> specials,double start,double end);
	
	
	
	
	
	
	

}
