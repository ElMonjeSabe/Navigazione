package DAO;

import Model.Porto;

import java.util.ArrayList;

/**
 * Interfaccia per prelevare i codici dei porti
 */
public interface GetPortiDAO {
    /**
     * Metodo per prelevare tutte le imbarcazioni salvate nel
     *
     * @return l'array list di Porto
     */
    public ArrayList<Porto> GetPortiDB();
}
