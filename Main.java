package com.company;

 import  java.util.Scanner ;

  public class Main {

      public static void ifCase2(){

          Scanner getInput = new Scanner(System.in);
          System.out.println("________________________________________________");
          //Name Input 
          System.out.println("Enter the name of the customer :");
          String name = getInput.nextLine();
          name = name.replaceAll("\\s","");
          if( name.isEmpty()){
              System.err.println("Invalid name. Please try again!");
              return;

          }

          //Surname Input
          System.out.println("Enter the surname of the customer :") ;
          String surname = getInput.nextLine();
          surname = surname.replaceAll("\\s","");
          if( surname.isEmpty()){
              System.err.println("Invalid surname. Please try again!");
              return;
          }


          //E-mail Input
          System.out.println("Enter E-mail :");
          String Email = getInput.nextLine();
          Email = Email.replaceAll("\\s","");
          if(Email.isEmpty()){
              System.err.println("Invalid e-mail. Please try again!");
              return;
          }


          //Gender Input
          System.out.println("Enter Gender [M - F]");
          String Gender = getInput.nextLine();
          Gender = Gender.replaceAll("\\s","");
          if(Gender.toUpperCase().equals("MALE") || Gender.toUpperCase().equals("M")){
              Gender = "M";
          }
          else if(Gender.toUpperCase().equals("FEMALE") || Gender.toUpperCase().equals("F")){
              Gender = "F";

          }
          else{
              System.err.println("Invalid gender. Please try again!");
              return;

          }


          //Creating the object
          Operations.CreateCustomer(name,surname,Email,Gender);
      }

      public static void ifCase3(){
          System.out.println("Enter the ID of the customer :");
          Scanner getInput = new Scanner(System.in);
          int id = getInput.nextInt();
          if(Operations.checkAvailable(id)){
              System.err.println("A customer with this ID: "+ id +" does not exists!");
              return;
          }
          else{
              Operations.Delete(id);
          }
      }

      public static void ifCase4(){
          System.out.println("Enter the ID of the customer :");
          Scanner getInput = new Scanner(System.in);
          int id = getInput.nextInt();

         if(Operations.checkAvailable(id)){
             System.err.println("A customer with this ID: "+ id +" does not exists!");
             return;
         }
          else {

              System.out.println("Which information would you like to update :");
              System.out.println("Please choose your action [1-5]\n");
              System.out.println("1 - Name ");
              System.out.println("2 - Surname");
              System.out.println("3 - Email");
              System.out.println("4 - Gender");
              System.out.println("5 - Credit");

              int choice = getInput.nextInt();


              Scanner scanner2 = new Scanner(System.in);
              String new1;
              if (choice == 1) {

                  System.out.println("Enter the new name :");
                  new1 = scanner2.nextLine();
                  new1 = new1.replaceAll("\\s", "");
                  Operations.UpdateName(new1, id);


              } else if (choice == 2) {
                  System.out.println("Enter the new surname :");
                  new1 = scanner2.nextLine();
                  new1 = new1.replaceAll("\\s", "");
                  Operations.UpdateSurname(new1, id);


              } else if (choice == 3) {
                  System.out.println("Enter the new email :");
                  new1 = scanner2.nextLine();
                  new1 = new1.replaceAll("\\s", "");
                  Operations.UpdateEmail(new1, id);


              } else if (choice == 4) {
                  System.out.println("Enter the new gender :");
                  new1 = scanner2.nextLine();
                  new1 = new1.replaceAll("\\s", "");
                  if(new1.toUpperCase().equals("MALE") || new1.toUpperCase().equals("M")){
                      new1 = "M";
                  }
                  else if(new1.toUpperCase().equals("FEMALE") || new1.toUpperCase().equals("F")){
                      new1 = "F";

                  }
                  else{
                      System.err.println("Invalid gender. Please try again!");
                      return;

                  }
                  Operations.UpdateGender(new1, id);

              } else if (choice == 5) {
                  System.out.println("Enter the new credit :");
                  double new2 = scanner2.nextDouble();
                  if(new2 < 0) {
                      System.err.println("Customers cannot have a negative balance!");
                  }
                  else{
                      Operations.UpdateCredit(new2, id);
                  }



              } else {
                  System.err.println("Invalid number. Please try again!");
              }
          }
      }

      public static void ifCase5(){
          System.out.println("Enter the ID of the customer :");
          Scanner getInput = new Scanner(System.in);
          int id = getInput.nextInt();
          if(Operations.checkAvailable(id)){
              System.err.println("A customer with this ID: "+ id +" does not exists!");
              return;
          }
          else {
              System.out.println("How much would you like to withdraw :");
              double reduceMoney = getInput.nextDouble();
              if(reduceMoney < 0){
                  System.err.println("You cannot withdraw a negative amount!");
              }
              Operations.CreditReduce(reduceMoney, id);
          }
      }

      public static void ifCase6(){
          System.out.println("Enter the ID of the customer :");
          Scanner getInput = new Scanner(System.in);
          int id = getInput.nextInt();
          if(Operations.checkAvailable(id)){
              System.err.println("A customer with this ID: "+ id +" does not exists!");
              return;
          }
          else {
              System.out.println("How much would you like to deposit :");
              double addMoney = getInput.nextDouble();
              Operations.CreditAdd(addMoney, id);
          }
      }

      public static void ifCase7(){
          System.out.println("What would you like to search with");
          System.out.println("Please choose your action[1-6]\n");
          System.out.println("1 - Name ");
          System.out.println("2 - Surname");
          System.out.println("3 - Email");
          System.out.println("4 - Gender");
          System.out.println("5 - Credit");
          System.out.println("6 - ID");
          Scanner getInput = new Scanner(System.in);
          int choice = getInput.nextInt();
          Scanner getInput2 = new Scanner(System.in);
          if (choice == 1) {
              System.out.println("Enter the name you want to search for :");
              String searchValue = getInput2.nextLine();
              searchValue = searchValue.replaceAll("\\s", "");
              Operations.FindCustomer("name", searchValue);
          } else if (choice == 2) {
              System.out.println("Enter the surname you want to search for :");
              String searchValue = getInput2.nextLine();
              searchValue = searchValue.replaceAll("\\s", "");
              Operations.FindCustomer("surname", searchValue);
          } else if (choice == 3) {
              System.out.println("Enter the email you want to search for :");
              String searchValue = getInput2.nextLine();
              searchValue = searchValue.replaceAll("\\s", "");
              Operations.FindCustomer("email", searchValue);
          } else if (choice == 4) {
              System.out.println("Enter the gender you want to search for [ M - F ]");
              String searchValue = getInput2.nextLine();
              searchValue = searchValue.replaceAll("\\s", "");
              Operations.FindCustomer("gender", searchValue);
          } else if (choice == 5) {
              System.out.println("Enter the credit value you want to search for :");
              double searchValue = getInput2.nextDouble();
              Operations.FindCustomer(searchValue);
          }
          else if( choice == 6){
              System.out.println("Enter the ID you want to search for :");
              int searchValue = getInput2.nextInt();
              Operations.FindCustomer(searchValue);
          }
          else {
              System.out.println("Invalid number. Please try again!");
          }
      }


      public static void MainScreen() {
          try{
          System.out.println("Please choose your action [1-9]\n");
          System.out.println("1 - List customers");
          System.out.println("2 - Add a new customer");
          System.out.println("3 - Remove a customer");
          System.out.println("4 - Update a customer");
          System.out.println("5 - Withdraw money from a customer");
          System.out.println("6 - Deposit money to a customer");
          System.out.println("7 - Find a customer");
          System.out.println("9 - Quit");

          Scanner scanner = new Scanner(System.in);
          int choice = scanner.nextInt();
          if (choice <= 9 && choice >= 1) {

              switch (choice) {
                  case 1:
                      Operations.List();
                      break;
                  case 2:
                      try {
                          ifCase2();
                          break;
                      } catch (Exception e) {
                          System.err.println("Error at creating a customer!");
                          System.err.println(e);
                          break;
                      }

                  case 3:

                      try {
                          ifCase3();
                          break;

                      } catch (Exception e) {
                          System.err.println(e);
                          break;
                      }

                  case 4:
                      try {
                          ifCase4();
                          break;

                      } catch (Exception e) {
                          System.err.println(e);
                          break;
                      }

                  case 5:
                      try {
                          ifCase5();
                          break;

                      } catch (Exception e) {
                          System.err.println(e);
                          break;
                      }

                  case 6:
                      try {
                          ifCase6();
                          break;

                      } catch (Exception e) {
                          System.err.println(e);
                          break;
                      }

                  case 7:
                      try {
                          ifCase7();
                          break;
                      } catch (Exception e) {
                          System.err.println(e);
                          break;
                      }
                  case 8:
                      break;

                  case 9:
                      System.exit(0);


              }
          }
          else{
              System.err.println("Please enter a number between [ 1 - 9 ]");
          }

      }

      catch(Exception e){
          System.err.println("Invalid number. Please try again!");
      }

      }


      public static void main(String args[])

      {
          System.out.println("___________________________________") ;
          System.out.println("WELCOME TO THE BANK SIMULATOR V1.1") ;
          System.out.println("___________________________________\n\n");

          while(true)
          {
              MainScreen() ;
          }
      }
  }
