/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author clemer.ribeiro
 */
public class EnderecoDAO extends DataBaseDAO {
    
         public EnderecoDAO() throws Exception {
    }
    
    public ArrayList<Endereco> getLista() throws Exception{
        
        ArrayList<Endereco> lista = new ArrayList<Endereco>();
        String sql = "SELECT e.*, c.nome_razao FROM endereco e "
                + "INNER JOIN cliente c ON c.id_cliente = e.id_cliente";
        
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery(sql);
        while (rs.next()){
            Endereco e = new Endereco();
            e.setId_endereco(rs.getInt("e.id_endereco"));
            e.setCep(rs.getInt("e.cep"));
            e.setRua(rs.getString("e.rua"));
            e.setNumero(rs.getInt("e.numero"));
            e.setRua(rs.getString("e.rua"));
            e.setBairro(rs.getString("e.bairro"));
            e.setCidade(rs.getString("e.cidade"));
            e.setUf(rs.getString("e.uf"));
            e.setComplemento(rs.getString("e.complemento"));
            
            Cliente c = new Cliente();
            c.setId_cliente(rs.getInt("e.id_cliente"));
            c.setNome_razao(rs.getString("c.nome_razao"));
            e.setCliente(c);
            lista.add(e);
        }
        this.desconectar();
        return lista;
    }
    
    public boolean gravar(Endereco e) {

        try {

            String sql;
            this.conectar();
            if (e.getId_endereco() == 0) {
                sql = "INSERT INTO endereco (cep, rua, numero, bairro, cidade, uf, complemento, id_cliente) VALUES (?,?,?,?,?,?,?,?)";
            } else {

                sql = "UPDATE endereco SET cep=?, rua=?, numero=?, bairro=?, cidade=?, uf=?, complemento=?, id_cliente=? WHERE id_endereco=?";
            }

            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, e.getCep());
            pstm.setString(2, e.getRua());
            pstm.setInt(3, e.getNumero());
            pstm.setString(4, e.getBairro());
            pstm.setString(5, e.getCidade());
            pstm.setString(6, e.getUf());
            pstm.setString(7, e.getComplemento());
            pstm.setInt(8, e.getCliente().getId_cliente());
            if (e.getId_endereco() > 0) {
                pstm.setInt(9, e.getId_endereco());
            }
            pstm.execute();
            this.desconectar();
            return true;

        } catch (Exception ex) {

            System.out.println(ex);
            return false;

        }

}
    public Endereco getCarregaPorID(int id_endereco) throws Exception{
    Endereco e = new Endereco();
    String sql ="SELECT e.* , c.nome_razao FROM endereco e " +
            "INNER JOIN  cliente c ON c.id_cliente = e.id_cliente " +
            "WHERE e.id_endereco=?";
    this.conectar();
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setInt(1,id_endereco);
    ResultSet rs = pstm.executeQuery();
    System.out.println(rs);
    if(rs.next()){
        e.setId_endereco(id_endereco);
        e.setCep(rs.getInt("e.cep"));
        e.setRua(rs.getString("e.rua"));
        e.setNumero(rs.getInt("e.numero"));
        e.setBairro(rs.getString("e.bairro"));
        e.setCidade(rs.getString("e.cidade"));
        e.setUf(rs.getString("e.uf"));
        e.setComplemento(rs.getString("e.complemento"));
        Cliente c = new Cliente();
        c.setId_cliente(rs.getInt("e.id_cliente"));
        c.setNome_razao(rs.getString("c.nome_razao"));
        e.setCliente(c);
    
    }
        this.desconectar();
        return e;
    }
    
    public boolean deletar (Endereco e){
    
        try{
            this.conectar();
            String sql ="DELETE FROM endereco WHERE id_endereco=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1,e.getId_endereco());
            pstm.execute();
            this.desconectar();
            return true;
            
        }catch(Exception ex) {
            System.out.println(ex);
            return false;
        
        }    
    }
public ArrayList<Endereco> getListaSelect(int id_cliente) throws Exception {

        ArrayList<Endereco> listaSelect = new ArrayList<Endereco>();
        String sql = "SELECT e.*, c.* FROM endereco e "
                + "INNER JOIN cliente c ON c.id_cliente = e.id_cliente WHERE e.id_cliente = ?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id_cliente);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Endereco e = new Endereco();
            e.setId_endereco(rs.getInt("e.id_endereco"));
            e.setCep(rs.getInt("e.cep"));
            e.setRua(rs.getString("e.rua"));
            e.setNumero(rs.getInt("e.numero"));
            e.setRua(rs.getString("e.rua"));
            e.setBairro(rs.getString("e.bairro"));
            e.setCidade(rs.getString("e.cidade"));
            e.setUf(rs.getString("e.uf"));
            e.setComplemento(rs.getString("e.complemento"));

            Cliente c = new Cliente();
            c.setId_cliente(rs.getInt("c.id_cliente"));
            c.setNome_razao(rs.getString("c.nome_razao"));
            e.setCliente(c);
            listaSelect.add(e);
        }
        this.desconectar();
        return listaSelect;
    }      
        
     
}
