package com.walmart.frontoffice.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	private @Value("${api.cantidadcolumnas}") String cantidadColumnas;
	private @Value("${frontoffice.productidlength}") String productIdLength;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = {"/home", "/"}, method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response , ModelMap model) throws Exception {

		logger.debug("---- Home controller start ----");
		
		// Set results in modelmap
		model.put("titleURL", "Walmart");
		model.put("cantidadXPagina", cantidadColumnas);
		model.put("productIdLength", productIdLength);
		
		logger.debug("---- Home controller end ----");
		
		return new ModelAndView("search", model);
	}

}
