package DAO;

import Model.Corsa;
import Model.Percorso;

import java.util.ArrayList;

/**
 * L'interfaccia per l'aggiunte di corse
 */
public interface AggiungiCorseDAO {

    /**
     * Metodo per inserire le corse e i loro percorsi della compagnia, nel database
     *
     * @param percorsi arraylist di Classe percorso
     * @param corse    arraylist di Classe corsa
     * @return esito (boolean)
     */
    public boolean AggiungiCorseDB(ArrayList<Percorso> percorsi, ArrayList<Corsa> corse);
}
