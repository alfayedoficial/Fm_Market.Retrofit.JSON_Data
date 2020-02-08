package com.alialfayed.marketapp.model;

import java.util.ArrayList;

/**
 * Created by ( Eng Ali Al Fayed)
 * Class do :
 * Date 2/8/2020 - 12:58 AM
 */
public class CategoryItems {
    private String id;
    private String name;
    private String category_img;
    private ArrayList<Product> products;

    public CategoryItems(){}

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory_img() {
        return category_img;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }



}
