package Model;


/**
 * La Classe Social.
 */
public class Social {
    /**
     Stringa che rappresenta l'URL
     */
    private String URL;
    /**
     Stringa che il nome del Social
     */
    private String nomeSocial;
    /**
        La Classe Compagnia del social
     */

    private Compagnia compagnia;


    /**
     * Costruttore per instanziare un social passando:.
     *
     * @param URL        l'url del sito
     * @param nomeSocial il nome del social
     * @param compagnia  il nome della compagnia
     */
    public Social(String URL, String nomeSocial, Compagnia compagnia) {
        this.URL = URL;
        this.nomeSocial = nomeSocial;
        this.compagnia = compagnia;
    }

    /**
     * metodo getter url.
     *
     * @return la stringa che rappresenta l'URL
     */
    public String getURL() {
        return URL;
    }

    /**
     * metodo getter url.
     *
     * @return la stringa del nome del social
     */
    public String getNomeSocial() {
        return nomeSocial;
    }

    /**
     * metodo getterl classe Compagnia
     *
     * @return l'oggetto di classe Compagnia
     */
    public Compagnia getCompagnia() {
        return compagnia;
    }
}
