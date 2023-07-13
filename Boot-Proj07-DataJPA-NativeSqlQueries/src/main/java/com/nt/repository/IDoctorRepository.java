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
	@Query(value="INSERT INTO JPA_DOCTOR_INFO VALUES(DOCID_SEQ.NEXTVAL,:name,:income,:special)",nativeQuery=true)
	@Modifying
	@Transactional
	public int registerDoctor(String name,String special,double income);

	@Query(value="SELECT SYSDATE FROM DUAL",nativeQuery = true)
	public String showSystemDate();
	@Query(value="CREATE TABLE TEMP(col1 number(5))",nativeQuery=true)
	@Modifying
	@Transactional
	public int createTempTable();
    

}
