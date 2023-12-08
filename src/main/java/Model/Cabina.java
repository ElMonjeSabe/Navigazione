package Model;

import java.util.ArrayList;

/**
 * The type Cabina.
 */
public class Cabina {
    private int numero;
    private int postiletto;
    private ArrayList<Imbarcazione> imbarcazioni = new ArrayList<Imbarcazione>();

    private ArrayList<Biglietto>biglietti=new ArrayList<Biglietto>();

    /**
     * Instantiates a new Cabina.
     *
     * @param numero the numero
     * @param letti  the letti
     */
    public Cabina(int numero, int letti, Imbarcazione imbarcazione){
        this.numero=numero;
        this.postiletto=letti;
        this.imbarcazioni.add(imbarcazione);

    }

    /**
     * Aggiungi imbarcazione.
     *
     * @param imbarcazione the imbarcazione
     */
    public void AggiungiImbarcazione(Imbarcazione imbarcazione){
        this.imbarcazioni.add(imbarcazione);
    }

    /**
     * Instantiates a new Cabina.
     *
     * @param numero       the numero
     * @param letti        the letti
     * @param biglietto    the biglietto
     * @param imbarcazione the imbarcazione
     */
    public Cabina(int numero, int letti, Biglietto biglietto, Imbarcazione imbarcazione){
        this.numero=numero;
        this.postiletto=letti;
        this.imbarcazioni.add(imbarcazione);
        this.biglietti.add(biglietto);
    }

}
