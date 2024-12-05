package com.tka.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int cId;
	String cName;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference 
	List<Products> products;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(int cId, String cName, List<Products> products) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.products = products;
	}

	public Category(String cName, List<Products> products) {
		super();
		this.cName = cName;
		this.products = products;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Category [cId=" + cId + ", cName=" + cName + "]";
	}

}
