import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Sender {

    public Sender() throws Exception{
        DatagramSocket socket = new DatagramSocket();
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("Enter msg = ");
            String msg = sc.nextLine();

            byte[] buffer = msg.getBytes();

            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("127.0.0.1"), 3000);
            socket.send(packet);

            buffer = new byte[1500];
            packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);

            String msg1 = new String(buffer).trim();
            System.out.println(msg1);
        }
    }
    public static void main(String[] args) {
        try {
            new Sender();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
