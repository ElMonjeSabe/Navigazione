package Model;

import java.time.LocalDate;

/**
 * The type Biglietto.
 */
public class Biglietto {
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
