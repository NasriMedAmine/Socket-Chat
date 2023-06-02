/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Objects;


public class Tournament {

   private int id_Tournament;
   private String tournament_Name;
   private int id_managers;
   private String code;
   private int id_game;
   private String type;

    public Tournament(String tournament_Name, int id_managers, String code, int id_game, String type) {
        this.tournament_Name = tournament_Name;
        this.id_managers = id_managers;
        this.code = code;
        this.id_game = id_game;
        this.type = type;
    }

    public Tournament(int id_Tournament, String tournament_Name, int id_managers, String code, int id_game, String type) {
        this.id_Tournament = id_Tournament;
        this.tournament_Name = tournament_Name;
        this.id_managers = id_managers;
        this.code = code;
        this.id_game = id_game;
        this.type = type;
    }

    public Tournament() {
    }

    @Override
    public String toString() {
        return "Tournament{" +
                "id_Tournament=" + id_Tournament +
                ", tournament_Name='" + tournament_Name + '\'' +
                ", id_managers=" + id_managers +
                ", code='" + code + '\'' +
                ", id_game=" + id_game +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tournament that = (Tournament) o;
        return getId_Tournament() == that.getId_Tournament() && getId_managers() == that.getId_managers() && getId_game() == that.getId_game() && Objects.equals(getTournament_Name(), that.getTournament_Name()) && Objects.equals(getCode(), that.getCode()) && Objects.equals(getType(), that.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_Tournament(), getTournament_Name(), getId_managers(), getCode(), getId_game(), getType());
    }

    public int getId_Tournament() {
        return id_Tournament;
    }

    public void setId_Tournament(int id_Tournament) {
        this.id_Tournament = id_Tournament;
    }

    public String getTournament_Name() {
        return tournament_Name;
    }

    public void setTournament_Name(String tournament_Name) {
        this.tournament_Name = tournament_Name;
    }

    public int getId_managers() {
        return id_managers;
    }

    public void setId_managers(int id_managers) {
        this.id_managers = id_managers;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getId_game() {
        return id_game;
    }

    public void setId_game(int id_game) {
        this.id_game = id_game;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}



   
    

       
    

