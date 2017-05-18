package com.company;


import java.util.ArrayList;

public class Customer {

    public static ArrayList<Customer> customers = new ArrayList<>();
    private String Name  ;
    private String Surname  ;
    private int ID ;
    private String Email ;
    private String Gender ;
    private double Credit ;

    public Customer(String Name, String Surname , String Email , String Gender ,double Credit, int ID ){

         this.Name = Name ;
         this.Surname = Surname ;
         this.Email = Email ;
         this.Gender = Gender ;
         this.Credit = Credit ;
         this.ID = ID;



    }



    public String getName() {
        return Name;
    }

    public String getSurname() {
        return Surname;
    }

    public int getID() {
        return ID;
    }

    public String getEmail() {
        return Email;
    }

    public String getGender() {
        return Gender;
    }

    public double getCredit() {
        return Credit;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public void setCredit(double credit)  {
        Credit = credit;
    }
}
