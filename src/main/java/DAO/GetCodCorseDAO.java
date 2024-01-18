package DAO;

import Model.Imbarcazione;

import java.util.ArrayList;

public interface GetCodCorseDAO {

    public ArrayList<String> GetCodCorseDB(String nomeComp);
    public ArrayList<String> GetCodCorseDB();
}
