package ro.scii.java8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author x-RauL-x
 * This class is a reader for the CSV file where all the information about the cars is stored
 */
public class EVReader extends Reader {

    private BufferedReader reader;

    public EVReader(BufferedReader reader) {
        this.reader = reader;
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        return reader.read(cbuf, off, len);
    }

    public List<ElectricVehicle> readVehicles() {
        try {
            String line = reader.readLine();
            List<ElectricVehicle> vehicles = new ArrayList<>();
            while (line != null) {
                String[] tokens = line.split(",");
                String manufacturer = tokens[0];
                String model = tokens[1];
                double motorPower = Double.parseDouble(tokens[2]);
                float batteryCapacity = Float.parseFloat(tokens[3]);
                int range = Integer.parseInt(tokens[4]);
                boolean hasFastCharging = Boolean.parseBoolean(tokens[5]);
                boolean isNew = Boolean.parseBoolean(tokens[6]);
                float price = Float.parseFloat(tokens[7]);
                int stock = Integer.parseInt(tokens[8]);
                ElectricVehicle v = new ElectricVehicle(manufacturer, model, motorPower, batteryCapacity, range, hasFastCharging, isNew, price, stock);
                vehicles.add(v);
                line = reader.readLine();
            }
            return vehicles;
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return Collections.emptyList();
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }
}
