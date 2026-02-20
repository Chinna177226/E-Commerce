package com.first.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.first.Entity.Order;
import com.first.Entity.Product;
import com.first.Repository.OrderRepo;
import com.first.Repository.ProductRepo;

@Service
public class OrderService {

	@Autowired
    private ProductRepo productRepo;

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ConsumerRepo consumerRepo;
    
    public String buy(String username, Long productId, int qty) {
    	
    	Consumer consumer = consumerRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Consumer not found"));

        Product product = productRepo.findById(productId)
        		orElseThrow(() -> new RuntimeException("Product not found"));

        if (product.getQuantity() < qty) {
            return "Stock not available";
        }

        product.setQuantity(product.getQuantity() - qty);
        productRepo.save(product);

        Order order = new Order();
        order.setConsumer(consumer);
        order.setProduct(product);
        order.setQuantity(qty);
        order.setTotalPrice(product.getPrice() * qty);
 
        orderRepo.save(order);

        return "Order placed successfully";
    }
}
