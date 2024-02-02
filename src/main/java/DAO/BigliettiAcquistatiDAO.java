package DAO;

import Model.BigliettiAcquistati;

import java.util.ArrayList;

/**
 * L'interfaccia con i metodi per inserire i biglietti acqusitati
 */
public interface BigliettiAcquistatiDAO {
    /**
     * Metodo per prelevare nel database tutti i biglietti associati a una compagnia
     *
     * @param BA            arraylist di bigliettiacquistati
     * @param NomeCompagnia il nome della compagnia
     */
    void leggiBigliettiAcquistatiCompagniaDB(ArrayList<BigliettiAcquistati> BA, String NomeCompagnia);

    /**
     * Metodo per prelevare nel database tutti i biglietti associati a una compagnia, filtrato per prezzo e/o codicecorsa
     *
     * @param BA            arraylist di bigliettiacquistati
     * @param codiceCorsa   il codice della corsa
     * @param prezzo        il prezzo
     * @param nomeCompagnia il nome della compagnia
     */
    void leggiBigliettiFiltratiAcquistatiCompagniaDB(ArrayList<BigliettiAcquistati> BA, String codiceCorsa, int prezzo,String nomeCompagnia);

    /**
     * Metodo per prelevare nel database tutti i biglietti di un passeggero
     *
     * @param BA arraylist di biglietti acquistati
     * @param cf il codice fiscale del passeggero
     */
    void leggiBigliettiAcquistatiUtenteDB(ArrayList<BigliettiAcquistati> BA, String cf);
}
