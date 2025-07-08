package org.example;

public class EBook extends Book implements Purchasable{
 private    String fileType;
  private   int stock;


    EBook(String ISBN, String title, int PuplishYear, double Price, String fileType, int quntity) {
        super(ISBN, title, PuplishYear, Price);
        this.fileType=fileType;
        this.stock=quntity;

    }


    @Override
    public boolean IsForBuying() {
        return true;
    }

    @Override
    public String BookType() {
        return "EBook";
    }



    @Override
    public double BuyBook(String ISBN, int quntity, String email, String address) {

       reduceStock(quntity);
        sendToPurchaseService(email, address);
        return quntity*getPrice();
    }
    public void reduceStock(int quantity) {
        if (quantity > stock) {
            throw new IllegalArgumentException("Insufficient stock. Available: " + stock + ", Requested: " + quantity);
        }
        stock -= quantity;
    }

    @Override
    public void sendToPurchaseService(String email, String address) {
        System.out.println("Sending Book to MailService");
    }

    public String getFileType() {
        return fileType;
    }
    public int getStock() {
        return stock;
    }
}
