package com.example.mall.service;

import com.example.mall.entity.Product;
import com.example.mall.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;


    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product get(int id) {
        Product product=productRepository.findById(id).orElseGet(null);
        return product;
    }

    public void add(Product product) {
        productRepository.save(product);
    }

    public String remove(int id) {
        try{
            if(productRepository.findById(id).get()!=null){
                productRepository.deleteById(id);
                return "删除成功";
            }
        }catch (Exception e){
        }
        return "删除失败";
    }

    public Product update(int id, Product product) {
        if(productRepository.existsById(id)){
            product.setId(id);
            return productRepository.save(product);
        }
        return null;
    }

    public List<Product> filterAll(String brand, String category, double minPrice, double maxPrice, int pageNum, int pageSize, String order) {
        return productRepository.filterAll(brand, category, minPrice, maxPrice, pageNum, pageSize, order);
    }
}
