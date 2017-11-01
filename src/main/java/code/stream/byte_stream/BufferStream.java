package code.stream.byte_stream;

import java.io.*;

public class BufferStream {

    public static void main(String[] args) {
        BufferStream bs = new BufferStream();
        bs.fileInOut("mind.png", "mind-copy.jpg");
    }

    private void fileInOut(String pathIn, String pathOut) {
        try (BufferedInputStream buffIn = new BufferedInputStream(new FileInputStream(pathIn));
             BufferedOutputStream buffOut = new BufferedOutputStream(new FileOutputStream(pathOut))) {
            byte[] data = new byte[512];
            while (buffIn.read(data) != -1)
                buffOut.write(data);
        } catch (IOException e) {
            System.out.println("WHAT HAVE YOU DONE!!");
        }
    }
}
