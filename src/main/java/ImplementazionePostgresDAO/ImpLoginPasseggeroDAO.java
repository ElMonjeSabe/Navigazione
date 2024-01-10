package ImplementazionePostgresDAO;

import DAO.loginPasseggeroDAO;
import Database.ConnessioneDatabase;
import Model.Compagnia;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ImpLoginPasseggeroDAO implements loginPasseggeroDAO {
    private Connection connection;
    public ImpLoginPasseggeroDAO(){
        try {
            connection = ConnessioneDatabase.getInstance().connection;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    @Override
    public boolean loginPasseggeroDB(String email, String password) {
        boolean res=false;
        try {
            PreparedStatement logCompagnia = connection.prepareStatement("select * from passeggero where email=? and passw=?;");

            logCompagnia.setString(1,email);
            logCompagnia.setString(2,password);
            ResultSet rs = logCompagnia.executeQuery();

            while(rs.next())
                res=true;

            logCompagnia.close();
            connection.close();

        } catch (SQLException e) {

            // gestisci altri errori SQL
            JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());

        }
        return res;
    }
}
