package Model;

import java.util.ArrayList;

/**
 * The type Corsa.
 */
public class Corsa {
    public String codiceCorsa;
    private double costoCorsa;

    private String stato;

    private String avviso;

    private Imbarcazione imbarcazioneUtilizzata;

    private Compagnia compagniaOfferente;

    private String nomeCompagniaOfferente;

    private ArrayList<Biglietto> biglietti;


    private ArrayList<Percorso> percorsi;


    /**
     * Instantiates a new Corsa.
     *
     * @param codice       the codice
     * @param costo        the costo
     * @param avviso       the avviso
     * @param stato        the stato
     * @param imbarcazione the imbarcazione
     * @param percorso     the percorso
     * @param compagnia    the compagnia
     */
    public Corsa(String codice, double costo, String avviso, String stato, Imbarcazione imbarcazione, Percorso percorso, Compagnia compagnia){
        this.codiceCorsa=codice;
        this.costoCorsa=costo;
        this.avviso=avviso;
        this.stato=stato;
        this.imbarcazioneUtilizzata= imbarcazione;
        this.percorsi.add(percorso);
        this.compagniaOfferente=compagnia;
    }



    public Corsa(String codice, double costo, String avviso, String stato, Imbarcazione imbarcazione, String nomeComp){
        this.codiceCorsa=codice;
        this.costoCorsa=costo;
        this.avviso=avviso;
        this.stato=stato;
        this.imbarcazioneUtilizzata= imbarcazione;
        this.nomeCompagniaOfferente=nomeComp;
    }



    public Corsa(String codice, double costo, String avviso, String stato, Imbarcazione imbarcazione, Compagnia compagnia){
        this.codiceCorsa=codice;
        this.costoCorsa=costo;
        this.avviso=avviso;
        this.stato=stato;
        this.imbarcazioneUtilizzata= imbarcazione;
        this.compagniaOfferente=compagnia;
    }


    /**
     * Instantiates a new Corsa.
     *
     * @param codice       the codice
     * @param costo        the costo
     * @param avviso       the avviso
     * @param stato        the stato
     * @param imbarcazione the imbarcazione
     * @param percorso     the percorso
     * @param compagnia    the compagnia
     * @param biglietto    the biglietto
     */
    public Corsa(String codice, double costo, String avviso, String stato, Imbarcazione imbarcazione, Percorso percorso, Compagnia compagnia, Biglietto biglietto){
        this.codiceCorsa=codice;
        this.costoCorsa=costo;
        this.avviso=avviso;
        this.stato=stato;
        this.imbarcazioneUtilizzata= imbarcazione;
        this.percorsi.add(percorso);
        this.compagniaOfferente=compagnia;
        this.biglietti.add(biglietto);
    }


    public String getCodiceCorsa() {
        return codiceCorsa;
    }


    public double getCostoCorsa() {
        return costoCorsa;
    }

    public String getStato() {
        return stato;
    }

    public String getAvviso() {
        return avviso;
    }

    public Imbarcazione getImbarcazioneUtilizzata() {
        return imbarcazioneUtilizzata;
    }



    public Compagnia getCompagniaOfferente() {
        return compagniaOfferente;
    }

}