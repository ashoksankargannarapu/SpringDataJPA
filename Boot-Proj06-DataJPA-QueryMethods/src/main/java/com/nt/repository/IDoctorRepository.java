package com.nt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.nt.entity.Doctor;

import jakarta.transaction.Transactional;

public interface IDoctorRepository extends JpaRepository<Doctor, Integer>{
	//@Query("FROM Doctor WHERE income>=?1 AND income<=?2")
	//@Query("FROM com.nt.entity.Doctor WHERE income>=?1 AND income<=?2")
	//@Query("FROM Doctor doc WHERE doc.income>=?1 AND doc.income<=?2")
	//@Query("FROM Doctor doc WHERE doc.income>=? AND doc.income<=?")IllegalArgumentException
	/*@Query("FROM Doctor WHERE income>=:start AND income<=:end")
	public List<Doctor> searchDoctorsByIncomeRange(@Param("start")double startRange,@Param("end")double endRange);
	*/
	@Query("FROM Doctor WHERE income>=:start AND income<=:end")
	public List<Doctor> searchDoctorsByIncomeRange(double start, double end);
	
	
	//-----------Select-Entity Query-------------
	@Query("FROM Doctor WHERE specialization IN(:sp1,:sp2) ORDER BY specialization")
	public List<Doctor> searchDoctorBySpecialization(String sp1,String sp2);
	
	//-----------Select-Projection Query with Specific multiple col values
	@Query("SELECT docId,docName,income FROM Doctor WHERE  income between :start and :end")
	public List<Object[]> searchDoctorDataByIncome(double start,double end);
	
	//----------Select--Projection Qyery with specific single col values------
	@Query("SELECT docName FROM Doctor WHERE income between :min and :max")
	public List<String> searchAllDoctorNamesByIncomeRange(double min,double max);
	
	//--------Entity query giving single record--------------
	@Query("FROM Doctor where docName=:name")//assume that doctor
	public Optional<Doctor> showDoctorInfoByName(String name);
	
	//---------Scalar Query giving single record multiple col values----
	@Query("SELECT docId,docName FROM Doctor where docName=:name")
	public Object showDoctorDataByName(String name);
	
	//-----------Scalar query giving single record col value
	@Query("SELECT specialization FROM Doctor where docName=:name")
	public String showSpecializationByName(String name);
	
	@Query("SELECT count(distinct docName)From Doctor")
	public int fetchDoctorsNameCount();
    @Query("SELECT count(*),max(income),min(income),avg(income),sum(income)from Doctor")
    public Object fetchAggregateData();
    
    @Query("update Doctor SET income=income+(income*:percentage/100.0)WHERE specialization=:sp")
    @Modifying
    @Transactional
    public int hikeDoctorsIncomeBySpecialization(String sp,double percentage);
    
    @Query("DELETE  FROM Doctor WHERE income>=:start AND income<=:end")
    @Modifying
    @Transactional
    public int removeDoctorsByIncomeRange(double start,double end);
    
    

}
