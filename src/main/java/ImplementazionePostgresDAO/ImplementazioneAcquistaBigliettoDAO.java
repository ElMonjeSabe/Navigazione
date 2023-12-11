package ImplementazionePostgresDAO;

import DAO.AcquistaBigliettoDAO;
import Database.ConnessioneDatabase;
import Model.Biglietto;
import Model.CorsaTabellone;

import java.sql.*;
import java.time.LocalDate;

public class ImplementazioneAcquistaBigliettoDAO implements AcquistaBigliettoDAO {
    private Connection connection;

    public ImplementazioneAcquistaBigliettoDAO() {
        try {
            connection = ConnessioneDatabase.getInstance().connection;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void  AcquistaBigliettoDB(Biglietto b) {
        // TODO Auto-generated method stub
        try {

            PreparedStatement pstmt = connection.prepareStatement("call AcquistaBiglietto( ?,?,?,?,?,?,?);");

            pstmt.setString(1, b.getCodiceBiglietto());
            pstmt.setDate(2, Date.valueOf(LocalDate.now()));
            pstmt.setBoolean(3, b.getVeicolo());
            pstmt.setObject(4, b.getNumerobagagli()); // Usa il metodo appropriato per il tuo tipo di dato personalizzato
            pstmt.setString(5, b.getPossessore().getCf());
            pstmt.setString(6, b.getCorsa().getCodiceCorsa());
            pstmt.setBoolean(7, b.getPrenotazione);

            pstmt.execute();

            pstmt.close();
            connection.close();

        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());
        }

    }


}
