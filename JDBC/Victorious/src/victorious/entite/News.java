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
public class News {
    private int id_news;
    private Date date_debut;
    private Date date_fin;

    public News() {
    }

    public News(int id_news, Date date_debut,Date date_fin) {
        this.id_news = id_news;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

   

    public int getId_news() {
        return id_news;
    }

    public void setId_news(int id_news) {
        this.id_news = id_news;
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
    public String toString() {
        return "News{" + "id_news=" + id_news + ", date_debut=" + date_debut + ", date_fin=" + date_fin + '}';
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
        final News other = (News) obj;
        if (this.id_news != other.id_news) {
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
