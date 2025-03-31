import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class ServerThread implements Runnable{
    Socket socket;
    Server s;
    public ServerThread(Socket socket , Server s){
        this.socket = socket;
        this.s = s;
    }

    public void run(){
        try {
            int num = s.increment();
            BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            out_socket.println("Welcome!");
            out_socket.flush();
            String msg = in_socket.readLine();
            System.out.println("Client "+num+" says = "+msg);
            socket.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

public class Server{
    int count = 1;
    public Server() throws Exception{
        ServerSocket ss = new ServerSocket(3000);
        System.out.println("Server is wating");
        while(true){
            Socket socket = ss.accept();
            System.out.println("Client "+count+" connected");
            ServerThread server_Thread = new ServerThread(socket , this);
            Thread t1 = new Thread(server_Thread);
            t1.start();
        }
    }
    public int increment(){
        return count++;
    }
    public static void main(String[] args) {
        try {
            new Server();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}