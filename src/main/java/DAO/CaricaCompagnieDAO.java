package DAO;

import Model.Compagnia;

import java.util.ArrayList;

/**
 * L'interfaccia utilizzata per la lettura di compagnie
 */
public interface CaricaCompagnieDAO {

    /**
     * Metodo per prelevare nel database tutte le compagnie memorizzate
     *
     * @return l'arraylist di compagnia
     */
    ArrayList<Compagnia> CaricaCompagnieDB();

}
