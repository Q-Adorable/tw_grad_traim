package com.thoughtworks.tw_mall_project.repository;

import com.thoughtworks.tw_mall_project.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
