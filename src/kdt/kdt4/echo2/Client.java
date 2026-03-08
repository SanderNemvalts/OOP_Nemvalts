package kdt.kdt4.echo2;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        for (int connectionAttempt = 0; connectionAttempt < 3;){ // loop et ühendust uuesti proovida, kui ei vota; loob uue yhenduse requesti ja uue porti

        int port = 0;
        String dataDir = "data/kdt4/echo2/received";
        dataDir = dataDir.replace('/', File.separatorChar).replace('\\', File.separatorChar);


        try (Socket socket = new Socket("localhost", 8080);
             DataInputStream dis = new DataInputStream(socket.getInputStream())
        ){
            if (dis.readInt() == 0) port = dis.readInt();
        } catch (IOException e) {System.out.println("server offline");}

        if (port == 0) return;
        try (Socket socket = new Socket("localhost", port);
             DataInputStream dis = new DataInputStream(socket.getInputStream());
             DataOutputStream dos = new DataOutputStream(socket.getOutputStream())
        ) {
            int messageCount = args.length / 2;
            dos.writeInt(messageCount);
            if (dis.readInt() == -1) return; //ERROR

            for (int i=0; i<messageCount; i++) {
                if (args[2*i].equals("echo")) {
                    dos.writeInt(2); // ECHO
                    dos.writeUTF(args[2*i+1]);

                    if (dis.readInt() == -1) return; // ERROR
                    String echo = dis.readUTF();
                    if (!echo.equals(args[2*i+1])) {dos.writeInt(-1);return;} // ERROR

                } else if (args[2*i].equals("file")) {

                    dos.writeInt(3); // FILE
                    dos.writeUTF(args[2*i+1]);
                    if (dis.readInt() == -1) return; //error


                    int dataLen = dis.readInt();
                    byte[] data = new byte[dataLen];
                    dis.readFully(data);

                    try (
                            FileOutputStream fos = new FileOutputStream(
                            dataDir+File.separatorChar+"p"+port+args[2*i+1]);
                    ) {
                        fos.write(data);
                    }
                }
            } return;

        } catch (IOException e) {connectionAttempt++;}
    }
        System.out.println("Connection failed after 3 attempts");
    }
}
