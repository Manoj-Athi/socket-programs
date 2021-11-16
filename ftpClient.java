import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class ftpClient {
    public static void main(String args[]) throws IOException {
        Socket s = new Socket("localhost", 6666);
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        FileInputStream fis = new FileInputStream("test.txt");
        byte buffer[] = new byte[4096];
        int read;
        while((read = fis.read(buffer)) > 0){
            dos.write(buffer, 0, read);
        }
        fis.close();
        dos.close();
    }
}
