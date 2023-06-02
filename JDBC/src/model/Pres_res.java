package model;

import java.util.Date;
import java.util.Objects;

public class Pres_res {
    private int id_pres_res;
    private int id_user;
    private Date date;

    public Pres_res(int id_pres_res, int id_user, Date date) {
        this.id_pres_res = id_pres_res;
        this.id_user = id_user;
        this.date = date;
    }

    public Pres_res() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pres_res pres_res = (Pres_res) o;
        return getId_pres_res() == pres_res.getId_pres_res() && getId_user() == pres_res.getId_user() && Objects.equals(getDate(), pres_res.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_pres_res(), getId_user(), getDate());
    }

    @Override
    public String toString() {
        return "Pres_res{" +
                "id_pres_res=" + id_pres_res +
                ", id_user=" + id_user +
                ", date=" + date +
                '}';
    }

    public void setId_pres_res(int id_pres_res) {
        this.id_pres_res = id_pres_res;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId_pres_res() {
        return id_pres_res;
    }

    public int getId_user() {
        return id_user;
    }

    public Date getDate() {
        return date;
    }
}
