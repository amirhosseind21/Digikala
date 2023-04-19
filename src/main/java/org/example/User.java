package org.example;

import java.util.ArrayList;

public class User {
    private String userName;
    private String password;
    private String email;
    private String number;
    private String address;
    private ArrayList<String> cart;
    private ArrayList purchaseHistory;
    private int wallet = 0;

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
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserName() {
        return userName;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public String getNumber() {
        return number;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return address;
    }
    public void setCart(ArrayList<String> cart) {
        this.cart = cart;
    }
    public void addToCart(String name) {
        cart.add(name);
    }
    public void removeFromCart (String productName) {
        cart.remove(productName);
    }
    public void cleanCartList () {
        for (int i = cart.size() - 1; i >= 0; i--) {
            cart.remove(i);
        }
    }
    public ArrayList<String> getCart() {
        return cart;
    }
    public void setPurchaseHistory(ArrayList<String> purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }
    public ArrayList getPurchaseHistory() {
        return purchaseHistory;
    }
    public void addCartToPurchaseHistory() {
        for (int i = 0; i < cart.size(); i++) {
            purchaseHistory.add(cart.get(i));
        }
    }
    public void setWallet(int wallet) {
        this.wallet = wallet;
    }
    public int getWallet() {
        return wallet;
    }
}
