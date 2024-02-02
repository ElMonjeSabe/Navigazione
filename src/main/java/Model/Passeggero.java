package Model;

import java.time.LocalDate;


/**
 * La Classe Passeggero
 */
public class Passeggero {

    private String cf;
    private String nome;
    private LocalDate dataNascita;
    private String cognome;
    private String email;
    private String password;


    /**
     * Costruttore di Passeggero
     *
     * @param codicefiscale il codice fiscale del passeggero
     * @param nome          il nome del passeggero
     * @param cognome       il cognome del passeggero
     * @param dataNascita   la data di nascita del passeggero
     * @param email         l'email del passeggero
     * @param password      la password del passeggero
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
     * Metodo Getter per prelevare il codicefiscale del passeggero
     *
     * @return il codice fiscale
     */
    public String getCf() {
        return cf;
    }

    /**
     * Metodo Getter per prelevare il nome del passeggero
     *
     * @return il nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Metodo Getter per prelevare la data di nascita del passeggero
     *
     * @return la data di nascita
     */
    public LocalDate getDataNascita() {
        return dataNascita;
    }

    /**
     * Metodo Getter per prelevare il cognome del passeggero
     *
     * @return il cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Metodo Getter per prelevare l'email del passeggero
     *
     * @return l'email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Metodo Getter per prelevare la password del passeggero
     *
     * @return la password
     */
    public String getPassword() {
        return password;
    }
}
