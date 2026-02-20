package com.first.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.first.Service.OrderService;

@RestController
public class OrderController {

	@Autowired
    private OrderService service;

    @PostMapping("/buy/{productId}/{qty}")
    public String buy(@PathVariable Long productId,
                      @PathVariable int qty,
                      Principal principal) {
        return service.buy(principal.getName(), productId, qty);
    }
}
