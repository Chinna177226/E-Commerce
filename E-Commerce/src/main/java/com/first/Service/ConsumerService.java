package com.first.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.first.Entity.Consumer;
import com.first.Repository.ConsumerRepo;
import com.first.Security.JwtUtil;


@Service
public class ConsumerService {

	    @Autowired
	    private ConsumerRepo consumerrepo;
	    
	    @Autowired
	    private JwtUtil jwtUtil;


	    /*public Consumer register(Consumer consumer) {
	        return consumerrepo.save(consumer);
	    }

	    public String login(String username, String password) {
	    	Consumer consumer = consumerrepo.findByUsername(username)
	                .orElseThrow(() -> new RuntimeException("Admin not found"));

	        if (!consumer.getPassword().equals(password)) {
	            throw new RuntimeException("Invalid password");
	        }
	        
	        return jwtUtil.generateToken(username, consumer.getRole());

	    }*/
	    public Consumer register(Consumer consumer) {
	        
	        return consumerRepo.save(consumer);
	    }

	    public String login(String username, String password) {

	        Consumer consumer = consumerRepo.findByUsername(username)
	                .orElseThrow(() -> new RuntimeException("Consumer not found"));

	        if (!consumer.getPassword().equals(password)) {
	            throw new RuntimeException("Invalid password");
	        }

	        return jwtUtil.generateToken(username, consumer.getRole());
	    }
	}


