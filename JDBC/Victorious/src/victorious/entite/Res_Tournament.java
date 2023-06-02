/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victorious.entite;

import java.util.Objects;

/**
 *
 * @author farouk
 */
public class Res_Tournament extends User{
    private int id_res ;
 
  
    public Res_Tournament() {
    }

    public Res_Tournament(int id_res, int id_user, String pseudo, String password, String mail) {
        super(id_user, pseudo, password, mail);
        this.id_res = id_res;
    }

    public int getId_res() {
        return id_res;
    }
   
    public void setId_res(int id_res) {
        this.id_res = id_res;
    }
   
    public String toString() {
        return "Res_Tournament{" + "id=" + id_res + ", pseudo=" + getPseudo() + ", password=" + getPassword() + ", mail=" + getMail() + '}';
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Res_Tournament other = (Res_Tournament) obj;
        if (this.id_res != other.id_res) {
            return false;
        }
        if (!Objects.equals(this.getId(), other.getId())) {
            return false;
        }
        if (!Objects.equals(this.getPseudo(), other.getPseudo())) {
            return false;
        }
        if (!Objects.equals(this.getPassword(), other.getPassword())) {
            return false;
        }
        if (!Objects.equals(this.getMail(), other.getMail())) {
            return false;
        }
        return true;
    }
    
    
    
    
}
