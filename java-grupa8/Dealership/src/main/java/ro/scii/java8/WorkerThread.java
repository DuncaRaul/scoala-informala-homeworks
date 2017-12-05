package ro.scii.java8;

import java.io.IOException;

public class WorkerThread implements Runnable {

    private String command;
    private CustomerID c = new CustomerID();

    @Override
    public void run() {
        try {
            c.login();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return this.command;
    }
}

