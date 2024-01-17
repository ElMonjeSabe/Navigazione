package DAO;

public interface GestisciCorsaDAO {

    //public void AggiungiCorsa();

    boolean ModificaCorsaDB(String CodiceCorsa, String Avviso, String Stato, String NomeCompagnia);

    float GetPrezzoCorsaDB(String CodCorsa);
}
