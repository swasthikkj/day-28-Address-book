package com.addressbook;
import java.util.*;
public class AddressBook{
    String bookName;
    int index = 0;
    static Scanner sc = new Scanner(System.in);
    ArrayList<Contact> entry = new ArrayList<>();
    AddressBook(String name){
        this.bookName = name;
    }
    public AddressBook(String bookName, ArrayList<Contact> entry) {
        this.bookName = bookName;
        this.entry = entry;
    }
    void setContact(){
        Contact person = new Contact(index);
        System.out.print("Enter First Name: ");
        person.setFirstName(sc.next());
        System.out.print("Enter Last Name: ");
        person.setLastName(sc.next());
        System.out.print("Enter Address: ");
        person.setAddress(sc.next());
        System.out.print("Enter City: ");
        person.setCity(sc.next());
        System.out.print("Enter State: ");
        person.setState(sc.next());
        System.out.print("Enter Zip Code: ");
        person.setZip(sc.next());
        System.out.print("Enter Phone Number: ");
        person.setPhoneNumber(sc.next());
        System.out.print("Enter E-Mail: ");
        person.seteMail(sc.next());
        System.out.println("\n");
        entry.add(person);
        System.out.println("Person Added!");
        index ++;
        }
    void editContact(){
        System.out.println("Enter the contact's First Name to be edited: ");
        String firstName = sc.next();
        boolean check = true;
        for (Contact person : entry){
            if(Objects.equals(person.getFirstName(), firstName)){
                System.out.println("Enter First Name: ");
                person.setFirstName(sc.nextLine());
                System.out.println("Enter Last Name: ");
                person.setLastName(sc.nextLine());
                System.out.println("Enter Address: ");
                person.setAddress(sc.nextLine());
                System.out.println("Enter City: ");
                person.setCity(sc.nextLine());
                System.out.println("Enter State: ");
                person.setState(sc.nextLine());
                System.out.println("Enter Zip Code: ");
                person.setZip(sc.nextLine());
                System.out.println("Enter Phone Number: ");
                person.setPhoneNumber(sc.nextLine());
                System.out.println("Enter E-Mail: ");
                person.seteMail(sc.nextLine());
                System.out.print("Enter First Name: ");
                person.setFirstName(sc.next());
                System.out.print("Enter Last Name: ");
                person.setLastName(sc.next());
                System.out.print("Enter Address: ");
                person.setAddress(sc.next());
                System.out.print("Enter City: ");
                person.setCity(sc.next());
                System.out.print("Enter State: ");
                person.setState(sc.next());
                System.out.print("Enter Zip Code: ");
                person.setZip(sc.next());
                System.out.print("Enter Phone Number: ");
                person.setPhoneNumber(sc.next());
                System.out.print("Enter E-Mail: ");
                person.seteMail(sc.next());
                System.out.println("\n");
                entry.set(entry.indexOf(person), person);
                System.out.println("Contact has been updated!");
                check = false;
                break;
            }
        }
        if(check){
            System.out.println("The Contact doesn't Exist.");
        }
    }
    void getContact(){
        for (Contact e: entry) {
            System.out.println("ID: " + e.id);
            System.out.println("First Name: " + e.firstName);
            System.out.println("Last Name: " + e.lastName);
            System.out.println("Address: " + e.address);
            System.out.println("City: " + e.city);
            System.out.println("State: " + e.state);
            System.out.println("Zip: " + e.zip);
            System.out.println("Phone Number: " + e.phoneNumber);
            System.out.println("E-Mail: " + e.eMail + "\n");
        }
    }
    void deleteContact(){
        System.out.println("Enter contact's  first name to be deleted: ");
        String name = sc.nextLine();
        boolean check = true;
        for (Contact person : entry) {
            if (Objects.equals(person.getFirstName(), name)) {
                entry.remove(person);
                System.out.println("Entry Removed! \n");
                check = false;
                break;
            }
        }
        if (check){
            System.out.println("No Such Entry Exists.");
        }
    }
    void bookNavigator() {
//        addContact();
        boolean toggle = true;
        while (toggle) {
            System.out.println("Current Book: " + this.bookName + "\n");
            System.out.println("""
                    1 -> Create Contact
                    2 -> Display Contacts
                    3 -> Sort Contacts
                    4 -> Edit Contacts
                    5 -> Delete Contact
                    0 -> Exit to Main Address Book
                    """);
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            System.out.println("============================= \n");
            switch (choice) {
                case 1 -> {
                    setContact();
                    System.out.println("============================= \n");
                }
                case 2 -> {
                    getContact();
                    System.out.println("============================= \n");
                }
                case 3 ->{
                    int option = sortMenu();
                    handleSortChoice(option);
                }
                case 4 -> {
                    editContact();
                    System.out.println("============================= \n");
                }
                case 5 -> {
                    deleteContact();
                    System.out.println("============================= \n");
                }
                case 0 -> {
                    System.out.println("Address Book Closed. \n");
                    toggle = false;
                }
                default -> {
                    System.out.println("Enter Correct choice.");
                    System.out.println("============================= \n");
                }
            }
        }
    }
    int sortMenu(){
        System.out.println("""
                Sort by:
                1 -> Alphabet
                2 -> City
                3 -> State
                4 -> Zip
                """);
        System.out.print("Choice: ");
        return sc.nextInt();
    }
    void handleSortChoice(int option){
        switch (option){
            case 1 -> {
                List<Contact> sorted = entry.stream()
                        .sorted(Comparator.comparing(Contact::getFirstName))
                        .toList();
                sorted.forEach(people -> System.out.println(people + "\n"));
            }
            case 2 -> {
                List<Contact> sorted = entry.stream()
                        .sorted(Comparator.comparing(Contact::getCity))
                        .toList();
                sorted.forEach(people -> System.out.println(people + "\n"));
            }
            case 3 -> {
                List<Contact> sorted = entry.stream()
                        .sorted(Comparator.comparing(Contact::getState))
                        .toList();
                sorted.forEach(people -> System.out.println(people + "\n"));
            }
            case 4 -> {
                List<Contact> sorted = entry.stream()
                        .sorted(Comparator.comparing(Contact::getZip))
                        .toList();
                sorted.forEach(people -> System.out.println(people + "\n"));
            }
        }
    }
    void addContact(){
        Contact obj1 = new Contact(1, "Amet", "Vikram", "SLC", "Bhopal", "MP", "462022", "1234", "abc@gmail.com");
        Contact obj2 = new Contact(2, "Aashu", "Kumar", "BD", "Jaipur", "Rajasthan", "462025", "5678", "def@gmail.com");
        Contact obj3 = new Contact(3, "Arin", "Verma", "CB", "Bhopal", "MP", "462052", "3245", "ghi@gmail.com");
        Contact obj4 = new Contact(4, "Manju", "Verma", "TP", "Mumbai", "Maharastra", "467077", "1245", "asd@gmail.com");
        Contact obj5 = new Contact(5, "Jtmayay", "Mkpdh", "WF", "BLR", "Karnataka", "123416", "6969", "bal@gmail.com");
        Contact obj6 = new Contact(6, "James", "Bond", "KRMLA", "BLR", "Karnataka", "420696", "4201", "bad@gmail.com");
        entry.add(obj1);
        entry.add(obj2);
        entry.add(obj3);
        entry.add(obj4);
        entry.add(obj5);
        entry.add(obj6);
    }
}