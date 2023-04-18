package org.example;

public class SubCategory extends Category {
    String subCategory;
    public SubCategory(String category, String subCategory) {
        super(category);
        this.subCategory = subCategory;
    }
}
