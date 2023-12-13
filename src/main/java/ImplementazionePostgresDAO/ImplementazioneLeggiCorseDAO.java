package ImplementazionePostgresDAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import DAO.CorseDAO;
import Database.ConnessioneDatabase;
import Model.CorsaTabellone;

import javax.swing.*;

public class ImplementazioneLeggiCorseDAO implements CorseDAO{

    private Connection connection;

    public ImplementazioneLeggiCorseDAO() {
        try {
            connection = ConnessioneDatabase.getInstance().connection;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void leggiCorseDB(ArrayList<CorsaTabellone> corse) {
        // TODO Auto-generated method stub
        try {
            PreparedStatement leggiTabellaPS = connection.prepareStatement(
                    "SELECT * FROM Tabellone");
            ResultSet rs = leggiTabellaPS.executeQuery();


            while (rs.next()) {

               corse.add(new CorsaTabellone(rs.getString(1),rs.getFloat(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getDate(10),rs.getDate(11),rs.getTime(12),rs.getTime(13),rs.getString(14),rs.getString(15)));

            }

            rs.close();
            leggiTabellaPS.close();
            connection.close();


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());

        }

    }
}
