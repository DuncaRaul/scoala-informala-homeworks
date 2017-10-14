package ro.siit.tema;

/**
 * @author x-RauL-x
 * A class used to initialize all the SalesRepresentatives in the SalesDepartment class
 */

public class InfoInit {

    //declaration of the SaleRepresentatives arrays
    static SalesRepresentatives[] SalesGuy = new SalesRepresentatives[5];
    static SalesRepresentatives[] SalesGuy2 = new SalesRepresentatives[5];
    static SalesRepresentatives[] SalesGuy3 = new SalesRepresentatives[5];
    static SalesRepresentatives[] SalesGuy4 = new SalesRepresentatives[5];

    /**
     * Initiation of the first departament
     * @param position posision in the array
     * @param name name of the SaleRep
     * @param sales number of sales
     * @param revenue revenue gained by the SalesRep
     */
    public static void initInfo0(int position, String name, int sales, int revenue) {
        SalesGuy[position] = new SalesRepresentatives();
        SalesGuy[position].name = name;
        SalesGuy[position].sales = sales;
        SalesGuy[position].revenue = revenue;

    }

    /**
     *Initiation of the second departament
     * @param position posision in the array
     * @param name name of the SaleRep
     * @param sales number of sales
     * @param revenue revenue gained by the SalesRepm revenue
     */
    public static void initInfo1(int position, String name, int sales, int revenue) {
        SalesGuy2[position] = new SalesRepresentatives();
        SalesGuy2[position].name = name;
        SalesGuy2[position].sales = sales;
        SalesGuy2[position].revenue = revenue;
    }

    /**
     * Initiation of the third departament
     * @param position posision in the array
     * @param name name of the SaleRep
     * @param sales number of sales
     * @param revenue revenue gained by the SalesRep
     */
    public static void initInfo2(int position, String name, int sales, int revenue) {
        SalesGuy3[position] = new SalesRepresentatives();
        SalesGuy3[position].name = name;
        SalesGuy3[position].sales = sales;
        SalesGuy3[position].revenue = revenue;
    }

    /**
     * Initiation of the fourth departament
     * @param position posision in the array
     * @param name name of the SaleRep
     * @param sales number of sales
     * @param revenue revenue gained by the SalesRep
     */
    public static void initInfo3(int position, String name, int sales, int revenue) {
        SalesGuy4[position] = new SalesRepresentatives();
        SalesGuy4[position].name = name;
        SalesGuy4[position].sales = sales;
        SalesGuy4[position].revenue = revenue;
    }

}


