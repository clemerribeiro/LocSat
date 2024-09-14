/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author clemer.ribeiro
 */
public class Funcionario {
    private int id_funcionario;
    private String nome_funcionario;
    private String telefone_funcionario;
    private Date data_nascimento;
    private Usuario usuario;
    private Perfil perfil;

    @Override
    public String toString() {
        return "Funcionario{" + "id_funcionario=" + id_funcionario + ", nome_funcionario=" + nome_funcionario + ", telefone_funcionario=" + telefone_funcionario + ", data_nascimento=" + data_nascimento + ", usuario=" + usuario + ", perfil=" + perfil + '}';
    }

    public Funcionario() {
    }

    public Funcionario(int id_funcionario, String nome_funcionario, String telefone_funcionario, Date data_nascimento, Usuario usuario, Perfil perfil) {
        this.id_funcionario = id_funcionario;
        this.nome_funcionario = nome_funcionario;
        this.telefone_funcionario = telefone_funcionario;
        this.data_nascimento = data_nascimento;
        this.usuario = usuario;
        this.perfil = perfil;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public String getNome_funcionario() {
        return nome_funcionario;
    }

    public void setNome_funcionario(String nome_funcionario) {
        this.nome_funcionario = nome_funcionario;
    }

    public String getTelefone_funcionario() {
        return telefone_funcionario;
    }

    public void setTelefone_funcionario(String telefone_funcionario) {
        this.telefone_funcionario = telefone_funcionario;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    
}
