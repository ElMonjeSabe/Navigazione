package Controller;

//importo le classi del model
import DAO.*;
import ImplementazionePostgresDAO.*;
import Model.*;

import java.util.ArrayList;

/**
 * Il controller
 */
public class Controller {

    private ArrayList<CorsaTabellone> corse = new ArrayList<CorsaTabellone>();

    private ArrayList<BigliettiAcquistati> biglietti = new ArrayList<BigliettiAcquistati>();

    private Compagnia compagnia;

    private Passeggero passeggero;

    private ArrayList<Compagnia> compagnie= new ArrayList<Compagnia>();

    private Integer postiPersoneDisp;
    private Integer postiVeicoliDisp;

    private String codCorsa;


//METODI

    /**
     * mefkeofkeo
     *
     * @param passeggero the passeggero
     */
    public void setPasseggero(Passeggero passeggero) {
        this.passeggero = passeggero;
    }


    /**
     * Gets passeggero.
     *
     * @return the passeggero
     */
    public Passeggero getPasseggero() {
        return passeggero;
    }


    /**
     * Sets compagnia.
     *
     * @param nome     the nome
     * @param password the password
     * @param email    the email
     * @param telefono the telefono
     * @param sito     the sito
     */
    public void setCompagnia(String nome, String password, String email, String telefono, String sito)
    {
        compagnia=new Compagnia(nome,password, email,telefono,sito);
    }


    /**
     * Metodo per prelevare il tabellone dal database
     */
    public void LeggiCorseDAO() {
        CorseDAO l=new ImplementazioneLeggiCorseDAO();
        corse.clear();
        l.leggiCorseDB(corse);  //legge listino dal DB

        // costruisce gli oggetti Model a partire dai risultati del db

    }


    /**
     * Metodo per prelevare tutte le corse della compagnia (il nome) passata per parametro
     *
     * @param nomeCompagnia il nome della compagnia
     */
    public void LeggiCorseCompagniaDAO(String nomeCompagnia) {
        CorseDAO l=new ImplementazioneLeggiCorseDAO();
        corse.clear();
        l.leggiCorseCompagniaDB(corse,nomeCompagnia);  //legge listino dal DB

        // costruisce gli oggetti Model a partire dai risultati del db

    }


    /**
     * Metodo per prelevare il tabellone dal database, filtrato per prezzo, compagnia e per il tipo di imbarcazione
     *
     * @param TipoImb il tipo di imbarcazione
     * @param prezzo  il prezzo
     * @param comp    la compagnia
     */
    public void LeggiCorseFiltrateDAO(String TipoImb, int prezzo, String comp) {
        CorseDAO l=new ImplementazioneLeggiCorseDAO();
        corse.clear();
        l.leggiCorseFiltroDB(corse, TipoImb, prezzo, comp);  //legge listino dal DB

        // costruisce gli oggetti Model a partire dai risultati del db
    }


    /**
     * Leggi corse della compagnia filtrate, per prezzo e per il tipo di imbarcazioni,dal database
     *
     * @param TipoImb il tipo di imbarcazione
     * @param prezzo  il prezzo
     * @param comp    la compagnia
     */
    public void LeggiCorseCompagniaFiltrateDAO(String TipoImb, int prezzo, String comp) {
        CorseDAO l=new ImplementazioneLeggiCorseDAO();
        corse.clear();
        l.leggiCorseCompagniaFiltroDB(corse, TipoImb, prezzo, comp);  //legge listino dal DB

        // costruisce gli oggetti Model a partire dai risultati del db

    }


    /**
     * Metodo getter per arraylist di Corse
     *
     * @return corse
     */
    public ArrayList<CorsaTabellone> getCorse() {
        return this.corse;
    }


    /**
     * Metodo per inserire i biglietti acquistati nel database
     *
     * @param b l'arraylist di Biglietto
     * @return esito in int
     */
    public int AcquistaBigliettoDAO(ArrayList<Biglietto> b){
        AcquistaBigliettoDAO a = new ImplementazioneAcquistaBigliettoDAO();

        return a.AcquistaBigliettoDB(b);
    }


    /**
     * Metodo getter per arraylist di Compagnia
     *
     * @return the array list
     */
    public ArrayList<Compagnia> getCompagnie(){
        return compagnie;
    }


