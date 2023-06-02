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
public class Result {
    private int id_result;
    private String winning_teams;
    private String Loosing_teams;

    public Result() {
    }

    public Result(int id_result, String winning_teams, String Loosing_teams) {
        this.id_result = id_result;
        this.winning_teams = winning_teams;
        this.Loosing_teams = Loosing_teams;
    }

    public int getId_result() {
        return id_result;
    }

    public void setId_result(int id_result) {
        this.id_result = id_result;
    }

    public String getWinning_teams() {
        return winning_teams;
    }

    public void setWinning_teams(String winning_teams) {
        this.winning_teams = winning_teams;
    }

    public String getLoosing_teams() {
        return Loosing_teams;
    }

    public void setLoosing_teams(String Loosing_teams) {
        this.Loosing_teams = Loosing_teams;
    }

    @Override
    public String toString() {
        return "Result{" + "id_result=" + id_result + ", winning_teams=" + winning_teams + ", Loosing_teams=" + Loosing_teams + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Result other = (Result) obj;
        if (this.id_result != other.id_result) {
            return false;
        }
        if (!Objects.equals(this.winning_teams, other.winning_teams)) {
            return false;
        }
        if (!Objects.equals(this.Loosing_teams, other.Loosing_teams)) {
            return false;
        }
        return true;
    }

  
    
    
    
    
}
