package com.thoughtworks.tw_mall_orderserver.tw_mall_orderserver.service;

import com.thoughtworks.tw_mall_orderserver.tw_mall_orderserver.entity.Order;
import com.thoughtworks.tw_mall_orderserver.tw_mall_orderserver.repository.OrderItemRepository;
import com.thoughtworks.tw_mall_orderserver.tw_mall_orderserver.repository.OrderRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private OrderItemRepository orderItemRepository;

    private OrderService orderService;

    @Before
    public void setUp() throws Exception {
        orderService = new OrderService(orderRepository, orderItemRepository);
    }

    @Test
    public void should_add_order_given_user_id_and_order_item_request(){
        //given
        Order order = new Order(1,"");
        given(orderRepository.save(any(Order.class))).willReturn(order);
        //when
        Order actual=orderService.add(1,new ArrayList<>());
        //then
        assertThat(actual.getUserId()).isEqualTo(1);

        verify(orderRepository,times(1)).save(any(Order.class));

    }

    @Test
    public void should_get_all_order_given_user_id() {
        //given
        List<Order> orders = new ArrayList<Order>();
        given(orderRepository.findByUserId(anyInt()))
                .willReturn(orders);
        //when
        List<Order> actual = orderService.getAllByUserId(1);
        //then
        assertThat(actual).isEqualTo(orders);

        verify(orderRepository, times(1)).findByUserId(anyInt());
    }

    @Test
    public void should_get_order_given_id(){
        //given
        Order order = new Order(1,"");
        Optional<Order> optOrder = Optional.of(order);
        given(orderRepository.findById(anyInt())).willReturn(optOrder);
        //when
        Order actual=orderService.getById(1);
        //then
        assertThat(actual.getUserId()).isEqualTo(1);

        verify(orderRepository,times(1)).findById(anyInt());
    }
}