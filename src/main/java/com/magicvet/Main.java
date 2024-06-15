package main.java.com.magicvet;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static String PASSWORD = "default";
    static Scanner SCANNER = new Scanner(System.in);

    static String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    static String NAME_PATTERN = "^[a-zA-Z-]{2,}$"; // Updated to require at least 3 characters

    public static void main(String[] args) {
        run();
    }

    static void run() {
        if (auth()) {
            registerNewClient();
        }
    }

    static boolean auth() {
        boolean accepted = false;
        for (int i = 0; i < 3; i++) {
            System.out.print("Password: ");
            String input = SCANNER.nextLine();

            if (PASSWORD.equals(input)) {
                accepted = true;
                break;
            } else {
                System.out.println("Access denied. Please check your password.");
            }
        }

        System.out.println(accepted ? "Welcome to the Magic Vet!" : "Application has been blocked.");
        return accepted;
    }

    static void registerNewClient() {
        System.out.println("Please provide client details.");
        System.out.print("Email: ");
        String email = SCANNER.nextLine();

        if (isEmailValid(email)) {
            Client client = buildClient(email);
            System.out.println("New client: " + client.firstName + " " + client.lastName + " (" + client.email + ")");
        } else {
            System.out.println("Provided email is invalid.");
        }
    }

    static Client buildClient(String email) {
        Client client = new Client();
        client.email = email;

        while (true) {
            try {
                System.out.print("First name: ");
                client.firstName = SCANNER.nextLine();
                validateName(client.firstName);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid first name: " + e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Last name: ");
                client.lastName = SCANNER.nextLine();
                validateName(client.lastName);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid last name: " + e.getMessage());
            }
        }

        return client;
    }

    static void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(name);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid name pattern. Name must contain at least 2 characters and only letters and hyphens.");
        }
    }

    static boolean isEmailValid(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
