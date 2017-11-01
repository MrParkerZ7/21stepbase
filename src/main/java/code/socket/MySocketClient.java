package code.socket;

import java.io.*;
import java.net.Socket;

public class MySocketClient {

    public static void main(String[] args) {
        MySocketClient msc = new MySocketClient();
        msc.sockClient();
    }

    void sockClient() {
        System.out.println("C: Client started..");
        try (Socket s = new Socket("localhost", 9999)) {
            inputFile("mind.png", s);
            s.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    void inputFile(String path, Socket s) {
        try (FileInputStream file = new FileInputStream(path);
             BufferedInputStream buffer = new BufferedInputStream(file);
             OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
             PrintWriter out = new PrintWriter(os)) {
            System.out.println("Output file start!!");
            try {
                while (true) {
                    out.print(buffer.read());
                    os.flush();
                    System.out.println(buffer.read());
                }
            } catch (EOFException e) {
                out.print(-1);
                out.close();
                os.close();
                buffer.close();
                file.close();
                s.close();
                System.out.println("C: Connection is ended");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
