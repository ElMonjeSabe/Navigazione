package Model;

import java.sql.Date;
import java.util.ArrayList;

/**
 * The type Imbarcazione.
 */
public class Imbarcazione {
    private String codiceImbarcazione;
    private String nomeImbarcazione;
    private String tipoImbarcazione;
    private int numMaxPersone;

    private int numMaxVeicoli;
    private Compagnia compagniaPoss;
    private ArrayList<Corsa> corse= new ArrayList<Corsa>();

    /**
     * Instantiates a new Imbarcazione.
     *
     * @param codice     the codice
     * @param nome       the nome
     * @param tipo       the tipo
     * @param maxpersone the maxpersone
     * @param maxveicoli the maxveicoli

     */


    String nomeCompagniaPoss;
    public Imbarcazione(String codice, String nome, String tipo, int maxpersone, int maxveicoli, String compagnia){
        this.codiceImbarcazione=codice;
        this.nomeImbarcazione=nome;
        this.tipoImbarcazione=tipo;
        this.numMaxPersone=maxpersone;
        this.numMaxVeicoli=maxveicoli;
        this.nomeCompagniaPoss = compagnia;
    }

    /**
     * Instantiates a new Imbarcazione.
     *
     * @param codice     the codice
     * @param nome       the nome
     * @param tipo       the tipo
     * @param maxpersone the maxpersone
     * @param maxveicoli the maxveicoli
     * @param compagnia  the compagnia
     * @param corsa      the corsa
     */
    public Imbarcazione(String codice, String nome, String tipo, int maxpersone, int maxveicoli, Compagnia compagnia, Corsa corsa){
        this.codiceImbarcazione=codice;
        this.nomeImbarcazione=nome;
        this.tipoImbarcazione=tipo;
        this.numMaxPersone=maxpersone;
        this.numMaxVeicoli=maxveicoli;
        this.compagniaPoss=compagnia;

        this.corse.add(corsa);
    }

    public String getCodice() {
        return codiceImbarcazione;
    }

    public String getNome() {
        return nomeImbarcazione;
    }

    public String  getTipo() {
        return tipoImbarcazione;
    }

    public String getNomeCompagniaPoss() {
        return nomeCompagniaPoss;
    }

    public int getMaxPass() {
        return numMaxPersone;
    }

    public int getMaxVei() {
        return numMaxVeicoli;
    }
}
