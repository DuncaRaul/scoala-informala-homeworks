package ro.scii.java8;

/**
 * @author x-RauL-x
 * This class represents the Kia model
 */
public class Kia extends ElectricVehicle {


    public Kia(String manufacturer, String vehicleModel, double motorPower, float batteryCapacity, int range, boolean hasFastCharging, boolean isNew, float price, int stockNr) {
        super(manufacturer, vehicleModel, motorPower, batteryCapacity, range, hasFastCharging, isNew, price, stockNr);
    }
}