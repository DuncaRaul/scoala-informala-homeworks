package ro.siit.tema;

/**
 * Created by x-RauL-x on 7/25/2017.
 * This is a class of objects called SalesRepresentatives that have 2 atributes : sales and quota;
 */
public class SalesRepresentatives {
    public int sales;
    public int quota;
    public String name;

    public int getSales() {
        return sales;
    }

    public void setSales(int m) {
        sales = m;
    }

    public int getQuota() {
        return quota;
    }

    public void setQuota(int n) {
        quota = n;
    }

    public String getName() {return name;}

    public void setName(String s) {name = s;}

}
