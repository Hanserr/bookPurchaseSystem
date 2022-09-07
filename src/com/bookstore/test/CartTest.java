package com.bookstore.test;

import com.bookstore.pojo.Cart;
import com.bookstore.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"tttt",1,new BigDecimal(123),new BigDecimal(13),1));
        cart.addItem(new CartItem(1,"tttt",1,new BigDecimal(123),new BigDecimal(13),1));
        cart.addItem(new CartItem(2,"tttt",1,new BigDecimal(123),new BigDecimal(13),1));
        cart.DeleteItem(1);
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
    }

    @Test
    public void clear() {
    }

    @Test
    public void update() {
    }
}