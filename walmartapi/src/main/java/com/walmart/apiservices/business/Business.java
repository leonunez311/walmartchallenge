package com.walmart.apiservices.business;

import java.util.List;

import com.walmart.apiservices.dto.ProductDTO;

public interface Business {

	/**
	 * @param phrase
	 * @return list of products that match phrase in it id, brand or description
	 */
	public List<ProductDTO> findProducts(String phrase);

}
