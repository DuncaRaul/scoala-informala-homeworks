package ro.scii.java8;

import java.util.Comparator;

/**
 * @author x-RauL-x
 * This is a custom comparator that sorts the vehicles by price
 */
public class PriceComparator implements Comparator<ElectricVehicle> {

    @Override
    public int compare(ElectricVehicle o1, ElectricVehicle o2) {
        return (int) (o1.getPrice() - o2.getPrice());
    }
}
