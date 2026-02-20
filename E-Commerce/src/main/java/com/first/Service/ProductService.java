package com.first.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.first.Entity.Product;
import com.first.Repository.ProductRepo;

@Service
public class ProductService {

	 @Autowired
	    private ProductRepo repo;

	    public Product add(Product p) {
	        return repo.save(p);
	    }

	    public void delete(Long id) {
	        repo.deleteById(id);
	    }

	    public Product update(Product p) {
	        return repo.save(p);
	    }

	    public Product get(Long id) {
	        return repo.findById(id).orElseThrow();
	    }
}
