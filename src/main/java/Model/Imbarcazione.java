package Model;

import java.util.ArrayList;

/**
 * La Classe Imbarcazione
 */
public class Imbarcazione {
    private String codiceImbarcazione;
    private String nomeImbarcazione;
    private String tipoImbarcazione;
    private int numMaxPersone;
    private int numMaxVeicoli;
    private Compagnia compagniaPoss;
    private ArrayList<Corsa> corse= new ArrayList<Corsa>();
    private String nomeCompagniaPoss;


    /**
     * Costruttore di Imbarcazione Passando la Stringa del nome della compagnia
     *
     * @param codice     il codice imbarcazione
     * @param nome       il nome dell'imbarcazione
     * @param tipo       il tipo dell'imbarcazione (traghetto, motonave o aliscafo)
     * @param maxpersone la capienza (per passeggeri)
     * @param maxveicoli la capienza (per veicoli)
     * @param compagnia  il nome della compagnia
     */
    public Imbarcazione(String codice, String nome, String tipo, int maxpersone, int maxveicoli, String compagnia){
        this.codiceImbarcazione=codice;
        this.nomeImbarcazione=nome;
        this.tipoImbarcazione=tipo;
        this.numMaxPersone=maxpersone;
        this.numMaxVeicoli=maxveicoli;
        this.nomeCompagniaPoss = compagnia;
    }


    /**
     * Costruttore di Imbarcazione Passando un oggetto di classe Compagnia al posto della stringa del nomecompagnia
     *
     * @param codice     the codice
     * @param nome       the nome
     * @param tipo       the tipo
     * @param maxpersone the maxpersone
     * @param maxveicoli the maxveicoli
     * @param compagnia  the compagnia
     * @param corsa      l'oggetto di Classe Compagnia
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

    /**
     * Metodo Getter per prelevare il codice dell'imbarcazione
     *
     * @return il codice imbarcazione
     */
    public String getCodice() {
        return codiceImbarcazione;
    }

    /**
     * Metodo Getter per prelevare il nome dell'imbarcazione
     *
     * @return il nome
     */
    public String getNome() {
        return nomeImbarcazione;
    }

    /**
     * Metodo Getter per prelevare il tipo d'imbarcazione
     *
     * @return il tipoImbarcazione
     */
    public String  getTipo() {
        return tipoImbarcazione;
    }

    /**
     * Metodo Getter per prelevare il nome della Compagnia in cui possiede l'imbarcazione
     *
     * @return il nome della compagnia
     */
    public String getNomeCompagniaPoss() {
        return nomeCompagniaPoss;
    }

    /**
     * Metodo Getter per prelevare la capienza di passeggeri dell'imbarcazione
     *
     * @return la capienza di passeggeri (NumMaxPersone)
     */
    public int getMaxPass() {
        return numMaxPersone;
    }

    /**
     * Metodo Getter per prelevare la capienza di veicoli dell'imbarcazione
     *
     * @return la capienza di veicoli (NumMaxVeicoli)
     */
    public int getMaxVei() {
        return numMaxVeicoli;
    }
}
