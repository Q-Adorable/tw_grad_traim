package com.example.mall.controller;

import com.example.mall.entity.Product;
import com.example.mall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public Product get(@PathVariable int id){
        return productService.get(id);
    }

    @PostMapping
    public void add(@RequestBody Product product){
        productService.add(product);
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable int id){
        return productService.remove(id);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable int id,@RequestBody Product product){
        return productService.update(id,product);

    }

    @GetMapping("/get")
    public List<Product> getAll(@RequestParam(value = "pageSize", defaultValue = "2") int pageSize,
                                 @RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
                                 @RequestParam(value = "order", required = false, defaultValue = "ASC") String order,
                                 @RequestParam(value = "brand", required = false) String brand,
                                 @RequestParam(value = "category", required = false) String category,
                                 @RequestParam(value = "minPrice", required = false, defaultValue = "0") double minPrice,
                                 @RequestParam(value = "maxPrice", required = false, defaultValue = "0") double maxPrice) {
        return productService.filterAll(brand, category, minPrice, maxPrice, pageNum, pageSize, order);
    }
}
