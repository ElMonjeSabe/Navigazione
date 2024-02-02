package DAO;

import Model.CorsaTabellone;

import java.util.ArrayList;

public interface CorseDAO {

    void leggiCorseDB(ArrayList<CorsaTabellone> a);

    void leggiCorseCompagniaDB(ArrayList<CorsaTabellone> a, String nomeCompagnia);

    void leggiCorseFiltroDB(ArrayList<CorsaTabellone> corse, String TipoImb, int prezzo, String comp);

    void leggiCorseCompagniaFiltroDB(ArrayList<CorsaTabellone> corse, String TipoImb, int prezzo, String comp);

}
