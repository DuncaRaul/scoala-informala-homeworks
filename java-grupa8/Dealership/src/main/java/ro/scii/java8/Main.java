package ro.scii.java8;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author x-RauL-x
 * This is the main class of the project
 */
public class Main {


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        WorkerThread w0 = new WorkerThread();
        WorkerThread w1 = new WorkerThread();
        WorkerThread w2 = new WorkerThread();

        CustomerID c = new CustomerID();
        CustomerID c1 = new CustomerID();
        CustomerID c2 = new CustomerID();

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.execute(w0);
        executorService.execute(w1);
        executorService.execute(w2);
        executorService.shutdown();

    }
}
