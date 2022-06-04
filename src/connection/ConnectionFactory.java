/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.*;


/**
 *
 * @author Nilson
 */
//Classe para a conexão do banco de dados
//Aqui vai ficar o Conector para abrir a conexao e outros metodos para fechar as conexoes
public class ConnectionFactory {
    
    public static Connection conector(){
    
    Connection conexao = null;
        
    String DRIVER = "com.mysql.cj.jdbc.Driver";
    String URL = "jdbc:mysql://localhost:3306/livraria?zeroDateTimeBehavior=CONVERT_TO_NULL";
    String USER = "root";
    String PASS = "";
    
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USER, PASS);
            return conexao;
        } catch (Exception e) {
            System.out.println("Errro ao conectar "+ e.getMessage());
            return null;
        }
    
    }
    
    public static void closeConnection(Connection con){
             try {
                 
                if(con!=null){
                 con.close();
                }
             } catch (SQLException ex) {
                 java.util.logging.Logger.getLogger(ConnectionFactory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
             }
         
    }
    
    
    public static void closeConnection(Connection con, PreparedStatement stmt){
        
        closeConnection(con);
        
            try {
                if(stmt!=null){
                stmt.close();}
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(ConnectionFactory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            }
        
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        
        closeConnection(con,stmt);
            
            try {
                if(rs!=null){
                rs.close();}
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(ConnectionFactory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            }

    }
    
