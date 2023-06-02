package services;

import model.Responsable;
import model.User;

import java.sql.SQLException;
import java.util.ArrayList;

public interface iServiceResp {

    public int ajoutResp(User user) throws SQLException;
    public ArrayList<Responsable> afficherResponsable();

    boolean isResponsable(User user1);
}
