package ro.scii.java8;

/**
 * @author x-RauL-x
 * This class represents the electric vehicle model
 */
public class ElectricVehicle {

    private String manufacturer;
    private String vehicleModel;
    private double motorPower;
    private float batteryCapacity;
    private int range;
    private boolean hasFastCharging;
    private float price;
    private int stockNr;
    private boolean isNew;

    public ElectricVehicle(String manufacturer, String vehicleModel, double motorPower, float batteryCapacity, int range, boolean hasFastCharging, boolean isNew, float price, int stockNr) {
        this.manufacturer = manufacturer;
        this.vehicleModel = vehicleModel;
        this.motorPower = motorPower;
        this.batteryCapacity = batteryCapacity;
        this.range = range;
        this.hasFastCharging = hasFastCharging;
        this.isNew = isNew;
        this.price = price;
        this.stockNr = stockNr;

    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public double getMotorPower() {
        return motorPower;
    }

    public float getBatteryCapacity() {
        return batteryCapacity;
    }

    public int getRange() {
        return range;
    }

    public boolean isHasFastCharging() {
        return hasFastCharging;
    }

    public float getPrice() {
        return price;
    }

    public int getStockNr() {
        return stockNr;
    }

    public void setStockNr(int stockNr) {
        this.stockNr = stockNr;
    }

    public boolean isNew() {
        return isNew;
    }

    @Override
    public String toString() {
        return "manufacturer='" + manufacturer + '\'' +
                ", vehicleModel='" + vehicleModel + '\'' +
                ", motorPower=" + motorPower +
                ", batteryCapacity=" + batteryCapacity +
                ", range=" + range +
                ", hasFastCharging=" + hasFastCharging +
                ", isNew=" + isNew +
                ", price=" + price +
                ", stockNr=" + stockNr;
    }
}
