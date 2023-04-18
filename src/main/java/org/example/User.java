package org.example;

import java.util.ArrayList;

public class User {
    public String userName;
    public String password;
    public String email;
    public String number;
    public String address;
    public ArrayList<String> cart;
    public ArrayList purchaseHistory;
    public int wallet = 0;

    public User(String userName, String password) {

        this.userName = userName;
        this.password = password;
    }
    public User(String userName, String password, String email, String number, String address) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.number = number;
        this.address = address;
        cart = new ArrayList<>();
        purchaseHistory = new ArrayList();
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setCart(ArrayList<String> cart) {
        this.cart = cart;
    }
    public void setPurchaseHistory(ArrayList<String> purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }
    public void setWallet(int wallet) {
        this.wallet = wallet;
    }
}
