package ImplementazionePostgresDAO;

import DAO.AcquistaBigliettoDAO;
import Database.ConnessioneDatabase;
import Model.Biglietto;

import javax.swing.*;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

/**
 * Implementazione dell'interfaccia AcquistaBigliettoDAO
 */
public class ImplementazioneAcquistaBigliettoDAO implements AcquistaBigliettoDAO {
    private Connection connection;
    private PreparedStatement pstmt;

    /**
     * Costruttore che si connette al database
     */
    public ImplementazioneAcquistaBigliettoDAO() {
        try {
            connection = ConnessioneDatabase.getInstance().connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int AcquistaBigliettoDB(ArrayList<Biglietto> b) {
        int v=0;
        try {
            pstmt=connection.prepareStatement("begin");
            pstmt.execute();
            pstmt.close();

            //genera il codice del biglietto
            for (int i = 0; i < b.size(); i++) {

                pstmt = connection.prepareStatement("SELECT codicebiglietto FROM Biglietto");
                ResultSet rs = pstmt.executeQuery();

                Set<String> codiciBiglietti = new HashSet<>();

                while (rs.next()) {
                    codiciBiglietti.add(rs.getString(1));
                }

                String codiceBiglietto;
                do {
                    codiceBiglietto = generateRandomString(5);
                } while (codiciBiglietti.contains(codiceBiglietto));

                rs.close();


                //chiama la procedura per inserire il biglietto
                pstmt = connection.prepareStatement("call AcquistaBiglietto( ?,?,?,?,?,?,?);");

                pstmt.setString(1, codiceBiglietto);
                pstmt.setString(2, b.get(i).getTipoBiglietto());
                pstmt.setDate(3, Date.valueOf(LocalDate.now()));
                pstmt.setBoolean(4, b.get(i).getVeicolo());
                pstmt.setObject(5, b.get(i).getNumeroBagagli());
                pstmt.setString(6, b.get(i).getcfposs());
                pstmt.setString(7, b.get(i).getcodCorsa());


                pstmt.execute();
                if (i == b.size()) {
                    pstmt.close();
                    rs.close();
                }

            }
            pstmt=connection.prepareStatement("END;");
            pstmt.execute();
            pstmt.close();

            connection.close();



            }catch(SQLException e){
             if(e.getMessage().contains("EXpersone")){
                 JOptionPane.showMessageDialog(null, "Non ci sono abbastanza posti passeggero disponibili");

             } else if (e.getMessage().contains("EXveicoli")) {
                 JOptionPane.showMessageDialog(null, "Non ci sono abbastanza posti per veicoli disponibili");

             }else{
                 JOptionPane.showMessageDialog(null, "Errore sconosciuto");
                 //System.out.println(e.getMessage());

             }
             try{
                pstmt=connection.prepareStatement("rollback ;");
                pstmt.execute();
                pstmt.close();
                connection.close();
            }
            catch (SQLException ee){
                JOptionPane.showMessageDialog(null, "Errore: " + ee.getMessage());
            }




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
