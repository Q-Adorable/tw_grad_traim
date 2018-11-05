package com.thoughtworks.tw_mall_project.service;

import com.thoughtworks.tw_mall_project.entity.Product;
import com.thoughtworks.tw_mall_project.exception.ProductNotFoundException;
import com.thoughtworks.tw_mall_project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product get(int id) {
        return productRepository.findById(id).orElseThrow(()->new ProductNotFoundException());
    }

    public void remove(int id) {
        productRepository.deleteById(id);
    }

    public Product add(Product product) {
        return productRepository.save(product);
    }

    public Product update(int id, Product product) {
        return productRepository.existsById(id) ?
                productRepository.save(product) : null;
    }
}
