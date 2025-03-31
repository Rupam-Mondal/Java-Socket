package Simple_UDP;

import java.net.*;
import java.util.Scanner;

public class Receiver {
    public Receiver() throws Exception{
        DatagramSocket socket = new DatagramSocket(3000);
        System.out.println("Receiver is running");
        Scanner sc = new Scanner(System.in);

        byte[] buffer = new byte[1500];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        socket.receive(packet);

        String msg = new String(buffer).trim();
        System.out.println(msg);

        InetAddress ip = packet.getAddress();
        int port = packet.getPort();

        System.out.println("Enter message = ");
        String message = sc.nextLine();

        buffer = message.getBytes();


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