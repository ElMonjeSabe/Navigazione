package DAO;

import Model.Compagnia;


/**
 * Interfaccia utilizzata per il login da parte della compagnia
 */
public interface LoginCompagniaDAO {
    /**
     * Metodo per controllare che le credenziali inseriti durante l'accesso di compagnia siano corretti. Se si, passa tutte le informazioni in una classe
     *
     * @param email    l'email della compagnia
     * @param password la password della compagnia
     * @return la classe di tipo compagnia
     */
    public Compagnia loginCompagniaDB(String email, String password);
}
