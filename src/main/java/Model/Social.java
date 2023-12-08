package Model;

/**
 * The type Social.
 */
public class Social {
    private String URL;
    private String nomeSocial;
    private Compagnia compagnia;

    /**
     * Instantiates a new Social.
     *
     * @param URL        the url
     * @param nomeSocial the nome social
     * @param compagnia  the compagnia
     */
    public Social(String URL, String nomeSocial, Compagnia compagnia) {
        this.URL = URL;
        this.nomeSocial = nomeSocial;
        this.compagnia = compagnia;
    }
}
