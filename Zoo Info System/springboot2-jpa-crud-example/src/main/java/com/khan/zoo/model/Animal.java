package com.khan.zoo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "animals")
public class Animal {

	private long id;
	private String AnimalName;
	private String Type;
	private String  qty;
	
	public Animal() {
		
	}
	
	public Animal(String AnimalName, String Type, String qty) {
		this.AnimalName = AnimalName;
		this.Type = Type;
		this.qty = qty;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "Animal_Name", nullable = false)
	public String getAnimalName() {
		return AnimalName;
	}
	public void setAnimalName(String AnimalName) {
		this.AnimalName = AnimalName;
	}
	
	@Column(name = "type", nullable = false)
	public String getType() {
		return Type;
	}
	public void setType(String Type) {
		this.Type = Type;
	}
	
	@Column(name = "qty", nullable = false)
	public String getqty() {
		return qty;
	}
	public void setqty(String qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", AnimalName=" + AnimalName + ", Type=" + Type + ", qty=" + qty
				+ "]";
	}
	
}
