package com.example.mall.repository;

import com.example.mall.entity.Product;

import java.util.List;

public interface ProductRepositoryCustom{
    List<Product> filterAll(String brand, String category, Double minPrice, Double maxPrice, int pageNum, int pageSize, String order);
}
