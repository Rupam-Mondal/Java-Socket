import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


class Server_Thread implements Runnable{
    Socket socket;
    public Server_Thread(Socket socket){
        this.socket = socket;
    }

    public void run(){
        try {
            BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            out_socket.println("welcome");

            String msg = in_socket.readLine();

            System.out.println("Client says = " + msg);

            socket.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
public class Simple_Thread_Server {
    public Simple_Thread_Server() throws Exception{
        ServerSocket ss = new ServerSocket(3000);
        System.out.println("Server started");

        while(true){
            Socket socket = ss.accept();
            System.out.print("Client connected");
            Server_Thread server_Thread = new Server_Thread(socket);
            Thread newThread = new Thread(server_Thread);
            newThread.start();
        }
    }
    public static void main(String[] args) {
        try {
            new Simple_Thread_Server();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
