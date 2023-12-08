package Model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * The type Biglietto.
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

    private Cabina posto;


    /**
     * Instantiates a new Biglietto.
     *
     * @param bagagli      the bagagli
     * @param veicolo      the veicolo
     * @param prenotazione the prenotazione
     * @param possessore   the possessore
     * @param corsa        the corsa
     * @param cabina       the cabina
     */
    public Biglietto( int bagagli, boolean veicolo, boolean prenotazione,Passeggero possessore, Corsa corsa, Cabina cabina){
        this.numerobagagli=bagagli;
        this.veicolo=veicolo;
        this.dataAcquisto=LocalDate.now();
        this.prenotazione=prenotazione;
        this.possessore=possessore;
        this.corsa=corsa;
        this.posto=cabina;
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
     * @param cabina       the cabina
     */
    public Biglietto( int bagagli, boolean veicolo, LocalDate dataAcquisto, boolean prenotazione,Passeggero possessore, Corsa corsa, Cabina cabina){
        this.numerobagagli=bagagli;
        this.veicolo=veicolo;
        this.dataAcquisto=dataAcquisto;
        this.prenotazione=prenotazione;
        this.possessore=possessore;
        this.corsa=corsa;
        this.posto=cabina;
    }








}
