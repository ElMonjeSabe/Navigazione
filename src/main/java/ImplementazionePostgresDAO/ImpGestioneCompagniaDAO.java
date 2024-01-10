package ImplementazionePostgresDAO;

import DAO.GestioneCompagniaDAO;
import Database.ConnessioneDatabase;
import Model.Compagnia;
import Model.Passeggero;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImpGestioneCompagniaDAO implements GestioneCompagniaDAO {
    private Connection connection;
    public ImpGestioneCompagniaDAO(){
        try {
            connection = ConnessioneDatabase.getInstance().connection;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    @Override
    public int AggiungiCompagniaDB(Compagnia c) {
        try {
            PreparedStatement regCompagnia = connection.prepareStatement("insert into Compagnia values(?,?,?,?,?);");

            regCompagnia.setString(1,c.getNomeCompagnia());
            regCompagnia.setString(2,c.getPasswCompagnia());
            regCompagnia.setString(3,c.getTelefono());
            regCompagnia.setString(4,c.getEmailCompagnia());
            regCompagnia.setString(5,c.getSitoWeb());


            regCompagnia.execute();

            regCompagnia.close();
            connection.close();

        } catch (SQLException e) {
            if (e.getSQLState().equals("23505")) {
                // gestisci l'errore di chiave duplicata
                JOptionPane.showMessageDialog(null, "Email già utilizzata" );

            } else {
                // gestisci altri errori SQL
                JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());
            }
            return 0;
        }
        return 1;
    }
}
