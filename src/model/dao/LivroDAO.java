/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import com.sun.jdi.connect.spi.Connection;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.ConnectionFactory;


/**
 *
 * @author Nilson
 */
public class LivroDAO {
    
    public void create (){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        //stmt = con.prepareStatement ("");
              
        
    }
    
}
