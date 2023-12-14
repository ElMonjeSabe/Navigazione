package Controller;

//importo le classi del model
import DAO.*;
import ImplementazionePostgresDAO.*;
import Model.*;

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



    public void AggiungiImbarcazioneDAO(Imbarcazione Imba){
        AggiungiImbarcazioneDAO AccImb = new ImpAggiungiImbarcazioneDAO();
        AccImb.AggiungiImbarcazioneDB(Imba);
    }

    public void ModificaCorsa(String CodiceCorsa, String Avviso, String Stato){
        GestisciCorsaDAO MC = new ImpGestisciCorsaDAO();
        MC.ModificaCorsaDB(CodiceCorsa,Avviso, Stato);

    }

    public void AggiungiPasseggero(Passeggero p){
        GestionePasseggeroDAO GP = new ImpGestionePasseggeroDAO();
        GP.AggiungiPasseggeroDB(p);
    }

}
