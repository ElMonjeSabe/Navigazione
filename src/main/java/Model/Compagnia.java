package Model;

import java.util.ArrayList;

/**
 * The type Compagnia.
 */
public class Compagnia {
    private String nomeCompagnia;

    private String passwCompagnia;
    private String emailCompagnia;
    private String telefono;

    private String sitoWeb;

    private ArrayList<Social> socials;

    //private ArrayList<Imbarcazione> imbarcazioni;

    private Imbarcazione imbarcazione;



    /**
     * Instantiates a new Compagnia.
     *
     * @param nome     the nome
     * @param password     the password
     * @param email    the email
     * @param telefono the telefono
     * @param sitoWeb  the sito web
     */
    public Compagnia(String nome, String password,String telefono, String email, String sitoWeb, Imbarcazione imbarcazione){
        this.nomeCompagnia=nome;
        this.passwCompagnia=password;
        this.emailCompagnia=email;
        this.telefono=telefono;
        this.sitoWeb=sitoWeb;
        this.imbarcazione=imbarcazione;
    }

    public Compagnia(String nome, String password,String telefono, String email, String sitoWeb){
        this.nomeCompagnia=nome;
        this.passwCompagnia=password;
        this.emailCompagnia=email;
        this.telefono=telefono;
        this.sitoWeb=sitoWeb;
    }


    public Compagnia(String nomeComp, String password,String telefono, String email, String sitoWeb, String codice, String nomeImb, String tipo, int maxpersone, int maxveicoli){
        this.nomeCompagnia=nomeComp;
        this.passwCompagnia=password;
        this.emailCompagnia=email;
        this.telefono=telefono;
        this.sitoWeb=sitoWeb;
        this.imbarcazione=new Imbarcazione(codice, nomeImb, tipo, maxpersone, maxveicoli, this.nomeCompagnia);
    }

    /**
     * Instantiates a new Compagnia.
     *
     * @param nome     the nome
     * @param password     the password
     * @param email    the email
     * @param telefono the telefono
     * @param sitoWeb  the sito web
     * @param corsa    the corsa
     * @param social   the social
     */
    public Compagnia(String nome, String password, String email, String telefono, String sitoWeb, Corsa corsa, Social social, Imbarcazione imbarcazione){
        this.nomeCompagnia=nome;
        this.passwCompagnia=password;
        this.emailCompagnia=email;
        this.telefono=telefono;
        this.sitoWeb=sitoWeb;
        this.socials.add(social);
        this.imbarcazione=imbarcazione;
    }




    /**
     * Crea corsa.
     *
     * @param codice       the codice
     * @param costo        the costo
     * @param avviso       the avviso
     * @param stato        the stato
     * @param imbarcazione the imbarcazione
     * @param percorso     the percorso
     * @param compagnia    the compagnia
     */
    public void CreaCorsa(String codice, double costo, String avviso, String stato, Imbarcazione imbarcazione, Percorso percorso, Compagnia compagnia) {
       Corsa c = new Corsa(codice,costo,avviso, stato, imbarcazione, percorso, compagnia);

       /* SQL*/

    }



    public String getNomeCompagnia(){
        return nomeCompagnia;
    }

    public String getPasswCompagnia() {
        return passwCompagnia;
    }

    public String getEmailCompagnia() {
        return emailCompagnia;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getSitoWeb() {
        return sitoWeb;
    }


}