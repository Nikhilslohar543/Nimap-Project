package com.tka.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int pId;
	String pName;
	long price;

	@ManyToOne
	@JoinColumn(name = "catId")
	@JsonBackReference
	Category category;

	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Products(int pId, String pName, long price, Category category) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.price = price;
	}

	public Products(String pName, long price, Category category) {
		super();
		this.pName = pName;
		this.price = price;
		this.category = category;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Products [pId=" + pId + ", pName=" + pName + ", price=" + price + ", category=" + category + "]";
	}

}
