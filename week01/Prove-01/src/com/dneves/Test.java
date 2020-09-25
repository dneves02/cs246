package com.dneves;

import java.util.Scanner;

public class Test {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter password: ");
        String password =scanner.nextLine();
        User user = new User(password);

        try{
            System.out.print("Password before hashUserPassword: " + user.getPassword());
            System.out.print("Salt before hashUserPassword: " + user.getSalt());
            System.out.print("Salt before hashUserPassword: " + user.getHashedPassword());

            NSALoginController.hashUserPassword(user);

            System.out.print("Password after hashUserPassword: " + user.getPassword());
            System.out.print("Salt after hashUserPassword: " + user.getSalt());
            System.out.print("Salt after hashUserPassword: " + user.getHashedPassword());

            System.out.print("Let's see if the password match...\n");
            System.out.print("Enter your password again: ");
            password = scanner.nextLine();

            user.setPassword(password);

            if (NSALoginController.verifyPassword(user)) {
                System.out.println("Passwords match!");
            }
            else{
                System.out.println("ERROR: Passwords do not match!");
            }
        }

        catch (WeakPasswordException e) {
            System.out.println("Weak Password Error: " + e.getMessage());
        }
        catch (Exception ex) {
            System.out.println("ERROR" + ex.getMessage());
        }

        //System.out.print(password);

    }
}