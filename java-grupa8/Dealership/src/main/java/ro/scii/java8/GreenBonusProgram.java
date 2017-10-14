package ro.scii.java8;

/**
 * @author x-RauL-x
 * This class will be implemented in future versions
 */
public class GreenBonusProgram {

    private float budget = 100000.0f;

    /**
     * This method checks if the GreenBonusProgram has enough funds.
     *
     * @return Returns true if funds are sufficient, and false if funds are insufficient.
     */
    public boolean checkBudget() {
        if ((budget - 10000) >= 0) {
            budget = budget - 10000;
            return true;
        } else return false;
    }
}
