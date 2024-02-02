package DAO;

import Model.Passeggero;

/**
 * Interfaccia utilizzata per la registrazione di un passeggero
 */
public interface RegistrazionePasseggeroDAO {
    /**
 * Metodo per inserire il passeggero nel database durante la registrazione
 *
 * @param p il passeggero
 * @return int (esito)
 */
    public int AggiungiPasseggeroDB(Passeggero p);
}
