package visionpi;
import java.io.*;
import java.net.*;
import java.util.concurrent.Semaphore;

public class SocClient extends Thread {
   // private DatagramSocket socket;
    private String addr;
    private int port;
    private String string2Send = "hello";
    private boolean sendRequest = false;
    private int stringLenCopy = 0;   //string length not working during send - try a copy
    
    public SocClient(String inAddr, int inPort)
    {
    //    try{
            addr = inAddr;
    //        socket = new DatagramSocket(inPort);
            port = inPort;
    //    }
    //    catch(IOException ex)
    //   {
    //    }
    }
    public void send(String str)
    {
        stringLenCopy = str.length();
        string2Send =str;
        sendRequest=true;
    }
    //todo: don't create and close socket every packet - keep it open
    public void run(){       
        try{                //This try needed for new DatagramSocket();
            while(true){                
                if(sendRequest)//wait for send request
                {
                    DatagramSocket clientSocket = new DatagramSocket();
                    InetAddress IPAddress = InetAddress.getByName(addr);

                    byte[] sendData = new byte[1024];
                    sendData = (string2Send + "*").getBytes();
                  //  System.err.println("len " + string2Send.length());
                  //  sendData[sendData.length-1] = '*';//hack together a sting term to solve issue on server end
                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                  //  System.out.println("len =  " + sendData.length);                     
                    clientSocket.send(sendPacket);
              //      System.out.println("data sent to server ");
                    clientSocket.close();
                    sendRequest=false; //clear send request
                }
                try{
                    Thread.sleep(10);//don't waste CPU
                }
                catch(Exception e){
                }
            }
        }
        catch(IOException ex)
        {
        }
        System.out.println("socClient exiting Run");
    }
}