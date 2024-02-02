package DAO;


import Model.Social;

/**
 * L'interfaccia per aggiungere il social
 */
public interface AggiungiSocialDAO {
    /**
     * Metodo per inviare al database i dati del social appena creata
     *
     * @param soc la classe social
     * @return esito (boolean)
     */
    public boolean AggiungiSocialDB(Social soc);
}
