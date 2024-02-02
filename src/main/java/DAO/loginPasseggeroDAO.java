package DAO;

import Model.Passeggero;

/**
 * Interfaccia utilizzata per il login da parte della compagnia
 */
public interface loginPasseggeroDAO {

    /**
     * Metodo per controllare che le credenziali inseriti durante l'accesso di passeggero siano corretti. Se si, passa tutte le informazioni in una classe
     *
     * @param email    l'email del passeggero
     * @param password la password del passeggero
     * @return la classe di tipo Passeggero
     */
    public Passeggero loginPasseggeroDB(String email, String password);
}
