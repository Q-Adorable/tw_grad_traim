package com.example.demo2.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    public void test_get_product(){
        assertThat(productService.getAll().getList()).isNotNull();
    }

    @Test
    public void test_add_product(){
        Product product=new Product("樱桃",16,"斤","./img");
        assertThat(productService.add(product).getName()).isEqualTo("樱桃");
    }

    @Test
    public void test_update_product(){
        Product product=new Product("樱桃",16,"斤","./img");
        assertThat(productService.update(1,product).getName()).isEqualTo("樱桃");
    }
}
