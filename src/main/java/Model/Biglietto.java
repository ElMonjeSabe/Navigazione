package Model;

import java.time.LocalDate;

/**
 * The type Biglietto.
 */
public class Biglietto {


    public void setGetPrenotazione(boolean getPrenotazione) {
        this.getPrenotazione = getPrenotazione;
    }

    public void setTipoBiglietto(String tipoBiglietto) {
        this.tipoBiglietto = tipoBiglietto;
    }

    public void setCodiceBiglietto(String codiceBiglietto) {
        CodiceBiglietto = codiceBiglietto;
    }

    public void setPrezzo(double prezzo) {
        Prezzo = prezzo;
    }

    public void setNumerobagagli(int numerobagagli) {
        this.numerobagagli = numerobagagli;
    }

    public void setVeicolo(boolean veicolo) {
        this.veicolo = veicolo;
    }

    public void setDataAcquisto(LocalDate dataAcquisto) {
        this.dataAcquisto = dataAcquisto;
    }

    public void setPrenotazione(boolean prenotazione) {
        this.prenotazione = prenotazione;
    }

    public void setPossessore(Passeggero possessore) {
        this.possessore = possessore;
    }

    public void setCorsa(Corsa corsa) {
        this.corsa = corsa;
    }

    public boolean getPrenotazione;
    private String tipoBiglietto;
    private String CodiceBiglietto;
    private double Prezzo;

    private int numerobagagli;
    private boolean veicolo;
    private LocalDate dataAcquisto;
    private boolean prenotazione;
    private Passeggero possessore;
    private Corsa corsa;

    public String getTipoBiglietto() {
        return tipoBiglietto;
    }

    public String getCodiceBiglietto() {
        return CodiceBiglietto;
    }

    public double getPrezzo() {
        return Prezzo;
    }

    public int getNumerobagagli() {
        return numerobagagli;
    }

    public boolean isVeicolo() {
        return veicolo;
    }

    public LocalDate getDataAcquisto() {
        return dataAcquisto;
    }

    public boolean isPrenotazione() {
        return prenotazione;
    }

    public Passeggero getPossessore() {
        return possessore;
    }










    String cfposs;
    String codCorsa;

    public Biglietto(int bagagli, boolean veicolo, String cfposs, String codCorsa) {
        this.numerobagagli=bagagli;
        this.veicolo=veicolo;
        this.dataAcquisto=LocalDate.now();
        this.prenotazione=prenotazione;
        this.cfposs=cfposs;
        this.codCorsa = codCorsa;
    }
    public String getcfposs() {
        return cfposs;
    }

    public String getcodCorsa() {
        return codCorsa;
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


/**
     * Instantiates a new Biglietto.
     *
     * @param bagagli      the bagagli
     * @param veicolo      the veicolo
     * @param dataAcquisto the data acquisto
     * @param prenotazione the prenotazione
     * @param possessore   the possessore
     * @param corsa        the corsa
     */
  /*  public Biglietto( int bagagli, boolean veicolo, LocalDate dataAcquisto, boolean prenotazione,Passeggero possessore, Corsa corsa){
        this.numerobagagli=bagagli;
        this.veicolo=veicolo;
        this.dataAcquisto=dataAcquisto;
        this.prenotazione=prenotazione;
        this.possessore=possessore;
        this.corsa=corsa;

    }
*/








}
