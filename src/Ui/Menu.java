package Ui;

import Models.Person;
import Utils.Input;
import java.security.PublicKey;

public class Menu {
    public static Person person;
    public static void showMainMenu(Person p) {
        person = p;
        while (true) {
            System.out.println("-----Menu-----");
            System.out.println("\t1. Manege contacts");
            System.out.println("\t2. Messages");
            System.out.println("\t3. Quit");
            int choice = Input.readInt("Choose: ", 1, 3);
            switch (choice) {
                case 1: showManegeContact();break;
                case 2: showMessages();break;
                case 3: {
                    System.out.println("Goodbye!");
                    System.exit(0);
                }
            }
        }
    }
    public static void showManegeContact(){
        while (true){
            System.out.println("-----Manege contacts-----");
            System.out.println("\t1. Show all contacts");
            System.out.println("\t2. Add a new contact");
            System.out.println("\t3. Search for a contact");
            System.out.println("\t4. Delete a contact");
            System.out.println("\t5. Back");
            int choice = Input.readInt("Choose: ", 1, 5);

            switch (choice) {
                case 1: person.showAllContact();break;
                case 2: person.addNewContact();break;
                case 3: person.searchContact();break;
                case 4: person.deleteContact();break;
                case 5: showMainMenu(person);
            }
        }
    }
    public static void showMessages(){
        while (true){
            System.out.println("-----Messages-----");
            System.out.println("\t1. See received messages");
            System.out.println("\t2. See sent messages");
            System.out.println("\t3. Send a new message");
            System.out.println("\t4. Back");
            int choice = Input.readInt("Choose: ", 1, 4);
            switch (choice) {
                case 1: person.showReceivedMessages();break;
                case 2: person.showSentMessages();break;
                case 3: person.sendMessage();break;
                case 4: showMainMenu(person);
            }
        }
    }

}
