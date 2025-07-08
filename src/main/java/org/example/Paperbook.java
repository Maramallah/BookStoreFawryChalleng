package org.example;

public class Paperbook extends Book implements  Purchasable{
    private int stock;

    Paperbook(String ISBN, String title, int PuplishYear, double Price, int stock) {
        super(ISBN, title, PuplishYear, Price);
        this.stock=stock;
    }

    public int getStock() {
        return stock;
    }

    public void reduceStock(int quantity) {
        if (quantity > stock) {
            throw new IllegalArgumentException("Insufficient stock. Available: " + stock + ", Requested: " + quantity);
        }
        stock -= quantity;
    }

    @Override
    public boolean IsForBuying() {
        return this.stock>0;
    }

    @Override
    public String BookType() {
        return "Paper Book";
    }




    @Override
    public double BuyBook(String ISBN, int quantity, String email, String address) {
        reduceStock(quantity);
        sendToPurchaseService(email, address);
        return quantity * getPrice();
    }



    @Override
    public void sendToPurchaseService(String email, String address) {

        System.out.println("Sending Book To ShippingService ");
    }
}
