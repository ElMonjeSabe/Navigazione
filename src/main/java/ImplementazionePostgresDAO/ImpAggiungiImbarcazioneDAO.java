package ImplementazionePostgresDAO;

import DAO.AggiungiImbarcazioneDAO;
import Database.ConnessioneDatabase;
import Model.Imbarcazione;

import javax.swing.*;
import java.sql.*;

public class ImpAggiungiImbarcazioneDAO implements AggiungiImbarcazioneDAO {
    private Connection connection;
    boolean esito=true;

    public ImpAggiungiImbarcazioneDAO() {
        try {
            connection = ConnessioneDatabase.getInstance().connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public boolean AggiungiImbarcazioneDB(Imbarcazione im) {
        try {
            PreparedStatement pstmt = connection.prepareStatement("call AggiungiImbarcazione( ?,?,?,?,?,?);");

            pstmt.setString(1,im.getCodice());
            pstmt.setString(2, im.getNome());
            pstmt.setString(3, im.getTipo());
            pstmt.setString(4, im.getNomeCompagniaPoss());
            pstmt.setInt(5, im.getMaxPass());
            pstmt.setInt(6, im.getMaxVei());
            pstmt.execute();

            pstmt.close();
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
