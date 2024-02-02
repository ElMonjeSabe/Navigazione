package DAO;

import Model.Imbarcazione;

import java.util.ArrayList;

/**
 * L'interfaccia per l'aggiunta di Imbarcazione.
 */
public interface AggiungiImbarcazioneDAO {

    /**
     * Metodo per inserire l'imbarcazione creata dalla compagnia, nel database
     *
     * @param imb l'imbarcazione
     * @return esito della query (boolean)
     */
    public boolean AggiungiImbarcazioneDB(Imbarcazione imb);

}
