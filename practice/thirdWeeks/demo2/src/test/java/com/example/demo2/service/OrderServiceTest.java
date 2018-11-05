package com.example.demo2.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private OrderItemRepository orderItemRepository;

    @Mock
    private ProductRepository productRepository;

    private OrderService orderService;

    @Before
    public void setUp() throws Exception {
        orderService = new OrderService(orderRepository,orderItemRepository,productRepository);
    }

    @Test
    public void should_get_a_order_by_given_id(){
        //given
        Order order =Order.builder()
                .id(10)
                .build();
        Optional<Order> optOrder = Optional.of(order);
        given(orderRepository.findById(anyInt()))
                .willReturn(optOrder);

        // when
        Order actual = orderService.getById(20);

        // then
        assertThat(actual.getId()).isEqualTo(10);
    }

    @Test
    public void should_add_a_order(){
        //given
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String time = formatter.format(new Date().getTime());
        Order order = new Order(time);
        when(orderRepository.saveAndFlush(any(Order.class))).thenReturn(order);
        //when
//        orderService.add();
        //then
        verify(orderRepository,times(1)).saveAndFlush(any(Order.class));
    }

    @Test(expected = OrderNotFoundException.class)
    public void should_throw_exception_given_not_exist_id() {
        // given
        Optional<Order> optOrder = Optional.empty();

        given(orderRepository.findById(anyInt()))
                .willReturn(optOrder);

        // when
        Order actual = orderService.getById(1);
    }
}
