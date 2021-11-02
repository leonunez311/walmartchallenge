package com.walmart.frontoffice.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.walmart.frontoffice.dto.ProductDTO;
import com.walmart.frontoffice.services.ProductService;

@Controller
public class SearchController {

	@Autowired
	ProductService productService;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = { "/search/{phrase}"}, method = RequestMethod.GET)
	public ResponseEntity<List<ProductDTO>> search(@PathVariable(name = "phrase", required=true) String phrase) throws Exception {

		logger.debug("---- Product search controller start ----");
		
		List<ProductDTO> products = new ArrayList<>();
		
		// Call product service to get the products that match the criteria
		if (phrase!=null && !phrase.isEmpty()) {
			products = productService.getProducts(phrase);
		}

		logger.debug("---- Product search controller end ----");
		
		return new ResponseEntity<List<ProductDTO>>(products, HttpStatus.OK);
	}

}
