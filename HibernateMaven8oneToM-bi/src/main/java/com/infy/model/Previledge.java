package com.infy.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name = "SS_PREVILEDGE")
public class Previledge {
	public Previledge() {
		
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue
	@Column(name = "PREVILEDGE_ID")
	private int previledgeId;
	private String name;
	private int cost;
	
	public int getMeetingId() {
		return previledgeId;
	}

    @ManyToMany(mappedBy = "previledge")  
	private Set<Employee> employees = new HashSet<Employee>();
		
	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	

	
	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getPreviledgeId() {
		return previledgeId;
	}

	public void setPreviledgeId(int previledgeId) {
		this.previledgeId = previledgeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Previledge [name=" + name + ", cost=" + cost + "]";
	}

	
}
