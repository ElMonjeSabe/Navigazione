package DAO;

import Model.Compagnia;
import Model.Corsa;
import Model.Imbarcazione;
import Model.Percorso;

import java.util.ArrayList;

/**
 * Interfaccia utilizzata per la registrazione di una compagnia
 */
public interface RegistrazioneCompagniaDAO {
    /**
     * Metodo per inviare al database i dati della compagnia appena registrata
     *
     * @param comp la classe compagnia
     * @param imb  la classe imbarcazione della compagnia
     * @return esito (boolean)
     */
    public boolean RegistrazioneCompagniaDB(Compagnia comp, Imbarcazione imb);
}
