package com.walmart.apiservices.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.apiservices.business.Business;
import com.walmart.apiservices.dto.ProductDTO;
import com.walmart.apiservices.dto.ProductsEnvelope;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RequestMapping(value="v1")
@RestController
public class mainController {
	
	@Autowired
    private Business business;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	/* This method returns list of products */
	@GetMapping({"/products/{phrase}"})
	@ApiOperation(value = "Get products by phrase", response = ProductsEnvelope.class, tags = "Product list")
	public @ResponseBody ResponseEntity<ProductsEnvelope>  getProducts(
	@ApiParam(name="phrase",value = "id, brand or product description", required = true)
	@PathVariable(required = true) String phrase){
		logger.info("Find products by following phrase : " + phrase);
		ProductsEnvelope envelope = new ProductsEnvelope();
		
		try {
			List<ProductDTO> products = business.findProducts(phrase);
			envelope.setProducts(products);
			logger.info("Succesfully recovered product list");
			return new ResponseEntity<ProductsEnvelope>(envelope, HttpStatus.OK); // 200 OK
		} catch (Exception e) {
			logger.error("Error recovering product list : " + e.getMessage());
			return new ResponseEntity<ProductsEnvelope>(envelope, HttpStatus.INTERNAL_SERVER_ERROR); // 500
		}
	} 
	
}
