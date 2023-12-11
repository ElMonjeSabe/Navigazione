package Model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * The type Passeggero.
 */
public class Passeggero {

    public String getCf() {
        return cf;
    }

    private String cf;
    private String nome;
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
     * @param biglietto     the biglietto
     */
//costruttore passando solamente gli attributi che non possono essere null, ossia il codice fiscale, il nome e il biglietto
    public Passeggero(String codicefiscale, String cognome, String nome, Biglietto biglietto)
    {
        this.cognome=cognome;
        this.nome=nome;
        this.cf=codicefiscale;
        this.biglietti.add(biglietto);
    };

    public Passeggero(String cf){
        this.cf = cf;
    }
    /**
     * Instantiates a new Passeggero.
     *
     * @param codicefiscale the codicefiscale
     * @param cognome       the cognome
     * @param nome          the nome
     * @param email         the email
     * @param password      the password
     * @param biglietto     the biglietto
     */
//costruttore passando tutti gli attributi
    public Passeggero(String codicefiscale, String cognome, String nome, String email, String password, Biglietto biglietto)
    {
        this.cognome=cognome;
        this.nome=nome;
        this.cf=codicefiscale;
        this.email=email;
        this.password=password;
        this.biglietti.add(biglietto);
    };

    /**
     * Instantiates a new Passeggero.
     *
     * @param codicefiscale the codicefiscale
     * @param cognome       the cognome
     * @param nome          the nome
     * @param code          the code
     * @param bagagli       the bagagli
     * @param veicolo       the veicolo
     * @param prenotazione  the prenotazione
     * @param corsa         the corsa
     */
//costruttore dove passo gli attributi essenziali, e il biglietto lo creo direttamente
    public Passeggero(String codicefiscale, String cognome, String nome, String code, int bagagli, boolean veicolo, boolean prenotazione, Corsa corsa)
    {
        this.cognome=cognome;
        this.nome=nome;
        this.cf=codicefiscale;
        this.biglietti.add(new Biglietto(bagagli,veicolo,LocalDate.now(), prenotazione,this, corsa));
    };

    /**
     * Instantiates a new Passeggero.
     *
     * @param codicefiscale the codicefiscale
     * @param cognome       the cognome
     * @param nome          the nome
     * @param email         the email
     * @param password      the password
     * @param code          the code
     * @param bagagli       the bagagli
     * @param veicolo       the veicolo
     * @param prenotazione  the prenotazione
     * @param corsa         the corsa
     * @param cabina        the cabina
     */
//costruttore dove tutti gli attributi, ma il biglietto lo creo direttamente
    public Passeggero(String codicefiscale, String cognome, String nome, String email, String password, String code, int bagagli, boolean veicolo, boolean prenotazione, Corsa corsa, Cabina cabina)
    {
        this.cognome=cognome;
        this.nome=nome;
        this.cf=codicefiscale;
        this.email=email;
        this.password=password;
        this.biglietti.add(new Biglietto(bagagli,veicolo,LocalDate.now(), prenotazione,this, corsa));
    };

    /**
     * Acquista biglietto.
     *
     * @param b the b
     */
    void AcquistaBiglietto(Biglietto b)
    {
        biglietti.add(b);
    }

    /**
     * Acquista biglietto.
     *
     * @param bagagli      the bagagli
     * @param veicolo      the veicolo
     * @param prenotazione the prenotazione
     * @param corsa        the corsa
     * @param cabina       the cabina
     */
    void AcquistaBiglietto(int bagagli, boolean veicolo, boolean prenotazione, Corsa corsa, Cabina cabina)
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
}
