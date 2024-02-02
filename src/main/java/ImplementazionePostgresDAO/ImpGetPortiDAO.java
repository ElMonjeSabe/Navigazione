package ImplementazionePostgresDAO;

import DAO.GetPortiDAO;
import Database.ConnessioneDatabase;
import Model.Porto;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Implementazione dell'interfaccia GetPortiDAO
 */
public class ImpGetPortiDAO implements GetPortiDAO {
    private Connection connection;

    /**
     * Costruttore che si connette al database
     */
    public ImpGetPortiDAO(){
        try {
            connection = ConnessioneDatabase.getInstance().connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Override
    public ArrayList<Porto> GetPortiDB() {
        ArrayList<Porto> porti= new ArrayList<Porto>();
        try {
            PreparedStatement portiLista = connection.prepareStatement("select * from Porto;");

            ResultSet rs = portiLista.executeQuery();

            while(rs.next()){
                porti.add(new Porto(rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(1)));
            }



            rs.close();
            portiLista.close();
            connection.close();

        } catch (SQLException e) {

            // gestisci altri errori SQL
            JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());

        }
        return porti;
    }
}
