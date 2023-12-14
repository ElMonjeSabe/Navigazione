package ImplementazionePostgresDAO;

import DAO.GestionePasseggeroDAO;
import DAO.GestisciCorsaDAO;
import Database.ConnessioneDatabase;
import Model.Passeggero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImpGestionePasseggeroDAO implements GestionePasseggeroDAO {
    private Connection connection;
    public ImpGestionePasseggeroDAO(){
        try {
            connection = ConnessioneDatabase.getInstance().connection;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    @Override
    public void AggiungiPasseggeroDB(Passeggero p) {
        try {
            //genera il codice del biglietto
            PreparedStatement pstmt = connection.prepareStatement("call InserisciPasseggero(?, ?, ?);");

            pstmt.setString(1,CodiceCorsa);
            pstmt.setString(2,Avviso);
            pstmt.setString(3,Stato);

            pstmt.execute();

            pstmt.close();
            connection.close();

        } catch (SQLException e) {

            System.out.println("Errore: " + e.getMessage());
        }
    }
}
