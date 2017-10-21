package ro.scii.java8;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * @author x-RauL-x
 * This is the main class of the project
 */
public class Main {


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Customer customer = new Customer("Dorel", 40000);

        EVReader eVReader = new EVReader(new BufferedReader(new FileReader("ElectricVehicles.csv")));
        List<ElectricVehicle> vehicleView = eVReader.readVehicles();
        eVReader.close();

        customer.viewAllVehiclesList(vehicleView);

    }
}
