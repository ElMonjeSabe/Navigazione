package Model;



public class Corsa {
    public String codiceCorsa;
    private double costoCorsa;
    private String stato;
    private String avviso;
    private Imbarcazione imbarcazioneUtilizzata;
    private Compagnia compagniaOfferente;


   public Corsa(String codice, double costo, String avviso, String stato, Imbarcazione imbarcazione, Compagnia compagnia){
        this.codiceCorsa=codice;
        this.costoCorsa=costo;
        this.avviso=avviso;
        this.stato=stato;
        this.imbarcazioneUtilizzata= imbarcazione;
        this.compagniaOfferente=compagnia;
    }


    public String getCodiceCorsa() {
        return codiceCorsa;
    }

    public double getCostoCorsa() {
        return costoCorsa;
    }

    public String getStato() {
        return stato;
    }

    public String getAvviso() {
        return avviso;
    }

    public Imbarcazione getImbarcazioneUtilizzata() {
        return imbarcazioneUtilizzata;
    }

    public Compagnia getCompagniaOfferente() {
        return compagniaOfferente;
    }

}