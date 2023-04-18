package org.example;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Manage {
    // file read and write
    public static void getFileDetails() {
        userGetFileDetails();
        sellerGetFileDetails();
        adminGetFileDetails();
        productGetFileDetails();
    }
    public static void writeFile() {
        writeUserFile();
        writeSellerFile();
        writeAdminFile();
        writeProductFile();
    }


    // user related functions
    public static ArrayList<User> user = new ArrayList<>();
    public static void userGetFileDetails() {
        try {
            File file = new File("User.txt");
            Scanner reader = new Scanner(file);
            int usersNumber = reader.nextInt();
            reader.nextLine();
            while (reader.hasNextLine()) {
                for (int i = 0; i < usersNumber; i++) {

                    user.add(i, new User(reader.next(), reader.next()));
                    user.get(i).setEmail(reader.next());
                    user.get(i).setAddress(reader.next());
                    user.get(i).setNumber(reader.next());
                    int wallet = reader.nextInt();
                    int cartNum = reader.nextInt();
                    ArrayList<String> cart = new ArrayList();
                    for (int j = 0; j < cartNum; j++) {
                        cart.add(reader.next());
                    }
                    int purchaseHistoryNum = reader.nextInt();
                    ArrayList<String> purchaseHistory = new ArrayList<>();
                    for (int j = 0; j < purchaseHistoryNum; j++) {
                        purchaseHistory.add(reader.next());
                    }
                    reader.nextLine();

                    user.get(i).setCart(cart);
                    user.get(i).setPurchaseHistory(purchaseHistory);
                    user.get(i).setWallet(wallet);
                }
            }
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void writeUserFile() {
        try {
            FileWriter writer = new FileWriter("User.txt");
            writer.write(user.size());
            writer.write("\n");
            for (int i = 0; i < user.size(); i++) {
                writer.write(user.get(i).userName + " " + user.get(i).password + " " + user.get(i).email + " " + user.get(i).address + " " + user.get(i).number + " ");
                writer.write(user.get(i).wallet + " " + user.get(i).cart.size() + " " + user.get(i).cart + " " + user.get(i).purchaseHistory.size() + " " + user.get(i).purchaseHistory);
                writer.write("\n");
            }

            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static boolean doesUserExist(String name, String password) {
        for (int i = 0; i < user.size(); i++) {
            if (user.get(i).userName.equals(name) && user.get(i).password.equals(password)) {
                return true;
            }
        }
        return false;
    }
    public static boolean doesUserExist(String name){
        return user.get(0).userName.equals(name);
    }
    public static void addUser(String name, String password, String email, String number, String address) {
        User newUser = new User(name, password, email, number , address);
        user.add(newUser);
    }
    public static void addProductToCart(String productId) {

    }
    public static void addMoney(int moneyAmount) {

    }


    // seller related functions
    public static ArrayList<Seller> seller = new ArrayList<>();
    public static void sellerGetFileDetails() {
        try {
            File file = new File("Seller.txt");
            Scanner reader = new Scanner(file);
            int sellersNumber = reader.nextInt();
            reader.nextLine();
            while (reader.hasNextLine()) {
                for (int i = 0; i < sellersNumber; i++) {
                    seller.add(i, new Seller(reader.next(), reader.next()));
                    int productNumber = reader.nextInt();
                    ArrayList<String> productName = new ArrayList<>();
                    for (int j = 0; j < productNumber; j++) {
                        productName.add(reader.next());
                    }
                    seller.get(i).setWallet(reader.nextInt());
                    reader.nextLine();
                    seller.get(i).setProductsName(productName);
                }
            }
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void writeSellerFile() {
        try {
            FileWriter writer = new FileWriter("Seller.txt");
            writer.write(seller.size());
            writer.write("\n");
            for (int i = 0; i < seller.size(); i++) {
                writer.write(seller.get(i).companyName + " " + seller.get(i).password + " ");
                writer.write(seller.get(i).productsName.size() + " " + seller.get(i).productsName + " " + seller.get(i).wallet);
                writer.write("\n");
            }

            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static boolean doesSellerExist(String name, String password) {
        for (int i = 0; i < seller.size(); i++) {
            if (seller.get(i).companyName.equals(name) && seller.get(i).password.equals(password)) {
                return true;
            }
        }
        return false;
    }
    public static boolean doesSellerExist(String name) {
        return false;
    }
    public static void addSeller(String name, String password) {

    }


    // admin related functions
    public static ArrayList<Admin> admin = new ArrayList<>();
    public static void adminGetFileDetails() {
        try {
            File file = new File("Admin.txt");
            Scanner reader = new Scanner(file);
            int adminsNumber = reader.nextInt();
            reader.nextLine();
            while (reader.hasNextLine()) {
                for (int i = 0; i < adminsNumber; i++) {
                    admin.add(i, new Admin(reader.next(), reader.next(), reader.next()));
                    reader.nextLine();
                }
            }
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void writeAdminFile() {
        try {
            FileWriter writer = new FileWriter("Admin.txt");
            writer.write(admin.size());
            writer.write("\n");
            for (int i = 0; i < admin.size(); i++) {
                writer.write(admin.get(i).name + " " + admin.get(i).password + " " + admin.get(i).email);
                writer.write("\n");
            }

            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static boolean doesAdminExist(String name, String password) {
        for (int i = 0; i < admin.size(); i++) {
            if (admin.get(i).name.equals(name) && admin.get(i).password.equals(password)) {
                return true;
            }
        }
        return false;
    }
    public static boolean doesAdminExist(String name) {
        return false;
    }


    // product related functions
    static ArrayList<Product> product = new ArrayList<>();
    public static void productGetFileDetails() {
        try {
            File file = new File("Product.txt");
            Scanner reader = new Scanner(file);
            int productsNumber = reader.nextInt();
            reader.nextLine();
            while (reader.hasNextLine()) {
                for (int i = 0; i < productsNumber; i++) {
                    product.add(i, new Product(reader.next(), reader.next(), reader.next(), reader.nextInt(), reader.nextInt()));
                    int commentsNumber = reader.nextInt();
                    ArrayList<String> comment = new ArrayList<>();
                    for (int j = 0; j < commentsNumber; j++) {
                        reader.nextLine();
                        comment.add(reader.nextLine());
                    }
                    product.get(i).setComment(comment);
                }
            }
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void writeProductFile() {
        try {
            FileWriter writer = new FileWriter("Product.txt");
            writer.write(product.size());
            writer.write("\n");
            for (int i = 0; i < product.size(); i++) {
                writer.write(product.get(i).category + " " + product.get(i).subCategory + " " + product.get(i).name + " ");
                writer.write(product.get(i).price + " " + product.get(i).price + " " + product.get(i).number + product.get(i).comment.size());
                writer.write("\n");
                for (int j = 0; j < product.get(i).comment.size(); j++) {
                    writer.write(product.get(i).comment.get(i) + "\n");
                }
            }

            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
