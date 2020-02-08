package com.alialfayed.marketapp.model;

/**
 * Created by ( Eng Ali Al Fayed)
 * Class do :
 * Date 2/8/2020 - 1:00 AM
 */
public class Product {
    private String  id;
    private String name;
    private String price;

    public Product(){}

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getProduct_img() {
        return product_img;
    }

    public String getWeight() {
        return weight;
    }

    private String product_img;
    private String weight;



}
