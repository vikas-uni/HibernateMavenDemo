package com.infy.biDir;
import javax.persistence.*;
@Entity
@Table(name = "V4_COUNTRY")
//This entity is owing side of the relationship
public class Country {
  	@Id 
	@GeneratedValue
	@Column(name="COUNTRY_ID")
	int id;
	String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="hos_id")
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
