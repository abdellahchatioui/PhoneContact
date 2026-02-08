package Models;

import Utils.Input;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Person {

    String fullname;
    String number;
    HashMap<String, String> contacts = new HashMap<String,String>();
    HashMap<String, String> SentMessages = new HashMap<String,String>();
    HashMap<String, String> receivedMessages = new HashMap<String,String>();


    public Person(String fullname, String number, HashMap<String, String> contacts,
                  HashMap<String, String> sendMessages,HashMap<String, String> receivedMessages) {
        this.fullname = fullname;
        this.number = number;
        this.contacts = new HashMap<>(contacts);
        this.SentMessages = new HashMap<>(sendMessages);
        this.receivedMessages = new HashMap<>(receivedMessages);
    }

    // Utilities
    private static <K, V> K getKeyByValue(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (Objects.equals(entry.getValue(), value)) {
                return entry.getKey();
            }
        }
        return null; // Return null if the value is not found
    }
    // Messages Methods
    public void showReceivedMessages(){
        int i = 1;
        for(String from : this.getReceivedMessages().keySet()){
            System.out.println(i++ + ") " + from  + " : " + this.getReceivedMessages().get(from) );
        }
    }
    public void showSentMessages(){
        int i = 1;
        for(String to : this.getSentMessages().keySet()){
            System.out.println(i++ + ") " + to  + " : " + this.getSentMessages().get(to) );
        }
    }
    public void sendMessage(){
        showAllContact();
        String to = Input.readString("Enter contact : ");
        while (!(getContacts().containsKey(to) || getContacts().containsValue(to))){
            System.out.println("Account doesn't Exist !");
            to = Input.readString("Enter contact : ");
        }
        if (getContacts().containsValue(to)) {
            to = getKeyByValue(getContacts(), to);
        }
        String message = Input.readString("Enter Message : ");
        System.out.println("Message sent successfully to " + to);
        getSentMessages().put(to,message);
    }
    // Contacts Methods
    public void showAllContact(){
        int i = 1;
        for(String contact : this.getContacts().keySet()){
            System.out.println(i++ + ") " + contact + " : " + this.getContacts().get(contact));
        }
    }
    public void addNewContact(){
        String newFullName = Input.readString("Enter the new contact : ");
        String newNumber = Input.readString("Enter the new number : ");
        try {
            contacts.put(newFullName,newNumber);
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        System.out.println(newFullName + " added successfully." );
    }
    public void searchContact(){
        String contact = Input.readString("Enter contact : ");
            for (Map.Entry<String,String> entry : contacts.entrySet()){
                if (entry.getValue().equals(contact)) {
                    System.out.println("Contact name : " + entry.getKey());
                    break;
                } else if (entry.getKey().equals(contact)) {
                    System.out.println("Contact number : " + entry.getValue());
                    break;
                }
            }
        System.out.println("Contact doesn't exist.");
    }
    public void deleteContact(){
        String contact = Input.readString("Enter contact : ");
        String removed = contacts.remove(contact);
        if(removed == null){
            System.out.println("Contact doesn't exist.");
        } else {
            System.out.println("Contact deleted: " + removed);
        }
    }

    // Getters And Setters
    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    public HashMap<String, String> getContacts() {
        return contacts;
    }
    public void setContacts(HashMap<String, String> contacts) {
        this.contacts = contacts;
    }

    public HashMap<String, String> getSentMessages() {
        return SentMessages;
    }
    public void setSentMessages(HashMap<String, String> sentMessages) {
        this.SentMessages = sentMessages;
    }

    public void setReceivedMessages(HashMap<String, String> receivedMessages) {
        this.receivedMessages = receivedMessages;
    }
    public HashMap<String, String> getReceivedMessages() {
        return receivedMessages;
    }




}

