import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


class Server_Thread implements Runnable{
    Socket socket;
    Simple_Thread_Server obj;
    public Server_Thread(Socket socket , Simple_Thread_Server obj){
        this.socket = socket;
        this.obj = obj;
    }

    public void run(){
        try {
            obj.count();
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
    int clientNumber = 1;
    public Simple_Thread_Server() throws Exception{
        ServerSocket ss = new ServerSocket(3000);
        System.out.println("Server started");

        while(true){
            Socket socket = ss.accept();
            System.out.print("Client connected = "+clientNumber);
            Server_Thread server_Thread = new Server_Thread(socket , this);
            Thread newThread = new Thread(server_Thread);
            newThread.start();
        }
    }
    public int count(){
        return clientNumber++;
    }
    public static void main(String[] args) {
        try {
            new Simple_Thread_Server();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
