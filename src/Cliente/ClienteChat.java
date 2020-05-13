package Cliente;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.net.*;  
import java.io.*;  
/**
 *
 * @author Dream-Pc
 */
public class ClienteChat {
    public static void main(String args[])throws Exception{  
        Socket s=new Socket("127.0.0.1",2556);  
        DataInputStream in=new DataInputStream(s.getInputStream());  
        DataOutputStream out=new DataOutputStream(s.getOutputStream());  
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  

        String mensaje1="",mensaje2="";  
        while(!mensaje1.equals("Termino")){  
            mensaje1=br.readLine();  
            out.writeUTF(mensaje1);  
            out.flush();  
            mensaje2=in.readUTF();  
            System.out.println("Server: "+mensaje2); 

        }  
    out.close(); 
    s.close();  
    } 
}