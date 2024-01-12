package DAO;

import Model.Corsa;
import Model.CorsaTabellone;

import java.util.ArrayList;

public interface CorseDAO {

        void leggiCorseDB(ArrayList<CorsaTabellone> a);
        void leggiCorseFiltroDB(ArrayList<CorsaTabellone> corse, String TipoImb, int prezzo);

}
