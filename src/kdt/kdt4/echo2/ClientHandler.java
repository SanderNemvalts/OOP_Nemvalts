package kdt.kdt4.echo2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;

public class ClientHandler implements Runnable {

    private final int port;
    private String dataDir;

    public ClientHandler(int port) {
        this.port = port;

        dataDir = "data/kdt4/echo2/server";
        dataDir = dataDir.replace('/', File.separatorChar).replace('\\', File.separatorChar);
    }

    @Override
    public void run() {

        try (ServerSocket ss = new ServerSocket(port);
             Socket socket = ss.accept(); // siinkohal, kui klient ei ühendu (tekib mingi ootamatu probleem) siis blockib thread siin igavesti. Saaks lahendada ss.setSoTimeout(), aga mul läks kiireks :/
             DataInputStream dis = new DataInputStream(socket.getInputStream());
             DataOutputStream dos = new DataOutputStream(socket.getOutputStream())
        ) {
            int requestCount = dis.readInt();
            if (requestCount < 1) {
                dos.writeInt(-1);
                return;
            } // ERROR
            dos.writeInt(0);//OK

            for (int i = 0; i < requestCount; i++) {
                int requestType = dis.readInt();
                if (requestType == -1) return;// clientside ERROR

                if (requestType == 2) {/*ECHO*/
                    String data = dis.readUTF();
                    dos.writeInt(0); // OK
                    dos.writeUTF(data);
                    System.out.println("echoed " + data + " on port " + port);

                } else if (requestType == 3) {/*FILE*/
                    String fname = dis.readUTF();
                    Path path = Path.of(dataDir, fname).toAbsolutePath();

                    if (path.isAbsolute() && Files.isRegularFile(path)) {
                        byte[] data = Files.readAllBytes(path);
                        dos.writeInt(0); // OK
                        dos.writeInt(data.length);
                        dos.write(data);
                        System.out.println("wrote file " + fname + " on port " + port);

                    } else {dos.writeInt(-1);return;} // ERROR
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
