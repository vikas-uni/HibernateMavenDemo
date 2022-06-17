package model;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;



@Entity
@Table(name="CART")
public class Cart1 {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cart_id")
	private long id;
	
	@Column(name="total")
	private double total;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy="cart1",cascade={CascadeType.ALL},orphanRemoval=true)//,fetch=FetchType.EAGER)
	//@Fetch(FetchMode.JOIN)   //this solves N+1 fetch query problem, setting fetch=FetchType.EAGER also does the same
	private Set<Items1> items1;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Items1> getItems1() {
		return items1;
	}

	public void setItems1(Set<Items1> items1) {
		this.items1 = items1;
	}
	
// Getter Setter methods for properties
	
}
