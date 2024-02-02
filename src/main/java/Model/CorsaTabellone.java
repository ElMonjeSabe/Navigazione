package Model;


import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;


/**
 * Classe di supporto per memorizzare tutte le corse disponibili nelle successive 48 ore.
 */
public class CorsaTabellone {
    /**
     * Il Codice corsa.
     */
    public String CodiceCorsa;
    /**
     * Il costo della corsa.
     */
    public Float costocorsa;
    /**
     * Il nome della compagnia.
     */
    public String nomeCompagnia;
    /**
     * Il nome del porto di partenza.
     */
    public String partenza;
    /**
     * La città di partenza.
     */
    public String cittapartenza;
    /**
     * La nazione di partenza.
     */
    public String nazionepartenza;
    /**
     * Il nome del porto di destinazione.
     */
    public String destinazione;
    /**
     * La citta di destinazione.
     */
    public String cittadestinazione;
    /**
     * La nazione  di destinazione.
     */
    public String nazionedestinazione;
    /**
     * La data di partenza.
     */
    public LocalDate datapartenza;
    /**
     * La  data di arrivo.
     */
    public LocalDate dataarrivo;
    /**
     * l'orario di partenza.
     */
    public Time orariopartenza;
    /**
     * L'orario di arrivo.
     */
    public Time orarioarrivo;

    /**
     * Lo stato della corsa.
     */
    public String stato;

    /**
     * L'avviso.
     */
    public String avviso;
    /**
     * Gli scali.
     */
    public int scali;


    /**
     * Costruttore CorsaTabellone.
     *
     * @param CodiceCorsa         il codice corsa
     * @param costocorsa          il costo della corsa
     * @param scali               gli scali
     * @param nomeCompagnia       il nome della compagnia
     * @param partenza            il nome del porto di partenza
     * @param cittapartenza       la città di partenza
     * @param nazionepartenza     la nazione di partenza
     * @param destinazione        il nome del porto di destinazione
     * @param cittadestinazione   la città di destinazione
     * @param nazionedestinazione la nazione di destinazione
     * @param datapartenza        la data di partenza
     * @param dataarrivo          la data di arrivo
     * @param orariopartenza      l'orario di partenza
     * @param orarioarrivo        l'orario di arrivo
     * @param stato               lo stato
     * @param avviso              l'avviso
     */
    public CorsaTabellone(String CodiceCorsa, Float costocorsa, int scali, String nomeCompagnia, String partenza, String cittapartenza, String nazionepartenza, String destinazione, String cittadestinazione, String nazionedestinazione, LocalDate datapartenza, LocalDate dataarrivo, Time orariopartenza, Time orarioarrivo, String stato, String avviso) {
                this.CodiceCorsa = CodiceCorsa;
                this.costocorsa = costocorsa;
                this.scali = scali;
                this.nomeCompagnia=nomeCompagnia;
                this.partenza = partenza;
                this.cittapartenza = cittapartenza;
                this.nazionepartenza = nazionepartenza;
                this.destinazione = destinazione;
                this.cittadestinazione = cittadestinazione;
                this.nazionedestinazione = nazionedestinazione;
                this.datapartenza = datapartenza;
                this.dataarrivo = dataarrivo;
                this.orariopartenza = orariopartenza;
                this.orarioarrivo = orarioarrivo;
                this.stato = stato;
                this.avviso = avviso;


            }



}
