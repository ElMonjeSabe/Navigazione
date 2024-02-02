package ImplementazionePostgresDAO;

import DAO.BigliettiAcquistatiDAO;
import Database.ConnessioneDatabase;
import Model.BigliettiAcquistati;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

/**
 * Implementazione dell'interfaccia BigliettiAcquistatiDAO
 */
public class ImpBigliettiAcquistatiDAO implements BigliettiAcquistatiDAO {
    private Connection connection;

    /**
     * Costruttore che si connette al database
     */
    public  ImpBigliettiAcquistatiDAO() {

        try {
            connection = ConnessioneDatabase.getInstance().connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void leggiBigliettiAcquistatiUtenteDB(ArrayList<BigliettiAcquistati> bigliettiAcquistati, String cf) {
        try {
            PreparedStatement leggiBiglAcqPS = connection.prepareStatement(
                    "SELECT * FROM bigliettiAcquistati WHERE cf = ?");
            leggiBiglAcqPS.setString(1, cf);


            ResultSet rs = leggiBiglAcqPS.executeQuery();


            while (rs.next()) {

                bigliettiAcquistati.add(new BigliettiAcquistati(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5).toLocalDate(),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getFloat(8),
                        rs.getDate(9).toLocalDate(),
                        rs.getBoolean(10),
                        rs.getInt(11),
                        rs.getBoolean(12)));

            }

            rs.close();
            leggiBiglAcqPS.close();
            connection.close();


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());

        }
    }

    @Override
    public void leggiBigliettiAcquistatiCompagniaDB(ArrayList<BigliettiAcquistati> bigliettiAcquistati, String NomeCompagnia) {
        try {
            PreparedStatement leggiBiglAcqPS = connection.prepareStatement(
                    "SELECT b.* FROM bigliettiAcquistati b JOIN corsa c ON b.codicecorsa = c.codicecorsa  WHERE c.FKComp = ?");
            leggiBiglAcqPS.setString(1, NomeCompagnia);


            ResultSet rs = leggiBiglAcqPS.executeQuery();


            while (rs.next()) {

                bigliettiAcquistati.add(new BigliettiAcquistati(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5).toLocalDate(),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getFloat(8),
                        rs.getDate(9).toLocalDate(),
                        rs.getBoolean(10),
                        rs.getInt(11),
                        rs.getBoolean(12)));

            }

            rs.close();
            leggiBiglAcqPS.close();
            connection.close();


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());

        }
    }

    @Override
    public void leggiBigliettiFiltratiAcquistatiCompagniaDB(ArrayList<BigliettiAcquistati> bigliettiAcquistati, String codiceCorsa,  int prezzo, String nomeCompagnia) {
        try {
            PreparedStatement leggiBiglAcqPS = connection.prepareStatement(
                    "SELECT b.* FROM bigliettiAcquistati b JOIN corsa c ON b.codicecorsa = c.codicecorsa  WHERE b.codicecorsa LIKE ? AND prezzo <= ? AND fkcomp LIKE ?");

            if(codiceCorsa.equals("tutte")){
                leggiBiglAcqPS.setString(1, "%");
            }else {
                leggiBiglAcqPS.setString(1, codiceCorsa);
            }

            leggiBiglAcqPS.setInt(2, prezzo);
            leggiBiglAcqPS.setString(3, nomeCompagnia);


            ResultSet rs = leggiBiglAcqPS.executeQuery();


            while (rs.next()) {

                bigliettiAcquistati.add(new BigliettiAcquistati(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5).toLocalDate(),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getFloat(8),
                        rs.getDate(9).toLocalDate(),
                        rs.getBoolean(10),
                        rs.getInt(11),
                        rs.getBoolean(12)));

            }

            rs.close();
            leggiBiglAcqPS.close();
            connection.close();


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());

        }
    }
}
