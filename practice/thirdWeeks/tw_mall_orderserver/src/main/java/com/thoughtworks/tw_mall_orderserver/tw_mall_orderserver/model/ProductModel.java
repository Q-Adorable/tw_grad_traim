package com.thoughtworks.tw_mall_orderserver.tw_mall_orderserver.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductModel {
    private int id;

    private String name;

    private double price;

    private String type;

    private String imgUrl;

    public ProductModel() {
    }

    public ProductModel(String name, double price, String type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public ProductModel(String name, double price, String type, String imgUrl) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.imgUrl = imgUrl;
    }

    public ProductModel(int id, String name, double price, String type, String imgUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
        this.imgUrl = imgUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
