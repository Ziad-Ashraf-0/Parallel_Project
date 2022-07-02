/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import dao.DbOperations;

/**
 *
 * @author mohamedkhaled
 */
public class tables {
    
   /* public static void main(String[]args){
       
       
      try{
          String userTable="create table user(id int AUTO_INCREMENT primary key,name varchar(200),email varchar(200),mobileno varchar(15),password varchar(200),status varchar(20),UNIQUE(email))";
          DbOperations.setDataOrDelete(userTable, "user table created successfully");
          String adminDetails=  "insert into user(name,email,mobileno,password,status)values('admin','admin1@gmail.com','12345689100','123','true')";
          DbOperations.setDataOrDelete(adminDetails, "admin details added successfully");
          String categoryTable = "create table category(id int AUTO_INCREMENT primary key,name varchar(200))";
          DbOperations.setDataOrDelete(categoryTable, "category table created successfully");
          String ProductTable="create table product (id int AUTO_INCREMENT primary key,name varchar(200),category varchar(200),price varchar(200))";
          DbOperations.setDataOrDelete(ProductTable, "Product table created successfully");
          String billTable = "create table bill(id int  primary key,name varchar(200),mobileNumber varchar(200) ,email varchar(200), date varchar(50) ,total varchar(200),createdBy varchar(200) )";
          DbOperations.setDataOrDelete(billTable, "Bill table created successfully");
      }
      catch(Exception e)
      {
          JOptionPane.showMessageDialog(null,e);
      }
        
    
    
    
    }*/
    
}
