package com.company.Models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Item implements Comparable<Item>{
    private String name;
    private String code;
    private int quantity;
    private Date expiration;
    Item(String name, String code, int quantity, String expiration) throws ParseException {
    this.name=name;
    this.code=code;
    this.quantity=quantity;
        SimpleDateFormat smd=new SimpleDateFormat("yyyy-MM-dd");
    this.expiration = smd.parse(expiration);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }


    @Override
    public int compareTo(Item item) {
      return name.compareTo(item.name);
    }
}
