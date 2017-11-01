package code.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MySocketServer {

    public static void main(String[] args) {
        MySocketServer mss = new MySocketServer();
        mss.sockServer("mind-copy.png");
    }

    void sockServer(String path) {
        System.out.println("S: Server started..");
        try (
                ServerSocket ss = new ServerSocket(9999);
                FileOutputStream file = new FileOutputStream(path);
                BufferedOutputStream buff = new BufferedOutputStream(file)
        ) {
            Socket s = ss.accept();
            try (BufferedReader buffer = new BufferedReader(new InputStreamReader(s.getInputStream()))) {
                System.out.println("S: Start stream file++");
                while (true) {
                    buff.write(buffer.read());
                    System.out.println(buffer.read());
                    s.setSoTimeout(10000);
                    if (buffer.read() == -1) {
                        buffer.close();
                        buff.close();
                        file.close();
                        System.out.println("Output from client finish++");
                        break;
                    }
                    OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
                    PrintWriter out = new PrintWriter(os);
                    out.print("Next+");

                    s = ss.accept();
                }
            }
            s.close();
            ss.close();
            System.out.println("S: Connection is ended");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
