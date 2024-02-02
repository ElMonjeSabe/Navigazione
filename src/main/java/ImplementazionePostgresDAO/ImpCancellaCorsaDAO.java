package ImplementazionePostgresDAO;

import DAO.CancellaCorsaDAO;
import Database.ConnessioneDatabase;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Implementazione dell'interfaccia CancellaCorsaDAO
 */
public class ImpCancellaCorsaDAO implements CancellaCorsaDAO {
    private Connection connection;
    /**
     * The Esito.
     */
    boolean esito=true;
    private PreparedStatement pstmt;

    /**
     * Costruttore che si connette al database
     */
    public ImpCancellaCorsaDAO() {
        try {
            connection = ConnessioneDatabase.getInstance().connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean CancellaCorsaDB(String codice) {
        try {
            //genera il codice del biglietto
            PreparedStatement pstmt = connection.prepareStatement("delete from corsa where substring(codicecorsa,2,7)=substring(?,2,7);");

            pstmt.setString(1,codice);
            pstmt.execute();

            pstmt.close();
            connection.close();

            return true;

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());

            return false;
        }
    }
}
