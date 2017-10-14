package ro.siit.tema;

/**
 * @author x-RauL-x
 * The main class of an algorithm that creates 4 departaments of 5 SalesRepresentatives and gives the user
 * diferent information about the departaments
 */

public class Main {


    public static void main(String[] args) {

        //initialization of the objects with data
        SalesDepartement.initSalesDepartament1();
        SalesDepartement.initSalesDepartament2();
        SalesDepartement.initSalesDepartament3();
        SalesDepartement.initSalesDepartament4();


        //best departament
        System.out.println(SalesOperations.bestDepartament(InfoInit.SalesGuy, InfoInit.SalesGuy2, InfoInit.SalesGuy3, InfoInit.SalesGuy4));
        //total company sales
        System.out.println("Total Company sales are = " + SalesOperations.totalComapnySales(InfoInit.SalesGuy, InfoInit.SalesGuy2, InfoInit.SalesGuy3, InfoInit.SalesGuy4));
        //best sales rep in the company
        System.out.println(SalesOperations.bestSalesRep(InfoInit.SalesGuy, InfoInit.SalesGuy2, InfoInit.SalesGuy3, InfoInit.SalesGuy4));

        BubbleSort.bubbleSort(InfoInit.SalesGuy);   //the use of the bubblesort method
    }


}
