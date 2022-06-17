package com.infy.biDir;
import javax.persistence.*;
@Entity
@Table(name="V4_headofstate")
// This entity is non-owing side  
public class HeadOfState {
	@Id
	@GeneratedValue
	@Column(name = "h_id")	 
	int id;
	String title;
	String name;
	
	/* mappedBy for bidirectional assocation 
	  The mappedBy attribute contains the name of the association-field on the owning side.
	  */
	
	@OneToOne(mappedBy = "hos")
	Country country;
	public String getTitle() {
		return title;
	}
		public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
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
