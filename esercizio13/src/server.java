import java.io.*;
import java.net.*;
import java.sql.Date;

public class server {
    public static void main(String[] args) throws Exception {

        ServerSocket server=new ServerSocket(6666);  
        Socket clientSocket = server.accept();
        ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());

        while(true)
        {
            String request = (String) in.readObject();
            System.out.println(request);
            if(request != null)
            {
                out.writeObject(Long.toString(secondsBetween()));
            }
        }

    }

    public static long secondsBetween()
    {
        long seconds = System.currentTimeMillis()/1000;
        return seconds;
    }
}