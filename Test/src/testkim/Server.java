package testkim;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {    
    public static void main(String[] args) {
        // TODO code application logic here   
       Thread sst = new ServerThreads();
       sst.start();
       
   
       
    }
  

}
  class ServerThreads extends Thread{
        @Override
        public void run(){
            try {
                ServerSocket ss= new ServerSocket(4000);
                while(true){
                Socket s = ss.accept();
                    DataInputStream dis = new DataInputStream(s.getInputStream());
                    System.out.println(dis.readUTF());
                    DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                   dos.writeUTF("너무 하다.");
                   s.close();
                    
                }
                
            } catch (IOException ex){
                
            }
            
             }
        
    }
