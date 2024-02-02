package DAO;

import Model.Imbarcazione;

import java.util.ArrayList;

/**
 * Interfaccia per prelevare le imbarcazioni di una compagnia
 */
public interface GetImbarcazioniDAO {
    /**
     * Metodo per prelevare tutte le imbarcazioni salvate nel database di una compagnia
     *
     * @param nomeComp il nome della compagnia
     * @return l'arraylist di imbarcazione
     */
    public ArrayList<Imbarcazione> GetImbarcazioniDB(String nomeComp);
}
