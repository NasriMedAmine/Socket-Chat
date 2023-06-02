package services;

import model.Team;
import model.User;

import java.sql.SQLException;
import java.util.ArrayList;

public interface iServiceTeam {
    public int ajouterTeam(User user, String nom ,int nbr );
    public Team modifierTeam() throws SQLException;
    public int supprimerTeam();
    public ArrayList<Team> afficherTeam();
    public Team chercher();
}
