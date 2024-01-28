package Controller;

//importo le classi del model
import DAO.*;
import ImplementazionePostgresDAO.*;
import Model.*;

import java.util.ArrayList;

public class Controller {

    private ArrayList<CorsaTabellone> corse = new ArrayList<CorsaTabellone>();

    private ArrayList<BigliettiAcquistati> biglietti = new ArrayList<BigliettiAcquistati>();

    private Compagnia compagnia;

    private Passeggero passeggero;

    private ArrayList<Compagnia> compagnie= new ArrayList<Compagnia>();

    private Integer postiPersoneDisp;
    private Integer postiVeicoliDisp;


//METODI

    public void setPasseggero(Passeggero passeggero) {
        this.passeggero = passeggero;
    }



    public Passeggero getPasseggero() {
        return passeggero;
    }



    public void setCompagnia(String nome, String password, String email, String telefono, String sito)
    {
        compagnia=new Compagnia(nome,password, email,telefono,sito);
    }



    public void LeggiCorseDAO() {
        CorseDAO l=new ImplementazioneLeggiCorseDAO();
        corse.clear();
        l.leggiCorseDB(corse);  //legge listino dal DB

        // costruisce gli oggetti Model a partire dai risultati del db

    }



    public void LeggiCorseCompagniaDAO(String nomeCompagnia) {
        CorseDAO l=new ImplementazioneLeggiCorseDAO();
        corse.clear();
        l.leggiCorseCompagniaDB(corse,nomeCompagnia);  //legge listino dal DB

        // costruisce gli oggetti Model a partire dai risultati del db

    }



    public void LeggiCorseFiltrateDAO(String TipoImb, int prezzo, String comp) {
        CorseDAO l=new ImplementazioneLeggiCorseDAO();
        corse.clear();
        l.leggiCorseFiltroDB(corse, TipoImb, prezzo, comp);  //legge listino dal DB

        // costruisce gli oggetti Model a partire dai risultati del db
    }



    public void LeggiCorseCompagniaFiltrateDAO(String TipoImb, int prezzo, String comp) {
        CorseDAO l=new ImplementazioneLeggiCorseDAO();
        corse.clear();
        l.leggiCorseCompagniaFiltroDB(corse, TipoImb, prezzo, comp);  //legge listino dal DB

        // costruisce gli oggetti Model a partire dai risultati del db

    }



    public ArrayList<CorsaTabellone> getCorse() {
        return this.corse;
    }



    public int AcquistaBigliettoDAO(ArrayList<Biglietto> b){
        AcquistaBigliettoDAO a = new ImplementazioneAcquistaBigliettoDAO();

        return a.AcquistaBigliettoDB(b);
    }



    public ArrayList<Compagnia> getCompagnie(){
        return compagnie;
    }



    public boolean ModificaCorsa(String CodiceCorsa, String Avviso, String Stato, String NomeCompagnia){
        GestisciCorsaDAO MC = new ImpGestisciCorsaDAO();
        return MC.ModificaCorsaDB(CodiceCorsa,Avviso, Stato, NomeCompagnia);
    }



    public int AggiungiPasseggero(Passeggero p){
        GestionePasseggeroDAO GP = new ImpGestionePasseggeroDAO();
        return GP.AggiungiPasseggeroDB(p);
    }



    public Passeggero loginPasseggero(String email, String password){
        loginPasseggeroDAO GP = new ImpLoginPasseggeroDAO();
        return GP.loginPasseggeroDB(email,password);
    }



    public Compagnia loginCompagnia(String email, String password) {
        LoginCompagniaDAO GC = new ImpLoginCompagniaDAO();
        return GC.loginCompagniaDB(email, password);
    }



    //metodo usato per prelevare le imbarcazioni possedute da una
    //public GetImbarcazioni(NomeComp)
    public boolean AggiungiImbarcazione(Imbarcazione imb){
        AggiungiImbarcazioneDAO AggImb = new ImpAggiungiImbarcazioneDAO();
        return AggImb.AggiungiImbarcazioneDB(imb);
    }



