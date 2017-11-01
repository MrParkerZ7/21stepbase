package code.stream.byte_stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamThread {

    public static void main(String[] args) {
        FileStreamThread st = new FileStreamThread();

        Thread t1 = new Thread(() -> {
            st.fileInOut("4k.jpg", "4k-copy.jpg");
        });
        Thread t2 = new Thread(() -> {
            st.fileInOut("4k2.jpg", "4k2-copy.jpg");
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
            System.out.println("FileStream file successful++");
        } catch (InterruptedException e) {
            System.out.println("FileStream file failed!!");
        } finally {
            System.out.println("||FileStream finish||");
        }
    }

    void fileInOut(String pathIn, String pathOut) {
        try (FileInputStream fileIn = new FileInputStream(pathIn);
             FileOutputStream fileOut = new FileOutputStream(pathOut)) {
            byte[] data = new byte[512];
            while (fileIn.read(data) != -1)
                fileOut.write(data);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        } finally {
            System.out.println("Finish!!");
        }
    }
}
