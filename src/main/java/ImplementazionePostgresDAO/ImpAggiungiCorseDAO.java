package ImplementazionePostgresDAO;

import DAO.AggiungiCorseDAO;
import Database.ConnessioneDatabase;
import Model.Corsa;
import Model.Imbarcazione;
import Model.Percorso;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class ImpAggiungiCorseDAO implements AggiungiCorseDAO {
    private Connection connection;
    boolean esito=true;
    private PreparedStatement pstmt;

    public ImpAggiungiCorseDAO() {
        try {
            connection = ConnessioneDatabase.getInstance().connection;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public boolean AggiungiCorseDB(ArrayList<Percorso> percorsi, ArrayList<Corsa> corse) {

        //avvio una transazione

        // TODO Auto-generated method stub
        try {
            pstmt=connection.prepareStatement("begin");
            pstmt.execute();
            pstmt.close();

            for(Corsa c: corse) {
                pstmt = connection.prepareStatement("insert into corsa values(?,?,?,?,?,?)");
                pstmt.setString(1, c.getCodiceCorsa());
                pstmt.setDouble(2, c.getCostoCorsa());
                pstmt.setString(3, c.getAvviso());
                pstmt.setString(4, c.getStato());
                pstmt.setString(5, c.getImbarcazioneUtilizzata().getCodice());
                pstmt.setString(6, c.getCompagniaOfferente().getNomeCompagnia());

                pstmt.execute();
                pstmt.close();
            }

            for(Percorso per : percorsi){
                pstmt = connection.prepareStatement("insert into percorso values(?,?,?,?,?,?,?);");

                pstmt.setString(1,per.getCorsa().getCodiceCorsa());
                pstmt.setInt(2, per.getPorto().getIdPorto());
                pstmt.setString(3, per.getTipoPercorso());
                pstmt.setTime(4, Time.valueOf(per.getOrarioPartenza()));
                pstmt.setTime(5, Time.valueOf(per.getOrarioArrivo()));
                pstmt.setDate(6, Date.valueOf(per.getDataAttivazione()));
                pstmt.setDate(7, Date.valueOf(per.getDataScadenza()));

                pstmt.execute();
                pstmt.close();

            }
            pstmt=connection.prepareStatement("END;");
            pstmt.execute();
            pstmt.close();


            connection.close();

        } catch (SQLException e) {
            // gestisci altri errori SQL
            JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());

            try{
                pstmt=connection.prepareStatement("rollback ;");
                pstmt.execute();
                pstmt.close();
                connection.close();
            }
            catch (SQLException ee){
                JOptionPane.showMessageDialog(null, "Errore: " + ee.getMessage());
            }


            esito=false;
        }

        return esito;
    }
}
