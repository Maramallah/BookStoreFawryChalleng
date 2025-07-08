package org.example;

public class ShowcaseBook extends Book{

    ShowcaseBook(String ISBN, String title, int PuplishYear, double Price) {
        super(ISBN, title, PuplishYear, Price);
    }

    @Override
    public boolean IsForBuying() {
        return false;
    }

    @Override
    public String BookType() {
        return "ShowCase Book";
    }



    @Override
    public double BuyBook(String ISBN, int quntity, String email, String address) {
        throw new IllegalArgumentException(" This Book is only for ShowCase" );
    }

}
