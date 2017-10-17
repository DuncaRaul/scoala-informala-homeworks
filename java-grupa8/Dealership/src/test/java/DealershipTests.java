import org.junit.Test;
import ro.scii.java8.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


/**
 * @author x-RauL-x
 */
public class DealershipTests {


    @Test
    public void noVehiclesWhichAreNotInStockAreDisplayedWhenStockFilterIsUsed() {

        List<ElectricVehicle> testElectricVehicleList = new ArrayList<>();

        testElectricVehicleList.add(new ElectricVehicle("Dacia", "1300", 40, 59, 244, false, true, 40000, 20));
        testElectricVehicleList.add(new ElectricVehicle("Oltcit", "Club", 41, 24, 232, true, false, 30000, 0));
        testElectricVehicleList.add(new ElectricVehicle("Lada", "Niva", 44, 23, 444, true, true, 20000, 20));

        Customer c = new Customer("Gicu", 500);

        for (ElectricVehicle v : c.getVehiclesInStockList(testElectricVehicleList)) {
            assertNotEquals(0, v.getStockNr());
        }
    }

    @Test
    public void noVehiclesWhichDoNotHaveFastChargingAreDisplayedWhenFastChargingFilterIsUsed() {

        List<ElectricVehicle> testElectricVehicleList = new ArrayList<>();

        testElectricVehicleList.add(new ElectricVehicle("Dacia", "1300", 40, 59, 244, false, true, 40000, 20));
        testElectricVehicleList.add(new ElectricVehicle("Oltcit", "Club", 41, 24, 232, true, false, 30000, 0));
        testElectricVehicleList.add(new ElectricVehicle("Lada", "Niva", 44, 23, 444, true, true, 20000, 20));

        Customer c = new Customer("Gigi", 600);

        for (ElectricVehicle v : c.getFastChargingList(testElectricVehicleList)) {
            assertNotEquals(0, v.isHasFastCharging());
        }
    }

    @Test
    public void theVehiclesAreProperlySortedWhenSortingByPrice() throws IOException {

        PriceComparator priceComparator = new PriceComparator();

        EVReader testReader = new EVReader(new BufferedReader(new FileReader("TestVehicleCSV.csv")));
        List<ElectricVehicle> testCsvList = testReader.readVehicles();
        testReader.close();

        ArrayList<ElectricVehicle> priceSortedTestList = new ArrayList<>();

        priceSortedTestList.add(new ElectricVehicle("Lada", "Niva", 44, 23, 444, true, true, 20000, 20));
        priceSortedTestList.add(new ElectricVehicle("Oltcit", "Club", 41, 24, 232, true, false, 30000, 0));
        priceSortedTestList.add(new ElectricVehicle("Dacia", "1300", 40, 59, 244, false, true, 40000, 20));

        Collections.sort(testCsvList, priceComparator);

        for (int i = 0; i < 3; i++) {
            assertEquals(testCsvList.get(i).toString(), priceSortedTestList.get(i).toString());
        }

    }

    @Test
    public void theVehiclesAreProperlySortedWhenSortingByRange() throws IOException {

        RangeComparator rangeComparator = new RangeComparator();

        EVReader testReader = new EVReader(new BufferedReader(new FileReader("TestVehicleCSV.csv")));
        List<ElectricVehicle> testCsvList = testReader.readVehicles();
        testReader.close();

        ArrayList<ElectricVehicle> priceSortedTestList = new ArrayList<>();

        priceSortedTestList.add(new ElectricVehicle("Oltcit", "Club", 41, 24, 232, true, false, 30000, 0));
        priceSortedTestList.add(new ElectricVehicle("Dacia", "1300", 40, 59, 244, false, true, 40000, 20));
        priceSortedTestList.add(new ElectricVehicle("Lada", "Niva", 44, 23, 444, true, true, 20000, 20));

        Collections.sort(testCsvList, rangeComparator);

        for (int i = 0; i < 3; i++) {
            assertEquals(testCsvList.get(i).toString(), priceSortedTestList.get(i).toString());
        }

    }

