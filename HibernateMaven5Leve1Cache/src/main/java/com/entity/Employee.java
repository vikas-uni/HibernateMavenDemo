package com.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name ="EmpTest1")
public class Employee {
	@Id
	@Column(name="Emp_Id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	int eid;
	@Column(name="Emp_Name",length=20,nullable=false)
	String name;
	@Column(name="Mob_No" ,length=10,nullable=false,unique=true)
	String mobno;
		public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
}
		public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getMobno() {
		return mobno;
	}

	public void setMobno(String mobno) {
		this.mobno = mobno;
	}

   
	public Employee(){}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", mobno=" + mobno + "]";
	}
	
	
	
	
	
}
