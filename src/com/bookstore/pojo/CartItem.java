package com.bookstore.pojo;

import java.math.BigDecimal;
//购物车商品项
public class CartItem {
    private Integer id;
    private String name;
    private Integer count;
    private BigDecimal Price;
    private BigDecimal TotalPrice;
    private Integer stock;

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", Price=" + Price +
                ", TotalPrice=" + TotalPrice +
                ", stock=" + stock +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return Price;
    }

    public void setPrice(BigDecimal price) {
        Price = price;
    }

    public BigDecimal getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        TotalPrice = totalPrice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public CartItem(Integer id, String name, Integer count, BigDecimal price, BigDecimal totalPrice, Integer stock) {
        this.id = id;
        this.name = name;
        this.count = count;
        Price = price;
        TotalPrice = totalPrice;
        this.stock = stock;
    }
    public CartItem() { }
}