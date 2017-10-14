package ro.siit.tema;

/**
 * @author x-RauL-x
 * A class that has all the methods who perform operations on the data
 */

public class SalesOperations {

    /**
     * Method that returns the best sales from a departament
     *
     * @param SalesGuys array object that is manipulated
     * @return the biggest sales in the departament
     */
    public static int bestSales(SalesRepresentatives[] SalesGuys) {
        int max = 0;
        for (int i = 0; i < 5; i++) {
            if (max < SalesGuys[i].getSales()) {
                max = SalesGuys[i].getSales();
            }
        }
        return max;
    }

    /**
     * Method that gets the name of the sales rep with the highest sales
     *
     * @param SalesGuys array object that is manipulated
     * @return the name of the sales rep with the highest sales
     */
    public static String bestSalesName(SalesRepresentatives[] SalesGuys) {
        int max = 0;
        String name = "";
        for (int i = 0; i < 5; i++) {
            if (max < SalesGuys[i].getSales()) {
                max = SalesGuys[i].getSales();
                name = SalesGuys[i].getName();
            }
        }
        return name;
    }


    /**
     * Method used to get the total sales from the array
     *
     * @param SalesGuys array object that is manipulated
     * @return the total sales in the array
     */
    public static int totalSales(SalesRepresentatives[] SalesGuys) {
        int total = 0;
        for (int i = 0; i < SalesGuys.length; i++) {
            total += SalesGuys[i].getSales();
        }
        return total;
    }

    /**
     * Method that gets the best departament based on number of sales
     *
     * @param SalesGuys1 array object that is manipulated
     * @param SalesGuys2 array object that is manipulated
     * @param SalesGuys3 array object that is manipulated
     * @param SalesGuys4 array object that is manipulated
     * @return the total sales of the best departament
     */
    public static int bestDepartament(SalesRepresentatives[] SalesGuys1, SalesRepresentatives[] SalesGuys2, SalesRepresentatives[] SalesGuys3, SalesRepresentatives[] SalesGuys4) {
        int max = 0;
        String best = "";

        if (max < totalSales(InfoInit.SalesGuy)) {
            max = totalSales(InfoInit.SalesGuy);
            best = "SalesGuy";
        }
        if (max < totalSales(InfoInit.SalesGuy2)) {
            max = totalSales(InfoInit.SalesGuy2);
            best = "SalesGuy2";
        }
        if (max < totalSales(InfoInit.SalesGuy3)) {
            max = totalSales(InfoInit.SalesGuy3);
            best = "SalesGuy3";
        }
        if (max < totalSales(InfoInit.SalesGuy4)) {
            max = totalSales(InfoInit.SalesGuy4);
            best = "SalesGuy4";
        }
        System.out.print("The most succesfull departament is " + best + " with total sales  ");
        return max;


    }

    /**
     * Method that gets the total sales of the company
     * @param SalesGuys array object that is manipulated
     * @param SalesGuys2 array object that is manipulated
     * @param SalesGuys3 array object that is manipulated
     * @param SalesGuys4 array object that is manipulated
     * @return the total number of sales
     */
    public static int totalComapnySales(SalesRepresentatives[] SalesGuys, SalesRepresentatives[] SalesGuys2, SalesRepresentatives[] SalesGuys3, SalesRepresentatives[] SalesGuys4) {
        int total = 0;
        for (int i = 0; i < 5; i++) {
            total += SalesGuys[i].getSales();
        }
        for (int i = 0; i < 5; i++) {
            total += SalesGuys2[i].getSales();
        }
        for (int i = 0; i < 5; i++) {
            total += SalesGuys3[i].getSales();
        }
        for (int i = 0; i < 5; i++) {
            total += SalesGuys4[i].getSales();
        }
        return total;
    }


    /**
     * Method that gets the best sales rep in the company based on the number of sales
     * @param SalesGuys1 array object that is manipulated
     * @param SalesGuys2 array object that is manipulated
     * @param SalesGuys3 array object that is manipulated
     * @param SalesGuys4 array object that is manipulated
     * @return the number of sales from the best sales rep in the company
     */
    public static int bestSalesRep(SalesRepresentatives[] SalesGuys1, SalesRepresentatives[] SalesGuys2, SalesRepresentatives[] SalesGuys3, SalesRepresentatives[] SalesGuys4) {
        int max = 0;
        String best = "";

        if (max < bestSales(InfoInit.SalesGuy)) {
            max = bestSales(InfoInit.SalesGuy);
            best = "" + bestSalesName(InfoInit.SalesGuy);
        }
        if (max < bestSales(InfoInit.SalesGuy2)) {
            max = bestSales(InfoInit.SalesGuy2);
            best = "" + bestSalesName(InfoInit.SalesGuy2);
        }
        if (max < bestSales(InfoInit.SalesGuy3)) {
            max = bestSales(InfoInit.SalesGuy3);
            best = "" + bestSalesName(InfoInit.SalesGuy3);
        }
        if (max < bestSales(InfoInit.SalesGuy4)) {
            max = bestSales(InfoInit.SalesGuy4);
            best = "" + bestSalesName(InfoInit.SalesGuy4);
        }
        System.out.print("The most succesfull Sales Representative is " + best + " with total sales  ");
        return max;


    }
}
