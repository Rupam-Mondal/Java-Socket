import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.*;
import java.nio.Buffer;

public class Client {
    public Client() throws Exception{
        Socket socket = new Socket("localhost" , 9090);
        System.out.println("Successfull connection");
        BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()) , true);


        String msg = in_socket.readLine();
        System.out.println("server says = "+msg);
        out_socket.println("Thanks!");

        socket.close();
    }
    public static void main(String[] args) {
        try {
            new Client();
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }
}
