package Model;

import java.time.LocalDate;

public class BigliettiAcquistati {

    public String codicecorsa, cf,nome,cognome, codicebiglietto,tipobiglietto;
    public LocalDate datanascita,dataacquisto;
    public int numeroBagagli;

    public float prezzo;
    public Boolean veicolo, prenotazione;

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
