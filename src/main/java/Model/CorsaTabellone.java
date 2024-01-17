package Model;


import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;


public class CorsaTabellone {
    public String CodiceCorsa;
    public Float costocorsa;
    public String partenza;
    public String cittapartenza;
    public String nazionepartenza;
    public String destinazione;
    public String cittadestinazione;
    public String nazionedestinazione;
    public LocalDate datapartenza;
    public LocalDate dataarrivo;
    public Time orariopartenza;
    public Time orarioarrivo;

    public String stato;

    public String avviso;

    public int scali;
            public CorsaTabellone(String CodiceCorsa, Float costocorsa,int scali, String partenza, String cittapartenza, String nazionepartenza, String destinazione, String cittadestinazione, String nazionedestinazione, LocalDate datapartenza, LocalDate dataarrivo, Time orariopartenza, Time orarioarrivo, String stato, String avviso) {
                this.CodiceCorsa = CodiceCorsa;
                this.costocorsa = costocorsa;
                this.scali = scali;
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
    @Override
    public String toString() {
        return "Corsa{" +
                "CodiceCorsa='" + CodiceCorsa + '\'' +
                ", costocorsa='" + costocorsa + '\'' +
                ",scali='" +scali+
                ", partenza='" + partenza + '\'' +
                ", cittapartenza='" + cittapartenza + '\'' +
                ", nazionepartenza='" + nazionepartenza + '\'' +
                ", destinazione='" + destinazione + '\'' +
                ", cittadestinazione='" + cittadestinazione + '\'' +
                ", nazionedestinazione='" + nazionedestinazione + '\'' +
                ", datapartenza='" + datapartenza + '\'' +
                ", dataarrivo='" + dataarrivo + '\'' +
                ", orariopartenza='" + orariopartenza + '\'' +
                ", orarioarrivo='" + orarioarrivo + '\'' +
                ", stato='" + stato + '\'' +
                ", avviso='" + avviso + '\'' +
                '}';
    }


}
