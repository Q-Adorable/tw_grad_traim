package com.thoughtworks.tw_mall_orderserver.tw_mall_orderserver.controller.request;

public class UpdateOrderItemRequest {
    private int productCount;

    public UpdateOrderItemRequest() {
    }

    public UpdateOrderItemRequest(int productCount) {
        this.productCount = productCount;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }
}
