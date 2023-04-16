package org.example;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("1.Login");
        System.out.println("2.Sign Up");
        System.out.println("3.Exit");

        Scanner in =new Scanner(System.in);
        int op = in.nextInt();

        if (op == 1) {
            login();
        }
        else if (op == 2) {
            signUp();
        }
        else if (op == 3) {
            System.out.print("Have a nice day.");
        }
        else {
            System.out.print("Invalid operation!!!");
        }
    }

    public static void login() {
        Scanner in =new Scanner(System.in);
        System.out.print("Name: ");
        String name = in.nextLine();
        System.out.print("Password: ");
        String password = in.nextLine();
        if (User.doesUserExist(name, password)){
            System.out.println("Welcome " + name);
            userMenu();
        }
        else if (Seller.doesSellerExist(name, password)) {
            System.out.println("Welcome " + name);
            sellerMenu();
        }
        else if (Admin.doesAdminExist(name, password)) {
            System.out.println("Welcome " + name);
            adminMenu();
        }
        else {
            System.out.println("Something went wrong. Please try again later.");
        }
    }
    public static void signUp() {

    }

    public static void adminMenu() {

    }
    public static void userMenu() {

    }
    public static void sellerMenu() {

    }
}