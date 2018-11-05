package com.thoughtworks.tw_mall_orderserver.tw_mall_orderserver.controller;

import com.thoughtworks.tw_mall_orderserver.tw_mall_orderserver.controller.request.AddOrderItemRequest;
import com.thoughtworks.tw_mall_orderserver.tw_mall_orderserver.controller.request.AddOrderRequest;
import com.thoughtworks.tw_mall_orderserver.tw_mall_orderserver.controller.request.OrderItemsViewRequest;
import com.thoughtworks.tw_mall_orderserver.tw_mall_orderserver.controller.request.UpdateOrderItemRequest;
import com.thoughtworks.tw_mall_orderserver.tw_mall_orderserver.entity.Order;
import com.thoughtworks.tw_mall_orderserver.tw_mall_orderserver.entity.OrderItem;
import com.thoughtworks.tw_mall_orderserver.tw_mall_orderserver.exception.OrderItemNotFoundException;
import com.thoughtworks.tw_mall_orderserver.tw_mall_orderserver.exception.OrderNotFoundException;
import com.thoughtworks.tw_mall_orderserver.tw_mall_orderserver.exception.ProductNotFoundException;
import com.thoughtworks.tw_mall_orderserver.tw_mall_orderserver.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;


    @PostMapping("/orders")
    public ResponseEntity add(@RequestHeader(name = "userId") int userId, @RequestBody AddOrderRequest addOrderRequest) {
        Order order = orderService.add(userId, addOrderRequest.getAddOrderItems());
        return ResponseEntity.created(URI.create("/orders/" + order.getId())).build();
    }

    @GetMapping("/orders")
    public ResponseEntity getAll(@RequestHeader(name = "userId") int userId) {
        List<Order> orders = orderService.getAllByUserId(userId);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<OrderItemsViewRequest> get(@PathVariable int id, @RequestHeader(name = "userId") int userId) {
        OrderItemsViewRequest orderItemsViewRequest = orderService.get(userId, id);
        return ResponseEntity.ok(orderItemsViewRequest);
    }

    @PostMapping("/orders/{orderId}/orderItems")
    public ResponseEntity<OrderItem> add(@PathVariable(name = "orderId") int orderId, @RequestHeader(name = "userId") int userId, @RequestBody AddOrderItemRequest addOrderItemRequest) {
        OrderItem orderItem = orderService.addOrderItem(userId, orderId, addOrderItemRequest);
        if (orderItem != null) {
            return ResponseEntity.created(URI.create("/orderItems/" + orderItem.getId())).build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("orders/{orderId}/orderItems/{orderItemId}")
    public ResponseEntity<OrderItem> update(@PathVariable(name = "orderId") int orderId, @PathVariable(name = "orderItemId") int orderItemId, @RequestHeader(name = "userId") int userId, @RequestBody UpdateOrderItemRequest updateOrderItemRequest) {
        OrderItem orderItem = orderService.update(userId, orderId, orderItemId, updateOrderItemRequest.getProductCount());
        return ResponseEntity.created(URI.create("/orderItems/" + orderItem.getId())).build();
    }

    @DeleteMapping("orders/{orderId}/orderItems/{orderItemId}")
    public ResponseEntity<OrderItem> remove(@PathVariable(name = "orderId") int orderId, @PathVariable(name = "orderItemId") int orderItemId, @RequestHeader(name = "userId") int userId) {
        OrderItem orderItem = orderService.delete(userId, orderId, orderItemId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("orders/{orderId}/orderItems/{orderItemId}")
    public ResponseEntity<OrderItem> get(@PathVariable(name = "orderId") int orderId, @PathVariable(name = "orderItemId") int orderItemId, @RequestHeader(name = "userId") int userId) {
        OrderItem orderItem = orderService.get(userId, orderId, orderItemId);
        return ResponseEntity.ok(orderItem);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void productNotFoundHandle(ProductNotFoundException ex) {

    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void orderNotFoundHandle(OrderNotFoundException ex) {

    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void orderItemNotFoundHandle(OrderItemNotFoundException ex) {

    }
}
