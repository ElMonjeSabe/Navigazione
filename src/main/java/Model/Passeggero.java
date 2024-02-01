package Model;

import java.time.LocalDate;



public class Passeggero {

    private String cf;
    private String nome;
    private LocalDate dataNascita;
    private String cognome;
    private String email;
    private String password;


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
