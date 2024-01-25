package DAO;

import Model.BigliettiAcquistati;

import java.util.ArrayList;

public interface BigliettiAcquistatiDAO {
    void leggiBigliettiAcquistatiCompagniaDB(ArrayList<BigliettiAcquistati> BA, String NomeCompagnia);
    void leggiBigliettiFiltratiAcquistatiCompagniaDB(ArrayList<BigliettiAcquistati> BA, String codiceCorsa, int prezzo,String nomeCompagnia);
    void leggiBigliettiAcquistatiUtenteDB(ArrayList<BigliettiAcquistati> BA, String cf);
}
