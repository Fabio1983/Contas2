/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contas;

/**
 *
 * @author Fabio
 */
public class Usuario {
    private int idUsuario;
    private String nome;
    private String senha;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nome, String senha) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.senha = senha;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
