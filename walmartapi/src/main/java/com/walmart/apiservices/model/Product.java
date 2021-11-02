package com.walmart.apiservices.model;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import nonapi.io.github.classgraph.json.Id;

@Document(collection="products")
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8964535987388647705L;

	@Id
	private String _id;
	
	@Field("id")
	private Integer id;
	private String brand;
	private String description;
	private String image;
	private Integer price;
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "products [_id=" + _id + ", id=" + id + ", brand=" + brand + ", description=" + description + ", image="
				+ image + ", price=" + price + "]";
	}
}
