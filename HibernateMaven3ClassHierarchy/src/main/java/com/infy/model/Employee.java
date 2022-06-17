package com.infy.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("E")
public class Employee  extends Person{
	
	String desg;
	Long Salary;
	
	public String getDesg() {
		return desg;
	}
	public void setDesg(String desg) {
		this.desg = desg;
	}
	public Long getSalary() {
		return Salary;
	}
	public void setSalary(Long salary) {
		Salary = salary;
	}
	public Employee(String name,String desg, Long salary) {
		super(name);
		this.desg = desg;
		Salary = salary;
	}

}









