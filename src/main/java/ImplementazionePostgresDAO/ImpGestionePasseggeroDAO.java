package ImplementazionePostgresDAO;

import DAO.GestionePasseggeroDAO;
import DAO.GestisciCorsaDAO;
import Database.ConnessioneDatabase;
import Model.Passeggero;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImpGestionePasseggeroDAO implements GestionePasseggeroDAO {
    private Connection connection;
    public ImpGestionePasseggeroDAO(){
        try {
            connection = ConnessioneDatabase.getInstance().connection;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    @Override
    public int AggiungiPasseggeroDB(Passeggero p) {
        try {
            PreparedStatement regUtente = connection.prepareStatement(
                    "Call aggiungiPass(?,?,?,?,?,?)");

            regUtente.setString(1,p.getCf());
            regUtente.setString(2,p.getNome());
            regUtente.setString(3,p.getCognome());
            regUtente.setDate(4, Date.valueOf(p.getDataNascita()));
            regUtente.setString(5,p.getEmail());
            regUtente.setString(6,p.getPassword());

            regUtente.execute();

            regUtente.close();
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
