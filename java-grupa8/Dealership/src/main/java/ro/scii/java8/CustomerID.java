package ro.scii.java8;

import ro.scii.java8.Customer;

import java.io.*;
import java.util.List;
import java.util.Scanner;

/**
 * This class will handle the identification of a customer whether he is new or old.
 */
public class CustomerID {

    private Scanner sc = new Scanner(System.in);

    private String temp1 = null;
    private String temp2 = null;
    private String temp3 = null;
    private List<Customer> customers;
    private boolean customerFound;

    Customer customer = new Customer(temp1, temp2, temp3);

    /**
     * This method implements the login feature, checking if the customer has an account already.
     *
     * @throws IOException
     */
    public void login() throws IOException, ClassNotFoundException {

        CustomerReader customerReader = new CustomerReader(new BufferedReader(new FileReader("Customers.csv")));
        customers = customerReader.readCustomers();
        sc.close();

        System.out.println("Please input your CNP: ");
        String id = sc.next();

        for (Customer forC : customers) {
            if (forC.getCustomerId().equals(id)) {
                Customer existingCustomer = new Customer(forC.getFirstName(), forC.getLastName(), forC.getCustomerId());
                customer = existingCustomer;
                System.out.println("Please specify your budget: ");
                int bug = sc.nextInt();
                customer.setBudget(bug);
                customer.viewAllVehiclesList();
                customerFound = true;
                break;
            } else customerFound = false;
        }
        if (!customerFound) {
            for (Customer forC : customers) {
                if (!(forC.getCustomerId().equals(id))) {
                    System.out.println("Your ID was not found in the database, do you want to register ? y/n");
                    String acc = sc.next();
                    if (acc.equals("y")) {
                        signUp();
                        break;
                    } else if (acc.equals("n")) {
                        System.out.println("Thank you for visiting.");
                        break;
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
            }
        }
    }


    public void signUp() throws IOException, ClassNotFoundException {
        CustomerReader customerReader = new CustomerReader(new BufferedReader(new FileReader("Customers.csv")));
        customers = customerReader.readCustomers();
        customerReader.close();

        System.out.println("Please input your first name: ");
        String fn = sc.next();
        System.out.println("Please input your last name: ");
        String ln = sc.next();
        System.out.println("Please input your CNP: ");
        String cnp = sc.next();

        customer.setFirstName(fn);
        customer.setLastName(ln);
        customer.setCustomerId(cnp);

        customers.add(customer);

        CustomerWriter writer = new CustomerWriter(new BufferedWriter(new FileWriter("Customers.csv")));
        for (Customer ce : customers) {
            writer.writeCustomers(ce);
        }
        writer.flush();
        writer.close();
        login();
    }

}