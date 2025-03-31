import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
    public Server1() throws Exception {
        ServerSocket ss = new ServerSocket(3000);
        System.out.println("Server started waiting for client");
        Socket socket = ss.accept();
        System.out.println("Client connected");

        BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

        out_socket.println("Hi client! welcome.");
        out_socket.flush();

        String msg = in_socket.readLine();
        System.out.println("Client says:-" + msg);
        socket.close();
        ss.close();
    }

    public static void main(String[] args) {
        try {
            new Server1();
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }
}
