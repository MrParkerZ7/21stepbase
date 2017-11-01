package code.stream.character_stream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharFileReaderWrite {

    public static void main(String[] args) {
        CharFileReaderWrite cfr = new CharFileReaderWrite();
        cfr.fileInOut();
    }

    private void fileInOut() {
        try (FileReader fileRe = new FileReader("21day.txt");
             FileWriter fileWr = new FileWriter("21day-copy.txt")) {
            char[] data = new char[512];
            while ((fileRe.read(data)) != -1) {
                fileWr.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
