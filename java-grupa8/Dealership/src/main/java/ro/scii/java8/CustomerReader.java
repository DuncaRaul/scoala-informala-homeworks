package ro.scii.java8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerReader extends Reader {

    private BufferedReader reader;

    public CustomerReader(BufferedReader reader) {
        this.reader = reader;
    }


    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        return reader.read(cbuf, off, len);
    }

    public List<Customer> readCustomers() {
        try {
            String line = reader.readLine();
            List<Customer> customers = new ArrayList<>();
            while (line != null) {
                String[] tokens = line.split(",");
                String firstName = tokens[0];
                String lastName = tokens[1];
                String id = tokens[2];
                Customer c = new Customer(firstName, lastName, id);
                customers.add(c);
                line = reader.readLine();
            }
            return customers;
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return Collections.emptyList();
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }
}

