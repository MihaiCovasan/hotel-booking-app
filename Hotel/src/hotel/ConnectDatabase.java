/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author ghene
 */
public class ConnectDatabase {
    Connection conn = ConnectDatabase.ConecrDb();
    
    Connection connex = null;
    
     static Connection ConecrDb(){

    try {
    
        Class.forName("com.mysql.jdbc.Driver");
        Connection connex = DriverManager.getConnection("jdbc:mysql://localhost:4000/hotel", "root", "");
    
      return connex;
          
        }catch (Exception e){
                JOptionPane.showMessageDialog(null,e);
                  return null;
        }
}
    
}
