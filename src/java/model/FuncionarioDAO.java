/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author clemer.ribeiro
 */
public class FuncionarioDAO extends DataBaseDAO {
    
         public FuncionarioDAO() throws Exception {
    }
    
    public ArrayList<Funcionario> getLista() throws Exception{
        
        ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
        String sql = "SELECT f.*, u.perfil FROM funcionario f "
                + "INNER JOIN usuario u ON u.id_usuario = f.id_usuario";
        
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery(sql);
        while (rs.next()){
            Funcionario f = new Funcionario();
            f.setId_funcionario(rs.getInt("f.id_funcionaario"));
            f.setNome_funcionario(rs.getString("f.nome_funcionario"));
            f.setTelefone_funcionario(rs.getString("f.telefone_funcionario"));
            f.setData_nascimento(rs.getDate("f.data_nascimento"));
            
            Usuario u = new Usuario ();
            u.setId_usuario(rs.getInt("f.id_usuario"));
            f.setUsuario(u);
            Perfil p = new Perfil();
            p.setIdPerfil(rs.getInt("u.idPerfil"));
            p.setNome(rs.getString("u.nome"));
            f.setPerfil(p);
            lista.add(f);
        }
        this.desconectar();
        return lista;
    }
    
    public boolean gravar(Funcionario f) {

        try {

            String sql;
            this.conectar();
            if (f.getId_funcionario() == 0) {
                sql = "INSERT INTO funcionario (nome_funcionario, telefone_funcionario, data_nascimento, id_usuario) VALUES (?,?,?,?)";
            } else {

                sql = "UPDATE funcionario SET nome_funcionario=?, telefone_funcionario=?, data_nascimento=?, id_usuario=? WHERE id_funcionario=?";
            }

            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, f.getNome_funcionario());
            pstm.setString(2, f.getTelefone_funcionario());
            pstm.setDate(3, new Date(f.getData_nascimento().getTime()));
            if (f.getId_funcionario() > 0) {
                pstm.setInt(4, f.getId_funcionario());
            }
            pstm.execute();
            this.desconectar();
            return true;

        } catch (Exception e) {

            System.out.println(e);
            return false;

        }

}
    public Funcionario getCarregaPorID(int id_funcionario) throws Exception{
    Funcionario f = new Funcionario();
    String sql ="SELECT f.* , p.nome FROM funcionario f " +
            "INNER JOIN  perfil p ON p.idperfil = f.idperfil " +
            "WHERE f.id_funcionario=?";
    this.conectar();
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setInt(1,id_funcionario);
    ResultSet rs = pstm.executeQuery();
    System.out.println(rs);
    if(rs.next()){
        f.setId_funcionario(id_funcionario);
        f.setNome_funcionario(rs.getString("f.nome_funcionario"));
        f.setTelefone_funcionario(rs.getString("f.telefone_funcionario"));
        f.setData_nascimento(rs.getDate("f.data_nascimento"));
        Usuario u = new Usuario ();
        u.setId_usuario(rs.getInt("f.id_usuario"));
        f.setUsuario(u);
        Perfil p = new Perfil();
        p.setIdPerfil(rs.getInt("u.idPerfil"));
        p.setNome(rs.getString("u.nome"));
        f.setPerfil(p);
           
    
    }
        this.desconectar();
        return f;
    }
    public boolean deletar (Funcionario f){
    
        try{
            this.conectar();
            String sql ="DELETE FROM funcionario WHERE id_funcionario=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1,f.getId_funcionario());
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
