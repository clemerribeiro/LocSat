/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author clemer.ribeiro
 */
public class OrdemServicoDAO extends DataBaseDAO {
    
         public OrdemServicoDAO() throws Exception {
    }
    
    public ArrayList<OrdemServico> getLista() throws Exception{
        
        ArrayList<OrdemServico> lista = new ArrayList<OrdemServico>();
        String sql = "SELECT os.*, c.nome_razao, ca.numero_cacamba, u.nome_usuario FROM ordem_servico os "
                + "INNER JOIN cliente c ON c.id_cliente = os.id_cliente "
                + "INNER JOIN cacamba ca ON ca.id_cacamba = os.id_cacamba "
                + "INNER JOIN usuario u ON u.id_usuario = os.id_usuario";
        
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery(sql);
        while (rs.next()){
            OrdemServico os = new OrdemServico();
            os.setId_ordem_servico(rs.getInt("os.id_ordem_servico"));
            os.setPlaca_caminhao(rs.getString("os.placa_caminhao"));
            os.setCtr(rs.getInt("os.ctr"));
            os.setTipo_servico(rs.getInt("os.tipo_servico"));
            os.setValor_servico(rs.getInt("os.valor_servico"));
           
            os.setStatus_ordem_servico(rs.getInt("os.status_ordem_servico"));
            os.setData_criacao(rs.getDate("data_criacao"));
            os.setEndereco(rs.getString("endereco"));
            Cliente c = new Cliente ();
            c.setId_cliente(rs.getInt("os.id_cliente"));
            c.setNome_razao(rs.getString("c.nome_razao"));
            os.setCliente(c);
            Cacamba ca = new Cacamba();
            ca.setId_cacamba(rs.getInt("os.id_cacamba"));
            ca.setNumero_cacamba(rs.getInt("ca.numero_cacamba"));
            os.setCacamba(ca);
            Usuario u = new Usuario();
            u.setId_usuario(rs.getInt("os.id_usuario"));
            u.setNome_usuario(rs.getString("u.nome_usuario"));
            os.setUsuario(u);
            lista.add(os);
        }
        this.desconectar();
        return lista;
    }
    public ArrayList<OrdemServico> getListaPendente() throws Exception{
        
        ArrayList<OrdemServico> listaPendente = new ArrayList<OrdemServico>();
        String sql = "SELECT os.*, c.nome_razao, ca.numero_cacamba, u.nome_usuario FROM ordem_servico os "
                + "INNER JOIN cliente c ON c.id_cliente = os.id_cliente "
                + "INNER JOIN cacamba ca ON ca.id_cacamba = os.id_cacamba "
                + "INNER JOIN usuario u ON u.id_usuario = os.id_usuario WHERE status_ordem_servico =1";
        
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery(sql);
        while (rs.next()){
            OrdemServico os = new OrdemServico();
            os.setId_ordem_servico(rs.getInt("os.id_ordem_servico"));
            os.setPlaca_caminhao(rs.getString("os.placa_caminhao"));
            os.setCtr(rs.getInt("os.ctr"));
            os.setTipo_servico(rs.getInt("os.tipo_servico"));
            os.setValor_servico(rs.getInt("os.valor_servico"));
            os.setStatus_ordem_servico(rs.getInt("os.status_ordem_servico"));
            os.setData_criacao(rs.getDate("data_criacao"));
            os.setEndereco(rs.getString("endereco"));
            Cliente c = new Cliente ();
            c.setId_cliente(rs.getInt("os.id_cliente"));
            c.setNome_razao(rs.getString("c.nome_razao"));
            os.setCliente(c);
            Cacamba ca = new Cacamba();
            ca.setId_cacamba(rs.getInt("os.id_cacamba"));
            ca.setNumero_cacamba(rs.getInt("ca.numero_cacamba"));
            os.setCacamba(ca);
            Usuario u = new Usuario();
            u.setId_usuario(rs.getInt("os.id_usuario"));
            u.setNome_usuario(rs.getString("u.nome_usuario"));
            os.setUsuario(u);
            listaPendente.add(os);
        }
        this.desconectar();
        return listaPendente;
    }
    
