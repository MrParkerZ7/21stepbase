package code.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class NavinSocketClient {

    public static void main(String[] args) throws Exception {
        NavinSocketClient sc = new NavinSocketClient();
        sc.socketClientV1();
    }

    void socketClientV1() throws Exception {
        String ip = "localhost";
        int port = 8080; // 0-1023 to 65535
        Socket s = new Socket(ip, port);

        String str = "Navin Reddy";

        OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
        PrintWriter toSer = new PrintWriter(os);
        toSer.println(str); // or os.write(str);
        os.flush();

        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String answer = br.readLine();
        System.out.println("C: " + answer);

        os.close();
        toSer.close();
        s.close();
    }

}
