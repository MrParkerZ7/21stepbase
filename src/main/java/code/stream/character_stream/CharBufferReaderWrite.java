package code.stream.character_stream;

import java.io.*;

public class CharBufferReaderWrite {

    public static void main(String[] args) {
        CharBufferReaderWrite cbr = new CharBufferReaderWrite();
        cbr.fileInOut();
    }

    private void fileInOut() {
        try (BufferedReader buffRe = new BufferedReader(new FileReader("21day.txt"));
             BufferedWriter buffWr = new BufferedWriter(new FileWriter("21day-copy.txt"))) {
            String str;
            while ((str = buffRe.readLine()) != null) {
                buffWr.write(str);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
