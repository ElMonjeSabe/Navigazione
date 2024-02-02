package Model;

import java.util.ArrayList;


/**
 * La classe Compagnia.
 */
public class Compagnia {
    private String nomeCompagnia;
    private String passwCompagnia;
    private String emailCompagnia;
    private String telefono;

    private String sitoWeb;


    public Compagnia(String nome, String password,String telefono, String email, String sitoWeb){
        this.nomeCompagnia=nome;
        this.passwCompagnia=password;
        this.emailCompagnia=email;
        this.telefono=telefono;
        this.sitoWeb=sitoWeb;
    }


    public String getNomeCompagnia(){
        return nomeCompagnia;
    }

    /**
     * Restituisce la password della compagnia.
     *
     * @return the passwCompagnia
     */
    public String getPasswCompagnia() {
        return passwCompagnia;
    }

    /**
     *  Restituisce l'email della compagnia.
     *
     * @return the emailCompagnia
     */
    public String getEmailCompagnia() {
        return emailCompagnia;
    }

    /**
     *  Restituisce il numero di telefono della compagnia.
     *
     * @return telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Restituisce il sito web della compagnia.
     *
     * @return the sitoWeb
     */
    public String getSitoWeb() {
        return sitoWeb;
    }


}