package com.thoughtworks.tw_mall_orderserver.tw_mall_orderserver.controller.request;

import java.util.List;

public class OrderItemsViewRequest {
    private List<OrderItemView> list;

    public OrderItemsViewRequest() {
    }

    public OrderItemsViewRequest(List<OrderItemView> list) {
        this.list = list;
    }

    public List<OrderItemView> getList() {
        return list;
    }

    public void setList(List<OrderItemView> list) {
        this.list = list;
    }
}
