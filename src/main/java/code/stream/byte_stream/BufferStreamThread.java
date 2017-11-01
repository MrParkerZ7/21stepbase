package code.stream.byte_stream;

import java.io.*;

public class BufferStreamThread {

    public static void main(String[] args) {
        BufferStreamThread bis = new BufferStreamThread();
        Thread t1 = new Thread((() -> {
            bis.fileInOut("mind.png", "mind-copy.jpg");
        }));
        Thread t2 = new Thread(() -> {
            bis.fileInOut("4k.jpg", "4k-copy.jpg");
        });
        Thread t3 = new Thread(() -> {
            bis.fileInOut("4k2.jpg", "4k2-copy.jpg");
        });

        t1.start();
        t2.start();
        t3.start();
    }

    private void fileInOut(String pathIn, String pathOut) {
        try (BufferedInputStream buffIn = new BufferedInputStream(new FileInputStream(pathIn));
             BufferedOutputStream buffOut = new BufferedOutputStream(new FileOutputStream(pathOut))) {
            byte[] data = new byte[512];
            while (buffIn.read(data) != -1)
                buffOut.write(data);
            System.out.println("Finished!!");
        } catch (IOException e) {
            System.out.println("WHAT THE FUCK HAVE YOU DONE!!");
        }
    }
}
