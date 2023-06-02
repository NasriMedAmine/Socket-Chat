/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victorious.entite;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
/**
 *
 * @author farouk
 */
public class Advertise {
    private int id_advertise;
    private String name_society ;
      private Date date_debut;
    private Date date_fin;

    public Advertise() {
    }

    public Advertise(int id_advertise, String name_society, Date date_debut, Date date_fin) {
        this.id_advertise = id_advertise;
        this.name_society = name_society;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    public int getId_advertise() {
        return id_advertise;
    }

    public void setId_advertise(int id_advertise) {
        this.id_advertise = id_advertise;
    }

    public String getname_society() {
        return name_society;
    }

    public void setname_society(String name_society) {
        this.name_society = name_society;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public String toString() {
        return "Advertise{" + "id_advertise=" + id_advertise + ", society=" + name_society + ", date_debut=" + date_debut + ", date_fin=" + date_fin + '}';
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
        final Advertise other = (Advertise) obj;
        if (this.id_advertise != other.id_advertise) {
            return false;
        }
        if (!Objects.equals(this.name_society, other.name_society)) {
            return false;
        }
        if (!Objects.equals(this.date_debut, other.date_debut)) {
            return false;
        }
        if (!Objects.equals(this.date_fin, other.date_fin)) {
            return false;
        }
        return true;
    }
    
    
    
}
