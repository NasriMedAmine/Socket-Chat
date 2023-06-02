/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victorious.entite;

import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author farouk
 */
public class Historique {
    private int id_historique;
    private String tournaments;


    public Historique() {
    }
    
    public Historique(int id_historique, String tournaments) {
        this.id_historique = id_historique;
        this.tournaments = tournaments;
    }

    public int getId_historique() {
        return id_historique;
    }

    public void setId_historique(int id_historique) {
        this.id_historique = id_historique;
    }

    public String getTournaments() {
        return tournaments;
    }

    public void setTournaments(String tournaments) {
        this.tournaments = tournaments;
    }

    @Override
    public String toString() {
        return "Historique{" + "id_historique=" + id_historique + ", tournaments=" + tournaments + '}';
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
        final Historique other = (Historique) obj;
        if (this.id_historique != other.id_historique) {
            return false;
        }
        if (!Objects.equals(this.tournaments, other.tournaments)) {
            return false;
        }
        return true;
    }

   
    
    
    
}
