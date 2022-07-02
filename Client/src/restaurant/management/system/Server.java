/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.management.system;

import dao.CategoryDao;
import dao.DbOperations;
import dao.ProductDao;
import dao.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Product;
import model.User;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author 5442
 */
public class Server {

    private ServerSocket serverSocket;

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void startServer() throws IOException {

        try {
            System.out.println("Server Started!!!!");

            while (!serverSocket.isClosed()) {

                Socket socket = serverSocket.accept();
                System.out.println("A new client has connected");
                ClientHandler clientHandler = new ClientHandler(socket);
                Thread thread = new Thread(clientHandler);
                thread.start();

            }
        } catch (IOException e) {
             
        }
    }

    
}

class ClientHandler implements Runnable {

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    public static ArrayList<ClientHandler> clientHandlers = new ArrayList<ClientHandler>();
    private Socket socket;
    private PrintWriter out;
    private Scanner in;
    //private String clientUsername;

    public ClientHandler(Socket socket){
        try {
            this.socket = socket;
            this.out = new PrintWriter(socket.getOutputStream(), true);
            this.in = new Scanner(socket.getInputStream());
            clientHandlers.add(this);
            System.out.println("Number of Connected Clients: " + clientHandlers.size());
        } catch (IOException ex) {
            System.out.println("Connection closed");
               
        }
    }

    @Override
    public void run() {
        String input;

        while (socket.isConnected()) {
            
            
            input = in.nextLine();
            System.out.println(input);
            JSONObject json;
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            if (isNumeric(input)) {
                System.out.println("Received radius from client: " + input);
                double radius = Double.valueOf(input);
                double area = Math.PI * radius * radius;
                out.println(area);
            } else {
                JSONParser parser = new JSONParser();
                try {
                    json = (JSONObject) parser.parse(input);
                    String type = (String) json.get("type");
                    System.out.println(type);

                    /**
                     * **********************************************************CASE SignUP*******************************************************
                     */
                    if (type.equals("signup")) {

                        System.out.println("Accesing database");

                        User user = new User();
                        user.setName((String) json.get("name"));
                        user.setEmail((String) json.get("email"));
                        user.setMobileno((String) json.get("mobile"));
                        user.setPassword((String) json.get("password"));
                        UserDao.save(user);

                    }
                    /**
                     * **********************************************************CASE SignIn*******************************************************
                     */

                    if (type.equals("signin")) {

                        System.out.println("Accesing database");

                        String email = (String) json.get("email");
                        String password = (String) json.get("password");
                        User user = null;
                        System.out.println("Accesing database11");
                        
                        user = UserDao.login(email, password);
                        JSONObject json11 = new JSONObject();
                        if (user == null) {
                            json11.put("status", "false");
                            System.out.println(json11.toString());
                            out.println(json11.toString());
 
                        } else {
                            
                            json11.put("email", user.getEmail());
                            json11.put("balance", user.getBalance());
                            json11.put("status", "true");
                            System.out.println(json11.toString());
                            out.println(json11.toString());
                
                        }

                    }
                    /**
                     * **********************************************************Get Product By Category*******************************************************s
                     */
                    
                    if (type.equals("getProductByCategory")) {

                        System.out.println("Accesing database");

                        String category = (String) json.get("category");
                        
                        ArrayList<String>list=ProductDao.getAllRecordsByCategory1(category);
                        String arraylist = list.toString();
                        out.println(arraylist);
                        System.out.println("String: " + arraylist);
                        
                        
                       
                        
                        
                        

                    }
                    
                    
                    /**
                     * **********************************************************Category Fill******************************************************s
                     */
                    
                    if (type.equals("categoryfill")) {

                        System.out.println("Accesing database");

                        //String category = (String) json.get("category");
                        
                        ArrayList<String>list=CategoryDao.getAllRecords1();
                        String arraylist = list.toString();
                        out.println(arraylist);
                        System.out.println("String: " + arraylist);
                        
                        
                       
                        
                        
                        

                    }
                    
                    /**
                     * **********************************************************Get Product By Name*******************************************************
                     */
                    
                    if (type.equals("getProductByname")) {

                        System.out.println("Accesing database");

                        String productName = (String) json.get("productname");
                        Product product = ProductDao.getProductByname(productName);
                        
                        JSONObject json1 = new JSONObject();
                        json1.put("name",product.getName());
                        json1.put("price",product.getPrice());
                        
                        out.println(json1.toString());
                        //System.out.println("String: " + arraylist);
                       
                        
                        

                    }
                    
                    /**
                     * **********************************************************Filter Product By Name*******************************************************
                     */
                    
                    if (type.equals("filterProductByname")) {

                        System.out.println("Accesing database");

                        String category = (String) json.get("category");
                        String name = (String) json.get("name");
                        
                        ArrayList<String>list=ProductDao.filterProductByname1(name,category);
                        String arraylist = list.toString();
                        out.println(arraylist);
                        System.out.println("String: " + arraylist);
                        
                        
                        

                    }
                    
                    
                    /**
                     * **********************************************************Filter Product By Name*******************************************************
                     */
                    
                    if (type.equals("placeorder")) {

                        System.out.println("Accesing database");

                        String total = (String) json.get("total");
                        int value = Integer.parseInt(total);
                        String email = (String) json.get("email");
                        DbOperations.setDataOrDelete("UPDATE user SET wallet = wallet - '"+value+"' WHERE email='"+email+"'" , "Status Changed Successfully");
                        
                        
                        
                                   
                        
                        
                        

                    }
                    
                    /**
                     * **********************************************************ADD Balance*******************************************************
                     */
                    
                    if (type.equals("addbalance")) {

                        System.out.println("Accesing database");

                        String balance = (String) json.get("balance");
                        int value = Integer.parseInt(balance);
                        String email = (String) json.get("email");
                        DbOperations.setDataOrDelete("UPDATE user SET wallet = wallet + '"+value+"' WHERE email='"+email+"'" , "Status Changed Successfully");
                        
                        
                        
                                   
                        
                        
                        

                    }
                    
                    
                    /**
                     * **********************************************************Info*******************************************************
                     */
                    
                    if (type.equals("info")) {

                        System.out.println("Accesing database");

                        String email = (String) json.get("email");
                        
                        User user = null;
                        
                        
                        user = UserDao.login(email);
                        JSONObject json11 = new JSONObject();
                        if (user == null) {
                            json11.put("status", "false");
                            System.out.println(json11.toString());
                            out.println(json11.toString());
 
                        } else {
                            
                            json11.put("email", user.getEmail());
                            json11.put("mobile", user.getMobileno());
                            json11.put("name", user.getName());
                            json11.put("balance", user.getBalance());
                            System.out.println(json11.toString());
                            out.println(json11.toString());
                
                        }
                        
                        
                        
                        
                                   
                        
                        
                        

                    }
                    
                    
                    
                    
                    

                } catch (ParseException ex) {

                }

            }
            

        }
        
        

    }

    public void removeClientHandler() {
        clientHandlers.remove(this);
    }

}