    /**
     * Metodo per modificare la corsa in base ai parametri inseriti
     *
     * @param CodiceCorsa   il codice corsa
     * @param Avviso        l'avviso
     * @param Stato         lo stato
     * @param NomeCompagnia il nome della compagnia
     * @return boolean (esito)
     */
    public boolean ModificaCorsa(String CodiceCorsa, String Avviso, String Stato, String NomeCompagnia){
        GestisciCorsaDAO MC = new ImpGestisciCorsaDAO();
        return MC.ModificaCorsaDB(CodiceCorsa,Avviso, Stato, NomeCompagnia);
    }


    /**
     * Metodo per inserire il passeggero nel database durante la registrazione
     *
     * @param p il passeggero
     * @return int (esito)
     */
    public int AggiungiPasseggero(Passeggero p){
        RegistrazionePasseggeroDAO GP = new ImpRegistrazionePasseggeroDAO();
        return GP.AggiungiPasseggeroDB(p);
    }


    /**
     * Metodo per controllare che le credenziali inseriti durante l'accesso di passeggero siano corretti. Se si, passa tutte le informazioni in una classe
     *
     * @param email    l'email del passeggero
     * @param password la password del passeggero
     * @return la classe di tipo Passeggero
     */
    public Passeggero loginPasseggero(String email, String password){
        loginPasseggeroDAO GP = new ImpLoginPasseggeroDAO();
        return GP.loginPasseggeroDB(email,password);
    }


    /**
     * Metodo per controllare che le credenziali inseriti durante l'accesso di compagnia siano corretti. Se si, passa tutte le informazioni in una classe
     *
     * @param email    l'email della compagnia
     * @param password la password della compagnia
     * @return la classe di tipo compagnia
     */
    public Compagnia loginCompagnia(String email, String password) {
        LoginCompagniaDAO GC = new ImpLoginCompagniaDAO();
        return GC.loginCompagniaDB(email, password);
    }


    /**
     * Metodo per inserire l'imbarcazione creata dalla compagnia, nel database
     *
     * @param imb l'imbarcazione
     * @return esito della query (boolean)
     */
//metodo usato per prelevare le imbarcazioni possedute da una

    public boolean AggiungiImbarcazione(Imbarcazione imb){
        AggiungiImbarcazioneDAO AggImb = new ImpAggiungiImbarcazioneDAO();
        return AggImb.AggiungiImbarcazioneDB(imb);
    }


    /**
     * Metodo per prelevare tutte le imbarcazioni salvate nel database di una compagnia
     *
     * @param nomeComp il nome della compagnia
     * @return l'arraylist di imbarcazione
     */
    public ArrayList<Imbarcazione> GetImbarcazioni(String nomeComp) {
        GetImbarcazioniDAO getImb = new ImpGetImbarcazioniDAO();
        return getImb.GetImbarcazioniDB(nomeComp);
    }


    /**
     * Metodo per prelevare tutte le imbarcazioni salvate nel
     *
     * @return l'array list di Porto
     */
    public ArrayList<Porto> GetPorti() {
        GetPortiDAO getPor = new ImpGetPortiDAO();
        return getPor.GetPortiDB();
    }


    /**
     * Metodo per inserire le corse e i loro percorsi della compagnia, nel database
     *
     * @param percorsi arraylist di Classe percorso
     * @param corse    arraylist di Classe corsa
     * @return esito (boolean)
     */
    public boolean AggiungiCorse(ArrayList<Percorso> percorsi, ArrayList<Corsa> corse) {
        AggiungiCorseDAO addCors= new ImpAggiungiCorseDAO();
        return addCors.AggiungiCorseDB(percorsi, corse);
    }


    /**
     * Metodo per prelevare una corsa salvata nel database, a partire dal suo codice
     *
     * @param CodCorsa il codice della corsa
     * @return la corsa tabellone
     */
    public CorsaTabellone GetCorsa(String CodCorsa){
        GestisciCorsaDAO Corsa = new ImpGestisciCorsaDAO();
       return Corsa.GetCorsaDB(CodCorsa);
    }


    /**
     * Metodo per inviare al database i dati della compagnia appena registrata
     *
     * @param comp la classe compagnia
     * @param imb  la classe imbarcazione della compagnia
     * @return esito (boolean)
     */
    public boolean RegistrazioneCompagnia(Compagnia comp, Imbarcazione imb){
        RegistrazioneCompagniaDAO regComp= new ImpRegistrazioneCompagniaDAO();
        return regComp.RegistrazioneCompagniaDB(comp, imb);
    }


    /**
     * Metodo per inviare al database i dati del social appena creata
     *
     * @param soc la classe social
     * @return esito (boolean)
     */
    public boolean AggiungiSocial(Social soc){
        AggiungiSocialDAO aggSoc= new ImpAggiungiSocialDAO();
        return aggSoc.AggiungiSocialDB(soc);
    }


