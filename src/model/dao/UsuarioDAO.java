/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            stmt.setString(2, cliente.getCpf().toString());
            stmt.setString(3, cliente.getDataNascimento());
            stmt.setString(4, cliente.getSexo());
            stmt.setString(5, cliente.getEmail());
            stmt.setString(6, cliente.getSenha());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso! ");
        }catch (Exception e){
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
  
        }catch(Exception e ){
            System.out.println("Não foi possivel fazer a leitura dos dados "+ e);
        }finally{
            ConnectionFactory.closeConnection(conexao, stmt, rs);
        }
        return usuario;
    }
}
