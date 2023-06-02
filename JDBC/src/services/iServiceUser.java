package services;

import model.*;

import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;

public interface iServiceUser {


    public int ajouterUser(User user);
    public int modifierUser() throws SQLException;
    public int supprimerUser();
    public ArrayList<User> afficherUser();
    public User chercher();
    public User logIn(String login , String pwd);
    public ArrayList<User> afficherUserLogIn(String login , String pwd);


}
