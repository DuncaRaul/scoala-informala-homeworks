package ro.siit.tema;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SalesRepresentatives[] SalesGuy = new SalesRepresentatives[2];
        int numberSales;
        int numberQuota;
        String Name;

        for (int i = 0; i < SalesGuy.length; i++) {
            System.out.print(" Name = ");
            Name = sc.next();
            System.out.print(" Number of sales = ");
            numberSales = sc.nextInt();
            System.out.print(" Sales quota = ");
            numberQuota = sc.nextInt();
            SalesGuy[i] = new SalesRepresentatives();
            SalesGuy[i].setName(Name);
            SalesGuy[i].setSales(numberSales);
            SalesGuy[i].setQuota(numberQuota);

        }
/*
        for (int i = 0; i < SalesGuy.length; i++) {
            System.out.print(" Number of sales = ");
            numberSales = sc.nextInt();
            SalesGuy[i].setSales(numberSales);
        }

        for (int i = 0; i < SalesGuy.length; i++) {
            System.out.print(" Sales quota = ");
            numberQuota = sc.nextInt();
            SalesGuy[i].setQuota(numberQuota);

        }
*/


        BubbleSort.bubbleSort(SalesGuy);


        for (int i = 0; i < SalesGuy.length; i++) {
            System.out.print("Name =" + SalesGuy[i].getName());
            System.out.print("Sales =" + SalesGuy[i].getSales());
            System.out.println(" Quota =" + SalesGuy[i].getQuota());
        }
    }
}
