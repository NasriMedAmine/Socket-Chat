package model;

import java.io.Serializable;
import java.util.Objects;

public class layerTournament implements Serializable {
    private int id_layer ;
    private int id_tournoi;
    private int id_user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        layerTournament that = (layerTournament) o;
        return getId_layer() == that.getId_layer() && getId_tournoi() == that.getId_tournoi() && getId_user() == that.getId_user();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_layer(), getId_tournoi(), getId_user());
    }

    public int getId_layer() {
        return id_layer;
    }

    public void setId_layer(int id_layer) {
        this.id_layer = id_layer;
    }

    public int getId_tournoi() {
        return id_tournoi;
    }

    public void setId_tournoi(int id_tournoi) {
        this.id_tournoi = id_tournoi;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public layerTournament(int id_tournoi, int id_user) {
        this.id_tournoi = id_tournoi;
        this.id_user = id_user;
    }

    public layerTournament(int id_layer, int id_tournoi, int id_user) {
        this.id_layer = id_layer;
        this.id_tournoi = id_tournoi;
        this.id_user = id_user;
    }

    public layerTournament() {
    }
}
