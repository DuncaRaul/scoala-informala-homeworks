package ro.scii.java8;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author x-RauL-x
 * This class is a writer for the green bonus program class
 */
public class GBPWriter extends Writer {

    private BufferedWriter writer;

    public GBPWriter(BufferedWriter writer) {
        this.writer = writer;
    }

    public void writeFunds(float p) throws IOException, ClassNotFoundException {
        String serializedFunds = String.valueOf(p);
        try {
            writer.write(serializedFunds);
        } catch (IOException e) {
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
