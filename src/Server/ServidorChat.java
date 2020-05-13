/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;


import java.net.*;  
import java.io.*;  

import java.io.PrintWriter;
/**
 *
 * @author Dream-Pc
 */
public class ServidorChat {
    public static void main(String args[])throws Exception{
        
            ServerSocket servidor=new ServerSocket(5050);  
            Socket s = servidor.accept();  
            DataInputStream in = new DataInputStream(s.getInputStream());  
            DataOutputStream out = new DataOutputStream(s.getOutputStream());  
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));  

            String mensaje1="",mensaje2="";  
            
            String Final = null;
            
            while(!mensaje1.equals("Termino")){  
                mensaje1=in.readUTF();  
                System.out.println("Cliente: "+mensaje1);  
                mensaje2=bf.readLine();  
                out.writeUTF(mensaje2);  
                out.flush();  
             
                if(Final == null){
                    Final = "Cliente: "+mensaje1+"\n"+"Servidor: "+mensaje2+"\n";
                }else{
                    Final = Final +"Cliente: "+mensaje1+"\n"+"Servidor: "+mensaje2+"\n";
                  
                }
            }
            
        in.close();  
        s.close();  
        servidor.close();
        int i = 1;
        String ruta = "g:/PruebasChat_"+ i +".txt";
        File archivo = new File(ruta);      
        
        do{
            ++i;
            ruta = "g:/PruebasChat_"+ i +".txt";
            archivo = new File(ruta);
        }while (archivo.exists());
        
        PrintWriter writer = new PrintWriter("g:/PruebasChat_"+ i +".txt", "UTF-8");
        writer.println(Final);
        writer.close();
    }
}