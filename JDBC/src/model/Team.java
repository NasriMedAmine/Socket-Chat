package model;

import java.util.Objects;

public class Team {
    private int id_team;
    private String nom;
    private int id_chef;
    private int nbr;

    @Override
    public String toString() {
        return "Team{" +
                "id_team=" + id_team +
                ", nom='" + nom + '\'' +
                ", id_chef=" + id_chef +
                ", nbr=" + nbr +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return getId_team() == team.getId_team() && getId_chef() == team.getId_chef() && getNbr() == team.getNbr() && Objects.equals(getNom(), team.getNom());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_team(), getNom(), getId_chef(), getNbr());
    }

    public void setId_team(int id_team) {
        this.id_team = id_team;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setId_chef(int id_chef) {
        this.id_chef = id_chef;
    }

    public void setNbr(int nbr) {
        this.nbr = nbr;
    }

    public int getId_team() {
        return id_team;
    }

    public String getNom() {
        return nom;
    }

    public int getId_chef() {
        return id_chef;
    }

    public int getNbr() {
        return nbr;
    }

    public Team() {
    }

    public Team(int id_team, String nom, int id_chef, int nbr) {
        this.id_team = id_team;
        this.nom = nom;
        this.id_chef = id_chef;
        this.nbr = nbr;
    }

    public Team(String nom, int id_chef, int nbr) {
        this.nom = nom;
        this.id_chef = id_chef;
        this.nbr = nbr;
    }
}
