/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.util.ArrayList;
import model.Category;
import java.sql.*;
import javax.swing.JOptionPane;
       
/**
 *
 * @author khaled
 */
public class CategoryDao {
    public static void save(Category category){
        String query ="insert into category(name) values('"+category.getName()+"')";
        DbOperations.setDataOrDelete(query,"Category added seccessfully");
    }
    public static ArrayList<Category> getAllRecords(){
        ArrayList<Category> arrayList = new ArrayList<>();
        try{
           ResultSet rs =DbOperations.getData("select *from category");
         while(rs.next())
         {
             Category category = new Category();
             category.setId(rs.getInt("id"));
             category.setName(rs.getString("name"));
             arrayList.add(category);
        }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
    }
        return arrayList;
    } 
    
    
    
    public static ArrayList<String> getAllRecords1(){
        ArrayList<String> arrayList = new ArrayList<>();
        try{
           ResultSet rs =DbOperations.getData("select *from category");
         while(rs.next())
         {
             //Category category = new Category();
             //category.setId(rs.getInt("id"));
             //category.setName(rs.getString("name"));
             arrayList.add(rs.getString("name"));
        }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
    }
        return arrayList;
    } 

    
    public static void delete(String id) {
        String query = "delete from category where id='"+id+"'";
        DbOperations.setDataOrDelete(query,"Category deleted Successfully");
        
    }
}
