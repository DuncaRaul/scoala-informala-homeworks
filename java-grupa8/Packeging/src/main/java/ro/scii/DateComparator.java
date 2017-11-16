package ro.scii;

import java.util.Comparator;

/**
 * @author x-RauL-x
 * This class sorts the packages list based on the delevery date
 */
public class DateComparator implements Comparator<Package> {
    @Override
    public int compare(Package o1, Package o2) {
        return o1.getDate().compareTo(o2.getDate());
    }
}
