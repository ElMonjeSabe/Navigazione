package DAO;

import Model.Corsa;
import Model.Percorso;

import java.util.ArrayList;

public interface AggiungiCorseDAO {

    public boolean AggiungiCorseDB(ArrayList<Percorso> percorsi, ArrayList<Corsa> corse);
}
