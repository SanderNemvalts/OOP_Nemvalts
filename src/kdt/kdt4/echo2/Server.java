package kdt.kdt4.echo2;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    static void main() {

        try (ServerSocket mainSocket = new ServerSocket(8080)) {

            int j=0;
            while (true) {
                int port;

                try (Socket socket = mainSocket.accept();
                     DataOutputStream dos = new DataOutputStream(socket.getOutputStream())
                ) {
                    dos.writeInt(0); // OK
                    port = 7500 + j;  // valin porte üsna halvav viisil :P
                    dos.writeInt(port);
                    System.out.println("directed client to port " + port);
                }
                new Thread(new ClientHandler(port)).start();

                j++;
                if (j>300) j=0;
            }

        } catch (IOException e) {throw new RuntimeException(e);}
    }

}