    public ArrayList<OrdemServico> getListaFinalizada() throws Exception{
        
        ArrayList<OrdemServico> listaFinalizada = new ArrayList<OrdemServico>();
        String sql = "SELECT os.*, c.nome_razao, ca.numero_cacamba, u.nome_usuario FROM ordem_servico os "
                + "INNER JOIN cliente c ON c.id_cliente = os.id_cliente "
                + "INNER JOIN cacamba ca ON ca.id_cacamba = os.id_cacamba "
                + "INNER JOIN usuario u ON u.id_usuario = os.id_usuario WHERE status_ordem_servico =2";
        
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery(sql);
        while (rs.next()){
            OrdemServico os = new OrdemServico();
            os.setId_ordem_servico(rs.getInt("os.id_ordem_servico"));
            os.setPlaca_caminhao(rs.getString("os.placa_caminhao"));
            os.setCtr(rs.getInt("os.ctr"));
            os.setTipo_servico(rs.getInt("os.tipo_servico"));
            os.setValor_servico(rs.getInt("os.valor_servico"));
            os.setStatus_ordem_servico(rs.getInt("os.status_ordem_servico")); 
            os.setData_criacao(rs.getDate("data_criacao"));
            os.setEndereco(rs.getString("endereco"));
            
            
            Cliente c = new Cliente ();
            c.setId_cliente(rs.getInt("os.id_cliente"));
            c.setNome_razao(rs.getString("c.nome_razao"));
            os.setCliente(c);
            Cacamba ca = new Cacamba();
            ca.setId_cacamba(rs.getInt("os.id_cacamba"));
            ca.setNumero_cacamba(rs.getInt("ca.numero_cacamba"));
            os.setCacamba(ca);
            Usuario u = new Usuario();
            u.setId_usuario(rs.getInt("os.id_usuario"));
            u.setNome_usuario(rs.getString("u.nome_usuario"));
            os.setUsuario(u);
            listaFinalizada.add(os);
        }
        this.desconectar();
        return listaFinalizada;
    }
    
    public ArrayList<OrdemServico> getListaLocacao() throws Exception{
        
        ArrayList<OrdemServico> listaLocacao = new ArrayList<OrdemServico>();
        String sql = "SELECT os.*, c.nome_razao, ca.numero_cacamba, u.nome_usuario FROM ordem_servico os "
                + "INNER JOIN cliente c ON c.id_cliente = os.id_cliente "
                + "INNER JOIN cacamba ca ON ca.id_cacamba = os.id_cacamba "
                + "INNER JOIN usuario u ON u.id_usuario = os.id_usuario WHERE tipo_servico =1";
        
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery(sql);
        while (rs.next()){
            OrdemServico os = new OrdemServico();
            os.setId_ordem_servico(rs.getInt("os.id_ordem_servico"));
            os.setPlaca_caminhao(rs.getString("os.placa_caminhao"));
            os.setCtr(rs.getInt("os.ctr"));
            os.setTipo_servico(rs.getInt("os.tipo_servico"));
            os.setValor_servico(rs.getInt("os.valor_servico"));
            os.setStatus_ordem_servico(rs.getInt("os.status_ordem_servico")); 
            os.setData_criacao(rs.getDate("data_criacao"));
            os.setEndereco(rs.getString("endereco"));
            
            
            Cliente c = new Cliente ();
            c.setId_cliente(rs.getInt("os.id_cliente"));
            c.setNome_razao(rs.getString("c.nome_razao"));
            os.setCliente(c);
            Cacamba ca = new Cacamba();
            ca.setId_cacamba(rs.getInt("os.id_cacamba"));
            ca.setNumero_cacamba(rs.getInt("ca.numero_cacamba"));
            os.setCacamba(ca);
            Usuario u = new Usuario();
            u.setId_usuario(rs.getInt("os.id_usuario"));
            u.setNome_usuario(rs.getString("u.nome_usuario"));
            os.setUsuario(u);
            listaLocacao.add(os);
        }
        this.desconectar();
        return listaLocacao;
    }
    
