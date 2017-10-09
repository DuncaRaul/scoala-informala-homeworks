package ro.scii.java8;

public class ElectricVehicle {

    private String manufacturer;
    private String vehicleModel;
    private float motorPower;
    private float batteryCapacity;
    private int range;
    private boolean hasFastCharging;

    public ElectricVehicle(String manufacturer, String vehicleModel, float motorPower, float batteryCapacity, int range, boolean hasFastCharging) {
        this.manufacturer = manufacturer;
        this.vehicleModel = vehicleModel;
        this.motorPower = motorPower;
        this.batteryCapacity = batteryCapacity;
        this.range = range;
        this.hasFastCharging = hasFastCharging;
    }
}
