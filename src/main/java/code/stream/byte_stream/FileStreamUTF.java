package code.stream.byte_stream;

import java.io.*;

public class FileStreamUTF {

    public static void main(String[] args) {
        FileStreamUTF fd = new FileStreamUTF();
        fd.fileOut("MyReviewCodeFileStream.txt");
        fd.fileIn("MyReviewCodeFileStream.txt");
    }

    void fileOut(String path) {
        try (DataOutputStream data = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(path)))) {
            data.writeUTF(" My name is John \n My wife leave me alone \n My dick were dead \n I feel lonely \n Can't event slide my dick! \n");
            data.writeUTF("My name is Jeff \n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void fileIn(String path) {
        try (DataInputStream data = new DataInputStream(new BufferedInputStream(new FileInputStream(path)))) {
            try {
                while (true) {
                    String str = data.readUTF();
                    System.out.println(str);
                }
            } catch (EOFException e) {
                System.out.println("Finish!!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
