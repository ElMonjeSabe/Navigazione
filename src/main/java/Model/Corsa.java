package Model;

import java.util.ArrayList;

/**
 * The type Corsa.
 */
public class Corsa {
    private String codiceCorsa;
    private double costoCorsa;

    private String stato;

    private String avviso;

    private ArrayList<Biglietto> biglietti;

    private ArrayList<Imbarcazione> imbarcazioni;

    private ArrayList<Percorso> percorsi;

    private ArrayList<Compagnia> compagnie;

    //vedere se fare costruttore passando direttamente l'arraylist di percorsi

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
        this.imbarcazioni.add(imbarcazione);
        this.percorsi.add(percorso);
        this.compagnie.add(compagnia);
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
        this.imbarcazioni.add(imbarcazione);
        this.percorsi.add(percorso);
        this.compagnie.add(compagnia);
        this.biglietti.add(biglietto);
    }

    /**
     * Mostra corse.
     */
    public void MostraCorse(){

    }

    public String getCodiceCorsa() {
        return codiceCorsa;
    }
}