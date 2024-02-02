package DAO;


/**
 * L'interfaccia con i metodi per cancellare le corse nel database
 */
public interface CancellaCorsaDAO {

    /**
     * Metodo per eliminare nel database la corsa passata per parametro (il suo codice)
     *
     * @param codice il codice corsa
     * @return esito (boolean)
     */
    public boolean CancellaCorsaDB(String codice);
}
