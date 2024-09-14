/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author clemer.ribeiro
 */
public class Usuario {
    private int id_usuario;
    private String nome_usuario;
    private String login_usuario;
    private String senha_usuario;
    private int status_usuario;
    private Perfil perfil;
    
    public Usuario() {
    }

    public Usuario(int id_usuario, String nome_usuario, String login_usuario, String senha_usuario, int status_usuario, Perfil perfil) {
        this.id_usuario = id_usuario;
        this.nome_usuario = nome_usuario;
        this.login_usuario = login_usuario;
        this.senha_usuario = senha_usuario;
        this.status_usuario = status_usuario;
        this.perfil = perfil;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getLogin_usuario() {
        return login_usuario;
    }

    public void setLogin_usuario(String login_usuario) {
        this.login_usuario = login_usuario;
    }

    public String getSenha_usuario() {
        return senha_usuario;
    }

    public void setSenha_usuario(String senha_usuario) {
        this.senha_usuario = senha_usuario;
    }

    public int getStatus_usuario() {
        return status_usuario;
    }

    public void setStatus_usuario(int status_usuario) {
        this.status_usuario = status_usuario;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nome_usuario=" + nome_usuario + '}';
    }
    
    
}
