package com.example.tw_mall.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="goods")
public class Goods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private double price;

    @Column(name="type")
    private String type;

    @Column(name="brand")
    private String brand;

    @Column(name="describes")
    private String describe;

    @Column(name="production_day")
    private Date production_day;

    @Column(name="place")
    private String place;

    public Goods(){}

    public Goods(String name,double price,String type,String brand,String describe,Date production_day,String place){
        this.name=name;
        this.price=price;
        this.type=type;
        this.brand=brand;
        this.describe=describe;
        this.production_day=production_day;
        this.place=place;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Date getProduction_day() {
        return production_day;
    }

    public void setProduction_day(Date production_day) {
        this.production_day = production_day;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
