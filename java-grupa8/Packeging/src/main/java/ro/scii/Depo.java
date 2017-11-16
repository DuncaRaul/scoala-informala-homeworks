package ro.scii;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author x-RauL-x
 * This class handles the operations necesary to deliver a package and to calculate the profit
 */
public class Depo {

    private final int PRICEPERKM = 5;
    private int totalProfit;
    private int clujProfit = 0;
    private int numberOfPackages = 0;
    private int totalMerchValue = 0;


    public void depo() throws InterruptedException {
        LocationComparator locationComparator = new LocationComparator();
        DateComparator dateComparator = new DateComparator();
        Scanner s = new Scanner(System.in);

        List<Package> packages = new ArrayList<>();
        packages.add(new Package("Cluj", 3, 1500, new Date(2017, 11, 20), 1));
        packages.add(new Package("Gherla", 50, 2500, new Date(2017, 11, 25), 2));
        packages.add(new Package("Cluj", 5, 500, new Date(2017, 11, 18), 3));
        packages.add(new Package("Gherla", 54, 300, new Date(2017, 11, 21), 4));
        packages.add(new Package("Cluj", 3, 900, new Date(2017, 11, 20), 5));
        packages.add(new Package("Cluj", 6, 5000, new Date(2017, 11, 20), 6));
        packages.add(new Package("Gherla", 51, 1900, new Date(2017, 11, 25), 7));
        packages.add(new Package("Cluj", 8, 200, new Date(2017, 11, 18), 8));
        packages.add(new Package("Gherla", 58, 4500, new Date(2017, 11, 21), 9));
        packages.add(new Package("Cluj", 5, 650, new Date(2017, 11, 20), 10));

        System.out.println("Do you want to sort the list based on delivery date? y/n");
        String sortingDate = s.next();

        //sorting the list based on delivery date
        if (sortingDate.equals("y")) {
            Collections.sort(packages, dateComparator);
        } else if (sortingDate.equals("n")) {

        } else throw new IllegalArgumentException("Only \"y\" or \"n\" answers can be used");

        System.out.println("Do you want to sort the list based on delivery location? y/n");
        String sortingLocation = s.next();

        //sorting the list based on delivery location
        if (sortingLocation.equals("y")) {
            Collections.sort(packages, locationComparator);
        } else if (sortingLocation.equals("n")) {

        } else throw new IllegalArgumentException("Only \"y\" or \"n\" answers can be used");

        for (Package p : packages) {
            System.out.println(p);
        }

        //creating and running the threads
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < packages.size(); i++) {
            WorkerThread workerThread = new WorkerThread(packages.get(i));
            executorService.execute(workerThread);

        }

        for (int i = 0; i < packages.size(); i++) {
            WorkerThread workerThread = new WorkerThread(packages.get(i));
            workerThread.join();

        }


        executorService.shutdown();

        //calculating the profits and merch value
        for (Package p : packages) {
            totalProfit += p.getDistanceToTarget() * PRICEPERKM;
            if (p.getTargetLocation().equals("Cluj") && p.getDate().equals(new Date(2017, 11, 20))) {
                clujProfit += p.getDistanceToTarget() * PRICEPERKM;
                numberOfPackages += 1;
            }
            totalMerchValue += p.getMerchValue();
        }


        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        System.out.println("At 20.11.2017, " + numberOfPackages + " packages were shipped to Cluj, resulting in a " + clujProfit + "$ profit.");
        System.out.println("Total generated profit: " + totalProfit + "$ !");
        System.out.println("Total shipped merchandise value " + totalMerchValue + "$ !");

    }


}
