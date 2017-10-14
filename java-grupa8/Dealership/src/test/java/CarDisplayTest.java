import org.junit.Test;
import ro.scii.java8.*;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotEquals;

/**
 * @author x-RauL-x
 */
public class CarDisplayTest {

    @Test
    public void noVehiclesWhichAreNotInStockAreDisplayedWhenStockFilterIsUsed() {

        List<View> testElectricVehicleList = new ArrayList<>();

        testElectricVehicleList.add(new View("Dacia", "1300", 40, 59, 244, false, 300, 1));
        testElectricVehicleList.add(new View("Oltcit", "Club", 40, 24, 232, true, 400, 0));
        testElectricVehicleList.add(new View("Lada", "Niva", 44, 23, 444, true, 340, 1));

        Customer c = new Customer();

        for (View v : c.getVehiclesInStockList(testElectricVehicleList)) {
            assertNotEquals(0, v.getStockNr());
        }
    }

    @Test
    public void noVehiclesWhichDoNotHaveFastChargingAreDisplayedWhenFastChargingFilterIsUsed() {

        List<View> testElectricVehicleList = new ArrayList<>();

        testElectricVehicleList.add(new View("Dacia", "1300", 40, 59, 244, false, 300, 1));
        testElectricVehicleList.add(new View("Oltcit", "Club", 40, 24, 232, true, 400, 0));
        testElectricVehicleList.add(new View("Lada", "Niva", 44, 23, 444, true, 340, 1));

        Customer c = new Customer();

        for (View v : c.getFastChargingList(testElectricVehicleList)) {
            assertNotEquals(0, v.isHasFastCharging());
        }
    }
}
