import org.junit.Test;
import ro.scii.java8.*;


import static org.junit.Assert.assertEquals;

public class CarDisplayTest {

    @Test
    public void numberOfCarsDisplayedIsEqualToFiveWhenFiltersAreUp() {

        ElectricVehicle[] electricVehicle = new ElectricVehicle[9];

        electricVehicle[0] = new Bmw("BMW", "i3", 125, 33, 183, true);
        electricVehicle[1] = new Hyundai("Hyundai", "Ioniq", 120, 28, 180, false);
        electricVehicle[2] = new Kia("Kia", "Soul", 109, 30, 150, false);
        electricVehicle[3] = new Renault("Renault", "Zoe", 90, 22, 200, true);
        electricVehicle[4] = new Smart("Smart", "ForTwo", 80, 18, 129, true);
        electricVehicle[5] = new Smart("Smart", "ForTwoCabrio", 80, 18, 129, true);
        electricVehicle[6] = new Smart("Smart", "ForFour", 80, 18, 129, true);
        electricVehicle[7] = new Volkswagen("VW", "e-UP", 82, 19, 160, true);
        electricVehicle[8] = new Volkswagen("VW", "e-Golf", 115, 36, 201, true);

        Dealership[] vehiclePriceAndStock = new Dealership[electricVehicle.length];

        vehiclePriceAndStock[0] = new Dealership(40000, 5);
        vehiclePriceAndStock[1] = new Dealership(36000, 2);
        vehiclePriceAndStock[2] = new Dealership(89752, 5);
        vehiclePriceAndStock[3] = new Dealership(43874, 0);
        vehiclePriceAndStock[4] = new Dealership(235857, 4);
        vehiclePriceAndStock[5] = new Dealership(2345857, 2);
        vehiclePriceAndStock[6] = new Dealership(213857, 6);
        vehiclePriceAndStock[7] = new Dealership(238757, 7);
        vehiclePriceAndStock[8] = new Dealership(238557, 0);

        int count = 0;

        for (int i = 0; i < 9; i++) {
            if (electricVehicle[i].isHasFastCharging() && (vehiclePriceAndStock[i].getStockNr()) > 0) {
                count++;
            }
        }
        assertEquals(5, count);
    }

    @Test
    public void numberOfCarsDisplayedIsEqualToFiveWhenUserPressesY() {

        ElectricVehicle[] electricVehicle = new ElectricVehicle[9];


        electricVehicle[0] = new Bmw("BMW", "i3", 125, 33, 183, true);
        electricVehicle[1] = new Hyundai("Hyundai", "Ioniq", 120, 28, 180, false);
        electricVehicle[2] = new Kia("Kia", "Soul", 109, 30, 150, false);
        electricVehicle[3] = new Renault("Renault", "Zoe", 90, 22, 200, true);
        electricVehicle[4] = new Smart("Smart", "ForTwo", 80, 18, 129, true);
        electricVehicle[5] = new Smart("Smart", "ForTwoCabrio", 80, 18, 129, true);
        electricVehicle[6] = new Smart("Smart", "ForFour", 80, 18, 129, true);
        electricVehicle[7] = new Volkswagen("VW", "e-UP", 82, 19, 160, true);
        electricVehicle[8] = new Volkswagen("VW", "e-Golf", 115, 36, 201, true);

        Dealership[] vehiclePriceAndStock = new Dealership[electricVehicle.length];

        vehiclePriceAndStock[0] = new Dealership(40000, 5);
        vehiclePriceAndStock[1] = new Dealership(36000, 2);
        vehiclePriceAndStock[2] = new Dealership(89752, 5);
        vehiclePriceAndStock[3] = new Dealership(43874, 0);
        vehiclePriceAndStock[4] = new Dealership(235857, 4);
        vehiclePriceAndStock[5] = new Dealership(2345857, 2);
        vehiclePriceAndStock[6] = new Dealership(213857, 6);
        vehiclePriceAndStock[7] = new Dealership(238757, 7);
        vehiclePriceAndStock[8] = new Dealership(238557, 0);

        int count = 0;

        String verify = "y";

        for (int i = 0; i < 9; i++) {
            if (verify.equals("y") && electricVehicle[i].isHasFastCharging() && (vehiclePriceAndStock[i].getStockNr()) > 0) {
                count++;
            }
        }
        assertEquals(5, count);
    }


