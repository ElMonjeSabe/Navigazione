package ImplementazionePostgresDAO;

import DAO.CaricaCompagnieDAO;
import Database.ConnessioneDatabase;
import Model.Compagnia;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Implementazione dell'interfaccia CaricaCompagnieDAO
 */
public class ImpCaricaCompagnieDAO implements CaricaCompagnieDAO
{
    private Connection connection;

    /**
     * Costruttore che si connette al database
     */
    public ImpCaricaCompagnieDAO() {
        try {
            connection = ConnessioneDatabase.getInstance().connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public ArrayList<Compagnia> CaricaCompagnieDB() {
        ArrayList<Compagnia> comps= new ArrayList<Compagnia>();
        try {
            PreparedStatement leggiCompagniePS = connection.prepareStatement(
                    "SELECT * FROM Compagnia");
            ResultSet rs = leggiCompagniePS.executeQuery();


            while (rs.next()) {
                comps.add(new Compagnia(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)));
            }

            rs.close();
            leggiCompagniePS.close();
            connection.close();


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());

        }
        return comps;
    }
}
