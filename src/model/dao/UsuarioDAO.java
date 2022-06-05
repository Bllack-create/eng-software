/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
}
