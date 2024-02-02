package DAO;

import Model.CorsaTabellone;

/**
 * L'interfaccia con i metodi per manipolare le corse sul database (modifica, prelevazione)
 */
public interface GestisciCorsaDAO {


    /**
     * Metodo per modificare la corsa in base ai parametri inseriti
     *
     * @param CodiceCorsa   il codice corsa
     * @param Avviso        l'avviso
     * @param Stato         lo stato
     * @param NomeCompagnia il nome della compagnia
     * @return boolean (esito)
     */
    boolean ModificaCorsaDB(String CodiceCorsa, String Avviso, String Stato, String NomeCompagnia);

    /**
     * Metodo per prelevare una corsa salvata nel database, a partire dal suo codice
     *
     * @param CodCorsa il codice della corsa
     * @return la corsa tabellone
     */
    CorsaTabellone GetCorsaDB(String CodCorsa);
}
