package com.walmart.frontoffice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.walmart.frontoffice.controllers.SearchController;
import com.walmart.frontoffice.dto.ProductDTO;
import com.walmart.frontoffice.services.ProductService;

@WebMvcTest(SearchController.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FrontofficeApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@MockBean
	ProductService productService;	

	@BeforeAll
    public void setUp() {
		List<ProductDTO> productos = new ArrayList<ProductDTO>();
		productos.add(new ProductDTO(181, "Lider", "Freezer", "image", 1, 1, 0));
		Mockito.when(productService.getProducts("181")).thenReturn(productos);
    }

	@Test
	void searchControllerTest() throws Exception {
		
		String responseBody = "[{\"id\":181,\"brand\":\"Lider\",\"description\":\"Freezer\",\"image\":\"image\",\"price\":1,\"previusPrice\":1,\"discountPercentage\":0}]";
		
		mockMvc.perform(get("/search/181")
				.accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(content().string(responseBody));
	}

}
