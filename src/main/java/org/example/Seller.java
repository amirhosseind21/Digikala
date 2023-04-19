package org.example;

import java.util.ArrayList;

public class Seller {
    private String companyName;
    private String password;
    private ArrayList<String> productsName;
    private int wallet;

    public Seller(String companyName, String password) {
        this.companyName =companyName;
        this.password = password;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public ArrayList<String> getProductsName() {
        return productsName;
    }
    public void setProductsName(ArrayList<String> productsName) {
        this.productsName = productsName;
    }
    public void addProduct(String productName) {
        productsName.add(productName);
    }
    public int getWallet() {
        return wallet;
    }
    public void setWallet(int wallet) {
        this.wallet = wallet;
    }
}

