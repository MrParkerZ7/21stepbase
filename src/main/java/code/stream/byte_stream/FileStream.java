package code.stream.byte_stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStream {

    public static void main(String[] args) {
        FileStream fs = new FileStream();
        fs.fileInOut("mind.png", "mind.jpg");
        fs.fileInOutByteArray("mind.png", "mind-copy.png");

    }

    private void fileInOut(String pathIn, String pathOut) {
        try (FileInputStream fileIn = new FileInputStream(pathIn);
             FileOutputStream fileOut = new FileOutputStream(pathOut)) {
            int in;
            while ((in = fileIn.read()) != -1)
                fileOut.write(in);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    void fileInOutByteArray(String pathIn, String pathOut) {
        try (FileInputStream fileIn = new FileInputStream(pathIn);
             FileOutputStream fileOut = new FileOutputStream(pathOut)) {
            byte[] data = new byte[512];
            while (fileIn.read(data) != -1)
                fileOut.write(data);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
