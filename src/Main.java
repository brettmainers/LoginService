import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
    
        Scanner input = new Scanner(System.in);
        HashMap<String,String> loginCreds = new HashMap<>();
        loginCreds.put("Jerry", "iloveicecream");
        loginCreds.put("Naomi", "chocolatechips");
        loginCreds.put("Jas", "DrPepper");
        loginCreds.put("brettmainers", "haloreach");

        System.out.println("Login to view your heap!");
        System.out.println("If you don't have an existing account, you can create one.");
        System.out.println("Enter '1' to login.");
        System.out.println("Enter '2' to create an account.");
        int selection = input.nextInt();
        boolean userSuccess = false;
        boolean loginSuccess = false;

        if (selection == 1) {
            System.out.print("Please enter your username: ");
            String username = input.nextLine();
        
            if (loginCreds.containsKey(username)) {
                userSuccess = true;
                System.out.print("\n Enter your password: ");
            } else {
                System.out.println("Username not found. Please try again or create a new account.");
            }
                while (!loginSuccess) {
                    String password = input.nextLine();
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
}