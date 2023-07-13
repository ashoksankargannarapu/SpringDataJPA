package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity

@Data
public class Employee_Info {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer eno;
	private String ename;
	private String desg;
	private Double salary;
	private Double gross_salary;
	private Double net_salary;

}
