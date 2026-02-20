package com.first.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.first.Entity.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long>{

	
}
