package org.example;

import java.util.ArrayList;

public class Product extends SubCategory {
    public String name;
    public int price;
    public int number;
    public ArrayList<String> comment;

    public Product(String category, String subCategory, String name, int price, int number) {
        super(category, subCategory);
        this.name = name;
        this.price = price;
        this.number = number;
    }

    public void setComment(ArrayList<String> comment) {
        this.comment = comment;
    }
}
