package ro.scii.java8;

import java.util.Comparator;

/**
 * @author x-RauL-x
 * This is a custom comparator that sorts the vehicles by range
 */
public class RangeComparator implements Comparator<ElectricVehicle> {
    @Override
    public int compare(ElectricVehicle o1, ElectricVehicle o2) {
        return o1.getRange() - o2.getRange();
    }
}
