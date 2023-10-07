package com.offcn.bean;

import java.io.Serializable;

public class Commodity implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer code; //商品编码
    private String title; // 商品名称
    private String category; //商品类别
    private double price; //商品单价
    private Integer stock; //商品库存
    public Commodity() {
    }
    public Commodity(Integer code, String title, String category, double price, Integer stock) {
        this.code = code;
        this.title = title;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "code=" + code +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}