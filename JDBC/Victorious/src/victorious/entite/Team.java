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
 * @author jasser
 */
public class Team {
    private int id_team;
    private String nom_team;
    private int nb_player;
    private String players;

    public Team(int id_team, String nom_team, int nb_player, String players) {
        this.id_team = id_team;
        this.nom_team = nom_team;
        this.nb_player = nb_player;
        this.players = players;
    }

    public int getId_team() {
        return id_team;
    }

    public void setId_team(int id_team) {
        this.id_team = id_team;
    }

    public String getNom_team() {
        return nom_team;
    }

    public void setNom_team(String nom_team) {
        this.nom_team = nom_team;
    }

    public int getNb_player() {
        return nb_player;
    }

    public void setNb_player(int nb_player) {
        this.nb_player = nb_player;
    }

    public String getPlayers() {
        return players;
    }

    public void setPlayers(String players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return "Team{" + "id_team=" + id_team + ", nom_team=" + nom_team + ", nb_player=" + nb_player + ", players=" + players + '}';
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
        final Team other = (Team) obj;
        if (this.id_team != other.id_team) {
            return false;
        }
        if (this.nb_player != other.nb_player) {
            return false;
        }
        if (!Objects.equals(this.nom_team, other.nom_team)) {
            return false;
        }
        if (!Objects.equals(this.players, other.players)) {
            return false;
        }
        return true;
    }

  
    
}
