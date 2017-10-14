package ro.scii.java8;

import java.util.LinkedHashMap;

/**
 * @author x-RauL-x
 * This class represents the dealership model.
 */
public class Dealership {

    private String dealershipName = "Get Electric";

    private int price;
    private int stockNr;
    private LinkedHashMap<ElectricVehicle, PricesAndStocks> pricesAndStocksMap = new LinkedHashMap<>();

    /**
     * This method represents the "database" of the dealership and it will be changed to a external file in the following versions.
     */
    public void dealershipDatabase() {

        Dealership d = new Dealership();

        d.addVehicleToDealership(new Bmw("BMW", "i3", 40, 50, 230, true), new PricesAndStocks(40000, 5));
        d.addVehicleToDealership(new Hyundai("Hyundai", "Ioniq", 120, 28, 180, false), new PricesAndStocks(36000, 3));
        d.addVehicleToDealership(new Kia("Kia", "Soul", 109, 30, 150, false), new PricesAndStocks(33000, 6));
        d.addVehicleToDealership(new Renault("Renault", "Zoe", 90, 22, 200, true), new PricesAndStocks(38000, 0));
        d.addVehicleToDealership(new Smart("Smart", "ForTwo", 80, 18, 129, true), new PricesAndStocks(32000, 20));
        d.addVehicleToDealership(new Smart("Smart", "ForTwoCabrio", 80, 18, 129, true), new PricesAndStocks(34000, 2));
        d.addVehicleToDealership(new Smart("Smart", "ForFour", 80, 18, 129, true), new PricesAndStocks(36000, 4));
        d.addVehicleToDealership(new Volkswagen("VW", "e-UP", 82, 19, 160, true), new PricesAndStocks(33000, 15));
        d.addVehicleToDealership(new Volkswagen("VW", "e-Golf", 115, 36, 201, true), new PricesAndStocks(38500, 0));

    }


    /**
     * This method adds a vehicle to the Dealership database, along with it's price and it's stock.
     *
     * @param electricVehicle This parameter represents the Vehicle.
     * @param ps              This parameter represents the vehicle's price and the vehicle's stock.
     */
    public void addVehicleToDealership(ElectricVehicle electricVehicle, PricesAndStocks ps) {
        this.pricesAndStocksMap.put(electricVehicle, ps);
    }


    public String getDealershipName() {
        return dealershipName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public int getStockNr() {
        return stockNr;
    }

    public void setStockNr(int stockNr) {
        this.stockNr = stockNr;
    }


    @Override
    public String toString() {
        return
                "price=" + price +
                        ", stockNr=" + stockNr;
    }


}

