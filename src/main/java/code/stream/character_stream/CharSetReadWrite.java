package code.stream.character_stream;

import java.io.*;

public class CharSetReadWrite {

    public static void main(String[] args) {
        fileReadWrite();
        fileReadWriteCustom();
    }

    private static void fileReadWrite() {
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream("charset-TIS620.txt"), "TIS620");
             OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("charset-UTF-8.txt"), "UTF-8")) {
            int in;
            while ((in = reader.read()) != -1) {
                writer.write(in);
                System.out.print((char) in);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void fileReadWriteCustom() {
        try (FileInputStream fileIn = new FileInputStream("charset-TIS620.txt");
             FileOutputStream fileOut = new FileOutputStream("charset-UTF-8.txt")) {
            byte[] data = new byte[512];
            String str;
            while (fileIn.read(data) != -1) {
                str = new String(data, "TIS620");
                data = str.getBytes("UTF-8");
                fileOut.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
