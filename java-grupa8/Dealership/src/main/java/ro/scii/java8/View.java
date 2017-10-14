package ro.scii.java8;

/**
 * @author x-RauL-x
 * This class represents a view for the customer.
 */
public class View {

    private String manufacturer;
    private String vehicleModel;
    private double motorPower;
    private float batteryCapacity;
    private int range;
    private boolean hasFastCharging;
    private float price;
    private int stockNr;

    public View(String manufacturer, String vehicleModel, double motorPower, float batteryCapacity, int range, boolean hasFastCharging, float price, int stockNr) {
        this.manufacturer = manufacturer;
        this.vehicleModel = vehicleModel;
        this.motorPower = motorPower;
        this.batteryCapacity = batteryCapacity;
        this.range = range;
        this.hasFastCharging = hasFastCharging;
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

    @Override
    public String toString() {
        return "manufacturer='" + manufacturer + '\'' +
                ", vehicleModel='" + vehicleModel + '\'' +
                ", motorPower=" + motorPower +
                ", batteryCapacity=" + batteryCapacity +
                ", range=" + range +
                ", hasFastCharging=" + hasFastCharging +
                ", price=" + price +
                ", stockNr=" + stockNr;
    }
}
