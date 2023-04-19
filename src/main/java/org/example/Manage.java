package org.example;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Manage {
    final String shopName = "Digikala";
    final String website = "digikala.com";
    final String shopNumber = "02161930000";
    private static int profit = 0;

    private static HashMap<String, Integer> fundRequest = new HashMap<>();// key : userName , value : request amount
    public static HashMap<String, Integer> getFundRequest() {
        return fundRequest;
    }
    public static void setFundRequest(String userName, int moneyAmount) {
        Manage.fundRequest.put(userName, moneyAmount);
    }

    public static HashMap<String, Product> addProductRequest = new HashMap<>();// key : companyName , value : product
    public static HashMap<String, Product> getAddProductRequest() {
        return addProductRequest;
    }
    public static void setAddProductRequest(String companyName, Product product) {
        addProductRequest.put(companyName, product);
    }

    private static HashMap<String, ArrayList<String>> orderRequest = new HashMap<>();// key : userName , value : cart
    public static void setOrderRequest(String userName, ArrayList<String> cart) {
        orderRequest.put(userName, cart);
    }
    public static HashMap<String, ArrayList<String>> getOrderRequest() {
        return orderRequest;
    }

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
            writer.write((int)user.size());
            writer.write("\n");
            for (int i = 0; i < user.size(); i++) {
                writer.write(user.get(i).getUserName() + " " + user.get(i).getPassword() + " " + user.get(i).getEmail() + " " + user.get(i).getAddress() + " " + user.get(i).getNumber() + " ");
                writer.write(user.get(i).getWallet() + " " + user.get(i).getCart().size() + " ");
                for (int j = 0; j < user.get(i).getCart().size(); j++) {
                    writer.write((user.get(i).getCart().get(j) + " " ));
                }
                writer.write(user.get(i).getPurchaseHistory().size());
                for (int j = 0; j < user.get(i).getPurchaseHistory().size(); j++) {
                    writer.write(" " + user.get(i).getPurchaseHistory().get(j));
                }
                writer.write("\n");
            }

            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static boolean doesUserExist(String name, String password) {
        for (int i = 0; i < user.size(); i++) {
            if (user.get(i).getUserName().equals(name) && user.get(i).getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
    public static boolean doesUserExist(String name){
        return user.get(0).getUserName().equals(name);
    }
    public static void addUser(String name, String password, String email, String number, String address) {
        User newUser = new User(name, password, email, number , address);
        user.add(newUser);
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
                writer.write(seller.get(i).getCompanyName() + " " + seller.get(i).getPassword() + " ");
                writer.write(seller.get(i).getProductsName().size() + " " + seller.get(i).getProductsName() + " " + seller.get(i).getWallet());
                writer.write("\n");
            }

            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static boolean doesSellerExist(String name, String password) {
        for (int i = 0; i < seller.size(); i++) {
            if (seller.get(i).getCompanyName().equals(name) && seller.get(i).getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
    public static boolean doesSellerExist(String name) {
        return false;
    }
    public static void addSeller(String name, String password) {
        seller.add(new Seller(name, password));
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
                writer.write(admin.get(i).getName() + " " + admin.get(i).getPassword() + " " + admin.get(i).getEmail());
                writer.write("\n");
            }

            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static boolean doesAdminExist(String name, String password) {
        for (int i = 0; i < admin.size(); i++) {
            if (admin.get(i).getName().equals(name) && admin.get(i).getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
    public static boolean doesAdminExist(String name) {
        for (int i = 0; i < admin.size(); i++) {
            if (admin.get(i).getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
    public static void addAdmin(String name, String password, String email) {
        admin.add(new Admin(name, password, email));
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
                writer.write(product.get(i).getCategory() + " " + product.get(i).getSubCategory() + " " + product.get(i).getName() + " ");
                writer.write(product.get(i).getPrice() + " " + product.get(i).getNumber() + " " + product.get(i).getComment().size());
                writer.write("\n");
                for (int j = 0; j < product.get(i).getComment().size(); j++) {
                    writer.write(product.get(i).getComment().get(i) + "\n");
                }
            }

            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static int productNumber() {
        return product.size();
    }
    public static ArrayList<Product> productList() {
        return product;
    }
    public static int nameToPrice(String name) {
        for (int i = 0; i < product.size(); i++) {
            if (product.get(i).getName().equals(name)) {
                return product.get(i).getPrice();
            }
        }
        return -1;
    }
}
