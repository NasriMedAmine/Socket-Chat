/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victorious.entite;

/**
 *
 * @author farouk
 */
public class Admin extends User{
    private int id_admin;

    public Admin() {
    }

    
    public Admin(int id_admin, int id_user, String pseudo, String password, String mail) {
        super(id_user, pseudo, password, mail);
        this.id_admin = id_admin;
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    @Override
    public String toString() {
        return "Admin{" + "id_admin " + id_admin +",Pseudo "+getPseudo()+",Password "+getPassword()+",Mail "+getMail()+ '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
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
        final Admin other = (Admin) obj;
        if (this.id_admin != other.id_admin) {
            return false;
        }
        if (this.getPseudo() != other.getPseudo()) {
            return false;
        }
        if (this.getPassword() != other.getPassword()) {
            return false;
        }
        if (this.getMail() != other.getMail()) {
            return false;
        }
        return true;
    }
    
    
    
}
