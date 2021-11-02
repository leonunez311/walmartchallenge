package com.walmart.apiservices.utils;

import java.util.ArrayList;
import java.util.List;

import com.walmart.apiservices.dto.ProductDTO;
import com.walmart.apiservices.model.Product;

/**
 * @author leoncio nunez
 *
 */
public class Utils {

	/**
	 * @param str
	 * @return true is the phrase is a palindrome, false if it is not
	 */
	public static Boolean checkPalindrome(String str) {
		// To be a palindrome phrase need to be at least two characters long
		if (str.length()<2) {
			return false;
		}
		// The string is filtered, only accept letters and numbers
		String strClean = str.replaceAll("[^0-9A-Za-z]", "").toLowerCase();
		StringBuilder strBuilder = new StringBuilder(strClean);
		
		String strReversed = strBuilder.reverse().toString();
		
		// If the reverse string equals the filtered string the string is palindrome
		if (strReversed.equals(strClean)) {
			return true;
		}
		return false;
	}
	
	/**
	 * @param products
	 * @param isPalindrome
	 * @return processed product list with discounts (if the discount applies)
	 */
	public static List<ProductDTO> applyDiscount(List<Product> products, Boolean isPalindrome) {
		List<ProductDTO> productList = new ArrayList<>();
		
		for (Product product : products) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setBrand(product.getBrand());
			productDTO.setDescription(product.getDescription());
			productDTO.setId(product.getId());
			productDTO.setImage(product.getImage());
			productDTO.setPreviusPrice(product.getPrice());
			
			// Apply discount only is the phrase is a palindrome
			if (isPalindrome) {
				productDTO.setPrice(product.getPrice()/2);
				productDTO.setDiscountPercentage(50);
			} else {
				productDTO.setPrice(product.getPrice());
				productDTO.setDiscountPercentage(0);				
			}
			
			productList.add(productDTO);
		}
		return productList;
	}
}
