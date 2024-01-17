package DAO;

import Model.Compagnia;
import Model.Corsa;
import Model.Imbarcazione;
import Model.Percorso;

import java.util.ArrayList;

public interface RegistrazioneCompagniaDAO {
    public boolean RegistrazioneCompagniaDB(Compagnia comp, Imbarcazione imb);
}
