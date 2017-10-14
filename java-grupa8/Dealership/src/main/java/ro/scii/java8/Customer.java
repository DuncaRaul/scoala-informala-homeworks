package ro.scii.java8;

import java.util.Scanner;

/**
 * @author x-RauL-x
 * This class represents the available actions of the customer towards the dealership.
 */
public class Customer {

    private String customerName;
    private int customerId;

    /**
     * This method allows the customer to filter the vehicle array.
     * In later versions, this method will allow the client to also sort the vehicles and purchase them.
     */
    public void carPurchase() {
        Scanner s = new Scanner(System.in);

        // This array represents the vehicles that are available for purchase.
        ElectricVehicle[] electricVehicle = new ElectricVehicle[9];

        electricVehicle[0] = new Bmw("Bmw", "i3", 125, 33, 183, true);
        electricVehicle[1] = new Hyundai("Hyundai", "Ioniq", 120, 28, 180, false);
        electricVehicle[2] = new Kia("Kia", "Soul", 109, 30, 150, false);
        electricVehicle[3] = new Renault("Renault", "Zoe", 90, 22, 200, true);
        electricVehicle[4] = new Smart("Smart", "ForTwo", 80, 18, 129, true);
        electricVehicle[5] = new Smart("Smart", "ForTwoCabrio", 80, 18, 129, true);
        electricVehicle[6] = new Smart("Smart", "ForFour", 80, 18, 129, true);
        electricVehicle[7] = new Volkswagen("VW", "e-UP", 82, 19, 160, true);
        electricVehicle[8] = new Volkswagen("VW", "e-Golf", 115, 36, 201, true);


        // This array represents the prices and stock numbers for the vehicles in the array above.
        Dealership[] vehiclePriceAndStock = new Dealership[electricVehicle.length];

        vehiclePriceAndStock[0] = new Dealership(40000, 4);
        vehiclePriceAndStock[1] = new Dealership(36000, 2);
        vehiclePriceAndStock[2] = new Dealership(89752, 5);
        vehiclePriceAndStock[3] = new Dealership(43874, 0);
        vehiclePriceAndStock[4] = new Dealership(235857, 4);
        vehiclePriceAndStock[5] = new Dealership(2345857, 2);
        vehiclePriceAndStock[6] = new Dealership(213857, 6);
        vehiclePriceAndStock[7] = new Dealership(238757, 7);
        vehiclePriceAndStock[8] = new Dealership(238557, 0);

        System.out.println("Do you want to filter the list based on fast charging and stock number? y/n ");
        String verify = s.next();

        //This loop allows the Customer to filter the vehicles array based on stock number and fast charging.
        for (int i = 0; i < 9; i++) {
            if (verify.equals("y") && electricVehicle[i].isHasFastCharging() && (vehiclePriceAndStock[i].getStockNr()) > 0) {
                System.out.println(electricVehicle[i].getManufacturer() + " " + electricVehicle[i].getVehicleModel() + " " + vehiclePriceAndStock[i].getStockNr() + " " + vehiclePriceAndStock[i].getPrice());
            } else if (verify.equals("n")) {
                System.out.println(electricVehicle[i].getManufacturer() + " " + electricVehicle[i].getVehicleModel() + " " + vehiclePriceAndStock[i].getStockNr() + " " + vehiclePriceAndStock[i].getPrice());
            }
        }


    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerId() {
        return customerId;
    }


    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
