/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import connection.ConnectionFactory;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Usuarios;

/**
 *
 * @author esrae
 */
public class UsuarioDAO {
    
    public void create (Usuarios cliente){
          //Conexão ao banco de dados 
          Connection conexao = ConnectionFactory.conector();
          PreparedStatement stmt = null;
        
        String sql = ("INSERT INTO usuario (nomeCompleto, cpf, nascimento, sexo, email, senha)VALUES(?,?,?,?,?,?)");
        try{
        
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cliente.getNomeCompleto());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getDataNascimento());
            stmt.setString(4, cliente.getSexo());
            stmt.setString(5, cliente.getEmail());
            stmt.setString(6, cliente.getSenha());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso! ");
        }catch (HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao salvar " + e);
        }finally{
               ConnectionFactory.closeConnection(conexao, stmt);
        }
        
    }
    
    public Usuarios buscaUsuarioPorEmail(String email){
        //Conexão ao banco de dados 
        Connection conexao = ConnectionFactory.conector();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        Usuarios usuario = new Usuarios();
        // colocando null para caso não tenha nenhum 
        usuario.setEmail("null");
        
        try{
            stmt = conexao.prepareStatement("SELECT * FROM usuario where email = ?");
            
            stmt.setString(1, email);
            
            rs = stmt.executeQuery();
      
            while(rs.next()){
                
                usuario.setNomeCompleto(rs.getString("nomeCompleto"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setDataNascimento(rs.getString("nascimento"));
                usuario.setSexo(rs.getString("sexo"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
            }
  
        }catch(SQLException e ){
            System.out.println("Não foi possivel fazer a leitura dos dados "+ e);
        }finally{
            ConnectionFactory.closeConnection(conexao, stmt, rs);
        }
        return usuario;
    }
    
    public Usuarios buscaUsuarioPorEmaileCPF(String email, String cpf){
        //Conexão ao banco de dados 
        Connection conexao = ConnectionFactory.conector();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        Usuarios usuario = new Usuarios();
        // colocando null para caso não tenha nenhum 
        usuario.setEmail("null");
        usuario.setCpf("null");
        
        try{
            stmt = conexao.prepareStatement("SELECT * FROM usuario where email = ? AND cpf = ?");
            
            stmt.setString(1, email);
            stmt.setString(2, cpf);
            
            rs = stmt.executeQuery();
      
            while(rs.next()){
                
                usuario.setNomeCompleto(rs.getString("nomeCompleto"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setDataNascimento(rs.getString("nascimento"));
                usuario.setSexo(rs.getString("sexo"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
            }
  
        }catch(SQLException e ){
            System.out.println("Não foi possivel fazer a leitura dos dados "+ e);
        }finally{
            ConnectionFactory.closeConnection(conexao, stmt, rs);
        }
        return usuario;
    }
    
    public void updateSenha(Usuarios usuario){
        //Conexão ao banco de dados 
        Connection conexao = ConnectionFactory.conector();
        PreparedStatement stmt = null;
        
        try{
            stmt = conexao.prepareStatement("UPDATE usuario SET senha = ? where cpf = ? AND email = ?");
            
            stmt.setString(1, usuario.getSenha());
            stmt.setString(2, usuario.getCpf());
            stmt.setString(3, usuario.getEmail());
            
            // executa o sql
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!");
        }catch(HeadlessException | SQLException e ){
            System.out.println("Falha na alteração de senha "+ e);
        }finally{
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
    
    public List<Usuarios> buscaTodosUsuarios(){
        List<Usuarios> rs = new ArrayList<Usuarios>();
        Usuarios usuario = new Usuarios();
        //Conexão ao banco de dados 
        Connection conexao = ConnectionFactory.conector();
        PreparedStatement stmt = null;
        ResultSet lista = null;
        
        try{
            stmt = conexao.prepareStatement("SELECT * FROM usuario");
            
            // executa o sql
            lista = stmt.executeQuery();
            stmt.close();
            
            while(lista.next()){
                usuario.setNomeCompleto(lista.getString("nomeCompleto"));
                usuario.setCpf(lista.getString("cpf"));
                usuario.setDataNascimento(lista.getString("nascimento"));
                usuario.setSexo(lista.getString("sexo"));
                usuario.setEmail(lista.getString("email"));
                usuario.setSenha(lista.getString("senha"));
                
                rs.add(usuario);
            }
            
            return rs;
            
        }catch(HeadlessException | SQLException e ){
            System.out.println("Falha na alteração de senhas "+ e);
        }finally{
            ConnectionFactory.closeConnection(conexao, stmt);
        }
        
        return rs;
    }
}
