package com.walmart.apiservices.dto;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class ProductsEnvelope implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3376476042140793067L;
	
	@ApiModelProperty(access = "public", name = "products", position=1)
	private List<ProductDTO> products;

	public List<ProductDTO> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "ProductsEnvelope [products=" + products + "]";
	}
	
}
