package com.company;


import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Operations {

    static void CreateCustomer(String Name, String Surname, String Email, String Gender) {

        int ID;
        Random rand = new Random();
        int randomNumber;

        while (true){
        randomNumber = rand.nextInt(9999) + 1000;
        if (checkAvailable(randomNumber)) {
            ID = randomNumber;
            break;
        }

    }
        Customer.customers.add(new Customer(Name, Surname, Email, Gender, 0, ID));
        System.out.println("New customer with the ID : " + ID + " has been added.");

    }

    static boolean checkAvailable(int ID) {
        Iterator<Customer> it = Customer.customers.iterator();
        boolean isAvailable = true;
        while (it.hasNext()) {
            Customer customers = it.next();

            if (ID == customers.getID()) {
                isAvailable = false;
            }
        }

        return isAvailable;

    }



    static void Delete(int ID) {
        Iterator<Customer> it = Customer.customers.iterator();
        while (it.hasNext()) {
            Customer customers = it.next();
            if (customers.getID() == ID) {
                FindCustomer(ID);
                System.out.println("Customer with the information above will be deleted. Do you confirm? [ Y - N ]");
                Scanner getInput = new Scanner(System.in);
                String choice = getInput.nextLine();
                choice = choice.replaceAll("\\s","");
                if(choice.toUpperCase().equals("Y") || choice.toUpperCase().equals("YES")){
                    it.remove();
                    System.out.println("Customer with the ID: "+ ID + " has been deleted.");
                }
                else if(choice.toUpperCase().equals("N") || choice.toUpperCase().equals("NO")){
                    System.out.println("Operation cancelled.");
                }
                else{
                    System.err.println("Invalid number. Please try again!");
                }

            }
        }


    }

    static void postHeader(){
        String[] headLine = {"ID", "NAME", "SURNAME", "E-MAIL", "GENDER", "CREDIT"};
        System.out.printf(" %25s %30s %30s %30s %30s %30s\n", headLine);
        System.out.printf("_________________________________________________________________________________________________" +
                "_____________________________________________________________________________________________________\n");
    }

    static void List() {
        if(Customer.customers.isEmpty()){
            System.err.println("There are not any customer currently registered!");
        }
        else {
            postHeader();
            Iterator<Customer> it = Customer.customers.iterator();
            while (it.hasNext()) {
                Customer customers = it.next();
                String[] inside = {String.valueOf(customers.getID()), customers.getName(), customers.getSurname(), customers.getEmail(), customers.getGender(), String.valueOf(customers.getCredit())};
                System.out.printf(" %25s %30s %30s %30s %30s %30s\n", inside);
            }
        }
    }

    static void UpdateName(String Name, int ID) {
        Iterator<Customer> it = Customer.customers.iterator();
        while (it.hasNext()) {
            Customer customers = it.next();
            if (customers.getID() == ID) {
                customers.setName(Name);
            }

        }
    }

    static void UpdateSurname(String Surname , int ID) {

        Iterator<Customer> it = Customer.customers.iterator();
        while (it.hasNext()) {
            Customer customers = it.next();
            if (customers.getID() == ID) {
                customers.setSurname(Surname);

            }

        }


    }

    static void UpdateEmail(String Email, int ID) {
        Iterator<Customer> it = Customer.customers.iterator();
        while (it.hasNext()) {
            Customer customers = it.next();
            if (customers.getID() == ID) {
                customers.setEmail(Email);
            }

        }
    }

    static void UpdateGender(String Gender, int ID) {
        Iterator<Customer> it = Customer.customers.iterator();
        while (it.hasNext()) {
            Customer customers = it.next();
            if (customers.getID() == ID) {
                customers.setGender(Gender);
            }

        }
    }

    static void UpdateCredit(double Credit, int ID) {
        Iterator<Customer> it = Customer.customers.iterator();
        while (it.hasNext()) {
            Customer customers = it.next();
            if (customers.getID() == ID) {
                customers.setCredit(Credit);
            }

        }
    }

    static void CreditAdd(double Credit, int ID) {
        if(Credit < 0){
            System.err.println("You cannot add a negative credit. Try withdrawing credit.");
        }
        else {
            Iterator<Customer> it = Customer.customers.iterator();
            while (it.hasNext()) {
                Customer customers = it.next();
                if (customers.getID() == ID) {
                    customers.setCredit(customers.getCredit() + Credit);
                    System.out.println("Credit added!");
                }


            }
        }

    }

    static void CreditReduce(double Credit, int ID) {
        Iterator<Customer> it = Customer.customers.iterator();
        while (it.hasNext()) {
            Customer customers = it.next();
            if (customers.getID() == ID) {
                if(customers.getCredit() < Credit){
                    System.err.println("You do not have enough money. Current balance : "+ customers.getCredit());
                }
                else if(customers.getCredit() <= 0){
                    System.err.println("You do not have any money. Current balance : "+ customers.getCredit());
                }
                else {
                    customers.setCredit(customers.getCredit() - Credit);
                    System.out.println("Credit reduced!");
                }

            }

        }

    }



    static void FindCustomer(String by, String input){
        boolean check = false;
        if( by.equals("name")){
            postHeader();
            Iterator<Customer> it = Customer.customers.iterator();
            while (it.hasNext()) {
                Customer customers = it.next();
                String customerName = customers.getName().replaceAll("\\s","").toUpperCase();
                if (customerName.equals(input.toUpperCase())) {

                    String[] inside2 = {String.valueOf(customers.getID()),customers.getName(),customers.getSurname(),customers.getEmail(),customers.getGender(),String.valueOf(customers.getCredit())};

                    System.out.printf(" %25s %30s %30s %30s %30s %30s\n", inside2);
                    check = true;
                }


            }

            if(!check){
                System.err.println("Could not find any customer with this name : "+input);
            }
        }
        else if(by.equals("surname")){
            postHeader();
            Iterator<Customer> it = Customer.customers.iterator();
            while (it.hasNext()) {
                Customer customers = it.next();
                String customerSurname = customers.getSurname().replaceAll("\\s","").toUpperCase();
                if (customerSurname.equals(input.toUpperCase())) {

                    String[] inside2 = {String.valueOf(customers.getID()), customers.getName(), customers.getSurname(), customers.getEmail(), customers.getGender(), String.valueOf(customers.getCredit())};

                    System.out.printf(" %25s %30s %30s %30s %30s %30s\n", inside2);
                    check = true;
                }
            }
            if(!check){
                System.err.println("Could not find any customer with this surname : "+input);
            }
        }
        else if(by.equals("email")){
            postHeader();
            Iterator<Customer> it = Customer.customers.iterator();
            while (it.hasNext()) {
                Customer customers = it.next();
                String customerMail = customers.getEmail().replaceAll("\\s","").toUpperCase();
                if (customerMail.equals(input.toUpperCase())) {

                    String[] inside2 = {String.valueOf(customers.getID()), customers.getName(), customers.getSurname(), customers.getEmail(), customers.getGender(), String.valueOf(customers.getCredit())};

                    System.out.printf(" %25s %30s %30s %30s %30s %30s\n", inside2);
                    check = true;
                }
            }
            if(!check){
                System.err.println("Could not find any customer with this email : "+input);
            }
        }
        else if(by.equals("gender")){
            postHeader();
            Iterator<Customer> it = Customer.customers.iterator();
            while (it.hasNext()) {
                Customer customers = it.next();
                String customerGender = customers.getGender().replaceAll("\\s","").toUpperCase();
                if (customerGender.equals(input.toUpperCase())) {

                    String[] inside2 = {String.valueOf(customers.getID()), customers.getName(), customers.getSurname(), customers.getEmail(), customers.getGender(), String.valueOf(customers.getCredit())};

                    System.out.printf(" %25s %30s %30s %30s %30s %30s\n", inside2);
                    check = true;
                }
            }
            if(!check){
                System.err.println("Could not find any customer with this gender : "+input);
            }
        }
        else{
            System.err.println("Invalid input. Please try again.");
        }
    }

    static void FindCustomer(double input) {
        boolean check = false;
        Scanner scan = new Scanner(System.in);
        System.out.println("Would you like to search for customers with Higher or Lower credit than "+ input +"  [H - L]");
        String choice = scan.nextLine();
        choice =  choice.replaceAll("\\s","").toUpperCase();
        if(choice.equals("HIGHER") || choice.equals("H") || choice.equals("HIGH")){

            postHeader();
            Iterator<Customer> it = Customer.customers.iterator();
            while (it.hasNext()) {
                Customer customers = it.next();

                if ( customers.getCredit() >= input) {

                    String[] inside2 = {String.valueOf(customers.getID()), customers.getName(), customers.getSurname(), customers.getEmail(), customers.getGender(), String.valueOf(customers.getCredit())};

                    System.out.printf(" %25s %30s %30s %30s %30s %30s\n", inside2);
                    check = true;

                }
            }

            if(!check){
                System.err.println("Could not find any customer who has a higher credit than  : "+input);
            }

        }
        else if(choice.equals("LOWER") || choice.equals("L") || choice.equals("LOW")){

            postHeader();
            Iterator<Customer> it = Customer.customers.iterator();
            while (it.hasNext()) {
                Customer customers = it.next();

                if ( customers.getCredit() <= input) {

                    String[] inside2 = {String.valueOf(customers.getID()), customers.getName(), customers.getSurname(), customers.getEmail(), customers.getGender(), String.valueOf(customers.getCredit())};

                    System.out.printf(" %25s %30s %30s %30s %30s %30s\n", inside2);
                    check = true;

                }
            }

            if(!check){
                System.err.println("Could not find any customer who has a lower credit than  : "+input);
            }
        }
        else{
            System.err.println("Invalid number. Please try again!");
        }






    }

    static void FindCustomer(int input){
            if(checkAvailable(input)){
                System.err.println("Could not find any customer with this ID : "+input);
            }
            else{
                postHeader();
                Iterator<Customer> it = Customer.customers.iterator();
                while (it.hasNext()) {
                    Customer customers = it.next();
                    if (customers.getID() == input) {

                        String[] inside2 = {String.valueOf(customers.getID()), customers.getName(), customers.getSurname(), customers.getEmail(), customers.getGender(), String.valueOf(customers.getCredit())};

                        System.out.printf(" %25s %30s %30s %30s %30s %30s\n", inside2);

                    }
                }
            }



    }


}


