package Model;


public class Social {
    private String URL;
    private String nomeSocial;
    private Compagnia compagnia;


    public Social(String URL, String nomeSocial, Compagnia compagnia) {
        this.URL = URL;
        this.nomeSocial = nomeSocial;
        this.compagnia = compagnia;
    }

    public String getURL() {
        return URL;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }

    public Compagnia getCompagnia() {
        return compagnia;
    }
}
