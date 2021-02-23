package com.openclassrooms.webinarjpa.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
@Table("Employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employeeID")
	private Integer employeeID;
	
	@Column(name = "employeeNumber")
	private Integer employeeNumber;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	private String email;
	
	@Column(name = "hireDate")
	private Date hireDate;	
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "departmentID")
	private Department department;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "employeeID")
	private List<Project> projects = new ArrayList<>();
}
