package Controller;

//importo le classi del model
import DAO.CorseDAO;
import ImplementazionePostgresDAO.ImplementazioneLeggiCorseDAO;
import Model.Compagnia;
import Model.CorsaTabellone;

import java.util.ArrayList;

public class Controller {

    private ArrayList<CorsaTabellone> corse = new ArrayList<CorsaTabellone>();
    private Compagnia compagnia;
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
}
