package Model;

/**
 * La Classe Porto
 */
public class Porto {


    private String NomePorto;
    private String Citta;
    private String Nazione;
    private int idPorto;


    /**
     * Costruttore di Porto passando:
     *
     * @param nomePorto il nome del porto
     * @param citta     la città
     * @param nazione   la nazione del porto
     * @param idPorto   l'id numerico del porto
     */
    public Porto(String nomePorto, String citta, String nazione, int idPorto) {
        NomePorto = nomePorto;
        Citta = citta;
        Nazione = nazione;
        this.idPorto=idPorto;
    }


    /**
     * Metodo getter Del Nome Porto
     *
     * @return Stringa del Nome Porto
     */
    public String getNomePorto() {
        return NomePorto;
    }

    /**
     * Metodo getter Del Nome Porto
     *
     * @return Ritorna la stringa della città del porto
     */
    public String getCitta() {
        return Citta;
    }

    /**
     * Metodo getter della nazione del porto
     *
     * @return Ritorna la stringa della nazione del porto
     */
    public String getNazione() {
        return Nazione;
    }

    /**
     * Metodo getter dell'id del porto
     *
     * @return Ritorna il codice numerico dell'id del porto
     */
    public int getIdPorto() {
        return idPorto;
    }

}
