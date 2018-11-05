package com.thoughtworks.tw_mall_orderserver.tw_mall_orderserver.controller.request;

import java.util.List;

public class AddOrderRequest {

    private List<AddOrderItemRequest> addOrderItems;

    public List<AddOrderItemRequest> getAddOrderItems() {
        return addOrderItems;
    }

    public void setAddOrderItems(List<AddOrderItemRequest> addOrderItems) {
        this.addOrderItems = addOrderItems;
    }
}
