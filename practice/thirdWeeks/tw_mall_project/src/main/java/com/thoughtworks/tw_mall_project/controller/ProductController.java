package com.thoughtworks.tw_mall_project.controller;

import com.thoughtworks.tw_mall_project.entity.Product;
import com.thoughtworks.tw_mall_project.exception.ProductNotFoundException;
import com.thoughtworks.tw_mall_project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> get(@PathVariable int id) {
        return ResponseEntity.ok(productService.get(id));
    }

    @PostMapping
    public ResponseEntity<Product> add(@RequestBody Product product) {
        Product product1 = productService.add(product);
        return ResponseEntity.created(URI.create("/products/" + product1.getId())).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable(name = "id") int id, @RequestBody Product product) {
        Product product1 = productService.update(id, product);
        if (product1 != null) {
            return ResponseEntity.created(URI.create("/products/" + product1.getId())).build();
        }
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void productNotFoundHandle(ProductNotFoundException ex) {

    }
}
