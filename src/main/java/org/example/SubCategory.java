package org.example;

public class SubCategory extends Category {
    private String subCategory;
    public SubCategory(String category, String subCategory) {
        super(category);
        this.subCategory = subCategory;
    }

    public String getSubCategory() {
        return subCategory;
    }
    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }
}
