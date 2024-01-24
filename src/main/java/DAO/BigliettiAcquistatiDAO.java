package DAO;

import Model.BigliettiAcquistati;

import java.util.ArrayList;

public interface BigliettiAcquistatiDAO {
    void leggiBigliettiAcquistatiCompagniaDB(ArrayList<BigliettiAcquistati> BA, String NomeCompagnia);
    void leggiBigliettiAcquistatiUtenteDB(ArrayList<BigliettiAcquistati> BA, String cf);
}
