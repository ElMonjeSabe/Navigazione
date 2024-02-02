package ImplementazionePostgresDAO;

import DAO.AggiungiImbarcazioneDAO;
import Database.ConnessioneDatabase;
import Model.Imbarcazione;

import javax.swing.*;
import java.sql.*;

/**
 * Implementazione dell'interfaccia AggiungiImbarcazioneDAO
 */
public class ImpAggiungiImbarcazioneDAO implements AggiungiImbarcazioneDAO {
    private Connection connection;

    /**
     * Costruttore che si connette al database
     */
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

            if (e.getMessage().contains("imbarcazione_pkey")) {

                JOptionPane.showMessageDialog(null, "Codice imbarcazione non valido");
                System.out.println("Codice imbarcazione già in uso" + e.getMessage());

            }else{

                JOptionPane.showMessageDialog(null, "Errore sconosciuto, riporva più tardi");
                System.out.println(e.getMessage());

            }
            return false;
        }

        return true;
    }



}
