/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bean;

import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class Usuarios {
    private String NomeCompleto;
    private String Cpf;
    private String DataNascimento;
    private String Sexo;
    private String Email;
    private String Senha;

    public Usuarios(String NomeCompleto, String Cpf, String DataNascimento, String Sexo, String Email, String Senha) {
        this.NomeCompleto = NomeCompleto;
        this.Cpf = Cpf;
        this.DataNascimento = DataNascimento;
        this.Sexo = Sexo;
        this.Email = Email;
        this.Senha = Senha;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
    }
    
    public Usuarios(){
        
    }

    public String getNomeCompleto() {
        return NomeCompleto;
    }

    public void setNomeCompleto(String NomeCompleto) {
        this.NomeCompleto = NomeCompleto;
    }

    public String getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(String DataNascimento) {
        this.DataNascimento = DataNascimento;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }
    
    
}
