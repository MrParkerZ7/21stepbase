package code.stream.byte_stream;

import java.io.*;

public class DataStreamThread {

    public static void main(String[] args) {
        DataStreamThread dst = new DataStreamThread();
        Thread t1 = new Thread(() -> {
            dst.fileInOut("21day.txt", "21day-copy.txt");
        });
        Thread t2 = new Thread(() -> {
            dst.fileInOut("data-stream.txt", "data-stream-copy.txt");
        });

        t1.start();
        t2.start();
    }

    synchronized void fileInOut(String pathIn, String pathOut) {
        try (DataInputStream dataIn = new DataInputStream(new FileInputStream(pathIn));
             DataOutputStream dataOut = new DataOutputStream(new FileOutputStream(pathOut))) {
            byte[] data = new byte[512];
            while (dataIn.read(data) != -1)
                dataOut.write(data);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
