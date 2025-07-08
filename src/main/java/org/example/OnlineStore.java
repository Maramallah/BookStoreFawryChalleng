package org.example;

import java.util.*;

public class OnlineStore {
   private static Map<String, Book> Store=new HashMap<>(); ;
  static Scanner input = new Scanner(System.in);

  /*
  Add a book to the inventory with some details like ISBN(just any string identifier), title, year when the book is published, price
   */
    public  static void StartStore(){
        int choice=0;
        do{
            System.out.println("1- Add new Book");
            System.out.println("2- Remove Outdated Books");
            System.out.println("3- Buy Book");
            System.out.println("4- Exit");
            System.out.print(" Enter Your Choice : ");
            choice= input.nextInt();

            switch (choice){
                case 1:
                    int booktype;
                    System.out.print("what is the type of book you want to add: 1- PaperBook 2- Ebook 3-ShowCase Book : ");
                    booktype=input.nextInt();
                    while (booktype<1 || booktype>3){
                        System.out.println("Wrong book type number please enter again : ");
                        System.out.print("what is the type of book you want to add: 1- PaperBook 2- Ebook 3-ShowCase Book : ");
                        booktype=input.nextInt();
                    }
                    Book Booktoadd=Bookinfo(booktype);
                    Store.put(Booktoadd.getISBN(),Booktoadd);
                    break;
                case 2:
                    RemoveOutDatedBooks();
                    break;
                case 3:
                    BuyBookFromStore();
                    break;
                default:
                    System.out.println("Invalid Input Please Enter choice");
                    System.out.println();
            }

        }while (choice!=4);
        System.out.println("Thanks For Using out store");
        System.out.println();
    }
      private static void RemoveOutDatedBooks(){
          Iterator<Map.Entry<String, Book>> iterator = Store.entrySet().iterator();
          int removedCount = 0;

          while (iterator.hasNext()) {
              Map.Entry<String, Book> entry = iterator.next();
              if (entry.getValue().isOutdated()) {
                  iterator.remove();
                  removedCount++;
              }
          }

          System.out.println( + removedCount + " outdated books removed successfully");
          System.out.println();
      }

      private static Book Bookinfo(int BookType){
          String ISBN;
          String title;
          int YearOfPublish;
          double price;
          int quntity ;
          System.out.print("Enter ISBN :");

          input.nextLine();
          ISBN=input.nextLine();
          System.out.print("Enter Title :");
          title=input.nextLine();
          System.out.print("Enter Year of Publish :");
          YearOfPublish=input.nextInt();
          System.out.print("Enter Price  :");
          price=input.nextDouble();
          System.out.println();
          switch (BookType){
              case 1:
                  System.out.print("Enter Quntity : ");
                  quntity = input.nextInt();
                  System.out.println();
                  return  new Paperbook(ISBN,title,YearOfPublish,price,quntity);
              case 2:
                  String Filetype;
                  System.out.print("Enter FileType : ");
                  input.nextLine();
                 Filetype = input.nextLine();
                  System.out.print("Enter Quntity : ");
                  quntity = input.nextInt();
                  System.out.println();
                  return  new EBook(ISBN,title,YearOfPublish,price,Filetype,quntity);
              case 3:
                  return  new ShowcaseBook(ISBN,title,YearOfPublish,price);


          }
          return null;
      }
      private static void BuyBookFromStore(){
        String ISBN;
        String email;
        String address;
        int quntity;
          System.out.print("Enter Book ISBN : ");
          input.nextLine();
          ISBN=input.nextLine();
          if (Store.containsKey(ISBN)){
              System.out.print("Enter Email : ");
              email=input.nextLine();
              System.out.print("Enter Address : ");
              address=input.nextLine();
              System.out.print("Enter Quntity : ");
              quntity=input.nextInt();
              Book booktobuy=Store.get(ISBN);
              System.out.println();

              try {
                  double totalCost = booktobuy.BuyBook(ISBN, quntity, email, address);
                  System.out.println("Purchase successful! Total cost: $" + totalCost);
                  System.out.println();
              } catch (IllegalArgumentException e) {
                  System.out.println(e.getMessage());
                  System.out.println();
                  return;
              }
          }else{
              System.out.println("Book Not Available in the store ");
              System.out.println();
              return;
          }

          System.out.println("Book Bought Successfully");
          System.out.println();



      }
}
