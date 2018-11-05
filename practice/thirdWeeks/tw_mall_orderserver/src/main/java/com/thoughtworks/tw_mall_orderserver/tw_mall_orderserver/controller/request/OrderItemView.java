package com.thoughtworks.tw_mall_orderserver.tw_mall_orderserver.controller.request;


import com.thoughtworks.tw_mall_orderserver.tw_mall_orderserver.model.ProductModel;

public class OrderItemView {
    private ProductModel product;
    private int productCount;
    private double totalPrice;

    public OrderItemView() {
    }

    public OrderItemView(ProductModel product, int productCount, double totalPrice) {
        this.product = product;
        this.productCount = productCount;
        this.totalPrice = totalPrice;
    }

    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
