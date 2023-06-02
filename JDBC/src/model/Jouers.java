package model;

import java.util.Objects;

public class Jouers {
    private int id_equipe;
    private int id_joueur;

    @Override
    public String toString() {
        return "Jouers{" +
                "id_equipe=" + id_equipe +
                ", id_joueur=" + id_joueur +
                '}';
    }

    public Jouers(int id_equipe) {
        this.id_equipe = id_equipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jouers jouers = (Jouers) o;
        return getId_equipe() == jouers.getId_equipe() && id_joueur == jouers.id_joueur;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_equipe(), id_joueur);
    }

    public int getId_equipe() {
        return id_equipe;
    }

    public void setId_equipe(int id_equipe) {
        this.id_equipe = id_equipe;
    }
}
