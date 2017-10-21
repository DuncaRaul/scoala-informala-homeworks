package ro.scii.java8;

import java.io.IOException;

/**
 * @author x-RauL-x
 * This class represents the dealership model
 */
public class Dealership {

    GreenBonusProgram g = new GreenBonusProgram();

    private String dealershipName = "Get Electric";

    public String getDealershipName() {
        return dealershipName;
    }

    public boolean checkIfCarIsInStock(ElectricVehicle v) {
        return v.getStockNr() > 0 ? true : false;
    }

    public boolean checkIfDealershipCanGrantFunds(ElectricVehicle electricVehicle) throws IOException, ClassNotFoundException {
        if (electricVehicle.isNew()) {
            g.checkFunds();
            return true;
        } else {
            System.out.println("The Green Bonus Program cannot grant you funds since the vehicle is not new.");
            return false;
        }
    }
}