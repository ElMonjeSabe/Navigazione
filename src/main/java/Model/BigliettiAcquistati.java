package Model;

import java.time.LocalDate;

/**
 * Classe di supporto per immagazzinare i biglietti acquistati
 */
public class BigliettiAcquistati {


    /**
     * Il codice corsa.
     */
    public String codicecorsa;
    /**
     * Il codice fiscale.
     */
    public String cf;
    /**
     * Il nome dell'utente.
     */
    public String nome;
    /**
     * Il cognome dell'utente.
     */
    public String cognome;
    /**
     * Il codice del biglietto.
     */
    public String codicebiglietto;
    /**
     * Il tipo di biglietto (intero, ridotto).
     */
    public String tipobiglietto;
    /**
     * La data di nascita del passeggero.
     */
    public LocalDate datanascita;
    /**
     * La data in cui è stato acquistato il biglietto.
     */
    public LocalDate dataacquisto;
    /**
     * Il numero di bagagli.
     */
    public int numeroBagagli;

    /**
     * Il prezzo.
     */
    public float prezzo;
    /**
     * Se possiede un veicolo o no.
     */
    public Boolean veicolo;
    /**
     * Se è un biglietto con prenotazione.
     */
    public Boolean prenotazione;

    /**
     * Costruttore BigliettiAcquistati.
     *
     * @param codicecorsa     il codicecorsa
     * @param cf              il codice fiscale
     * @param nome            il nome
     * @param cognome         il cognome
     * @param datanascita     la data di nascita
     * @param codicebiglietto il codice del biglietto
     * @param tipobiglietto   il tipo di biglietto
     * @param prezzo          il prezzo
     * @param dataacquisto    la data d'acquisto
     * @param veicolo         se ha un veicolo veicolo
     * @param numeroBagagli   il numero di bagagli
     * @param prenotazione    se è con prenotazione
     */
    public BigliettiAcquistati(String codicecorsa, String cf, String nome, String cognome, LocalDate datanascita, String codicebiglietto, String tipobiglietto, float prezzo, LocalDate dataacquisto,Boolean veicolo,int numeroBagagli, Boolean prenotazione) {
        this.codicecorsa = codicecorsa;
        this.cf = cf;
        this.nome = nome;
        this.cognome = cognome;
        this.codicebiglietto = codicebiglietto;
        this.tipobiglietto = tipobiglietto;
        this.datanascita = datanascita;
        this.dataacquisto = dataacquisto;
        this.prezzo = prezzo;
        this.numeroBagagli = numeroBagagli;
        this.veicolo = veicolo;
        this.prenotazione = prenotazione;
    }


}
