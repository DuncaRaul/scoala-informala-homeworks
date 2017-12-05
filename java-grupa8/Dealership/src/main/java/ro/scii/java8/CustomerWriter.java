package ro.scii.java8;

import ro.scii.java8.Customer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;

public class CustomerWriter extends Writer {

    private BufferedWriter writer;

    public CustomerWriter(BufferedWriter writer) {
        this.writer = writer;
    }


    public synchronized void writeCustomers(Customer c) {
        String serializedCustomer = c.getFirstName() + "," + c.getLastName() + "," + c.getCustomerId();
        try {
            writer.write(serializedCustomer);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {

    }

    @Override
    public void flush() throws IOException {
        writer.flush();
    }

    @Override
    public void close() throws IOException {
        writer.close();
    }
}