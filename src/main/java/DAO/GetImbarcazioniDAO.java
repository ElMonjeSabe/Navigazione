package DAO;

import Model.Imbarcazione;

import java.util.ArrayList;

public interface GetImbarcazioniDAO {
    public ArrayList<Imbarcazione> GetImbarcazioniDB(String nomeComp);
}
