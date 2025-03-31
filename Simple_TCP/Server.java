import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.*;

public class  Server {
    public Server() throws Exception{
        ServerSocket ss = new ServerSocket(9090); //opening a new port
        System.out.println("Port 2020 is open");

        Socket socket = ss.accept();
        System.out.println("Client "+socket.getInetAddress());

        //I/O buffer


        BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()) , true);
        out_socket.println("welcome");

        String msg = in_socket.readLine();

        System.out.println("Client says = " + msg);

        socket.close();
        ss.close();
    }
    public static void main(String[] args) {
        try {
            new Server();
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }
}