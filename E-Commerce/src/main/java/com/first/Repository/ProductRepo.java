package com.first.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.first.Entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{

	
}
