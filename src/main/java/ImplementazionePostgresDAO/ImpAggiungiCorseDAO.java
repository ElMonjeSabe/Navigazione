package ImplementazionePostgresDAO;

import DAO.AggiungiCorseDAO;
import Database.ConnessioneDatabase;
import Model.Imbarcazione;
import Model.Percorso;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class ImpAggiungiCorseDAO implements AggiungiCorseDAO {
    private Connection connection;
    boolean esito=true;

    public ImpAggiungiCorseDAO() {
        try {
            connection = ConnessioneDatabase.getInstance().connection;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public boolean AggiungiCorseDB(ArrayList<Percorso> percorsi) {
        // TODO Auto-generated method stub
        try {
            for(Percorso per : percorsi){
                PreparedStatement pstmt = connection.prepareStatement("insert into percorso values(?,?,?,?,?,?,?);");

                pstmt.setString(1,per.getCodCorsa());
                pstmt.setInt(2, per.getCodPorto());
                pstmt.setInt(3, per.getTappa());
                pstmt.setTime(4, Time.valueOf(per.getOrarioPartenza()));
                pstmt.setTime(5, Time.valueOf(per.getOrarioArrivo()));
                pstmt.setDate(6, Date.valueOf(per.getDataAttivazione()));
                pstmt.setDate(7, Date.valueOf(per.getDataScadenza()));
                pstmt.execute();

                pstmt.close();

            }

            connection.close();


        } catch (SQLException e) {
            if (e.getSQLState().equals("23505")) {
                // gestisci l'errore di chiave duplicata
                JOptionPane.showMessageDialog(null, "Errore: Codice non valido" );

            } else {
                // gestisci altri errori SQL
                JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());
            }
            esito=false;
        }

        return esito;
    }
}
