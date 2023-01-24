
import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

public class client {
    public static void main(String[] args) throws Exception {

        try{      
            Socket server=new Socket();  
            server.connect(new InetSocketAddress("localhost", 6666), 1000);
            ObjectOutputStream outputStream = new ObjectOutputStream(server.getOutputStream());
            ObjectInputStream inputstream = new ObjectInputStream(server.getInputStream());

            Scanner scan = new Scanner(System.in);     

            while (true) {
                try{
                    String command = scan.nextLine();
                    outputStream.writeObject(command);
                    String response = (String) inputstream.readObject();
                    System.out.println(response);
                }
                catch(SocketTimeoutException e)
                {
                    System.out.println("timeout");
                }

            }

        }
        catch(Exception e){System.out.println(e);}  

            
    }

    public void sendData() {
        
    }
    
}

