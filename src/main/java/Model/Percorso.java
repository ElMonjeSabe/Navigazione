package Model;

import java.time.LocalDate;
import java.time.LocalTime;


/**
 * La Classe Percorso
 */
public class Percorso {
    private LocalTime orarioPartenza;

    private LocalTime orarioArrivo;

    private LocalDate dataAttivazione;

    private LocalDate dataScadenza;

    private String tipoPercorso;

    private Porto porto;

    private Corsa corsa;

    //   private String codCorsa;
//    private int codPorto;


    /**
     * Costruttore di Percorso
     *
     * @param orarioPartenza  L'orario della partenza
     * @param orarioArrivo    L'orario di arivo
     * @param dataAttivazione La data di partenza
     * @param dataScadenza    La data di arrivo
     * @param tappa           Il tipo del percorso (partenza,scalo,destinazione)
     * @param porto           L'oggetto Porto
     * @param corsa           L'oggetto corsa
     */
    public Percorso(LocalTime orarioPartenza, LocalTime orarioArrivo, LocalDate dataAttivazione, LocalDate dataScadenza, String tappa, Porto porto, Corsa corsa) {
        this.orarioPartenza = orarioPartenza;
        this.orarioArrivo = orarioArrivo;
        this.dataAttivazione = dataAttivazione;
        this.dataScadenza = dataScadenza;
        this.tipoPercorso = tappa;
        this.porto = porto;
        this.corsa = corsa;
    }


    /**
     * Metodo getter dell'orario di partenza
     *
     * @return LocalTime che rappresenta l'orario di partenza
     */
    public LocalTime getOrarioPartenza() {
        return orarioPartenza;
    }

    /**
     * Metodo getter dell'orario di arrivo
     *
     * @return LocalTime che rappresenta l'orario di arrivo
     */
    public LocalTime getOrarioArrivo() {
        return orarioArrivo;
    }

    /**
     * Metodo getter della data di partenza
     *
     * @return LocalDate che rappresenta la data di partenza
     */
    public LocalDate getDataAttivazione() {
        return dataAttivazione;
    }

    /**
     * Metodo getter della datascandenza (data di arrivo)
     *
     * @return LocalDate che rappresenta la datascadenza
     */
    public LocalDate getDataScadenza() {
        return dataScadenza;
    }

    /**
     * Metodo getter della tipologia del percorso
     *
     * @return stringa che rappresenta il tipo del percorso (partenza, scalo o destinazione)
     */
    public String getTipoPercorso() {
        return tipoPercorso;
    }

    /**
     * Metodo getter della classe Porto
     *
     * @return Oggetto Porto
     */
    public Porto getPorto() {
        return porto;
    }

    /**
     * Metodo getter della classe Corsa
     *
     * @return Oggetto Corsa
     */
    public Corsa getCorsa() {
        return corsa;
    }


}