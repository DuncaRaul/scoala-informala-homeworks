package ro.scii.java8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author x-RauL-x
 * This class is a reader for the green bonus program class
 */
public class GBPReader extends Reader {

    private BufferedReader reader;

    public GBPReader(BufferedReader reader) {
        this.reader = reader;
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        return 0;
    }

    public float readGBPFunds() {
        try {
            String line = reader.readLine();
            float funds = 0;
            while (line != null) {
                String[] tokens = line.split(",");
                float money = Float.parseFloat(tokens[0]);
                funds += money;
                line = reader.readLine();
            }
            return funds;
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }
}
