package org.example;

import java.util.ArrayList;

public class Seller {
    public String companyName;
    public String password;
    public ArrayList<String> productsName;
    public int wallet;

    public Seller(String companyName, String password) {
        this.companyName =companyName;
        this.password = password;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }
    public void setProductsName(ArrayList<String> productsName) {
        this.productsName = productsName;
    }
}

