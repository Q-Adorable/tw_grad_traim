package com.thoughtworks.tw_mall_orderserver.tw_mall_orderserver.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_item")
@Setter
@Getter
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "order_id")
    private int orderId;

    @Column(name = "product_id")
    private int productId;

    @Column(name = "product_count")
    private int productCount;

    public OrderItem() {
    }

    public OrderItem(int orderId, int productId, int productCount) {
        this.orderId = orderId;
        this.productId = productId;
        this.productCount = productCount;
    }
}
