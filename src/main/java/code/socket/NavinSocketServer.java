package code.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class NavinSocketServer {

    public static void main(String[] args) throws Exception {
        NavinSocketServer ss = new NavinSocketServer();
        for (int i = 0; i < 2; i++)
            ss.socketServerV1();
    }

    void socketServerV1() throws Exception {
        System.out.println("S: Server is started");
        ServerSocket ss = new ServerSocket(8080);

        ss.setSoTimeout(30000);
        System.out.println("S: SetTimeout 30 second");

        System.out.println("S: Server is waiting for client request");
        Socket s = ss.accept();

        System.out.println("S: Client Connected");

        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String getCli = br.readLine();
        System.out.println("S: Client Data : " + getCli);

        OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
        PrintWriter toCli = new PrintWriter(os);
        toCli.println("Hello " + getCli);
        os.flush();
        System.out.println("S: Data has been send to client!!");


        br.close();
        s.close();
        ss.close();
    }
}
