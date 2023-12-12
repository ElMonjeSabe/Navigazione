package Controller;

//importo le classi del model
import DAO.AcquistaBigliettoDAO;
import DAO.AggiungiImbarcazioneDAO;
import DAO.CaricaCompagnieDAO;
import DAO.CorseDAO;
import ImplementazionePostgresDAO.ImpAggiungiImbarcazioneDAO;
import ImplementazionePostgresDAO.ImpCaricaCompagnieDAO;
import ImplementazionePostgresDAO.ImplementazioneAcquistaBigliettoDAO;
import ImplementazionePostgresDAO.ImplementazioneLeggiCorseDAO;
import Model.Biglietto;
import Model.Compagnia;
import Model.CorsaTabellone;
import Model.Imbarcazione;

import java.util.ArrayList;

public class Controller {

    private ArrayList<CorsaTabellone> corse = new ArrayList<CorsaTabellone>();
    private Compagnia compagnia;
    private Biglietto BigliettoAQ;
    private ArrayList<String> CodiciBiglietti = new ArrayList<String>();

    private ArrayList<Compagnia> Compagnie= new ArrayList<Compagnia>();



    public void setCompagnia(String nome, String email, String telefono, String sito)
    {
            compagnia=new Compagnia(nome,email,telefono,sito);
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



}
