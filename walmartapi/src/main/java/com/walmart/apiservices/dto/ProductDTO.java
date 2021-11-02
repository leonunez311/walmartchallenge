package com.walmart.apiservices.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class ProductDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1987951691718017579L;

	@ApiModelProperty(access = "public", name = "productId", position=1)
	private Integer id;
	
	@ApiModelProperty(access = "public", name = "brand", position=1)
	private String brand;
	
	@ApiModelProperty(access = "public", name = "description", position=1)
	private String description;
	
	@ApiModelProperty(access = "public", name = "image", position=1)
	private String image;
	
	@ApiModelProperty(access = "public", name = "price", position=1)
	private Integer price;
	
	@ApiModelProperty(access = "public", name = "previusPrice", position=1)
	private Integer previusPrice;
	
	@ApiModelProperty(access = "public", name = "discountPercentage", position=1)
	private Integer discountPercentage;
	
	public Integer getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(Integer discountPercentage) {
		this.discountPercentage = discountPercentage;
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
	public Integer getPreviusPrice() {
		return previusPrice;
	}
	public void setPreviusPrice(Integer previusPrice) {
		this.previusPrice = previusPrice;
	}
	
	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", brand=" + brand + ", description=" + description + ", image=" + image
				+ ", price=" + price + ", previusPrice=" + previusPrice + ", discountPercentage=" + discountPercentage
				+ "]";
	}	
}