    @Test
    public void theVehiclesAreProperlySortedWhenSortingByPower() throws IOException {

        MotorPowerComparator motorPowerComparator = new MotorPowerComparator();

        EVReader testReader = new EVReader(new BufferedReader(new FileReader("TestVehicleCSV.csv")));
        List<ElectricVehicle> testCsvList = testReader.readVehicles();
        testReader.close();

        ArrayList<ElectricVehicle> priceSortedTestList = new ArrayList<>();

        priceSortedTestList.add(new ElectricVehicle("Dacia", "1300", 40, 59, 244, false, true, 40000, 20));
        priceSortedTestList.add(new ElectricVehicle("Oltcit", "Club", 41, 24, 232, true, false, 30000, 0));
        priceSortedTestList.add(new ElectricVehicle("Lada", "Niva", 44, 23, 444, true, true, 20000, 20));

        Collections.sort(testCsvList, motorPowerComparator);

        for (int i = 0; i < 3; i++) {
            assertEquals(testCsvList.get(i).toString(), priceSortedTestList.get(i).toString());
        }

    }

    @Test
    public void whenCustomerPurchasesAVehicleItsStockIsSubtractedByOne() {

        List<ElectricVehicle> testElectricVehicleList = new ArrayList<>();

        testElectricVehicleList.add(new ElectricVehicle("Dacia", "1300", 40, 59, 244, false, true, 40000, 20));
        testElectricVehicleList.add(new ElectricVehicle("Oltcit", "Club", 41, 24, 232, true, false, 30000, 1));
        testElectricVehicleList.add(new ElectricVehicle("Lada", "Niva", 44, 23, 444, true, true, 20000, 20));

        Customer c = new Customer("Gicu", 40000);
        Dealership d = new Dealership();


        c.subtractStockByOne(testElectricVehicleList, 0);
        c.subtractStockByOne(testElectricVehicleList, 1);
        c.subtractStockByOne(testElectricVehicleList, 2);

        assertEquals(testElectricVehicleList.get(0).getStockNr(), 19);
        assertEquals(testElectricVehicleList.get(1).getStockNr(), 0);
        assertEquals(testElectricVehicleList.get(2).getStockNr(), 19);


    }

    @Test
    public void ifNoVehiclesAreInStockTheCheckIfCarIsInStockMethodReturnsFalse() {

        List<ElectricVehicle> testElectricVehicleList = new ArrayList<>();

        testElectricVehicleList.add(new ElectricVehicle("Dacia", "1300", 40, 59, 244, false, true, 40000, 20));
        testElectricVehicleList.add(new ElectricVehicle("Oltcit", "Club", 41, 24, 232, true, false, 30000, 0));
        testElectricVehicleList.add(new ElectricVehicle("Lada", "Niva", 44, 23, 444, true, true, 20000, 20));

        Dealership d = new Dealership();

        assertEquals(d.checkIfCarIsInStock(testElectricVehicleList.get(1)), false);
    }

    @Test
    public void greenBonusProgramDoesNotGrantFundsWhenVehicleIsNotNew() throws IOException, ClassNotFoundException {

        ElectricVehicle testElectricVehicle = new ElectricVehicle("Oltcit", "Club", 41, 24, 232, true, false, 30000, 1);

        Dealership d = new Dealership();

        GreenBonusProgram g = new GreenBonusProgram();

        g.setFunds(10000);

        assertEquals(d.checkIfDealershipCanGrantFunds(testElectricVehicle), false);
    }

    @Test
    public void greenBonusProgramGrantsMoneyWhenFundsAreSufficient() throws IOException, ClassNotFoundException {

        ElectricVehicle testElectricVehicle = new ElectricVehicle("Oltcit", "Club", 41, 24, 232, true, true, 30000, 1);

        GreenBonusProgram g = new GreenBonusProgram();

        g.setFunds(10000);

        assertEquals(g.checkFundsForTest(), true);

    }


    @Test
    public void greenBonusProgramDoesNotGrantMoneyWhenFundsAreInsufficient() throws IOException, ClassNotFoundException {

        GreenBonusProgram g = new GreenBonusProgram();

        g.setFunds(200);

        assertEquals(g.checkFundsForTest(), false);
    }

}
