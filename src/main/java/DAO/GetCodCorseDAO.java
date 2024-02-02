package DAO;

import Model.Imbarcazione;

import java.util.ArrayList;

/**
 * L'interfaccia per prelevare il codice delle corse
 */
public interface GetCodCorseDAO {

    /**
     * Metodo per prelevare nel database tutti i codicecorsa di una compagnia, utilizzato durante la modifica della corsa
     *
     * @param nomeComp il nome della compagnia
     * @return the array list di String che rappresentano il codice delle corse
     */
    public ArrayList<String> GetCodCorseDB(String nomeComp);

}
