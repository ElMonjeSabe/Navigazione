package DAO;

import Model.Biglietto;

import java.util.ArrayList;

/**
 * L'interfaccia per l'acquisto di biglietti
 */
public interface AcquistaBigliettoDAO {

    /**
     * Metodo per inserire i biglietti acquistati nel database
     *
     * @param b l'arraylist di Biglietto
     * @return esito in int
     */
    int AcquistaBigliettoDB(ArrayList<Biglietto> b);
}
