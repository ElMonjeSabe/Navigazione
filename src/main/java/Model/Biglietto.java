package Model;

import java.time.LocalDate;


/**
 * La classe Biglietto.
 */
public class Biglietto {

    private String tipoBiglietto;
    private double Prezzo;
    private int numerobagagli;
    private boolean veicolo;
    private LocalDate dataAcquisto;
    private boolean prenotazione;
    private Passeggero possessore;
    private Corsa corsa;

    private String cfposs;
    private String codCorsa;

    /**
     * Costruttore di Biglietto.
     *
     * @param bagagli       il numero di bagagli assegnati
     * @param tipoBiglietto il tipo biglietto
     * @param veicolo       se possiede un veicolo
     * @param cfposs        codice fiscale del passeggere che sta acquistando il biglietto
     * @param codCorsa      il codice della corsa a cui si riferisce il biglietto
     */
    public Biglietto(int bagagli,String tipoBiglietto ,boolean veicolo, String cfposs, String codCorsa) {
        this.numerobagagli=bagagli;
        this.tipoBiglietto = tipoBiglietto;
        this.veicolo=veicolo;
        this.dataAcquisto=LocalDate.now();
        this.cfposs=cfposs;
        this.codCorsa = codCorsa;

    }


    /**
     * Restituisce l'oggetto la corsa a cui si riferisce il biglietto.
     *
     * @return corsa
     */
    public Corsa getCorsa() {
        return corsa;
    }

    /**
     * Restituisce il valore di veicolo.
     *
     * @return veicolo
     */
    public boolean getVeicolo() {
        return veicolo;
    }

    /**
     * Permette di assegnare un valore a prezzo.
     *
     * @param prezzo il prezzo che gli si vuole assegnare
     */
    public void setPrezzo(double prezzo) {
        Prezzo = prezzo;
    }


    /**
     * Permette di assegnare un oggetto a corsa.
     *
     * @param corsa the corsa
     */
    public void setCorsa(Corsa corsa) {
        this.corsa = corsa;
    }


    /**
     * Restituisce il codice fiscale del biglietto.
     *
     * @return cfposs
     */
    public String getcfposs() {
        return cfposs;
    }

    /**
     * Restituisce il codice del biglietto.
     *
     * @return  codcorsa
     */
    public String getcodCorsa() {
        return codCorsa;
    }


    /**
     * Restituise il tipo di biglietto.
     *
     * @return tipoBiglietto
     */
    public String getTipoBiglietto() {
        return tipoBiglietto;
    }


    /**
     * Restituisce il prezzo del biglietto.
     *
     * @return prezzo
     */
    public double getPrezzo() {
        return Prezzo;
    }

    /**
     *Restituisce il numero di bagagli.
     *
     * @return numeroBagagli
     */
    public int getNumeroBagagli() {
        return numerobagagli;
    }

}
