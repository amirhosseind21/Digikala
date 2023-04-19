package org.example;

import java.util.ArrayList;

public class Product extends SubCategory {
    private String name;
    private int price;
    private int number;
    private ArrayList<String> comment;

    public Product(String category, String subCategory, String name, int price, int number) {
        super(category, subCategory);
        this.name = name;
        this.price = price;
        this.number = number;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getPrice() {
        return price;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public int getNumber() {
        return number;
    }
    public void setComment(ArrayList<String> comment) {
        this.comment = comment;
    }
    public ArrayList<String> getComment() {
        return comment;
    }
    public void addComment(String comment) {
        this.comment.add(comment);
    }
    @Override
    public String toString() {
        return "Product{" +
                "category:" + super.getCategory() +
                ", subcategory:" + super.getSubCategory() +
                ", name:" + name +
                ", price:" + price +
                ", number:" + number +
                '}';
    }
}
