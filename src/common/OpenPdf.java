/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author modyb
 */
public class OpenPdf {
    public static void openById(String id){
    
    try{
    if((new File ("C:\\Users\\khaled\\Desktop\\New folder (8)"+id+".pdf")).exists()){          //could be changed
    Process p=Runtime
            .getRuntime()
            .exec("rundll32 url.dll,FileProtocolHandler C:\\Users\\khaled\\Desktop\\New folder (8)"+id+".pdf");
    
    }else{
    JOptionPane.showMessageDialog(null,"File is not Exists");
    }
    
    }
    catch(Exception e){
    JOptionPane.showMessageDialog(null,e);
    
    }
    
    }
    
}