    public ArrayList<Imbarcazione> GetImbarcazioni(String nomeComp) {
        GetImbarcazioniDAO getImb = new ImpGetImbarcazioniDAO();
        return getImb.GetImbarcazioniDB(nomeComp);
    }



    public ArrayList<Porto> GetPorti() {
        GetPortiDAO getPor = new ImpGetPortiDAO();
        return getPor.GetPortiDB();
    }



    public boolean AggiungiCorse(ArrayList<Percorso> percorsi, ArrayList<Corsa> corse) {
        AggiungiCorseDAO addCors= new ImpAggiungiCorseDAO();
        return addCors.AggiungiCorseDB(percorsi, corse);
    }



    public CorsaTabellone GetCorsa(String CodCorsa){
        GestisciCorsaDAO Corsa = new ImpGestisciCorsaDAO();
       return Corsa.GetCorsaDB(CodCorsa);
    }



    public boolean RegistrazioneCompagnia(Compagnia comp, Imbarcazione imb){
        RegistrazioneCompagniaDAO regComp= new ImpRegistrazioneCompagniaDAO();
        return regComp.RegistrazioneCompagniaDB(comp, imb);
    }



    public boolean AggiungiSocial(Social soc){
        AggiungiSocialDAO aggSoc= new ImpAggiungiSocialDAO();
        return aggSoc.AggiungiSocialDB(soc);
    }



    //mi prendo tutte le codice di una compagnia, utilizzato durante la modifica della corsa
    public ArrayList<String> GetCodiceCorse(String nomeComp) {
        GetCodCorseDAO getCodCorse = new ImpGetCodCorseDAO();
        return getCodCorse.GetCodCorseDB(nomeComp);
    }



    //senza passare nessuna compagnia, utilizzato durante l'acquisto di biglietti
    public ArrayList<String> GetCodiceCorse() {
        GetCodCorseDAO getCodCorse = new ImpGetCodCorseDAO();
        return getCodCorse.GetCodCorseDB();
    }



    public boolean CancellaCorsa(String codice){
        CancellaCorsaDAO CancCorsa= new ImpCancellaCorsaDAO();
        return CancCorsa.CancellaCorsaDB(codice);
    }



    public ArrayList<Compagnia> CaricaCompagnie(){
        CaricaCompagnieDAO car = new ImpCaricaCompagnieDAO();
        return car.CaricaCompagnieDB();
    }



    public Compagnia getCompagnia() {
        return compagnia;
    }




    public void setCompagnia(Compagnia c){
        this.compagnia = c;
    }



    public void leggiBigliettiAcquistatiUtente(){
        BigliettiAcquistatiDAO BA = new ImpBigliettiAcquistatiDAO();
        biglietti.clear();
        BA.leggiBigliettiAcquistatiUtenteDB(biglietti, passeggero.getCf());
    }



    public void leggiBigliettiAcquistatiCompagnia(String nomeCompagnia){
        BigliettiAcquistatiDAO BA = new ImpBigliettiAcquistatiDAO();
        biglietti.clear();
        BA.leggiBigliettiAcquistatiCompagniaDB(biglietti, compagnia.getNomeCompagnia());
    }



    public void leggiBigliettiFiltratiAcquistatiCompagnia(String codiceCorsa, int prezzo,String nomeCompagnia){
        BigliettiAcquistatiDAO BA = new ImpBigliettiAcquistatiDAO();
        biglietti.clear();
        BA.leggiBigliettiFiltratiAcquistatiCompagniaDB(biglietti, codiceCorsa,prezzo, nomeCompagnia);
    }



    public ArrayList<BigliettiAcquistati> getBiglietti() {
        return biglietti;
    }



    public Integer getPostiPersoneDisp() {
        return postiPersoneDisp;
    }



    public Integer getPostiVeicoliDisp() {
        return postiVeicoliDisp;
    }


    public void getPostiDisponibili(String codCorsa){
        GetPostiDisponibiliDAO postDisp = new ImpGetPostiDisponibiliDAO();
        int [] posti = postDisp.getPostiDisponibiliDB(codCorsa);
        postiPersoneDisp = posti[0] ;
        postiVeicoliDisp = posti[1];
    }
}
