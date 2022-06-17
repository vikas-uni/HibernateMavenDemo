package com.infy.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "SS_EMPLOYEE")
public class Employee {
	@Id
	@GeneratedValue
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "EMPLOYEE_ID")
	private int employeeId;
	private String firstname;
	private String job;
	private int salary;
	@ManyToMany(cascade = { CascadeType.ALL })  
	@JoinTable
	private Set<Previledge> previledge = new HashSet<Previledge>();
	
	public Employee() {
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return job;
	}

	public void setLastname(String lastname) {
		this.job = lastname;
	}

	 public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Set<Previledge> getPreviledge() {
		return previledge;
	}

	public void setPreviledge(Set<Previledge> previledge) {
		this.previledge = previledge;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}





	public Employee(String firstname, String job, int salary) {
		super();
		this.firstname = firstname;
		this.job = job;
		this.salary = salary;
	}





	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstname="
				+ firstname + ", job=" + job + ", salary=" + salary
				+ ", previledge=" + previledge + "]";
		
		//return employeeId+"\t"+firstname;
	}
	
}
