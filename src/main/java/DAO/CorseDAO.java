package DAO;

import Model.CorsaTabellone;

import java.util.ArrayList;

/**
 * L'interfaccia con i metodi per leggere le corse dal tabellone
 */
public interface CorseDAO {

    /**
     * Metodo per prelevare il tabellone dal database
     *
     * @param a l'arraylist di corsatabellone
     */
    void leggiCorseDB(ArrayList<CorsaTabellone> a);

    /**
     * Metodo per prelevare tutte le corse della compagnia (il nome) passata per parametro
     *
     * @param a l'arraylist di corsatabellone
     * @param nomeCompagnia il nome della compagnia
     */
    void leggiCorseCompagniaDB(ArrayList<CorsaTabellone> a, String nomeCompagnia);

    /**
     * Metodo per prelevare il tabellone dal database, filtrato per prezzo, compagnia e per il tipo di imbarcazione
     *
     * @param corse   l'arraylist di corse
     * @param TipoImb il tipo di imbarcazione
     * @param prezzo  il prezzo
     * @param comp    la compagnia
     */
    void leggiCorseFiltroDB(ArrayList<CorsaTabellone> corse, String TipoImb, int prezzo, String comp);


    /**
     * Leggi corse della compagnia filtrate, per prezzo e per il tipo di imbarcazioni,dal database
     *
     * @param corse   l'arraylist di corse
     * @param TipoImb il tipo di imbarcazione
     * @param prezzo  il prezzo
     * @param comp    la compagnia
     */
    void leggiCorseCompagniaFiltroDB(ArrayList<CorsaTabellone> corse, String TipoImb, int prezzo, String comp);

}
