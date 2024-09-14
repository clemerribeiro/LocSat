
package model;

/**
 *
 * @author Administrador
 */
public class Cliente {
    private int id_cliente;
    private String nome_razao;
    private String cpf_cnpj;
    private int rg_ie;
    private String telefone_cliente;
    private String responsavel_obra;
    private String email_cliente;
    private String obs_cliente;
    private int tipo_cliente;
    private int status_cliente;

    public Cliente() {
    }

    public Cliente(int id_cliente, String nome_razao, String cpf_cnpj, int rg_ie, String telefone_cliente, String responsavel_obra, String email_cliente, String obs_cliente, int tipo_cliente, int status_cliente) {
        this.id_cliente = id_cliente;
        this.nome_razao = nome_razao;
        this.cpf_cnpj = cpf_cnpj;
        this.rg_ie = rg_ie;
        this.telefone_cliente = telefone_cliente;
        this.responsavel_obra = responsavel_obra;
        this.email_cliente = email_cliente;
        this.obs_cliente = obs_cliente;
        this.tipo_cliente = tipo_cliente;
        this.status_cliente = status_cliente;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNome_razao() {
        return nome_razao;
    }

    public void setNome_razao(String nome_razao) {
        this.nome_razao = nome_razao;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public int getRg_ie() {
        return rg_ie;
    }

    public void setRg_ie(int rg_ie) {
        this.rg_ie = rg_ie;
    }

    public String getTelefone_cliente() {
        return telefone_cliente;
    }

    public void setTelefone_cliente(String telefone_cliente) {
        this.telefone_cliente = telefone_cliente;
    }

    public String getResponsavel_obra() {
        return responsavel_obra;
    }

    public void setResponsavel_obra(String responsavel_obra) {
        this.responsavel_obra = responsavel_obra;
    }

    public String getEmail_cliente() {
        return email_cliente;
    }

    public void setEmail_cliente(String email_cliente) {
        this.email_cliente = email_cliente;
    }

    public String getObs_cliente() {
        return obs_cliente;
    }

    public void setObs_cliente(String obs_cliente) {
        this.obs_cliente = obs_cliente;
    }

    public int getTipo_cliente() {
        return tipo_cliente;
    }

    public void setTipo_cliente(int tipo_cliente) {
        this.tipo_cliente = tipo_cliente;
    }

    public int getStatus_cliente() {
        return status_cliente;
    }

    public void setStatus_cliente(int status_cliente) {
        this.status_cliente = status_cliente;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id_cliente=" + id_cliente + ", nome_razao=" + nome_razao + ", cpf_cnpj=" + cpf_cnpj + ", rg_ie=" + rg_ie + ", telefone_cliente=" + telefone_cliente + ", responsavel_obra=" + responsavel_obra + ", email_cliente=" + email_cliente + ", obs_cliente=" + obs_cliente + ", tipo_cliente=" + tipo_cliente + ", status_cliente=" + status_cliente + '}';
    }
    

   
    
}
