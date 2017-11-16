package ro.scii;

import java.util.Comparator;

/**
 * @author x-RauL-x
 * This class sorts the packages list based on the delevery location
 */
public class LocationComparator implements Comparator<Package> {

    @Override
    public int compare(Package o1, Package o2) {
        return o1.getTargetLocation().compareTo(o2.getTargetLocation());
    }
}