    public ArrayList<OrdemServico> getListaTroca() throws Exception{
        
        ArrayList<OrdemServico> listaTroca= new ArrayList<OrdemServico>();
        String sql = "SELECT os.*, c.nome_razao, ca.numero_cacamba, u.nome_usuario FROM ordem_servico os "
                + "INNER JOIN cliente c ON c.id_cliente = os.id_cliente "
                + "INNER JOIN cacamba ca ON ca.id_cacamba = os.id_cacamba "
                + "INNER JOIN usuario u ON u.id_usuario = os.id_usuario WHERE tipo_servico =2";
        
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery(sql);
        while (rs.next()){
            OrdemServico os = new OrdemServico();
            os.setId_ordem_servico(rs.getInt("os.id_ordem_servico"));
            os.setPlaca_caminhao(rs.getString("os.placa_caminhao"));
            os.setCtr(rs.getInt("os.ctr"));
            os.setTipo_servico(rs.getInt("os.tipo_servico"));
            os.setValor_servico(rs.getInt("os.valor_servico"));
            os.setStatus_ordem_servico(rs.getInt("os.status_ordem_servico")); 
            os.setData_criacao(rs.getDate("data_criacao"));
            os.setEndereco(rs.getString("endereco"));
            
            
            Cliente c = new Cliente ();
            c.setId_cliente(rs.getInt("os.id_cliente"));
            c.setNome_razao(rs.getString("c.nome_razao"));
            os.setCliente(c);
            Cacamba ca = new Cacamba();
            ca.setId_cacamba(rs.getInt("os.id_cacamba"));
            ca.setNumero_cacamba(rs.getInt("ca.numero_cacamba"));
            os.setCacamba(ca);
            Usuario u = new Usuario();
            u.setId_usuario(rs.getInt("os.id_usuario"));
            u.setNome_usuario(rs.getString("u.nome_usuario"));
            os.setUsuario(u);
            listaTroca.add(os);
        }
        this.desconectar();
        return listaTroca;
    }
    
