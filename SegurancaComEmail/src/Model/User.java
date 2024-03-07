/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author guilh
 */
public class User {
    
    private int id;
    
    private String nome, email, senha;
    
    private Date dt_cadastro;

    public Date getDt_cadastro() {
        return dt_cadastro;
    }

    public void setDt_cadastro(Date dt_cadastro) {
        this.dt_cadastro = dt_cadastro;
    }
    
    public User(int id, String nome, String email, String senha, Date dt_cadastro){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dt_cadastro = dt_cadastro;
    }
    
    public User(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", dt_cadastro=" + dt_cadastro + '}';
    }
    
}
