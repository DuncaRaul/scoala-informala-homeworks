package ro.scii.java8;

/**
 * @author x-RauL-x
 * This class represents the electric vehicle model.
 */
public class ElectricVehicle {

    private String manufacturer;
    private String vehicleModel;
    private double motorPower;
    private float batteryCapacity;
    private int range;
    private boolean hasFastCharging;


    public ElectricVehicle(String manufacturer, String vehicleModel, double motorPower, float batteryCapacity, int range, boolean hasFastCharging) {
        this.manufacturer = manufacturer;
        this.vehicleModel = vehicleModel;
        this.motorPower = motorPower;
        this.batteryCapacity = batteryCapacity;
        this.range = range;
        this.hasFastCharging = hasFastCharging;

    }


    @Override
    public String toString() {
        return "manufacturer='" + manufacturer + '\'' +
                ", vehicleModel='" + vehicleModel + '\'' +
                ", motorPower=" + motorPower +
                ", batteryCapacity=" + batteryCapacity +
                ", range=" + range +
                ", hasFastCharging=" + hasFastCharging;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public double getMotorPower() {
        return motorPower;
    }

    public void setMotorPower(double motorPower) {
        this.motorPower = motorPower;
    }

    public float getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(float batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }


    public boolean isHasFastCharging() {
        return hasFastCharging;
    }

    public void setHasFastCharging(boolean hasFastCharging) {
        this.hasFastCharging = hasFastCharging;
    }

}