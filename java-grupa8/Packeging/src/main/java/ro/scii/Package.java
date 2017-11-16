package ro.scii;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Package {
    private String targetLocation;
    private int distanceToTarget;
    private float merchValue;
    private Date date;
    private int ID;

    public Package(String targetLocation, int distanceToTarget, float merchValue, Date date, int ID) {
        this.targetLocation = targetLocation;
        this.distanceToTarget = distanceToTarget;
        this.merchValue = merchValue;
        this.date = date;
        this.ID = ID;
    }

    public Package() {
    }

    ;

    public void delivery(Package pack) {
        System.out.println("Package " + pack.getID() + " has been delivered");
    }


    public String getTargetLocation() {
        return targetLocation;
    }

    public int getDistanceToTarget() {
        return distanceToTarget;
    }

    public float getMerchValue() {
        return merchValue;
    }

    public Date getDate() {
        return date;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "Package{" +
                "targetLocation='" + targetLocation + '\'' +
                ", distanceToTarget=" + distanceToTarget +
                ", merchValue=" + merchValue +
                ", deliveryDate='" + date + '\'' +
                ", ID=" + ID +
                '}';
    }
}
