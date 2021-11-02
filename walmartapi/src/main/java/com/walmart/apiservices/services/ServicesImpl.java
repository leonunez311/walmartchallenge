package com.walmart.apiservices.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.walmart.apiservices.model.Product;

@Service
public class ServicesImpl implements Services {

	@Autowired
	MongoTemplate mongoTemplate;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
    /**
     * @return all products
     */
	@Override
	public List<Product> findAll() {
		return mongoTemplate.findAll(Product.class);
    }

    /**
     * @param id
     * @return a single product
     */
	@Override
    public Product findById(Integer id) {
    	Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		return mongoTemplate.findOne(query, Product.class);
    }
    
	/**
	 * @param phrase
	 * @return returns list of products that match the phrase
	 */
	@Override
	public List<Product> findByPhrase(String phrase) {
		
		// Split the phrase into words to match any of the words contained in the phrase
    	String[] parts = phrase.split(" ");
    	
		Query orQuery = new Query();
		Criteria orCriteria = new Criteria();

		List<Criteria> orExpression =  new ArrayList<>();
    	if (parts.length>0) {
    		for (String word : parts) {
    			word = word.trim();
    			if (word.length()>0) {
        			Criteria expression = new Criteria();
        			// Match word against the brand field
        			expression.and("brand").regex(word);
        			orExpression.add(expression);
        			
        			// Match word against the description field
        			expression = new Criteria();
        			expression.and("description").regex(word);
        			orExpression.add(expression);    				
    			}
    		}
    	}
				
		// Add search criteria
		orQuery.addCriteria(orCriteria.orOperator(orExpression.toArray(new Criteria[orExpression.size()])));
		
		return mongoTemplate.find(orQuery, Product.class);
    }
}
