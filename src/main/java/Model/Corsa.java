package Model;


/**
 * La classe corsa.
 */
public class Corsa {

    public String codiceCorsa;
    private double costoCorsa;
    private String stato;
    private String avviso;
    private Imbarcazione imbarcazioneUtilizzata;
    private Compagnia compagniaOfferente;


    /**
     * Costruttore Corsa.
     *
     * @param codice       il codice
     * @param costo        il costo
     * @param avviso       l'avviso
     * @param stato        lo stato
     * @param imbarcazione l'imbarcazione
     * @param compagnia    la compagnia
     */
    public Corsa(String codice, double costo, String avviso, String stato, Imbarcazione imbarcazione, Compagnia compagnia){
        this.codiceCorsa=codice;
        this.costoCorsa=costo;
        this.avviso=avviso;
        this.stato=stato;
        this.imbarcazioneUtilizzata= imbarcazione;
        this.compagniaOfferente=compagnia;
    }


    /**
     *  Restituisce il codice della corsa.
     *
     * @return the codiceCorsa
     */
    public String getCodiceCorsa() {
        return codiceCorsa;
    }

    /**
     * Restituisce il costo della corsa.
     *
     * @return the costoCorsa
     */
    public double getCostoCorsa() {
        return costoCorsa;
    }

    /**
     * Restituisce lo stato della corsa.
     *
     * @return stato
     */
    public String getStato() {
        return stato;
    }

    /**
     *  Restituisce l'avviso della corsa.
     *
     * @return avviso
     */
    public String getAvviso() {
        return avviso;
    }

    /**
     * Restituisce l'imbarcazione utilizzata della corsa.
     *
     * @return the imbarcazioneUtilizzata
     */
    public Imbarcazione getImbarcazioneUtilizzata() {
        return imbarcazioneUtilizzata;
    }

    /**
     * Restituisce l'oggetto compagnia che offre la corsa.
     *
     * @return the compagnia offerente
     */
    public Compagnia getCompagniaOfferente() {
        return compagniaOfferente;
    }

}