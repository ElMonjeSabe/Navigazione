package ImplementazionePostgresDAO;

import DAO.CancellaCorsaDAO;
import Database.ConnessioneDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImpCancellaCorsaDAO implements CancellaCorsaDAO {
    private Connection connection;
    boolean esito=true;
    private PreparedStatement pstmt;

    public ImpCancellaCorsaDAO() {
        try {
            connection = ConnessioneDatabase.getInstance().connection;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public boolean CancellaCorsaDB(String codice) {
        try {
            //genera il codice del biglietto
            PreparedStatement pstmt = connection.prepareStatement("delete from corsa where codicecorsa=?;");

            pstmt.setString(1,codice);
            pstmt.execute();

            pstmt.close();
            connection.close();

            return true;

        } catch (SQLException e) {

            System.out.println("Errore: " + e.getMessage());

            return false;
        }
    }
}
