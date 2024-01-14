package Controller;

//importo le classi del model
import DAO.*;
import ImplementazionePostgresDAO.*;
import Model.*;

import javax.swing.*;
import java.util.ArrayList;

public class Controller {


    private ArrayList<CorsaTabellone> corse = new ArrayList<CorsaTabellone>();
    private Compagnia compagnia;
    private Biglietto BigliettoAQ;
    private ArrayList<String> CodiciBiglietti = new ArrayList<String>();

    private ArrayList<Compagnia> Compagnie= new ArrayList<Compagnia>();



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

    public void LeggiCorseFiltrateDAO(String TipoImb, int prezzo) {
        CorseDAO l=new ImplementazioneLeggiCorseDAO();
        corse.clear();
        l.leggiCorseFiltroDB(corse, TipoImb, prezzo);  //legge listino dal DB

        // costruisce gli oggetti Model a partire dai risultati del db

    }

    public ArrayList<CorsaTabellone> getCorse() {
        return this.corse;
    }



    public void AcquistaBigliettoDAO(Biglietto b){
        AcquistaBigliettoDAO a = new ImplementazioneAcquistaBigliettoDAO();


        //generare il codice biglietto e controllarlo con la lista di codici biglietto



        a.AcquistaBigliettoDB(b);
    }


    public void CaricaCompagnie(){
        CaricaCompagnieDAO car = new ImpCaricaCompagnieDAO();
        Compagnie.clear();
        car.CaricaCompagnieDB(Compagnie);

    }

    public ArrayList<Compagnia> getCompagnie(){
        return Compagnie;
    }





    public void ModificaCorsa(String CodiceCorsa, String Avviso, String Stato, String NomeCompagnia){
        GestisciCorsaDAO MC = new ImpGestisciCorsaDAO();
        MC.ModificaCorsaDB(CodiceCorsa,Avviso, Stato, NomeCompagnia);

    }

    public int AggiungiPasseggero(Passeggero p){
        GestionePasseggeroDAO GP = new ImpGestionePasseggeroDAO();
        return GP.AggiungiPasseggeroDB(p);
    }


    public int AggiungiCompagnia(Compagnia c){
        GestioneCompagniaDAO GC = new ImpGestioneCompagniaDAO();
        return GC.AggiungiCompagniaDB(c);
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
}
