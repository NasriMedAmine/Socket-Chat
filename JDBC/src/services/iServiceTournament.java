package services;

import model.Tournament;

import java.util.ArrayList;

public interface iServiceTournament {

    public int ajoutTournement(Tournament tournament);
    public ArrayList<Tournament> afficherTournament();
}
