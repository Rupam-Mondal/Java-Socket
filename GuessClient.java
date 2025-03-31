import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class GuessClient {
    public GuessClient() throws Exception{
        Socket socket = new Socket("localhost" , 3000);
        Scanner sc = new Scanner(System.in);
        System.out.println("Client side started");
        BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        
        while(true){
            System.out.println(in_socket.readLine());
            String msg = sc.nextLine();
            out_socket.println(msg);
            out_socket.flush();
            String msg1 = in_socket.readLine();
            System.out.println(msg1);
            if(msg1.equals("You guessed correct")){
                out_socket.println("Thanks");
                break;
            }
        }
        sc.close();
        socket.close();
    }
    public static void main(String[] args) {
        try {
            new GuessClient();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
