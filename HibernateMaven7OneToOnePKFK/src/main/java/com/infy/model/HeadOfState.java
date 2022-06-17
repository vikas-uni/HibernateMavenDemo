package com.infy.model;
import javax.persistence.*;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
@Entity
@Table(name="v1_headofstate")
public class HeadOfState {
	@Id
	@GeneratedValue
	@Column(name = "h_id")	 
	int id;
	String title;
	String name;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
