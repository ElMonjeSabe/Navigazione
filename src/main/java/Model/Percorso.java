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
    private String codCorsa;
    private int codPorto;



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

    public Percorso(LocalTime orarioPartenza, LocalTime orarioArrivo, LocalDate dataAttivazione, LocalDate dataScadenza, int tappa, int codPorto, String corsa) {
        this.orarioPartenza = orarioPartenza;
        this.orarioArrivo = orarioArrivo;
        this.dataAttivazione = dataAttivazione;
        this.dataScadenza = dataScadenza;
        this.tappa = tappa;
        this.codPorto=codPorto;
        this.codCorsa = corsa;
    }


    public LocalTime getOrarioPartenza() {
        return orarioPartenza;
    }

    public LocalTime getOrarioArrivo() {
        return orarioArrivo;
    }

    public LocalDate getDataAttivazione() {
        return dataAttivazione;
    }

    public LocalDate getDataScadenza() {
        return dataScadenza;
    }

    public int getTappa() {
        return tappa;
    }

    public Porto getPorto() {
        return porto;
    }

    public Corsa getCorsa() {
        return corsa;
    }

    public String getCodCorsa() {
        return codCorsa;
    }

    public int getCodPorto() {
        return codPorto;
    }

    public void stampaPercorso()
    {
        System.out.println(this.orarioPartenza+ " ");
        System.out.println(this.orarioArrivo+ " ");
        System.out.println(this.dataAttivazione+ " ");
        System.out.println(this.dataScadenza+ " ");
        System.out.println(this.tappa+" ");
        System.out.println(this.codPorto+" ");
        System.out.println(this.codCorsa+ "\n\n");
    }
}