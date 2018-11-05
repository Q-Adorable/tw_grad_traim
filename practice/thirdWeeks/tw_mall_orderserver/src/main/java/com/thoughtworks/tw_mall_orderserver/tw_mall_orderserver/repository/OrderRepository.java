package com.thoughtworks.tw_mall_orderserver.tw_mall_orderserver.repository;

import com.thoughtworks.tw_mall_orderserver.tw_mall_orderserver.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    Optional<Order> findByUserIdAndId(int userId, int id);

    List<Order> findByUserId(int userId);
}
