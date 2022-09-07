package com.bookstore.pojo;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
    private Map<Integer,CartItem> items = new LinkedHashMap<Integer, CartItem>();
    public void addItem(CartItem cartItem){
    CartItem item = items.get(cartItem.getId());
    if(item == null){
        items.put(cartItem.getId(),cartItem);
    }else{
        item.setCount(item.getCount()+1);
        item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
    }
    }

    public void DeleteItem(Integer id){
    items.remove(id);
    }

    public void clear(){
        items.clear();
    }

    public void update(Integer id, Integer count){
    CartItem cartItem = items.get(id);
    if(cartItem != null){
        cartItem.setCount(count);
        cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
    }
    }

    @Override
    public String toString() {
        return "Cart{" +
                "TotalCount=" + getTotalCount() +
                ", TotalPrice=" + getTotalPrice()+
                ", items=" + items +
                '}';
    }

    public Integer getTotalCount() {
        Integer TotalCount = 0;
        for (Map.Entry<Integer, CartItem>entry:items.entrySet()){
            TotalCount+=entry.getValue().getCount();
        }
        return TotalCount;
    }


    public BigDecimal getTotalPrice() {
    BigDecimal TotalPrice = new BigDecimal(0);
        for (Map.Entry<Integer,CartItem>entry:items.entrySet()) {
            TotalPrice = TotalPrice.add(entry.getValue().getTotalPrice());
        }
        return TotalPrice;
    }


    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }
}
