/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import connection.ConnectionFactory;
import model.bean.Livros;


/**
 *
 * @author Nilson
 */
//Classe responsánvel pela manipulação do banco de dados para a classe Livro
//Aqui vai ficar o CRUD
public class LivroDAO {
       
    public void create (Livros livro){
          //Conexão ao banco de dados 
          Connection conexao = ConnectionFactory.conector();
          PreparedStatement stmt = null;
        
        String sql = ("INSERT INTO livros (nome,autor,assunto,status)VALUES(?,?,?,?)");
        try{
        
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, livro.getNome());
            stmt.setString(2, livro.getAutor());
            stmt.setString(3, livro.getAssunto());
            stmt.setBoolean(4, Boolean.parseBoolean(livro.getStatus().toString()));
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso! ");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao salvar " + e);
        }finally{
               ConnectionFactory.closeConnection(conexao, stmt);
        }
        
    }
    
}
