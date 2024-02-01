package Model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * The type Passeggero.
 */
public class Passeggero {

    private String cf;
    private String nome;
    private LocalDate dataNascita;
    private String cognome;
    private String email;
    private String password;
    private ArrayList<Biglietto> biglietti= new ArrayList<Biglietto>();


    /**
     * Instantiates a new Passeggero.
     *
     * @param codicefiscale the codicefiscale
     * @param cognome       the cognome
     * @param nome          the nome
     * @param email         the email
     * @param password      the password
     */
//costruttore passando tutti gli attributi
    public Passeggero(String codicefiscale,  String nome, String cognome, LocalDate dataNascita, String email, String password)
    {
        this.cognome=cognome;
        this.nome=nome;
        this.dataNascita = dataNascita;
        this.cf=codicefiscale;
        this.email=email;
        this.password=password;
    };



    /**
     * Acquista biglietto.
     *
     * @param b the b
     */
    void AcquistaBiglietto(Biglietto b){

        biglietti.add(b);
    }

    /**
     * Acquista biglietto.
     *
     * @param bagagli      the bagagli
     * @param veicolo      the veicolo
     * @param prenotazione the prenotazione
     * @param corsa        the corsa
     */
    void AcquistaBiglietto(int bagagli, boolean veicolo, boolean prenotazione, Corsa corsa)
    {
        biglietti.add(new Biglietto(bagagli,veicolo,LocalDate.now(), prenotazione,this, corsa));
    }

    /**
     * Visualizza corse.
     */
    void VisualizzaCorse(){
        /*SQL mostrare la view
        * */
    }


    public void VisualizzaBiglietti(){
        //qury sql per prendere i biglietti di quell'utente (cf)
    }

    public String getCf() {
        return cf;
    }

    public String getNome() {
        return nome;
    }
    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public String getCognome() {
        return cognome;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
