package ImplementazionePostgresDAO;

import DAO.GestisciCorsaDAO;
import Database.ConnessioneDatabase;

import java.sql.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class ImpGestisciCorsaDAO implements GestisciCorsaDAO {
    private Connection connection;

    public ImpGestisciCorsaDAO() {
        try {
            connection = ConnessioneDatabase.getInstance().connection;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void ModificaCorsaDB(String CodiceCorsa, String Avviso, String Stato) {
        try {
            //genera il codice del biglietto
            PreparedStatement pstmt = connection.prepareStatement("call CambiaStato(?, ?, ?);");

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
