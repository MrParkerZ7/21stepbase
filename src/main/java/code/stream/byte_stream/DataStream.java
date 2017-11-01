package code.stream.byte_stream;

import java.io.*;

public class DataStream {

    public static void main(String[] args) {
        DataStream ds = new DataStream();
        ds.dataInputStream("21day.txt", "21day-copy.txt");
    }

    void dataInputStream(String pathIn, String pathOut) {
        try (DataInputStream dataIn = new DataInputStream(new FileInputStream(pathIn));
             DataOutputStream dataOut = new DataOutputStream(new FileOutputStream(pathOut))) {
            byte[] data = new byte[512];
            while (dataIn.read(data) != -1)
                dataOut.write(data);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
