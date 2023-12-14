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

    private ArrayList<Imbarcazione> imbarcazioni;




    /**
     * Instantiates a new Compagnia.
     *
     * @param nome     the nome
     * @param password     the password
     * @param email    the email
     * @param telefono the telefono
     * @param sitoWeb  the sito web
     */
    public Compagnia(String nome, String password,String telefono, String email, String sitoWeb){
        this.nomeCompagnia=nome;
        this.passwCompagnia=password;
        this.emailCompagnia=email;
        this.telefono=telefono;
        this.sitoWeb=sitoWeb;


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
    public Compagnia(String nome, String password, String email, String telefono, String sitoWeb, Corsa corsa, Social social){
        this.nomeCompagnia=nome;
        this.passwCompagnia=password;
        this.emailCompagnia=email;
        this.telefono=telefono;
        this.sitoWeb=sitoWeb;
        this.socials.add(social);
    }

    /**
     * Instantiates a new Compagnia.
     *
     * @param nome         the nome
     * @param password     the password
     * @param email        the email
     * @param telefono     the telefono
     * @param sitoWeb      the sito web
     * @param social       the social
     * @param imbarcazione the imbarcazione
     */
    public Compagnia(String nome, String password, String email, String telefono, String sitoWeb, Social social, Imbarcazione imbarcazione){
        this.nomeCompagnia=nome;
        this.passwCompagnia=password;
        this.emailCompagnia=email;
        this.telefono=telefono;
        this.sitoWeb=sitoWeb;
        this.socials.add(social);
        this.imbarcazioni.add(imbarcazione);
    }

    /**
     * Instantiates a new Compagnia.
     *
     * @param nome         the nome
     * @param password     the password
     * @param email        the email
     * @param telefono     the telefono
     * @param sitoWeb      the sito web
     * @param imbarcazione the imbarcazione
     */
    public Compagnia(String nome, String password,String compagnia, String email, String telefono, String sitoWeb, Imbarcazione imbarcazione){
        this.nomeCompagnia=nome;
        this.passwCompagnia=password;
        this.passwCompagnia=compagnia;
        this.emailCompagnia=email;
        this.telefono=telefono;
        this.sitoWeb=sitoWeb;
        this.imbarcazioni.add(imbarcazione);
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

    /**
     * Modifica corsa.
     */
    public void ModificaCorsa(String codiceCorsa){
        /*SQL che cerca il codiceCorsa nel database
        * Inserisce la tupla trovata in una classe corsa
        * Vengono effettuate l'eventuali modifiche
        * SQL che modifica la tupla
        * */

    }



    public void AggiungiImbarcazioneConCorsa(String codice, String nome, String tipo, int maxpersone, int maxveicoli, Cabina stanza,Corsa corsa){
        Imbarcazione i = new Imbarcazione(codice, nome, tipo, maxpersone,maxveicoli, this, stanza, corsa);
        /*SQL
         * */
    }


    /**
     * Visualizza corse.
     */
    void VisualizzaCorse(){
        /*SQL mostrare la view
         * */
    }


    public String getNomeCompagnia(){
        return nomeCompagnia;
    }


}