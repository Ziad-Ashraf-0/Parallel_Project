/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.User;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author mohamedkhaled
 */
public class UserDao {
    
public static void save(User user){
    {
        String query="insert into user(name,email,mobileno,password,status) values('"+user.getName()+"','"+user.getEmail()+"','"+user.getMobileno()+"','"+user.getPassword()+"','true')";
        DbOperations.setDataOrDelete(query, "Registered Successfully wait for admin approval");
    }
}
    
    public static User login(String email,String password)
    {
        User user=null;
        try{
            ResultSet rs = DbOperations.getData("select *from user where email='"+email+"' and password='"+password+"'");
            while(rs.next())
            {
                user =new User();
                user.setStatus(rs.getString("status"));
                user.setEmail(rs.getString("email"));
                user.setBalance(rs.getString("wallet"));
                
                
            }
            
        }
        
           
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return user;
        
    }
    
 
    
    
    
    public static ArrayList<User> getAllRecords(String email) {
        ArrayList<User> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("select *from user where email like'%"+email+"%'");
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setMobileno(rs.getString("mobileno"));
                user.setStatus(rs.getString("status"));
                arrayList.add(user);
            }
                  
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    public static void changeStatus(String email,String status){
      
       String query = "update user set status='"+status+"' where email='"+email+"'";
       DbOperations.setDataOrDelete(query, "Status Changed Successfully");
              
    }
    
}

