package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Manage.getFileDetails();
            firstMenu();
        }
        catch (Exception e) {
            e.printStackTrace();
            Manage.writeFile();
        }
    }

    public static void firstMenu() {
        System.out.println("1.Login");
        System.out.println("2.Sign Up");
        System.out.println("3.Exit");

        Scanner in =new Scanner(System.in);
        String op = in.nextLine();

        if (op.equals("1")) {
            login();
        }
        else if (op.equals("2")) {
            signUp();
        }
        else if (op.equals("3")) {
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
        if (Manage.doesUserExist(name, password)){
            System.out.println("Welcome " + name);
            userMenu();
        }
        else if (Manage.doesSellerExist(name, password)) {
            System.out.println("Welcome " + name);
            sellerMenu();
        }
        else if (Manage.doesAdminExist(name, password)) {
            System.out.println("Welcome " + name);
            adminMenu();
        }
        else {
            System.out.println("Something went wrong. Please try again later.");
        }
    }
    public static void signUp() {
        Scanner in =new Scanner(System.in);
        String op = in.nextLine();

        System.out.print("Name: ");
        String name = in.nextLine();
        System.out.print("Password: ");
        String password = in.nextLine();
        System.out.print("Email: ");
        String email = in.nextLine();
        System.out.print("Number: ");
        String number = in.nextLine();
        System.out.print("Address: ");
        String address = in.nextLine();

        if (!Manage.doesUserExist(name) && !Manage.doesSellerExist(name) && !Manage.doesAdminExist(name)) {
            Manage.addUser(name, password, email, number, address);
            System.out.println("Sign up was successful");
            firstMenu();
        }
        else {
            System.out.println("Name already exist.");
            firstMenu();
        }


    }

    public static void adminMenu() {
        System.out.println("1.Add admin");
        System.out.println("2.Add seller");
        System.out.println("3.Fund request");
        System.out.println("4.Order request");
        System.out.println("5.Exit");

        Scanner in = new Scanner(System.in);
        String op = in.next();

        if (op.equals("1")) {

        }
        else if (op.equals("2")) {

        }
        else if (op.equals("3")) {

        }
        else if (op.equals("4")) {

        }
        else if (op.equals("5")) {

        }
        else {
            System.out.println("Invalid operation!");
        }
    }
    public static void userMenu() {
        System.out.println("1.Products");
        System.out.println("2.Cart");
        System.out.println("3.Fund request");
        System.out.println("4.Profile");
        System.out.println("5.Exit");

        Scanner in = new Scanner(System.in);
        String op = in.next();

        if (op.equals("1")) {

        }
        else if (op.equals("2")) {

        }
        else if (op.equals("3")) {

        }
        else if (op.equals("4")) {

        }
        else if (op.equals("5")) {

        }
        else {
            System.out.println("Invalid operation!");
        }
    }
    public static void sellerMenu() {
        System.out.println("1.Add Products");
        System.out.println("2.Product list");
        System.out.println("3.Wallet amount");
        System.out.println("4.Profile");
        System.out.println("5.Exit");

        Scanner in = new Scanner(System.in);
        String op = in.next();

        if (op.equals("1")) {

        }
        else if (op.equals("2")) {

        }
        else if (op.equals("3")) {

        }
        else if (op.equals("4")) {

        }
        else if (op.equals("5")) {

        }
        else {
            System.out.println("Invalid operation!");
        }
    }
}