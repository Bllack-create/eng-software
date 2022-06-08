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
import java.util.ArrayList;
import java.util.List;
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
    
    public List<Livros> read(){
        
       //Conexão ao banco de dados 
       Connection conexao = ConnectionFactory.conector();
       PreparedStatement stmt = null;
       ResultSet rs = null;
       
       List<Livros> livros = new ArrayList<>();
          
      try{
      stmt = conexao.prepareStatement("SELECT * FROM Livros");
      rs = stmt.executeQuery();
      
      while(rs.next()){
      
          Livros livro = new Livros();
          
          livro.setId(rs.getInt("idLivro"));
          livro.setNome(rs.getString("nome"));
          livro.setAutor(rs.getString("autor"));
          livro.setAssunto(rs.getString("assunto"));
          livro.setStatus(rs.getBoolean("status"));
          
          //Adicionando os valores vindos do banco dentro de uma lista
          //para que possa ser feito a leitura dos valores.
          livros.add(livro);
      }
  
      }catch(Exception e ){
          System.out.println("Não foi possivel fazer a leitura dos dados "+ e);
      }finally{
          ConnectionFactory.closeConnection(conexao, stmt, rs);
      }
        return livros;
    }
    
     public void update (Livros livro){
          //Conexão ao banco de dados 
          Connection conexao = ConnectionFactory.conector();
          PreparedStatement stmt = null;
        
        String sql = ("UPDATE livros SET nome = ?, autor = ?, assunto = ?, status = ? WHERE idLivro = ?");
        try{
        
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, livro.getNome());
            stmt.setString(2, livro.getAutor());
            stmt.setString(3, livro.getAssunto());
            stmt.setBoolean(4, Boolean.parseBoolean(livro.getStatus().toString()));
            stmt.setInt(5, livro.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso! ");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar " + e);
        }finally{
               ConnectionFactory.closeConnection(conexao, stmt);
        }
        
    }
    public void delete (Livros livro){
          //Conexão ao banco de dados 
          Connection conexao = ConnectionFactory.conector();
          PreparedStatement stmt = null;
        
        String sql = ("DELETE FROM livros WHERE idLivro = ?");
        try{
        
            stmt = conexao.prepareStatement(sql);
         
            stmt.setInt(1, livro.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso! ");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao excluir " + e);
        }finally{
               ConnectionFactory.closeConnection(conexao, stmt);
        }
        
    }
    
    public List<Livros> buscaLivros(String strBusca){
        
       //Conexão ao banco de dados 
       Connection conexao = ConnectionFactory.conector();
       PreparedStatement stmt = null;
       ResultSet rs = null;
       
       List<Livros> livros = new ArrayList<>();
          
      try{
      stmt = conexao.prepareStatement("SELECT * FROM Livros where (nome LIKE %?% OR autor LIKE %?% OR assunto LIKE %?%) AND status = TRUE ORDER BY nome");
      stmt.setString(1, strBusca);
      stmt.setString(2, strBusca);
      stmt.setString(3, strBusca);
      
      rs = stmt.executeQuery();
      
      while(rs.next()){
      
          Livros livro = new Livros();
          
          livro.setId(rs.getInt("idLivro"));
          livro.setNome(rs.getString("nome"));
          livro.setAutor(rs.getString("autor"));
          livro.setAssunto(rs.getString("assunto"));
          livro.setStatus(rs.getBoolean("status"));
          
          //Adicionando os valores vindos do banco dentro de uma lista
          //para que possa ser feito a leitura dos valores.
          livros.add(livro);
      }
  
      }catch(Exception e ){
          System.out.println("Não foi possivel fazer a leitura dos dados "+ e);
      }finally{
          ConnectionFactory.closeConnection(conexao, stmt, rs);
      }
        return livros;
    }
}
