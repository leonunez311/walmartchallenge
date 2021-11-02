package com.walmart.apiservices;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ActiveProfiles;

import com.walmart.apiservices.model.Product;
import com.walmart.apiservices.services.Services;
import com.walmart.apiservices.utils.Utils;

@AutoConfigureMockMvc
@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureDataMongo
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ApiservicesApplicationTests {

	@Autowired
	Services services;

	Logger logger = LoggerFactory.getLogger(ApiservicesApplicationTests.class);
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@BeforeAll
    public void setUp() {

		Product product = new Product();
		
		product.setId(1);
		product.setBrand("ooy eqrceli");
		product.setDescription("rlñlw brhrka");
		product.setImage("www.lider.cl/catalogo/images/whiteLineIcon.svg");
		product.setPrice(498724);
		mongoTemplate.insert(product);
    }
	
	@Test
	void findAllTest() throws Exception {
		System.out.println("--------------------- findAll TEST ----------------------------");
		List<Product> products = services.findAll();
		assertNotNull(products);
		assertNotEquals(0,products.size());
		System.out.println("findAll OK");
	}

	@Test
	void findByIdTest() throws Exception  {
		System.out.println("--------------------- findById TEST ----------------------------");
		Product product = services.findById(1);
		assertNotNull(product);
		assertEquals(1,product.getId());
		System.out.println("findById OK");
	}

	@Test
	void checkPalindromeTest() throws Exception {
		System.out.println("--------------------- checkPalindrome TEST ----------------------------");
		
		Boolean result = Utils.checkPalindrome("leoncio nuneZ");
		assertNotNull(result);
		assertFalse(result);

		result = Utils.checkPalindrome("Ali tomo tila");
		assertNotNull(result);
		assertTrue(result);
		
		System.out.println("checkPalindromeTest OK");
	}

	@Test
	void findByPhraseTest() throws Exception  {
		System.out.println("--------------------- findByPhrase TEST ----------------------------");

		List<Product> products = services.findByPhrase("ñl");
		assertNotNull(products);
		assertNotEquals(0, products.size());
			
		System.out.println("findByPhrase OK");
	}

}
