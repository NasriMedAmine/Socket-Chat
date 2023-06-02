package services;

import model.Pres_res;
import model.User;

import java.util.ArrayList;
import java.util.List;

public interface iServiceDemandeRes {

    public int AjoutDemandeRes(User user);
    public ArrayList<Pres_res> afficherDemandeRes();
}
