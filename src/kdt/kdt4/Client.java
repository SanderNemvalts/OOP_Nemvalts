package kdt.kdt4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client {

    static void main(String[] args) throws Exception {

        System.out.println("Attempting connect");
        try (Socket socket = new Socket("Localhost", 1337);
             DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
             DataInputStream dis = new DataInputStream(socket.getInputStream())) {
            System.out.println("\nConnection established");
            dos.writeInt(args.length);
            for (int i = 0; i < args.length; i++){
                dos.writeUTF(args[i]);
                String echo = dis.readUTF();
                System.out.println("Server : " + echo);
            }
        }
        System.out.println("\nprocess finished");
    }

}

