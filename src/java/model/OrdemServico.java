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
public class OrdemServico {
    private int id_ordem_servico;
    private Cacamba cacamba;
    private Usuario usuario; 
    private Cliente cliente;
    private String placa_caminhao;
    private int ctr;
    private int status_ordem_servico;
    private int valor_servico;
    private int tipo_servico;
    private Date data_criacao;
    private String endereco;

    public OrdemServico() {
    }

    public OrdemServico(int id_ordem_servico, Cacamba cacamba, Usuario usuario, Cliente cliente, String placa_caminhao, int ctr, int status_ordem_servico, int valor_servico, int tipo_servico, Date data_criacao, String endereco) {
        this.id_ordem_servico = id_ordem_servico;
        this.cacamba = cacamba;
        this.usuario = usuario;
        this.cliente = cliente;
        this.placa_caminhao = placa_caminhao;
        this.ctr = ctr;
        this.status_ordem_servico = status_ordem_servico;
        this.valor_servico = valor_servico;
        this.tipo_servico = tipo_servico;
        this.data_criacao = data_criacao;
        this.endereco = endereco;
    }

    public int getId_ordem_servico() {
        return id_ordem_servico;
    }

    public void setId_ordem_servico(int id_ordem_servico) {
        this.id_ordem_servico = id_ordem_servico;
    }

    public Cacamba getCacamba() {
        return cacamba;
    }

    public void setCacamba(Cacamba cacamba) {
        this.cacamba = cacamba;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getPlaca_caminhao() {
        return placa_caminhao;
    }

    public void setPlaca_caminhao(String placa_caminhao) {
        this.placa_caminhao = placa_caminhao;
    }

    public int getCtr() {
        return ctr;
    }

    public void setCtr(int ctr) {
        this.ctr = ctr;
    }

    public int getStatus_ordem_servico() {
        return status_ordem_servico;
    }

    public void setStatus_ordem_servico(int status_ordem_servico) {
        this.status_ordem_servico = status_ordem_servico;
    }

    public int getValor_servico() {
        return valor_servico;
    }

    public void setValor_servico(int valor_servico) {
        this.valor_servico = valor_servico;
    }

    public int getTipo_servico() {
        return tipo_servico;
    }

    public void setTipo_servico(int tipo_servico) {
        this.tipo_servico = tipo_servico;
    }

    public Date getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(Date data_criacao) {
        this.data_criacao = data_criacao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "OrdemServico{" + "id_ordem_servico=" + id_ordem_servico + ", cacamba=" + cacamba + ", usuario=" + usuario + ", cliente=" + cliente + ", placa_caminhao=" + placa_caminhao + ", ctr=" + ctr + ", status_ordem_servico=" + status_ordem_servico + ", valor_servico=" + valor_servico + ", tipo_servico=" + tipo_servico + ", data_criacao=" + data_criacao + ", endereco=" + endereco + '}';
    }

    
   
   
}