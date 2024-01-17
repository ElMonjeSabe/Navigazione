package DAO;

import Model.CorsaTabellone;

public interface GestisciCorsaDAO {

    //public void AggiungiCorsa();

    boolean ModificaCorsaDB(String CodiceCorsa, String Avviso, String Stato, String NomeCompagnia);

    CorsaTabellone GetCorsaDB(String CodCorsa);
}
