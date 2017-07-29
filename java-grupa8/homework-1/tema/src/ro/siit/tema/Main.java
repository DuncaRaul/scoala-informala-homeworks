package ro.siit.tema;

import java.util.Scanner;

/**
 * @author x-RauL-x
 * The main class of an algorithm that creates an array of objects of the SalesRepresentatives class
 * and uses a decending bubble sort on the array
 */

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);     // creating a scanner object
        SalesRepresentatives[] SalesGuy = new SalesRepresentatives[2];  // creating a SalesRepresentatives object
        int numberSales;   //declaring the variables used to read data from the keyboard
        int numberRevenue;
        String Name;

        for (int i = 0; i < SalesGuy.length; i++) {    //loop for reading data from the keyboard
            System.out.print(" Name = ");
            Name = sc.next();
            System.out.print(" Number of sales = ");
            numberSales = sc.nextInt();
            System.out.print(" Revenue = ");
            numberRevenue = sc.nextInt();
            SalesGuy[i] = new SalesRepresentatives();
            SalesGuy[i].setName(Name);
            SalesGuy[i].setSales(numberSales);
            SalesGuy[i].setRevenue(numberRevenue);

        }

        BubbleSort.bubbleSort(SalesGuy);   //the use of the bubblesort method


        for (int i = 0; i < SalesGuy.length; i++) {    //printing on the screen the results of the bubble sort
            System.out.print("Name = " + SalesGuy[i].getName());
            System.out.print(" Sales = " + SalesGuy[i].getSales());
            System.out.println(" Revenue = " + SalesGuy[i].getRevenue());
        }
    }
}
