package Model;

import java.util.ArrayList;


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