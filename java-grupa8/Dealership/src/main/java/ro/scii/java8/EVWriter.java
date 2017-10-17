package ro.scii.java8;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author x-RauL-x
 * This class is a writer for the CSV file where all the information about the cars is stored
 */
public class EVWriter extends Writer {

    private BufferedWriter writer;

    public EVWriter(BufferedWriter writer) {
        this.writer = writer;
    }

    public void writeVehicles(ElectricVehicle v) {
        String serializedVehicle = v.getManufacturer() + "," + v.getVehicleModel() + "," + v.getMotorPower() + "," +
                v.getBatteryCapacity() + "," + v.getRange() + "," + v.isHasFastCharging() +  "," + v.isNew() +  "," + v.getPrice() + "," + v.getStockNr();
        try {
            writer.write(serializedVehicle);
            writer.newLine();
        } catch (IOException e) {
            // TODO - think about error handling
            e.printStackTrace();
        }
    }


    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {

    }

    @Override
    public void flush() throws IOException {
        writer.flush();

    }

    @Override
    public void close() throws IOException {
        writer.close();
    }
}

