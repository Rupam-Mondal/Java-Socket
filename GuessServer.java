import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class GuessServer {
    public GuessServer() throws Exception{
        while(true){
            ServerSocket ss = new ServerSocket(3000);
            System.out.println("Server is started");
            while (true) {
                try {
                    Socket socket = ss.accept();
                    System.out.println("Server is Connected");

                    BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

                    int secret_number = (int) (Math.random() * 10 + 1);
                    while (true) {
                        out_socket.println("Guess a number[1 - 10] = ");
                        out_socket.flush();
                        int num = Integer.parseInt(in_socket.readLine());
                        if (num == secret_number) {
                            out_socket.println("You guessed correct");
                            out_socket.flush();
                            break;
                        }
                        out_socket.println("Wrong guess");

                        out_socket.flush();
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }
    public static void main(String[] args) {
        try {
            new GuessServer();
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }
}
