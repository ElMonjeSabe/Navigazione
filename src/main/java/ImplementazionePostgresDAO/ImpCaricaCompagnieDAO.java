package ImplementazionePostgresDAO;

import DAO.CaricaCompagnieDAO;
import Database.ConnessioneDatabase;
import Gui.CompagniaGUI;
import Model.Compagnia;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ImpCaricaCompagnieDAO implements CaricaCompagnieDAO
{
    private Connection connection;

    public ImpCaricaCompagnieDAO() {
        try {
            connection = ConnessioneDatabase.getInstance().connection;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public void CaricaCompagnieDB(ArrayList<Compagnia> l){
        // TODO Auto-generated method stub
        try {
            PreparedStatement leggiCompagniePS = connection.prepareStatement(
                    "SELECT * FROM Compagnia");
            ResultSet rs = leggiCompagniePS.executeQuery();


            while (rs.next()) {
                l.add(new Compagnia(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }

            rs.close();
            leggiCompagniePS.close();
            connection.close();


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());

        }
    }
}