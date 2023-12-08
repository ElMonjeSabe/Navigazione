package Model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * The type Percorso.
 */
public class Percorso {
    private LocalTime orarioPartenza;

    private LocalTime orarioArrivo;

    private LocalDate dataAttivazione;

    private LocalDate dataScadenza;

    private int tappa;

    private Porto porto;

    private Corsa corsa;

    /**
     * Instantiates a new Percorso.
     *
     * @param orarioPartenza  the orario partenza
     * @param orarioArrivo    the orario arrivo
     * @param dataAttivazione the data attivazione
     * @param dataScadenza    the data scadenza
     * @param tappa           the tappa
     * @param porto           the porto
     * @param corsa           the corsa
     */
    public Percorso(LocalTime orarioPartenza, LocalTime orarioArrivo, LocalDate dataAttivazione, LocalDate dataScadenza, int tappa, Porto porto, Corsa corsa) {
        this.orarioPartenza = orarioPartenza;
        this.orarioArrivo = orarioArrivo;
        this.dataAttivazione = dataAttivazione;
        this.dataScadenza = dataScadenza;
        this.tappa = tappa;
        this.porto = porto;
        this.corsa = corsa;
    }
}