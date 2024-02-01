package Model;

import java.time.LocalDate;
import java.time.LocalTime;


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



    public Percorso(LocalTime orarioPartenza, LocalTime orarioArrivo, LocalDate dataAttivazione, LocalDate dataScadenza, String tappa, Porto porto, Corsa corsa) {
        this.orarioPartenza = orarioPartenza;
        this.orarioArrivo = orarioArrivo;
        this.dataAttivazione = dataAttivazione;
        this.dataScadenza = dataScadenza;
        this.tipoPercorso = tappa;
        this.porto = porto;
        this.corsa = corsa;
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

    public String getTipoPercorso() {
        return tipoPercorso;
    }

    public Porto getPorto() {
        return porto;
    }

    public Corsa getCorsa() {
        return corsa;
    }


}