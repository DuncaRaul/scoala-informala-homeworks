package ro.scii;

/**
 * @author x-RauL-x
 * This class represents the threads that execute the operation (deliver packages)
 */
public class WorkerThread extends Thread {


    private Package aPackage;
    private final int PRICEPERKM = 5;
    private int profit = 0;

    public WorkerThread(Package aPackage) {
        this.aPackage = aPackage;
    }

    @Override
    public void run() {
        System.out.println("The package with the id code " + aPackage.getID() + "has departed!");
        int distance = aPackage.getDistanceToTarget();
        try {
            for (int i = 1; i <= distance; i++) {
                sleep(1000);
                System.out.println("The package with the ID " + aPackage.getID() + " has travelled " + i + " kilometers");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        profit = PRICEPERKM * distance;
        System.out.println("The package with the ID:" + aPackage.getID() + " has been delivered and has generated " + profit + "$ worth of profit!");

    }


}