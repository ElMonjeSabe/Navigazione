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
    public boolean ModificaCorsaDB(String CodiceCorsa, String Avviso, String Stato, String NomeCompagnia) {
        try {
            //genera il codice del biglietto
            PreparedStatement pstmt = connection.prepareStatement("call CambiaStato(?, ?, ?, ?);");

            pstmt.setString(1,CodiceCorsa);
            pstmt.setString(2,Avviso);
            pstmt.setString(3,Stato);
            pstmt.setString(4, NomeCompagnia);
            pstmt.execute();

            pstmt.close();
            connection.close();

            return true;

        } catch (SQLException e) {

            System.out.println("Errore: " + e.getMessage());

            return false;
        }
    }




    @Override
    public float GetPrezzoCorsaDB(String CodCorsa) {
        float prezzo = 0;
        try {
            //genera il codice del biglietto

            PreparedStatement pstmt = connection.prepareStatement("Select costocorsa from tabellone where codicecorsa = ?;");

            pstmt.setString(1,CodCorsa);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
            prezzo = rs.getFloat(1);
            }
            rs.close();
            pstmt.close();
            connection.close();

        } catch (SQLException e) {

            System.out.println("Errore: " + e.getMessage());
        }
        return prezzo;
    }


}
