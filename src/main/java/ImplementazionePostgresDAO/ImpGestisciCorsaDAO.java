package ImplementazionePostgresDAO;

import DAO.GestisciCorsaDAO;
import Database.ConnessioneDatabase;
import Model.CorsaTabellone;

import java.sql.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Implementazione dell'interfaccia GestisciCorsaDAO
 */
public class ImpGestisciCorsaDAO implements GestisciCorsaDAO {
    private Connection connection;

    /**
     * Costruttore che si connette al database
     */
    public ImpGestisciCorsaDAO() {
        try {
            connection = ConnessioneDatabase.getInstance().connection;
        } catch (SQLException e) {
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
    public CorsaTabellone GetCorsaDB(String CodCorsa) {
        CorsaTabellone corsa = null;
        try {
            //genera il codice del biglietto

            PreparedStatement pstmt = connection.prepareStatement("Select * from tabellone where codicecorsa = ?;");

            pstmt.setString(1,CodCorsa);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                corsa = new CorsaTabellone(
                        rs.getString(1),
                        rs.getFloat(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getDate(11).toLocalDate(),
                        rs.getDate(12).toLocalDate(),
                        rs.getTime(13),
                        rs.getTime(14),
                        rs.getString(15),
                        rs.getString(16));
            }
            rs.close();
            pstmt.close();
            connection.close();

        } catch (SQLException e) {

            System.out.println("Errore: " + e.getMessage());

        }
        return corsa;
    }


}
