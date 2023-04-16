package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class User {
    public static boolean doesUserExist(String name, String password){
        try {
            File file = new File("UserLogin.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNext()) {
                String readName = reader.next();
                String readPassword = reader.next();
                if (name.equals(readName) && password.equals(readPassword)) {
                    reader.close();
                    return true;
                }
            }
            reader.close();
            return false;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
