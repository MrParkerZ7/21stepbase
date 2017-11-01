package code.stream.byte_stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataConsoleInputStream {

    public static void main(String[] args) {
        DataConsoleInputStream dcist = new DataConsoleInputStream();
        dcist.fileConsole("console-output.txt");
    }

    private void fileConsole(String path) {
        System.out.print("Input: ");
        try (BufferedInputStream buffIn = new BufferedInputStream(System.in);
             BufferedOutputStream buffOut = new BufferedOutputStream(new FileOutputStream(path))) {
            int in;
            while ((in = buffIn.read()) != -1 && ((char) in) != '\n') {
                System.out.print(in + " ");
                buffOut.write(in);
            }
        } catch (IOException e) {
            System.out.println("WHAT THE FUCK HAVE YOU DONE!!");
        }
    }
}
