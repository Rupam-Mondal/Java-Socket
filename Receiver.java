import java.net.*;
import java.util.Scanner;

public class Receiver {
    public Receiver() throws Exception{
        DatagramSocket socket = new DatagramSocket(3000);
        Scanner sc = new Scanner(System.in);
        System.out.println("Server started");

        byte[] buffer = new byte[1500];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);

        String msg = new String(buffer).trim();
        System.out.println(msg);

        InetAddress ip = packet.getAddress();
        int port = packet.getPort();
        System.out.println("Say something");
        String msg1 = sc.nextLine();

        buffer = msg1.getBytes();
        packet = new DatagramPacket(buffer, buffer.length , ip , port);

        socket.send(packet);

    }
    public static void main(String[] args) {
        try {
            new Receiver();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
