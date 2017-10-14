package ro.scii.java8;

import java.util.Comparator;

public class PricesAndStocks implements Comparator {

    private float price;
    private int stockNr;

    public PricesAndStocks(int price, int stockNr) {
        this.price = price;
        this.stockNr = stockNr;
    }

    public float getPrice() {
        return price;
    }

    public int getStockNr() {
        return stockNr;
    }

    @Override
    public String toString() {
        return " price=" + price +
                ", stockNr=" + stockNr +
                '}';
    }


    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}
