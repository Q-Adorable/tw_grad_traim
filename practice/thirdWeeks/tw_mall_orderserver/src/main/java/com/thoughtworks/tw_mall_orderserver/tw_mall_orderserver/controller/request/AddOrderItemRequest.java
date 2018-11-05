package com.thoughtworks.tw_mall_orderserver.tw_mall_orderserver.controller.request;


public class AddOrderItemRequest {

    private int productId;

    private int productCount;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }
}
