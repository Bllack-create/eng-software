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
import java.util.Iterator;
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
    
    public List<Livros> readIndisponivel(){
        
       //Conexão ao banco de dados 
       Connection conexao = ConnectionFactory.conector();
       PreparedStatement stmt = null;
       ResultSet rs = null;
       
       List<Livros> livros = new ArrayList<>();
          
      try{
      stmt = conexao.prepareStatement("SELECT * FROM Livros where status = FALSE");
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
      stmt = conexao.prepareStatement("SELECT * FROM Livros where (nome LIKE ? OR autor LIKE ? OR assunto LIKE ?) AND status = TRUE");
      stmt.setString(1, "%"+strBusca+"%");
      stmt.setString(2, "%"+strBusca+"%");
      stmt.setString(3, "%"+strBusca+"%");
      
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
    
    public void alteraInformacoesEmprestimo(Livros livro){
        //Conexão ao banco de dados 
          Connection conexao = ConnectionFactory.conector();
          PreparedStatement stmt = null;
        
        String sql = ("UPDATE livros SET status = ?, cpfUserEmp = ? WHERE idLivro = ?");
        try{
        
            stmt = conexao.prepareStatement(sql);
            stmt.setBoolean(1, Boolean.parseBoolean(livro.getStatus().toString()));
            stmt.setString(2, livro.getCpfUserEmp()); // tem que pegar o cpf do usuario
            stmt.setInt(3, livro.getId());
            
            stmt.executeUpdate();
       
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao fazer emprestimo do livro " + livro.getId() + "\n" + e);
        }finally{
               ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
    
    public void fazEmprestimo(List<Livros> cesta){
        //Conexão ao banco de dados 
          Connection conexao = ConnectionFactory.conector();
          PreparedStatement stmt = null;
        
        try{
        
              for (Iterator<Livros> it = cesta.iterator(); it.hasNext();) {
                  Livros livroAtual = it.next();
                  alteraInformacoesEmprestimo(livroAtual);
              }
              
              // tenta mostra um comprovante de emprestimo e as informaçoes do usuario que fez
              String informacoes = "O usuario " + cesta.get(0).getCpfUserEmp() + " fez o emprestimo dos seguintes livros:\n\n";
              String id;
              String nome;
              String autor;
              // adiciona as informações
              for (Livros livroAtual : cesta) {
                  nome = livroAtual.getNome();
                  autor = livroAtual.getAutor();
                  id = String.format("%d   -  ", livroAtual.getId());
                  informacoes = String.format("%s\n", informacoes + id + "  -  " + nome + "  -  " + autor + "\n");
              }
              
              JOptionPane.showMessageDialog(null, informacoes, "Emprestimo realizado com sucesso", 0);
              //JOptionPane.showMessageDialog(null, "Emprestimo realizado com sucesso");
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao fazer emprestimo " + e);
        }finally{
               ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
}