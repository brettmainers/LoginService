import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
    
        Scanner input = new Scanner(System.in);
        HashMap<String,String> loginCreds = new HashMap<>();
        loginCreds.put("Jerry", "iloveicecream");
        loginCreds.put("Naomi", "chocolatechips");
        loginCreds.put("Jas", "DrPepper");
        loginCreds.put("brettmainers", "cheetos");

        System.out.println("Login to view your heap!");
        System.out.println("If you don't have an existing account, you can create one.");
        System.out.println("Enter '1' to login.");
        System.out.println("Enter '2' to create a new account.");
        String selection = input.nextLine();
        boolean userSuccess = false;
        boolean loginSuccess = false;
        String username = "";

        if (selection.equals("1")) {
            System.out.print("Please enter your username: ");
            username = input.nextLine();
            
            while (!userSuccess) {
            if (loginCreds.containsKey(username)) {
                userSuccess = true;
            } else {
                System.out.println("Username not found. Please try again or press '2' to create a new account.");
                username = input.nextLine();
                if (username.equals("2")) {
                    selection = "2";
                    break;
                }
            } 
        }
        }
        if (selection.equals("2")) {
            System.out.print("Please enter a new username: ");
            username = input.nextLine();
            while (loginCreds.containsKey(username)) {
                System.out.println("Username already exists, please select a different username.");
                username = input.nextLine();
            }

            System.out.print("Please enter a new password: ");
            String newPass = input.nextLine();
            loginCreds.put(username, newPass);
            System.out.println("Account created successfully! Please login to view your heap.");
        }
        System.out.print("\nEnter your password: ");
        String password = input.nextLine();

            while (!loginSuccess) {
                if (loginCreds.get(username).equals(password)) {
                System.out.println("Login successful!");
                loginSuccess = true;
                } else {
                    System.out.println("Incorrect password. Please try again.");
                    password = input.nextLine();
                }
        }


        
    }
}