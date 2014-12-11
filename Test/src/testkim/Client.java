package testkim;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
	 public static void main(String[] args) {
	try {
	                Socket s1= new Socket("200.1.4.205",2015);
	                    DataOutputStream dos = new DataOutputStream(s1.getOutputStream());
	                    dos.writeUTF("너무 하다.");
	                    DataInputStream dis = new DataInputStream(s1.getInputStream());
	                    System.out.println(dis.readUTF());
	                   s1.close();
	                   
	                    
	                
	                
	}catch (IOException e1){
	                
	            }
	 }
	}