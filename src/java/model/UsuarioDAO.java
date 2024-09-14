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
public class UsuarioDAO extends DataBaseDAO {
    
         public UsuarioDAO() throws Exception {
    }
    
    public ArrayList<Usuario> getLista() throws Exception{
        
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        String sql = "SELECT u.*, p.nome FROM usuario u "
                + "INNER JOIN perfil p ON p.idperfil = u.idperfil";
        
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery(sql);
        while (rs.next()){
            Usuario u = new Usuario();
            u.setId_usuario(rs.getInt("u.id_usuario"));
            u.setNome_usuario(rs.getString("u.nome_usuario"));
            u.setLogin_usuario(rs.getString("u.login_usuario"));
            u.setSenha_usuario(rs.getString("u.senha_usuario"));
            u.setStatus_usuario(rs.getInt("u.status_usuario"));
            
            Perfil p = new Perfil ();
            p.setIdPerfil(rs.getInt("u.idperfil"));
            p.setNome(rs.getString("p.nome"));
            u.setPerfil(p);
            lista.add(u);
        }
        this.desconectar();
        return lista;
    }
    
    public boolean gravar(Usuario u) {

        try {

            String sql;
            this.conectar();
            if (u.getId_usuario() == 0) {
                sql = "INSERT INTO usuario (nome_usuario, login_usuario, senha_usuario, status_usuario, idperfil) VALUES (?,?,?,?,?)";
            } else {

                sql = "UPDATE usuario SET nome_usuario=?, login_usuario=?, senha_usuario=?, status_usuario=?, idperfil=? WHERE id_usuario=?";
            }

            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, u.getNome_usuario());
            pstm.setString(2, u.getLogin_usuario());
            pstm.setString(3, u.getSenha_usuario());
            pstm.setInt(4, u.getStatus_usuario());
            pstm.setInt(5, u.getPerfil().getIdPerfil());
            if (u.getId_usuario() > 0) {
                pstm.setInt(6, u.getId_usuario());
            }
            pstm.execute();
            this.desconectar();
            return true;

        } catch (Exception e) {

            System.out.println(e);
            return false;

        }

}
    public Usuario getCarregaPorID(int id_usuario) throws Exception{
    Usuario u = new Usuario();
    String sql ="SELECT u.* , p.nome FROM usuario u " +
            "INNER JOIN  perfil p ON p.idperfil = u.idperfil " +
            "WHERE u.id_usuario=?";
    this.conectar();
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setInt(1,id_usuario);
    ResultSet rs = pstm.executeQuery();
    System.out.println(rs);
    if(rs.next()){
        u.setId_usuario(id_usuario);
        u.setNome_usuario(rs.getString("u.nome_usuario"));
        u.setLogin_usuario(rs.getString("u.login_usuario"));
        u.setSenha_usuario(rs.getString("u.senha_usuario"));
        u.setStatus_usuario(rs.getInt("u.status_usuario"));
        Perfil p = new Perfil();
        p.setIdPerfil(rs.getInt("u.idperfil"));
        p.setNome(rs.getString("p.nome"));
        u.setPerfil(p);
    
    }
        this.desconectar();
        return u;
    }
    public boolean desativar (Usuario u){
    
        try{
            this.conectar();
            String sql ="UPDATE usuario SET status_usuario=2 WHERE id_usuario=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1,u.getId_usuario());
            pstm.execute();
            this.desconectar();
            return true;
            
        }catch(Exception e) {
            System.out.println(e);
            return false;
        
        }
}
    public boolean ativar (Usuario u){
    
        try{
            this.conectar();
            String sql ="UPDATE usuario SET status_usuario=1 WHERE id_usuario=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1,u.getId_usuario());
            pstm.execute();
            this.desconectar();
            return true;
            
        }catch(Exception e) {
            System.out.println(e);
            return false;
        
        }
               
}
    public Usuario  getRecuperarUsuario (String login_usuario){
    
        
        Usuario u = new Usuario();
        String sql ="SELECT u.* FROM usuario u "
                +"WHERE u.login_usuario=? AND status_usuario=1";
        try{
            this.conectar();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1,login_usuario);
            ResultSet rs = pstm.executeQuery();
             if(rs.next()){
                u.setId_usuario(rs.getInt("u.id_usuario"));
                u.setNome_usuario(rs.getString("u.nome_usuario"));
                u.setLogin_usuario(rs.getString("u.login_usuario"));
                u.setSenha_usuario(rs.getString("u.senha_usuario"));
                u.setStatus_usuario(rs.getInt("u.status_usuario"));
                PerfilDAO pDAO = new PerfilDAO();
                u.setPerfil(pDAO.getCarregaPorID(rs.getInt("u.idPerfil")));
            }
            this.desconectar();
                return u; 
        }catch(Exception e) {
            System.out.println(e);
            return null;
        
        }
    }
}
