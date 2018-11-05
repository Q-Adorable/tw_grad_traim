package com.thoughtworks.tw_mall_orderserver.tw_mall_orderserver.repository;

import com.thoughtworks.tw_mall_orderserver.tw_mall_orderserver.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
    Optional<OrderItem> findByOrderIdAndProductId(int orderId, int productId);

    OrderItem findByOrderId(int orderId);

    Optional<OrderItem> findByOrderIdAndId(int orderId,int id);
}
