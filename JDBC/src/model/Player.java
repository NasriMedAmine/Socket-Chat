package model;

public class Player extends User{
    private int niveau ;
    private int pseudo_id;

    @Override
    public int getPseudo_id() {
        return pseudo_id;
    }

    @Override
    public void setPseudo_id(int pseudo_id) {
        this.pseudo_id = pseudo_id;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Player joueur = (Player) o;
        return niveau == joueur.niveau;
    }

    @Override
    public String toString() {
        super.toString();
        return "Player{" +
                "niveau=" + niveau +
                '}';
    }

    public Player(String pseudo, String pwd, String email, int age, int niveau) {
        super(pseudo, pwd, email, age);
        this.niveau = niveau;
    }

    @Override
    public int hashCode() {
//        return Objects.hash(super.hashCode(), niveau);
        int hash = 24;
        hash += super.hashCode() * hash;
        hash += hash * this.niveau;
        return hash;

    }
}
