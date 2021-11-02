package com.walmart.frontoffice.services;

import java.util.List;

import com.walmart.frontoffice.dto.ProductDTO;

public interface ProductService {

	public List<ProductDTO> getProducts(String phrase);
	
}
