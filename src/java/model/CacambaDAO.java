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
public class CacambaDAO extends DataBaseDAO {

    public CacambaDAO() throws Exception {
    }

    public boolean gravar(Cacamba ca) {

        try {

            String sql;
            this.conectar();
            if (ca.getId_cacamba() == 0) {
                sql = "INSERT INTO cacamba (numero_cacamba, status_cacamba) VALUES (?,?)";
            } else {

                sql = "UPDATE cacamba SET numero_cacamba=?, status_cacamba=? WHERE id_cacamba=?";
            }

            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, ca.getNumero_cacamba());
            pstm.setInt(2, ca.getStatus_cacamba());
            if (ca.getId_cacamba() > 0) {
                pstm.setInt(3, ca.getId_cacamba());
            }
            pstm.execute();
            this.desconectar();
            return true;

        } catch (Exception e) {

            System.out.println(e);
            return false;

        }

    }
        
        public ArrayList<Cacamba> getLista() throws Exception{
        
        ArrayList<Cacamba> lista = new ArrayList<Cacamba>();
        String sql = "SELECT * FROM cacamba";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()){
            Cacamba ca = new Cacamba();
            ca.setId_cacamba(rs.getInt("id_cacamba"));
            ca.setNumero_cacamba(rs.getInt("numero_cacamba"));
            ca.setStatus_cacamba(rs.getInt("status_cacamba"));
            lista.add(ca);
        }
        this.desconectar();
        return lista;
    }
    
    public Cacamba getCarregaPorID(int id_cacamba) throws Exception{
    Cacamba ca = new Cacamba();
    String sql ="SELECT * FROM cacamba WHERE id_cacamba=?";
    this.conectar();
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setInt(1,id_cacamba);
    ResultSet rs = pstm.executeQuery();
    System.out.println(rs);
    if(rs.next()){
        ca.setId_cacamba(id_cacamba);
        ca.setNumero_cacamba(rs.getInt("numero_cacamba"));
        ca.setStatus_cacamba(rs.getInt("status_cacamba"));
    
    }
        this.desconectar();
        return ca;
    }
    
    
    public boolean deletar (Cacamba ca){
    
        try{
            this.conectar();
            String sql ="DELETE FROM cacamba WHERE id_cacamba=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1,ca.getId_cacamba());
            pstm.execute();
            this.desconectar();
            return true;
            
        }catch(Exception e) {
            System.out.println(e);
            return false;
        
        }
    
        
    
    }
    
}
