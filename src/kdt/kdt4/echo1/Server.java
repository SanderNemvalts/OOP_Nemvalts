package kdt.kdt4.echo1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

    static void main(String[] args) throws Exception{

        try (ServerSocket ss = new ServerSocket(1337)){
            System.out.println("live on socket 1337");
            for (int i = 0; i < 10; i++) {

                try (Socket socket = ss.accept();
                     DataInputStream dis = new DataInputStream(socket.getInputStream());
                     DataOutputStream dos = new DataOutputStream(socket.getOutputStream())
                ){
                    System.out.println("\nClient connected");
                    int messageCount = dis.readInt();
                    System.out.println("reading " + messageCount + " messages\n");
                    for (int j = 0; j < messageCount; j++) {
                        String message = dis.readUTF();
                        System.out.print(message + " | ");
                        dos.writeUTF(message);
                    }
                }
                System.out.println("\nClient handled");
            }
        }
        System.out.println("\nprocess finished");
    }
}
