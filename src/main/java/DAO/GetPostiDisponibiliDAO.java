package DAO;

/**
 * Interfaccia con i metodi per prelevare i posti disponibili in una corsa
 */
public interface GetPostiDisponibiliDAO {
    /**
     * Metodo getter posti disponibili db int [ ].
     *
     * @param CodCorsa il codice della corsa
     * @return the int [ ] (array di int, uno per i passeggeri e uno per i veicoli)
     */
    int[] getPostiDisponibiliDB(String CodCorsa);
}
