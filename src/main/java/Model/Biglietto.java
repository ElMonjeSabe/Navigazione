package Model;

import java.time.LocalDate;

/**
 * The type Biglietto.
 */
public class Biglietto {

    private String tipoBiglietto;
    private String CodiceBiglietto;
    private double Prezzo;
    private int numerobagagli;
    private boolean veicolo;
    private LocalDate dataAcquisto;
    private boolean prenotazione;
    private Passeggero possessore;
    private Corsa corsa;

    private String cfposs;
    private String codCorsa;

    public Biglietto(int bagagli,String tipoBiglietto ,boolean veicolo, String cfposs, String codCorsa) {
        this.numerobagagli=bagagli;
        this.tipoBiglietto = tipoBiglietto;
        this.veicolo=veicolo;
        this.dataAcquisto=LocalDate.now();
        this.cfposs=cfposs;
        this.codCorsa = codCorsa;

    }


    /**
     * Instantiates a new Biglietto.
     */
    public Biglietto(int bagagli, boolean veicolo, LocalDate dataAcquisto, boolean prenotazione,Passeggero possessore, Corsa corsa)
 {
        this.numerobagagli=bagagli;
        this.veicolo=veicolo;
        this.dataAcquisto=LocalDate.now();
        this.prenotazione=prenotazione;
        this.possessore=possessore;
        this.corsa = corsa;

    }


    public Corsa getCorsa() {
        return corsa;
    }

    public boolean getVeicolo() {
        return veicolo;
    }

    public void setPrezzo(double prezzo) {
        Prezzo = prezzo;
    }


    public void setCorsa(Corsa corsa) {
        this.corsa = corsa;
    }


    public String getcfposs() {
        return cfposs;
    }

    public String getcodCorsa() {
        return codCorsa;
    }


    public String getTipoBiglietto() {
        return tipoBiglietto;
    }


    public double getPrezzo() {
        return Prezzo;
    }

    public int getNumerobagagli() {
        return numerobagagli;
    }







}