    @Test
    public void numberOfCarsDisplayedIsEqualToNineWhenUserPressesN() {

        ElectricVehicle[] electricVehicle = new ElectricVehicle[9];


        electricVehicle[0] = new Bmw("BMW", "i3", 125, 33, 183, true);
        electricVehicle[1] = new Hyundai("Hyundai", "Ioniq", 120, 28, 180, false);
        electricVehicle[2] = new Kia("Kia", "Soul", 109, 30, 150, false);
        electricVehicle[3] = new Renault("Renault", "Zoe", 90, 22, 200, true);
        electricVehicle[4] = new Smart("Smart", "ForTwo", 80, 18, 129, true);
        electricVehicle[5] = new Smart("Smart", "ForTwoCabrio", 80, 18, 129, true);
        electricVehicle[6] = new Smart("Smart", "ForFour", 80, 18, 129, true);
        electricVehicle[7] = new Volkswagen("VW", "e-UP", 82, 19, 160, true);
        electricVehicle[8] = new Volkswagen("VW", "e-Golf", 115, 36, 201, true);

        Dealership[] vehiclePriceAndStock = new Dealership[electricVehicle.length];

        vehiclePriceAndStock[0] = new Dealership(40000, 5);
        vehiclePriceAndStock[1] = new Dealership(36000, 2);
        vehiclePriceAndStock[2] = new Dealership(89752, 5);
        vehiclePriceAndStock[3] = new Dealership(43874, 0);
        vehiclePriceAndStock[4] = new Dealership(235857, 4);
        vehiclePriceAndStock[5] = new Dealership(2345857, 2);
        vehiclePriceAndStock[6] = new Dealership(213857, 6);
        vehiclePriceAndStock[7] = new Dealership(238757, 7);
        vehiclePriceAndStock[8] = new Dealership(238557, 0);

        int count = 0;

        String verify = "n";

        for (int i = 0; i < 9; i++) {
            if (verify.equals("y") && electricVehicle[i].isHasFastCharging() && (vehiclePriceAndStock[i].getStockNr()) > 0) {
                count++;
            } else if (verify.equals("n")) {
                count++;
            }
        }
        assertEquals(9, count);
    }

    @Test
    public void noCarsAreDisplayedWhenUserPressesSomethingElseThanYOrN() {

        ElectricVehicle[] electricVehicle = new ElectricVehicle[9];


        electricVehicle[0] = new Bmw("BMW", "i3", 125, 33, 183, true);
        electricVehicle[1] = new Hyundai("Hyundai", "Ioniq", 120, 28, 180, false);
        electricVehicle[2] = new Kia("Kia", "Soul", 109, 30, 150, false);
        electricVehicle[3] = new Renault("Renault", "Zoe", 90, 22, 200, true);
        electricVehicle[4] = new Smart("Smart", "ForTwo", 80, 18, 129, true);
        electricVehicle[5] = new Smart("Smart", "ForTwoCabrio", 80, 18, 129, true);
        electricVehicle[6] = new Smart("Smart", "ForFour", 80, 18, 129, true);
        electricVehicle[7] = new Volkswagen("VW", "e-UP", 82, 19, 160, true);
        electricVehicle[8] = new Volkswagen("VW", "e-Golf", 115, 36, 201, true);

        Dealership[] vehiclePriceAndStock = new Dealership[electricVehicle.length];

        vehiclePriceAndStock[0] = new Dealership(40000, 5);
        vehiclePriceAndStock[1] = new Dealership(36000, 2);
        vehiclePriceAndStock[2] = new Dealership(89752, 5);
        vehiclePriceAndStock[3] = new Dealership(43874, 0);
        vehiclePriceAndStock[4] = new Dealership(235857, 4);
        vehiclePriceAndStock[5] = new Dealership(2345857, 2);
        vehiclePriceAndStock[6] = new Dealership(213857, 6);
        vehiclePriceAndStock[7] = new Dealership(238757, 7);
        vehiclePriceAndStock[8] = new Dealership(238557, 0);

        int count = 0;

        String verify = "k";

        for (int i = 0; i < 9; i++) {
            if (verify.equals("y") && electricVehicle[i].isHasFastCharging() && (vehiclePriceAndStock[i].getStockNr()) > 0) {
                count++;
            } else if (verify.equals("n")) {
                count++;
            }
        }
        assertEquals(0, count);
    }
}
