/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victorious.entite;

import java.util.Objects;

/**
 *
 * @author jasser
 */
public class Player extends User{
    
    private int id_player;
    private int level;

    public Player() {
    }

    public Player(int id_player, int id_user, int level, String pseudo, String password, String mail) {
        super(id_user, pseudo, password, mail);
        this.id_player = id_player;
        this.level = level;
    }

    public int getId_player() {
        return id_player;
    }

    public void setId_player(int id_player) {
        this.id_player = id_player;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Player{" + "id_player " + id_player +", level " + level+", Id user "+getId()+", Pseudo "+getPseudo()+
                ", Password "+ getPassword()+", Mail "+ getMail()+'}';
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
        final Player other = (Player) obj;
        if (this.id_player != other.id_player) {
            return false;
        }
        if (this.level != other.level) {
            return false;
        }
        if (this.getId() != other.getId()) {
            return false;
        }
        if (this.getPseudo() != other.getPseudo()) {
            return false;
        }
        if (this.getPassword() != other.getPassword()) {
            return false;
        }
        if (this.getMail() != other.getMail()) {
            return false;
        }
        return true;
    }
    
   
}
