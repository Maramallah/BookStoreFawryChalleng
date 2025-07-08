package org.example;

import java.time.Year;

public abstract class Book {
  private   String ISBN;
    private String title;
    private int PuplishYear ;
    private   double Price;

    Book(String ISBN,String title,int PuplishYear,double Price ){
        this.ISBN=ISBN;
        this.title=title;
        this.PuplishYear=PuplishYear;
        this.Price=Price;
    }


    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public int getPuplishYear() {
        return PuplishYear;
    }

    public double getPrice() {
        return Price;
    }

    public boolean isOutdated() {
        int currentYear = Year.now().getValue();
        return (currentYear - PuplishYear) > 100;
    }
 public abstract  boolean IsForBuying();

 public  abstract  String BookType();
public abstract double BuyBook(String ISBN,int quntity,String email, String address);

}
