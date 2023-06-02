/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victorious.entite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author farouk
 */
public class Tournament {
    private int id_tournament;
    private String tournament_name;
    private String res_Tournaments;
    private String brackets;
    private String teams;

    public Tournament() {
    }

    public Tournament(int id_tournament, String tournament_name, String res_Tournaments, String brackets, String teams) {
        this.id_tournament = id_tournament;
        this.tournament_name = tournament_name;
        this.res_Tournaments = res_Tournaments;
        this.brackets = brackets;
        this.teams = teams;
    }

    public int getId_tournament() {
        return id_tournament;
    }

    public void setId_tournament(int id_tournament) {
        this.id_tournament = id_tournament;
    }

    public String getTournament_name() {
        return tournament_name;
    }

    public void setTournament_name(String tournament_name) {
        this.tournament_name = tournament_name;
    }

    public String getRes_Tournaments() {
        return res_Tournaments;
    }

    public void setRes_Tournaments(String res_Tournaments) {
        this.res_Tournaments = res_Tournaments;
    }

    public String getBrackets() {
        return brackets;
    }

    public void setBrackets(String brackets) {
        this.brackets = brackets;
    }

    public String getTeams() {
        return teams;
    }

    public void setTeams(String teams) {
        this.teams = teams;
    }

    @Override
    public String toString() {
        return "Tournament{" + "id_tournament=" + id_tournament + ", tournament_name=" + tournament_name + ", res_Tournaments=" + res_Tournaments + ", brackets=" + brackets + ", teams=" + teams + '}';
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
        final Tournament other = (Tournament) obj;
        if (this.id_tournament != other.id_tournament) {
            return false;
        }
        if (!Objects.equals(this.tournament_name, other.tournament_name)) {
            return false;
        }
        if (!Objects.equals(this.res_Tournaments, other.res_Tournaments)) {
            return false;
        }
        if (!Objects.equals(this.brackets, other.brackets)) {
            return false;
        }
        if (!Objects.equals(this.teams, other.teams)) {
            return false;
        }
        return true;
    }

    

       
    
}
