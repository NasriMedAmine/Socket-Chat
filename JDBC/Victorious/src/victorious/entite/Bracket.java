/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victorious.entite;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

/**
 *
 * @author farouk
 */
public class Bracket {
    private int id_braket;
    private Date date;
    private String teams;
    private Chat chat;
    private String match ;

    public Bracket() {
    }

    public Bracket(int id_braket, Date date, String teams, Chat chat, String match) {
        this.id_braket = id_braket;
        this.date = date;
        this.teams = teams;
        this.chat = chat;
        this.match = match;
    }

    public int getId_braket() {
        return id_braket;
    }

    public void setId_braket(int id_braket) {
        this.id_braket = id_braket;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTeams() {
        return teams;
    }

    public void setTeams(String teams) {
        this.teams = teams;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public String getMatch() {
        return match;
    }

    public void setMatch(String match) {
        this.match = match;
    }

    @Override
    public String toString() {
        return "Bracket{" + "id_braket=" + id_braket + ", date=" + date + ", teams=" + teams + ", chat=" + chat + ", match=" + match + '}';
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
        final Bracket other = (Bracket) obj;
        if (this.id_braket != other.id_braket) {
            return false;
        }
        if (!Objects.equals(this.teams, other.teams)) {
            return false;
        }
        if (!Objects.equals(this.match, other.match)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.chat, other.chat)) {
            return false;
        }
        return true;
    }

  
    
    
}
