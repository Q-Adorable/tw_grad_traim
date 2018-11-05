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
public class OrderItemServiceTest {

//    @Autowired
//    private OrderItemService orderItemService;
//
//    @Test
//    public void test_update_orderItem() {
//        assertThat(orderItemService.update(2, 2).getProductCount()).isEqualTo(2);
//    }
//
//    @Test
//    public void test_delete_orderItem() {
//        assertThat(orderItemService.delete(2).getId()).isEqualTo(2);
//    }
//
//    @Test
//    public void test_get_orderItem() {
//        assertThat(orderItemService.get(2).getId()).isEqualTo(2);
//    }
}
