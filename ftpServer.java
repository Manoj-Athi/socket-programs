import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ftpServer extends Thread {
    public static void main(String args[]) throws IOException{
        ServerSocket ss = new ServerSocket(6666);
        Socket s = ss.accept();
        DataInputStream dis = new DataInputStream(s.getInputStream());
        FileOutputStream fos = new FileOutputStream("demo2.txt");
        byte buffer[] = new byte[4096];
        int fs = 15123;
        int read = 0;
        int total_read = 0;
        int remaining = fs;
        while ((read = dis.read(buffer, 0, Math.min(buffer.length, remaining))) > 0) {
            total_read += read;
            remaining -= read;
            System.out.println("read" + total_read + "byte");
            fos.write(buffer, 0, read);
        }
        fos.close();
        dis.close();
    }
}

