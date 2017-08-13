package ro.siit.tema;

/**
 * Created by x-RauL-x on 7/25/2017.
 * This is a class of objects called SalesRepresentatives that have 2 atributes : sales and quota;
 */
public class SalesRepresentatives {
    public int sales;
    public int revenue;
    public String name;

    public int getSales() {
        return sales;
    }    // getter method for sales

    public void setSales(int m) {
        sales = m;
    }  //setter method for sales

    public int getRevenue() {
        return revenue;
    }  //getter method for revenue

    public void setRevenue(int n) { revenue = n; } //setter method for revenue

    public String getName() { return name; }  //getter method for name

    public void setName(String s) { name = s; } //setter method for name

}
