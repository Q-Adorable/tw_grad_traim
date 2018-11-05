package com.thoughtworks.tw_mall_orderserver.tw_mall_orderserver.service;

import com.thoughtworks.tw_mall_orderserver.tw_mall_orderserver.controller.request.AddOrderItemRequest;
import com.thoughtworks.tw_mall_orderserver.tw_mall_orderserver.controller.request.OrderItemView;
import com.thoughtworks.tw_mall_orderserver.tw_mall_orderserver.controller.request.OrderItemsViewRequest;
import com.thoughtworks.tw_mall_orderserver.tw_mall_orderserver.entity.Order;
import com.thoughtworks.tw_mall_orderserver.tw_mall_orderserver.entity.OrderItem;
import com.thoughtworks.tw_mall_orderserver.tw_mall_orderserver.exception.OrderItemNotFoundException;
import com.thoughtworks.tw_mall_orderserver.tw_mall_orderserver.exception.OrderNotFoundException;
import com.thoughtworks.tw_mall_orderserver.tw_mall_orderserver.exception.ProductNotFoundException;
import com.thoughtworks.tw_mall_orderserver.tw_mall_orderserver.model.ProductModel;
import com.thoughtworks.tw_mall_orderserver.tw_mall_orderserver.repository.OrderItemRepository;
import com.thoughtworks.tw_mall_orderserver.tw_mall_orderserver.repository.OrderRepository;
import com.thoughtworks.tw_mall_orderserver.tw_mall_orderserver.restService.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    private OrderItemRepository orderItemRepository;

    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private ProductClient productClient;

    @Autowired
    public OrderService(OrderRepository orderRepository, OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }

    public Order add(int id, List<AddOrderItemRequest> list) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String time = formatter.format(new Date().getTime());
        Order order = new Order(time);
        order.setUserId(id);
        Order order1 = orderRepository.save(order);
        for (AddOrderItemRequest addOrderItemRequest : list) {
            OrderItem orderItem = new OrderItem(order1.getId(), addOrderItemRequest.getProductId(), addOrderItemRequest.getProductCount());
            orderItemRepository.save(orderItem);
        }
        return order1;
    }

    public List<Order> getAllByUserId(int userId) {
        List<Order> orders = orderRepository.findByUserId(userId);
        return orders;
    }

    public OrderItemsViewRequest get(int userId, int orderId) throws ProductNotFoundException {
        Order order = orderRepository.findByUserIdAndId(userId, orderId).orElseThrow(() -> new ProductNotFoundException());
        List<OrderItem> list = order.getOrderItems();
        OrderItemsViewRequest orderItemsViewRequest = new OrderItemsViewRequest();
        List<OrderItemView> orderItemViews = new ArrayList<OrderItemView>();

        List<ProductModel> productList = productClient.getProducts();
        //  ResponseEntity<ProductModel[]> productList = restTemplate.getForEntity("http://localhost:8081/products", ProductModel[].class);

        for (OrderItem orderItem : list) {
            for (ProductModel product : productList) {
                if (product.getId() == orderItem.getProductId()) {
                    double totalPrice = 0.0;
                    totalPrice = product.getPrice() * orderItem.getProductCount();
                    OrderItemView orderItemView = new OrderItemView(product, orderItem.getProductCount(), totalPrice);
                    orderItemViews.add(orderItemView);
                }
            }

        }
        orderItemsViewRequest.setList(orderItemViews);
        return orderItemsViewRequest;
    }

    public Order getById(int id) {
        return orderRepository.findById(id)
                .orElseThrow(OrderNotFoundException::new);
    }

    public OrderItem addOrderItem(int userId, int orderId, AddOrderItemRequest addOrderItemRequest) {
        orderRepository.findByUserIdAndId(userId, orderId).orElseThrow(() -> new OrderNotFoundException());
        OrderItem orderItem=orderItemRepository.findByOrderIdAndProductId(orderId, addOrderItemRequest.getProductId()).orElse(null);
        if (orderItem == null) {
            OrderItem item = new OrderItem(orderId, addOrderItemRequest.getProductId(), addOrderItemRequest.getProductCount());
            orderItemRepository.saveAndFlush(item);
            return orderItemRepository.saveAndFlush(item);
        }
        orderItem.setProductCount(orderItem.getProductCount()+addOrderItemRequest.getProductCount());
        orderItemRepository.saveAndFlush(orderItem);
        return orderItem;
    }

    public OrderItem update(int userId, int orderId, int orderItemId, int productCount) throws OrderNotFoundException,OrderItemNotFoundException {
        orderRepository.findByUserIdAndId(userId, orderId).orElseThrow(()->new OrderNotFoundException());
        OrderItem orderItem=orderItemRepository.findByOrderIdAndId(orderId,orderItemId).orElseThrow(()->new OrderItemNotFoundException());
        orderItem.setProductCount(productCount);
        return orderItemRepository.save(orderItem);
    }

    public OrderItem delete(int userId, int orderId, int orderItemId) throws OrderItemNotFoundException {
        orderRepository.findByUserIdAndId(userId, orderId).orElseThrow(()->new OrderNotFoundException());
        OrderItem orderItem=orderItemRepository.findByOrderIdAndId(orderId,orderItemId).orElseThrow(()->new OrderItemNotFoundException());
        orderItemRepository.deleteById(orderItem.getId());
        return orderItem;
    }

    public OrderItem get(int userId, int orderId, int orderItemId) throws ProductNotFoundException {
        orderRepository.findByUserIdAndId(userId, orderId).orElseThrow(()->new OrderNotFoundException());
        return orderItemRepository.findByOrderIdAndId(orderId,orderItemId).orElseThrow(()->new OrderItemNotFoundException());
    }
}
