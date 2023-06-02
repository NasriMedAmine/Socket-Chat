package services;

import model.*;

import java.sql.SQLException;
import java.util.ArrayList;

public interface iServicePlayer {
    public int ajouterPlayer(User user, Team team);
    public int modifierPlayer() throws SQLException;
    public int supprimerPlayer();
    public ArrayList<User> afficherPlayer();
    public User chercher();
}
