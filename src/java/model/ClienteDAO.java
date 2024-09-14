/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class ClienteDAO extends DataBaseDAO {

    public ClienteDAO() throws Exception {
    }
    
    public ArrayList<Cliente> getLista() throws Exception{
        
        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        String sql = "SELECT * FROM cliente";
        this.conectar();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        while (rs.next()){
            Cliente c = new Cliente();
            c.setId_cliente(rs.getInt("id_cliente"));
            c.setNome_razao(rs.getString("nome_razao"));
            c.setCpf_cnpj(rs.getString("cpf_cnpj"));
            c.setRg_ie(rs.getInt("rg_ie"));
            c.setTelefone_cliente(rs.getString("telefone_cliente"));
            c.setResponsavel_obra(rs.getString("responsavel_obra"));
            c.setEmail_cliente(rs.getString("email_cliente"));
            c.setObs_cliente(rs.getString("obs_cliente"));
            c.setTipo_cliente(rs.getInt("tipo_cliente"));
            c.setStatus_cliente(rs.getInt("status_cliente"));
            lista.add(c);
        }
        this.desconectar();
        return lista;
    }
    
    public boolean gravar(Cliente c){
        try {
            String sql;
            this.conectar();
            if (c.getId_cliente() == 0){
                sql = "INSERT INTO cliente (nome_razao, cpf_cnpj, rg_ie, telefone_cliente, responsavel_obra,"
                        + "email_cliente, obs_cliente, tipo_cliente, status_cliente) VALUES (?,?,?,?,?,?,?,?,?)" ;
             }else
                sql = "UPDATE cliente SET nome_razao=?, cpf_cnpj=?, rg_ie=?, telefone_cliente=?,"
                        + "responsavel_obra=?, email_cliente=?, obs_cliente=?, tipo_cliente=?,"
                        + "status_cliente=? WHERE id_cliente = ?";                 
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, c.getNome_razao());
            pstm.setString(2, c.getCpf_cnpj());
            pstm.setInt(3, c.getRg_ie());
            pstm.setString(4, c.getTelefone_cliente());
            pstm.setString(5, c.getResponsavel_obra());
            pstm.setString(6, c.getEmail_cliente());
            pstm.setString(7, c.getObs_cliente());
            pstm.setInt(8, c.getTipo_cliente());
            pstm.setInt(9, c.getStatus_cliente());
            if (c.getId_cliente() > 0)
                pstm.setInt(10,c.getId_cliente());
            pstm.execute();
            this.desconectar();
            return true;                
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public Cliente getCarregaPorID(int id_cliente) throws Exception{
    Cliente c = new Cliente();
    String sql ="SELECT * FROM cliente WHERE id_cliente=?";
    this.conectar();
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setInt(1,id_cliente);
    ResultSet rs = pstm.executeQuery();
    System.out.println(rs);
    if(rs.next()){
        c.setId_cliente(rs.getInt("id_cliente"));
        c.setNome_razao(rs.getString("nome_razao"));
        c.setCpf_cnpj(rs.getString("cpf_cnpj"));
        c.setRg_ie(rs.getInt("rg_ie"));
        c.setTelefone_cliente(rs.getString("telefone_cliente"));
        c.setResponsavel_obra(rs.getString("responsavel_obra"));
        c.setEmail_cliente(rs.getString("email_cliente"));
        c.setObs_cliente(rs.getString("obs_cliente"));
        c.setTipo_cliente(rs.getInt("tipo_cliente"));
        c.setStatus_cliente(rs.getInt("status_cliente"));
        
    
    }
        this.desconectar();
        return c;
    }
    
    public Endereco getExibirEndereco(int id_cliente) throws Exception{
    Endereco e= new Endereco();
    String sql ="SELECT * FROM endereco WHERE id_cliente = ?";
    this.conectar();
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setInt(1,id_cliente);
    ResultSet rs = pstm.executeQuery();
    System.out.println(rs);
    if(rs.next()){
        e.setId_endereco(rs.getInt("id_endereco"));
        e.setCep(rs.getInt("cep"));
        e.setRua(rs.getString("rua"));
        e.setNumero(rs.getInt("numero"));
        e.setBairro(rs.getString("bairro"));
        e.setCidade(rs.getString("cidade"));
        e.setUf(rs.getString("uf"));
        e.setComplemento(rs.getString("complemento"));

        
        
    
    }
        this.desconectar();
        return e;
    }
    
         public boolean deletar (Cliente c){
    
        try{
            this.conectar();
            String sql ="DELETE FROM cliente WHERE id_cliente=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1,c.getId_cliente());
            pstm.execute();
            this.desconectar();
            return true;
            
        }catch(Exception e) {
            System.out.println(e);
            return false;
        
        }
    }
   
    }

    
    
    
    
    
