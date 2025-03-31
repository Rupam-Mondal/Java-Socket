import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

public class Simple_Thread_Client {
    public Simple_Thread_Client() throws Exception {
        Socket socket = new Socket("localhost", 3000);
        Scanner sc = new Scanner(System.in);
        System.out.println("Successfull connection");
        BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

        String msg = in_socket.readLine();
        System.out.println("server says = " + msg);
        String msg1 = sc.nextLine();
        out_socket.println(msg1);

        socket.close();
    }

    public static void main(String[] args) {
        try {
            new Simple_Thread_Client();
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }
}