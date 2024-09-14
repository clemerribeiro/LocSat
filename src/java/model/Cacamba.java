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
public class Cacamba {
    private int id_cacamba;
    private int numero_cacamba;
    private int status_cacamba;

    public Cacamba() {
      
    }

    public int getId_cacamba() {
        return id_cacamba;
    }

    public void setId_cacamba(int id_cacamba) {
        this.id_cacamba = id_cacamba;
    }

    public int getNumero_cacamba() {
        return numero_cacamba;
    }

    public void setNumero_cacamba(int numero_cacamba) {
        this.numero_cacamba = numero_cacamba;
    }

    public int getStatus_cacamba() {
        return status_cacamba;
    }

    public void setStatus_cacamba(int status_cacamba) {
        this.status_cacamba = status_cacamba;
    }

    @Override
    public String toString() {
        return "Cacamba{" + "id_cacamba=" + id_cacamba + ", numero_cacamba=" + numero_cacamba + ", status_cacamba=" + status_cacamba + '}';
    }
    
    
}
