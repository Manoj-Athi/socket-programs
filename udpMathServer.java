import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.StringTokenizer;

class udpMathServer {

    public static void main(String[] args)
            throws IOException
    {

        DatagramSocket ds = new DatagramSocket(1234);

        byte[] buf = null;

        DatagramPacket DpReceive = null;
        DatagramPacket DpSend = null;

        while (true) {
            buf = new byte[65535];

            DpReceive = new DatagramPacket(buf, buf.length);

            ds.receive(DpReceive);

            String inp = new String(buf, 0, buf.length);

            inp = inp.trim();

            System.out.println("Equation Received:- "
                    + inp);

            if (inp.equals("bye")) {
                System.out.println(
                        "Client sent bye.....EXITING");

                break;
            }

            StringTokenizer st = new StringTokenizer(inp);

            String operation = st.nextToken();
            int oprnd1, oprnd2, result = 0;
            if (operation.equals("sum")){
                oprnd1 = Integer.parseInt(st.nextToken());
                oprnd2 = Integer.parseInt(st.nextToken());
                result = oprnd1 + oprnd2;
            }
            else if (operation.equals("product")) {
                oprnd1 = Integer.parseInt(st.nextToken());
                oprnd2 = Integer.parseInt(st.nextToken());
                result = oprnd1 * oprnd2;
            }
            else if (operation.equals("negate")) {
                oprnd1 = Integer.parseInt(st.nextToken());
                result = -oprnd1;
            }


            System.out.println("Sending the result...");
            String res = Integer.toString(result);
            buf = res.getBytes();
            int port = DpReceive.getPort();

            DpSend = new DatagramPacket(
                    buf, buf.length, InetAddress.getLocalHost(),
                    port);
            ds.send(DpSend);
        }
    }
}