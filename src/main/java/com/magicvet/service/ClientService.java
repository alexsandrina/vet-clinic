package main.java.com.magicvet.service;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Client;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientService {

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static  String NAME_PATTERN = "^[a-zA-Z-]{2,}$";



    public Optional<Client> registerNewClient() {
        Client client = null;


        System.out.println("Please provide client details.");
        System.out.print("Email: ");
        String email = Main.SCANNER.nextLine();

        if (isEmailValid(email)) {
            client = buildClient(email);
            System.out.println("New client: " + client.getFirstName() + " "
                    + client.getLastName() + " (" + client.getEmail() + ")");
        } else {
            System.out.println("Provided email is invalid.");

        }

        return Optional.ofNullable(client);
    }
    private static Client buildClient(String email) {
        Client client = new Client();
        client.setEmail(email);

        while (true) {
            try {
                System.out.print("First name: ");
                client.setFirstName(Main.SCANNER.nextLine());
                validateName(client.getFirstName());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid first name: " + e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Last name: ");
                client.setLastName(Main.SCANNER.nextLine());
                validateName(client.getLastName());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid last name: " + e.getMessage());
            }
        }
        System.out.println("Location: ");
        Client.Location location;
        String locationInput = Main.SCANNER.nextLine();
        try {
            location = Client.Location.valueOf(locationInput);

        } catch (IllegalArgumentException e) {
            location = Client.Location.UKNOWN;
            System.out.println("Unable to parse value '" + locationInput
                    + "'. Using default value: " + Client.Location.UKNOWN);

        }
        client.setLocation(location);
        return client;
    }

    private static void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(name);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid name pattern. Name must contain at least 2 characters and only letters and hyphens.");
        }
    }

    private static boolean isEmailValid(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}



