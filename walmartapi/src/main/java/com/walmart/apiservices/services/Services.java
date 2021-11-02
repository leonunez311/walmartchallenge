package com.walmart.apiservices.services;

import java.util.List;

import com.walmart.apiservices.model.Product;

public interface Services {

    /**
     * @return all products
     */
	public List<Product> findAll();

	/**
     * @param id
     * @return a single product
     */
    public Product findById(Integer id);
    
	/**
	 * @param phrase
	 * @return returns list of products that match the phrase
	 */
	public List<Product> findByPhrase(String phrase);
	
}
