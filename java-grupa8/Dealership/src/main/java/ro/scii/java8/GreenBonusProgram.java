package ro.scii.java8;

import java.io.*;

/**
 * @author x-RauL-x
 * This class represents the green bonus program model
 */
public class GreenBonusProgram {


    private float funds;

    public float getFundsForTest() {
        return funds;
    }

    public float getFunds() throws IOException, ClassNotFoundException {
        GBPReader gbpReader = new GBPReader(new BufferedReader(new FileReader("GreenBonusProgramFunds.csv")));
        funds = gbpReader.readGBPFunds();
        gbpReader.close();
        return funds;
    }


    public boolean checkFunds() throws IOException, ClassNotFoundException {
        funds = getFunds();
        if ((funds - 10000) >= 0) {
            return true;
        } else return false;
    }

    public boolean checkFundsForTest() {
        funds = getFundsForTest();
        return (funds - 10000) >= 0;
    }


    public void subtractFunds() throws IOException, ClassNotFoundException {
        funds -= 10000;
        GBPWriter gbpWriter = new GBPWriter(new BufferedWriter(new FileWriter("GreenBonusProgramFunds.csv")));
        gbpWriter.writeFunds(funds);
        gbpWriter.flush();
        gbpWriter.close();
    }


    public void setFunds(float funds) {
        this.funds = funds;
    }
}
