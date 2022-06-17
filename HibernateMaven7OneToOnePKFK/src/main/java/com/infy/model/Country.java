package com.infy.model;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.persistence.*;
@Entity
@Table(name = "v1_country")
public class Country {
 	@Id 
	@GeneratedValue
	int id;
	String name;	
	@OneToOne(cascade={CascadeType.ALL})
	//@JoinColumn indicates that this entity is the owner of the relationship
	//(that is: the corresponding table v1_country has a column hosid with a foreign key to the referenced table)
	@JoinColumn(name="hosid")	
	// country has one to one relationship with HeadOfState
	HeadOfState hos;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HeadOfState getHos() {
		return hos;
	}
	public void setHos(HeadOfState hos) {
		this.hos = hos;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
