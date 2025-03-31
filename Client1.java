

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.*;

public class Client1 {
    public Client1() throws Exception {
        Socket socket = new Socket("127.0.0.1", 3000);
        Scanner sc = new Scanner(System.in);

        BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

        String msg = in_socket.readLine();
        System.out.println("Server says = " + msg);
        System.out.println("Say something = ");
        String msg1 = sc.nextLine();
        out_socket.println(msg1);
        
        out_socket.flush();
        socket.close();
    }

    public static void main(String[] args) {
        try {
            new Client1();
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }
}
