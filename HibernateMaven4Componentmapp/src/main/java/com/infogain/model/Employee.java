package com.infogain.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMP_ADD")
public class Employee {
	@Id
	@GeneratedValue
	@Column(name = "EMP_ID")
	private long employeeId;
   @Column(name = "EMP_NAME", nullable = false, length = 100)
  private String employeeName;
   
   /*The @Embedded annotation is used to specify the Address entity should be stored in the EMP_ADD table as a component.*/  
  @Embedded
   private Address employeeAddress;
	public Employee() {
	}

	public Employee(String employeeName, Address employeeAddress) {
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Address getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(Address employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	
	
	
	
	
}
