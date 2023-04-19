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
        }
        finally {
            //Manage.writeFile();
        }
    }

    public static void firstMenu() {
        while (true) {
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
                break;
            }
            else {
                System.out.print("Invalid operation!!!");
            }
        }
    }
    public static void login() {
        Scanner in =new Scanner(System.in);
        System.out.print("Name: ");
        String name = in.nextLine();
        System.out.print("Password: ");
        String password = in.nextLine();
        if (Manage.doesUserExist(name, password)){
            userMenu(name);
        }
        else if (Manage.doesSellerExist(name, password)) {
            sellerMenu(name);
        }
        else if (Manage.doesAdminExist(name, password)) {
            adminMenu(name);
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

    public static void adminMenu(String adminName) {
        System.out.println("Welcome " + adminName);
        while (true) {
            System.out.println("1.Add admin");
            System.out.println("2.Add seller");
            System.out.println("3.Fund requests");
            System.out.println("4.Order requests");
            System.out.println("5.Add product requests");
            System.out.println("6.Exit");

            Scanner in = new Scanner(System.in);
            String op = in.next();

            if (op.equals("1")) {
                System.out.println("Name: ");
                String name = in.next();
                System.out.println("Password: ");
                String password = in.next();
                System.out.println("Email: ");
                String email = in.next();

                if (!Manage.doesUserExist(name) && !Manage.doesSellerExist(name) && !Manage.doesAdminExist(name)) {
                    Manage.addAdmin(name, password, email);
                    System.out.println("Added successfully");
                }
                else {
                    System.out.println("This name is not available.");
                }
            }
            else if (op.equals("2")) {
                System.out.println("Name: ");
                String name = in.next();
                System.out.println("Password: ");
                String password = in.next();

                if (!Manage.doesUserExist(name) && !Manage.doesSellerExist(name) && !Manage.doesAdminExist(name)) {
                    Manage.addSeller(name, password);
                    System.out.println("Added successfully");
                }
                else {
                    System.out.println("This name is not available.");
                }
            }
            else if (op.equals("3")) {
                while (true) {
                    for (int i = 0; i < Manage.user.size(); i++) {
                        if (Manage.getFundRequest().containsKey(Manage.user.get(i).getUserName())) {
                            System.out.println("Username: " + Manage.user.get(i).getUserName() + " , Requested amount: " + Manage.getFundRequest().get(Manage.user.get(i).getUserName()));
                        }
                    }
                    System.out.println("Enter username to accept or reject");
                    System.out.println("Enter \"menu\" to get back");
                    op = in.next();
                    if (op.equals("menu")) {
                        break;
                    }
                    else {
                        if (Manage.getFundRequest().containsKey(op)) {
                            System.out.println("Username: " + op + "  Requested amount: " + Manage.getFundRequest().get(op));
                            System.out.println("1.Accept");
                            System.out.println("2.Reject");
                            String op1 = in.next();
                            if(op1.equals("1")) {
                                int userIndex = -1;
                                for (int i = 0; i < Manage.user.size(); i++) {
                                    if (Manage.user.get(i).getUserName().equals(op)) {
                                        userIndex = i;
                                    }
                                }
                                Manage.user.get(userIndex).setWallet(Manage.user.get(userIndex).getWallet() + Manage.getFundRequest().get(op));
                                Manage.getFundRequest().remove(op);
                                System.out.println("Request accepted.");
                            }
                            else if (op1.equals("2")) {
                                Manage.getFundRequest().remove(op);
                                System.out.println("Request rejected.");
                            }
                            else {
                                System.out.println("Invalid operation!");
                            }
                        }
                        else {
                            System.out.println("Invalid operation!");
                        }
                    }
                }
            }
            else if (op.equals("4")) {
                while (true) {
                    for (int i = 0; i < Manage.user.size(); i++) {
                        if (Manage.getOrderRequest().containsKey(Manage.user.get(i).getUserName())) {
                            System.out.println("Username: " + Manage.user.get(i).getUserName() + " , Requested order: " + Manage.getOrderRequest().get(Manage.user.get(i).getUserName()));
                        }
                    }
                    System.out.println("Enter username to accept or reject");
                    System.out.println("Enter \"menu\" to get back");
                    op = in.next();
                    if (op.equals("menu")) {
                        break;
                    }
                    else {
                        if (Manage.getOrderRequest().containsKey(op)) {
                            System.out.println("Username: " + op + "  Requested order: " + Manage.getOrderRequest().get(op));
                            System.out.println("1.Accept");
                            System.out.println("2.Reject");
                            String op1 = in.next();
                            if(op1.equals("1")) {
                                int userIndex = -1;
                                for (int i = 0; i < Manage.user.size(); i++) {
                                    if (Manage.user.get(i).getUserName().equals(op)) {
                                        userIndex = i;
                                    }
                                }
                                int price = 0;
                                for (int i = 0; i < Manage.getOrderRequest().get(op).size(); i++) {
                                    price += Manage.nameToPrice(Manage.getOrderRequest().get(op).get(i));
                                }
                                Manage.user.get(userIndex).setWallet(Manage.user.get(userIndex).getWallet() - price);
                                Manage.user.get(userIndex).addCartToPurchaseHistory();
                                Manage.user.get(userIndex).cleanCartList();
                                Manage.getOrderRequest().remove(op);
                                System.out.println("Request accepted.");
                            }
                            else if (op1.equals("2")) {
                                Manage.getOrderRequest().remove(op);
                                System.out.println("Request rejected.");
                            }
                            else {
                                System.out.println("Invalid operation!");
                            }
                        }
                        else {
                            System.out.println("Invalid operation!");
                        }
                    }
                }
            }
            else if (op.equals("5")) {
                while (true) {
                    for (int i = 0; i < Manage.seller.size(); i++) {
                        if (Manage.getAddProductRequest().containsKey(Manage.seller.get(i).getCompanyName())) {
                            System.out.println("Company name: " + Manage.seller.get(i).getCompanyName() + " , Requested " + Manage.getAddProductRequest().get(Manage.seller.get(i).getCompanyName()));
                        }
                    }
                    System.out.println("Enter company name to accept or reject");
                    System.out.println("Enter \"menu\" to get back");
                    op = in.next();
                    if (op.equals("menu")) {
                        break;
                    }
                    else {
                        if (Manage.getAddProductRequest().containsKey(op)) {
                            System.out.println("Company name: " + op + "  Requested " + Manage.getAddProductRequest().get(op));
                            System.out.println("1.Accept");
                            System.out.println("2.Reject");
                            String op1 = in.next();
                            if(op1.equals("1")) {
                                int sellerIndex = -1;
                                for (int i = 0; i < Manage.seller.size(); i++) {
                                    if (Manage.seller.get(i).getCompanyName().equals(op)) {
                                        sellerIndex = i;
                                    }
                                }
                                Manage.product.add(Manage.getAddProductRequest().get(op));
                                Manage.seller.get(sellerIndex).addProduct(Manage.getAddProductRequest().get(op).getName());
                                Manage.getAddProductRequest().remove(op);
                                System.out.println("Request accepted.");
                            }
                            else if (op1.equals("2")) {
                                Manage.getAddProductRequest().remove(op);
                                System.out.println("Request rejected.");
                            }
                            else {
                                System.out.println("Invalid operation!");
                            }
                        }
                        else {
                            System.out.println("Invalid operation!");
                        }
                    }
                }
            }
            else if (op.equals("6")) {
                break;
            }
            else {
                System.out.println("Invalid operation!");
            }
        }
    }
    public static void sellerMenu(String companyName) {
        // get seller index
        int sellerIndex = -1;
        for (int i = 0; i < Manage.seller.size(); i++) {
            if (Manage.seller.get(i).getCompanyName().equals(companyName)) {
                sellerIndex = i;
            }
        }
        System.out.println("Welcome " + companyName);
        while (true) {

            System.out.println("1.Add Products request");
            System.out.println("2.My products list");
            System.out.println("3.Profile");
            System.out.println("4.Exit");

            Scanner in = new Scanner(System.in);
            String op = in.next();

            if (op.equals("1")) {

                System.out.println("Enter category: ");
                String category = in.next();
                System.out.println("Enter subCategory: ");
                String subCategory = in.next();
                System.out.println("Enter name: ");
                String name = in.next();
                System.out.println("Enter price: ");
                int price = Integer.parseInt(in.next());
                System.out.println("Enter number: ");
                int number = Integer.parseInt(in.next());
                Manage.setAddProductRequest(companyName ,new Product(category, subCategory, name, price, number));
                System.out.println("Request sent.");
            }
            else if (op.equals("2")) {
                while (true) {
                    for (int i = 0; i < Manage.seller.get(sellerIndex).getProductsName().size(); i++) {
                        for (int j = 0; j < Manage.product.size(); j++) {
                            if (Manage.seller.get(sellerIndex).getProductsName().get(i).equals(Manage.product.get(j).getName())) {
                                System.out.println("Name: " + Manage.product.get(j).getName());
                                System.out.println("Price: " + Manage.product.get(j).getPrice());
                                System.out.println(("Number: " + Manage.product.get(j).getNumber()));
                                System.out.println("Comments: ");
                                for (int k = 0; k < Manage.product.get(j).getComment().size(); k++) {
                                    System.out.println(Manage.product.get(j).getComment().get(k));
                                }
                                System.out.println();
                            }
                        }
                    }

                    System.out.println("1.Edit product");
                    System.out.println("2.Back to menu");
                    op = in.next();

                    if (op.equals("1")) {
                        System.out.println("Enter name of product: ");
                        String productName = in.next();
                        int productIndex = -1;
                        for (int i = 0; i < Manage.product.size(); i++) {
                            if (Manage.product.get(i).getName().equals(productName)) {
                                productIndex = i;
                            }
                        }
                        while (true) {
                            System.out.println("1.Change price");
                            System.out.println("2.Change number");
                            System.out.println("3.Back");

                            op = in.next();

                            if (op.equals("1")) {
                                System.out.println("Enter new price: ");
                                op = in.next();
                                Manage.product.get(productIndex).setPrice(Integer.parseInt(op));
                                System.out.println("Done.");
                            }
                            else if (op.equals("2")) {
                                System.out.println("Enter new number:");
                                op = in.next();
                                if (Integer.parseInt(op) >= 0) {
                                    Manage.product.get(productIndex).setNumber(Integer.parseInt(op));
                                    System.out.println("Done.");
                                }
                                else if (Integer.parseInt(op) < 0) {
                                    System.out.println("Invalid amount entered!");
                                }
                            }
                            else if (op.equals("3")) {
                                break;
                            }
                            else {
                                System.out.println("Invalid operation!");
                            }
                        }
                    }
                    else if (op.equals("2")) {
                        break;
                    }
                    else {
                        System.out.println("Invalid operation!");
                    }
                }
            }
            else if (op.equals("3")) {
                    while (true) {
                        System.out.println("CompanyName: " + Manage.seller.get(sellerIndex).getCompanyName());
                        System.out.println("Password: " + Manage.seller.get(sellerIndex).getPassword());
                        System.out.println("Wallet: " + Manage.seller.get(sellerIndex).getWallet());

                        System.out.println("Type the name of attribute to edit");
                        System.out.println("Type \"menu\" to come back");

                        op = in.next();

                        if (op.equals("menu")) {
                            break;
                        }
                        else if (op.equals("CompanyName")) {
                            System.out.println("Enter new name");
                            op = in.next();
                            if (!Manage.doesUserExist(op) && !Manage.doesSellerExist(op) && !Manage.doesAdminExist(op)) {
                                Manage.seller.get(sellerIndex).setCompanyName(op);
                                System.out.println("Done.");
                            }
                            else {
                                System.out.println("Name already exists!");
                            }
                        }
                        else if (op.equals("Password")) {
                            System.out.println("Enter new password");
                            op = in.next();
                            Manage.seller.get(sellerIndex).setPassword(op);
                            System.out.println("Done.");
                        }
                        else {
                            System.out.println("Invalid operation!");
                        }
                    }
                }
            else if (op.equals("4")) {
                break;
            }
            else {
                    System.out.println("Invalid operation!");
                }
        }
    }
    public static void userMenu(String userName) {
        System.out.println("Welcome " + userName);
        while (true) {
            // get user index
            int userIndex = -1;
            for (int i = 0; i < Manage.user.size(); i++) {
                if (Manage.user.get(i).getUserName().equals(userName)) {
                    userIndex = i;
                }
            }

            System.out.println("1.Products");
            System.out.println("2.Cart");
            System.out.println("3.Fund request");
            System.out.println("4.Profile");
            System.out.println("5.Exit");

            Scanner in = new Scanner(System.in);
            String op = in.next();

            if (op.equals("1")) {
                while (true) {
                    for (int i = 0; i < Manage.productNumber(); i++) {
                        System.out.println(Manage.productList().get(i).getName());
                    }
                    System.out.println("Type name of product to see details.");
                    System.out.println("Type \"menu\" to get back");
                    op = in.next();

                    boolean hasProduct = false;
                    int productIndex = -1;
                    for (int i = 0; i < Manage.productNumber(); i++) {
                        if(Manage.productList().get(i).getName().equals(op));
                        {
                            hasProduct =true;
                            productIndex = i;
                        }
                    }
                    if (op.equals("menu")) {
                        break;
                    }
                    else if (hasProduct) {
                        while (true) {
                            System.out.println("name : " + Manage.product.get(productIndex).getName());
                            System.out.println("price : " + Manage.product.get(productIndex).getPrice());
                            System.out.println("comments : ");
                            for (int i = 0; i < Manage.product.get(productIndex).getComment().size(); i++) {
                                System.out.println(Manage.product.get(productIndex).getComment().get(i));
                            }
                            System.out.println();
                            System.out.println("1.Add to cart");
                            System.out.println("2.Add comment");
                            System.out.println("3.Exit");
                            String productName = op;
                            op = in.next();

                            if (op.equals("1")) {
                                if (Manage.product.get(productIndex).getNumber() > 0) {
                                    Manage.user.get(userIndex).addToCart(productName);
                                    Manage.product.get(productIndex).setNumber(Manage.product.get(productIndex).getNumber() - 1);
                                    System.out.println("Product added to your cart.");
                                }
                                else {
                                    System.out.println("This product is not available right now!");
                                }
                            }
                            else if (op.equals("2")) {
                                System.out.println("Type your comment: ");
                                in.nextLine();
                                String newComment = in.nextLine();
                                Manage.product.get(productIndex).addComment(newComment);
                                System.out.println("Done.");
                            }
                            else if (op.equals("3")) {
                                break;
                            }
                            else {
                                System.out.println("Invalid operation!");
                            }
                        }
                    }
                    else {
                        System.out.println("Invalid operation!");
                    }
                }
            }
            else if (op.equals("2")) {
                while (true){
                    for (int i = 0; i < Manage.user.get(userIndex).getCart().size(); i++) {
                        System.out.println(Manage.user.get(userIndex).getCart().get(i));
                    }
                    System.out.println("1.Finalize order");
                    System.out.println("2.Delete a product from cart");
                    System.out.println("3.Exit");

                    op = in.next();

                    if (op.equals("1")) {
                        int price = 0;
                        for (int i = 0; i < Manage.user.get(userIndex).getCart().size(); i++) {
                            price += Manage.nameToPrice(Manage.user.get(userIndex).getCart().get(i));
                        }

                        if (price <= Manage.user.get(userIndex).getWallet()) {
                            Manage.setOrderRequest(userName, Manage.user.get(userIndex).getCart());
                            System.out.println("Order request sent.");
                        }
                        else {
                            System.out.println("You don't have enough money.");
                        }
                    }
                    else if (op.equals("2")) {
                        System.out.println("Enter product name: ");
                        op = in.next();

                        boolean hasProduct = false;
                        for (int i = 0; i < Manage.user.get(userIndex).getCart().size(); i++) {
                            if (Manage.user.get(userIndex).getCart().get(i).equals(op)) {
                                hasProduct = true;
                            }
                        }
                        if (hasProduct) {
                            Manage.user.get(userIndex).removeFromCart(op);
                            System.out.println("Done.");
                        }
                        else {
                            System.out.println("Wrong name entered!");
                        }
                    }
                    else if (op.equals("3")) {
                        break;
                    }
                    else {
                        System.out.println("Invalid operation!");
                    }
                }

            }
            else if (op.equals("3")) {
                while (true) {
                    System.out.println("Enter money amount: (Your previous request will be cancelled)");
                    System.out.println("type \"menu\" to get back");
                    op = in.next();
                    if(op.equals("menu")) {
                        break;
                    }
                    else if (0 <= Integer.parseInt(op) && Integer.parseInt(op) <= 10_000) {
                        Manage.setFundRequest(userName, Integer.parseInt(op));
                        System.out.println("Your request successfully sent.");
                    }
                    else  {
                        System.out.println("Invalid operation or money amount");
                    }
                }
            }
            else if (op.equals("4")) {
                while (true) {
                    System.out.println("Username: " + Manage.user.get(userIndex).getUserName());
                    System.out.println("Password: " + Manage.user.get(userIndex).getPassword());
                    System.out.println("Email: " + Manage.user.get(userIndex).getEmail());
                    System.out.println("Address: " + Manage.user.get(userIndex).getAddress());
                    System.out.println("Number: " + Manage.user.get(userIndex).getNumber());
                    System.out.println("Wallet: " + Manage.user.get(userIndex).getWallet());
                    System.out.println("Purchase history: ");
                    for (int i = 0; i < Manage.user.get(userIndex).getPurchaseHistory().size(); i++) {
                        System.out.println(Manage.user.get(userIndex).getPurchaseHistory().get(i));
                    }
                    System.out.println("Type the name of attribute to edit");
                    System.out.println("Type \"menu\" to come back");

                    op = in.next();

                    if (op.equals("menu")) {
                        break;
                    }
                    else if (op.equals("Username")) {
                        System.out.println("Enter new Username");
                        op = in.next();
                        if (!Manage.doesUserExist(op) && !Manage.doesSellerExist(op) && !Manage.doesAdminExist(op)) {
                            Manage.user.get(userIndex).setUserName(op);
                            System.out.println("Done.");
                        }
                        else {
                            System.out.println("Username already exists!");
                        }
                    }
                    else if (op.equals("Password")) {
                        System.out.println("Enter new password");
                        op = in.next();
                        Manage.user.get(userIndex).setPassword(op);
                        System.out.println("Done.");
                    }
                    else if (op.equals("Email")) {
                        System.out.println("Enter new email");
                        op = in.next();
                        Manage.user.get(userIndex).setEmail(op);
                        System.out.println("Done.");
                    }
                    else if (op.equals("Address")) {
                        System.out.println("Enter new address");
                        op = in.next();
                        Manage.user.get(userIndex).setAddress(op);
                        System.out.println("Done.");
                    }
                    else if (op.equals("Number")) {
                        System.out.println("Enter new number");
                        op = in.next();
                        Manage.user.get(userIndex).setNumber(op);
                        System.out.println("Done.");
                    }
                    else {
                        System.out.println("Invalid operation!");
                    }
                }
            }
            else if (op.equals("5")) {
                break;
            }
            else {
                System.out.println("Invalid operation!");
            }
        }
    }
}