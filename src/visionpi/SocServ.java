package visionpi;
import java.io.*;
import java.net.*;
public class SocServ extends Thread {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter responce;
    private BufferedReader inBuffedReader;
    
    private DatagramSocket socket;
    private byte[] buf = new byte[256];
    
    public SocServ()
    {
        try{
            socket = new DatagramSocket(1234);
        }
        catch(IOException ex)
        {
        }
    }
    public void run(){       
        try{
            boolean running = true;
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            while(running)
            {
                System.out.println("waiting for a reception"); 
                socket.receive(packet);
                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                packet = new DatagramPacket(buf, buf.length, address, port);
                String received = new String(packet.getData(), 0, packet.getLength());
                System.out.println("client sent: " + received);
                if (received.equals("end")) 
                {
                    System.out.println("client trying to end server");
                }
                buf[0] = 'X';
                socket.send(packet);
            }
        }
        catch(IOException ex)
        {
        }
        System.out.println("socketServer exiting Run");
    }
}
