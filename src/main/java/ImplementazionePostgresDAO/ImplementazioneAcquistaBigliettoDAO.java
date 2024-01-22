package ImplementazionePostgresDAO;

import DAO.AcquistaBigliettoDAO;
import Database.ConnessioneDatabase;
import Model.Biglietto;
import Model.CorsaTabellone;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

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
    public int AcquistaBigliettoDB(Biglietto b) {

        try {
            //genera il codice del biglietto
            PreparedStatement pstmt = connection.prepareStatement("SELECT codicebiglietto FROM Biglietto");
            ResultSet rs = pstmt.executeQuery();

            Set<String> codiciBiglietti = new HashSet<>();

            while (rs.next()) {
                codiciBiglietti.add(rs.getString(1));
            }

            String codiceBiglietto;
            do {
                codiceBiglietto= generateRandomString(5);
            } while (codiciBiglietti.contains(codiceBiglietto));

            rs.close();


            //chiama la procedura per inserire il biglietto
            pstmt = connection.prepareStatement("call AcquistaBiglietto( ?,?,?,?,?,?);");

            pstmt.setString(1, codiceBiglietto);
            pstmt.setDate(2, Date.valueOf(LocalDate.now()));
            pstmt.setBoolean(3, b.getVeicolo());
            pstmt.setObject(4, b.getNumerobagagli());
            pstmt.setString(5, b.getcfposs());
            pstmt.setString(6, b.getcodCorsa());


            pstmt.execute();

            pstmt.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Errore: " + e.getMessage());
            return 0;
        }
        return 1;

    }

    private static String generateRandomString(int length) {
        String alphanumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = (int) (alphanumeric.length() * Math.random());
            sb.append(alphanumeric.charAt(index));
        }

        return sb.toString();
    }
}
