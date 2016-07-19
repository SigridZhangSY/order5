package com.thoughtworks.ketsu.infrastructure.records;


import com.thoughtworks.ketsu.infrastructure.core.Product;

public class ProductRecord implements Product{
    private int id;
    private String name;
    private String description;
    private float price;

    public ProductRecord(int id){
        this.id = id;
    }

    public ProductRecord(){
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public float getPrice() {
        return price;
    }
}
