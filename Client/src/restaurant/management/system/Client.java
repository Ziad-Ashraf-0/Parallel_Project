/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.management.system;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
import org.json.JSONObject;

/**
 *
 * @author zashr
 */
public class Client {
    private Socket socket;
    private PrintWriter out;
    private Scanner in;
    
    
    
    public Client(Socket socket){
        
            this.socket = socket;
        try {
             this.out = new PrintWriter(socket.getOutputStream(), true);
             this.in = new Scanner(socket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
           
            
            
        
    }
    
    
    
    public User Login(String email,String password){
        JSONObject obj = new JSONObject();      
        obj.put("type","login");
        obj.put("email",email);
        obj.put("password",password);
        System.out.println(obj.toString());
        out.println(obj.toString());
        
        
        String input = in.nextLine();               
        if (input.equalsIgnoreCase("true")){
            return new User();
        }
        return null;
                
    }
    
    
     public User SignUp(String email,String password){
        JSONObject obj = new JSONObject();      
        obj.put("type","login");
        obj.put("email",email);
        obj.put("password",password);
        System.out.println(obj.toString());
        out.println(obj.toString());
        
        
        
                
    }
    
    
    
    
}