    /**
     * Metodo per prelevare nel database tutti i codicecorsa di una compagnia, utilizzato durante la modifica della corsa
     *
     * @param nomeComp il nome della compagnia
     * @return the array list di String che rappresentano il codice delle corse
     */
//mi prendo tutte le codice di una compagnia, utilizzato durante la modifica della corsa
    public ArrayList<String> GetCodiceCorse(String nomeComp) {
        GetCodCorseDAO getCodCorse = new ImpGetCodCorseDAO();
        return getCodCorse.GetCodCorseDB(nomeComp);
    }


    /**
     * Metodo per eliminare nel database la corsa passata per parametro (il suo codice)
     *
     * @param codice il codice corsa
     * @return esito (boolean)
     */
    public boolean CancellaCorsa(String codice){
        CancellaCorsaDAO CancCorsa= new ImpCancellaCorsaDAO();
        return CancCorsa.CancellaCorsaDB(codice);
    }


    /**
     * Metodo per prelevare nel database tutte le compagnie memorizzate
     *
     * @return l'arraylist di compagnia
     */
    public ArrayList<Compagnia> CaricaCompagnie(){
        CaricaCompagnieDAO car = new ImpCaricaCompagnieDAO();
        return car.CaricaCompagnieDB();
    }


    /**
     * Gets compagnia.
     *
     * @return the compagnia
     */
    public Compagnia getCompagnia() {
        return compagnia;
    }


    /**
     * Set compagnia.
     *
     * @param c the c
     */
    public void setCompagnia(Compagnia c){
        this.compagnia = c;
    }


    /**
     * Metodo per prelevare nel database tutti i biglietti di un passeggero
     */
    public void leggiBigliettiAcquistatiUtente(){
        BigliettiAcquistatiDAO BA = new ImpBigliettiAcquistatiDAO();
        biglietti.clear();
        BA.leggiBigliettiAcquistatiUtenteDB(biglietti, passeggero.getCf());
    }


    /**
     * Metodo per prelevare nel database tutti i biglietti associati a una compagnia
     *
     * @param nomeCompagnia il nome della compagnia
     */
    public void leggiBigliettiAcquistatiCompagnia(String nomeCompagnia){
        BigliettiAcquistatiDAO BA = new ImpBigliettiAcquistatiDAO();
        biglietti.clear();
        BA.leggiBigliettiAcquistatiCompagniaDB(biglietti, compagnia.getNomeCompagnia());
    }


    /**
     * Metodo per prelevare nel database tutti i biglietti associati a una compagnia, filtrato per prezzo e/o codicecorsa
     *
     * @param codiceCorsa   il codice della corsa
     * @param prezzo        il prezzo
     * @param nomeCompagnia il nome della compagnia
     */
    public void leggiBigliettiFiltratiAcquistatiCompagnia(String codiceCorsa, int prezzo,String nomeCompagnia){
        BigliettiAcquistatiDAO BA = new ImpBigliettiAcquistatiDAO();
        biglietti.clear();
        BA.leggiBigliettiFiltratiAcquistatiCompagniaDB(biglietti, codiceCorsa,prezzo, nomeCompagnia);
    }


    /**
     * Gets biglietti.
     *
     * @return the biglietti
     */
    public ArrayList<BigliettiAcquistati> getBiglietti() {
        return biglietti;
    }


    /**
     * Gets posti persone disp.
     *
     * @return the posti persone disp
     */
    public Integer getPostiPersoneDisp() {
        return postiPersoneDisp;
    }


    /**
     * Gets posti veicoli disp.
     *
     * @return the posti veicoli disp
     */
    public Integer getPostiVeicoliDisp() {
        return postiVeicoliDisp;
    }


    /**
     * Metodo getter posti disponibili di una corsa
     */
    public void getPostiDisponibili(){
        GetPostiDisponibiliDAO postDisp = new ImpGetPostiDisponibiliDAO();
        int [] posti = postDisp.getPostiDisponibiliDB(this.codCorsa);
        postiPersoneDisp = posti[0] ;
        postiVeicoliDisp = posti[1];
    }


    /**
     * Sets cod corsa acq.
     *
     * @param codCorsa the cod corsa
     */
    public void setCodCorsaAcq(String codCorsa) {
        this.codCorsa = codCorsa;
    }


    /**
     * Gets cod corsa acq.
     *
     * @return the cod corsa acq
     */
    public String getCodCorsaAcq() {
        return this.codCorsa;
    }
}
