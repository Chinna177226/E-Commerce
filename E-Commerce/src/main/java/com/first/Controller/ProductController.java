package com.first.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.first.Entity.Product;
import com.first.Service.ProductService;

@RestController
public class ProductController {

	@Autowired
    private ProductService service;

    @PostMapping("/add")
    public Product add(@RequestBody Product p) {
        return service.add(p);
    }

    @PutMapping("/update")
    public Product update(@RequestBody Product p) {
        return service.update(p);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted";
    }
}