    public ArrayList<OrdemServico> getListaRetirada() throws Exception{
        
        ArrayList<OrdemServico> listaRetirada = new ArrayList<OrdemServico>();
        String sql = "SELECT os.*, c.nome_razao, ca.numero_cacamba, u.nome_usuario FROM ordem_servico os "
                + "INNER JOIN cliente c ON c.id_cliente = os.id_cliente "
                + "INNER JOIN cacamba ca ON ca.id_cacamba = os.id_cacamba "
                + "INNER JOIN usuario u ON u.id_usuario = os.id_usuario WHERE tipo_servico =3";
        
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery(sql);
        while (rs.next()){
            OrdemServico os = new OrdemServico();
            os.setId_ordem_servico(rs.getInt("os.id_ordem_servico"));
            os.setPlaca_caminhao(rs.getString("os.placa_caminhao"));
            os.setCtr(rs.getInt("os.ctr"));
            os.setTipo_servico(rs.getInt("os.tipo_servico"));
            os.setValor_servico(rs.getInt("os.valor_servico"));
            os.setStatus_ordem_servico(rs.getInt("os.status_ordem_servico")); 
            os.setData_criacao(rs.getDate("data_criacao"));
            os.setEndereco(rs.getString("endereco"));
            
            
            Cliente c = new Cliente ();
            c.setId_cliente(rs.getInt("os.id_cliente"));
            c.setNome_razao(rs.getString("c.nome_razao"));
            os.setCliente(c);
            Cacamba ca = new Cacamba();
            ca.setId_cacamba(rs.getInt("os.id_cacamba"));
            ca.setNumero_cacamba(rs.getInt("ca.numero_cacamba"));
            os.setCacamba(ca);
            Usuario u = new Usuario();
            u.setId_usuario(rs.getInt("os.id_usuario"));
            u.setNome_usuario(rs.getString("u.nome_usuario"));
            os.setUsuario(u);
            listaRetirada.add(os);
        }
        this.desconectar();
        return listaRetirada;
    }
    public boolean gravar(OrdemServico os) {

        try {

            String sql;
            this.conectar();
            if (os.getId_ordem_servico() == 0) {
                sql = "INSERT INTO ordem_servico (id_cacamba, id_usuario, id_cliente, placa_caminhao, ctr, "
                        + "tipo_servico, valor_servico, status_ordem_servico, data_criacao, endereco) VALUES (?,?,?,?,?,?,?,?,now(),?)";
            }else{
                 sql = "UPDATE ordem_servico SET id_cacamba=?, id_usuario=?, id_cliente=?, placa_caminhao=?, ctr=?,"
                         + "tipo_servico=?, valor_servico=?, status_ordem_servico=?, endereco=? WHERE id_ordem_servico=?";
            }

            PreparedStatement pstm = conn.prepareStatement(sql);
           
            pstm.setInt(1, os.getCacamba().getId_cacamba());
            pstm.setInt(2, os.getUsuario().getId_usuario());
            pstm.setInt(3, os.getCliente().getId_cliente());
            pstm.setString(4, os.getPlaca_caminhao());
            pstm.setInt(5, os.getCtr());
            pstm.setInt(6, os.getTipo_servico());
            pstm.setInt(7, os.getValor_servico());
            pstm.setInt(8, os.getStatus_ordem_servico());
            pstm.setString(9, os.getEndereco());
            if (os.getId_ordem_servico() > 0) {
                pstm.setInt(10, os.getId_ordem_servico());
            }
            pstm.execute();
            this.desconectar();
            return true;

        } catch (Exception e) {

            System.out.println(e);
            return false;

        }

}
    public OrdemServico getCarregaPorID(int id_ordem_servico) throws Exception{
    OrdemServico os = new OrdemServico();
    String sql ="SELECT os.*, c.nome_razao, ca.numero_cacamba, u.nome_usuario FROM ordem_servico os "
           +"INNER JOIN  cliente c ON c.id_cliente = os.id_cliente " 
           +"INNER JOIN  cacamba ca ON ca.id_cacamba = os.id_cacamba " 
           +"INNER JOIN  usuario u ON u.id_usuario = os.id_usuario " 
           +"WHERE os.id_ordem_servico=?";
    this.conectar();
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setInt(1,id_ordem_servico);
    ResultSet rs = pstm.executeQuery();
    System.out.println(rs);
    if(rs.next()){
            os.setId_ordem_servico(rs.getInt("os.id_ordem_servico"));
            os.setPlaca_caminhao(rs.getString("os.placa_caminhao"));
            os.setCtr(rs.getInt("os.ctr"));
            os.setTipo_servico(rs.getInt("os.tipo_servico"));
            os.setValor_servico(rs.getInt("os.valor_servico"));
            os.setStatus_ordem_servico(rs.getInt("os.status_ordem_servico"));
            os.setData_criacao(rs.getDate("data_criacao"));
            os.setEndereco(rs.getString("endereco"));
            
            Cliente c = new Cliente ();
            c.setId_cliente(rs.getInt("os.id_cliente"));
            c.setNome_razao(rs.getString("c.nome_razao"));
            os.setCliente(c);
            Cacamba ca = new Cacamba();
            ca.setId_cacamba(rs.getInt("os.id_cacamba"));
            ca.setNumero_cacamba(rs.getInt("ca.numero_cacamba"));
            os.setCacamba(ca);
            Usuario u = new Usuario();
            u.setId_usuario(rs.getInt("os.id_usuario"));
            u.setNome_usuario(rs.getString("u.nome_usuario"));
            os.setUsuario(u);
            
            
    
    }
        this.desconectar();
        return os;
    }
    
     public ArrayList<Cacamba> CacambasLivres(int id_ordem_servico) throws Exception{
    
        ArrayList<Cacamba> lista = new ArrayList<Cacamba>();
        String sql = "SELECT ca.* FROM cacamba as ca" 
                + " WHERE ca.status_cacamba =1";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id_ordem_servico);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()){
            Cacamba ca = new Cacamba();
            ca.setId_cacamba(rs.getInt("ca.id_cacamba"));
            ca.setNumero_cacamba(rs.getInt("ca.numero_cacamba"));
            ca.setStatus_cacamba(rs.getInt("ca.status_cacamba"));
            lista.add(ca);
        }
        this.desconectar();
        return lista;
    
    }
   
     public boolean finalizar(OrdemServico os){
    
    try{
        this.conectar();
        String sql = "UPDATE ordem_servico SET status_ordem_servico=2 WHERE id_ordem_servico=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1,os.getId_ordem_servico());
        pstm.execute();
        this.desconectar();
        return true;
    }catch(Exception e){
        System.out.println(e);
        return false;
    }
        
    }
     
      public boolean cancelar(OrdemServico os){
    
    try{
        this.conectar();
        String sql = "UPDATE ordem_servico SET status_ordem_servico=3 WHERE id_ordem_servico=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1,os.getId_ordem_servico());
        pstm.execute();
        this.desconectar();
        return true;
    }catch(Exception e){
        System.out.println(e);
        return false;
    }
        
    }
    
}
