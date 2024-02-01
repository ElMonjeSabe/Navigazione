package Model;

import java.time.LocalDate;

public class BigliettiAcquistati {

    //mettere nome camel case (ES. CodiceCorsa) e nei campo, al posto di public, mettere private

    public String codicecorsa;
    public String cf;
    public String nome;
    public String cognome;
    public String codicebiglietto;
    public String tipobiglietto;
    public LocalDate datanascita;

    public LocalDate dataacquisto;
    public int numeroBagagli;

    public float prezzo;
    public Boolean veicolo;

    public Boolean prenotazione;

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
