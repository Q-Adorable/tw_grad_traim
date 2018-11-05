package com.example.providercontract.controller;

import com.example.providercontract.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController{

    @GetMapping("/{id}")
    public Product get(@PathVariable int id){
        return new Product(1,"apple");
    }
}
