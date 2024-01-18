package DAO;

import Model.Cabina;
import Model.Imbarcazione;

import java.util.ArrayList;

public interface GetCabineDAO {

    ArrayList<Cabina> GetCabineDB(String CDCorsa);

    int GetUltimaCabinaDB(Imbarcazione imb);
}
