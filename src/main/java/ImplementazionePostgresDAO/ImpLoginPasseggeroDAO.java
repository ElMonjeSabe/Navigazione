package ImplementazionePostgresDAO;

import DAO.loginPasseggeroDAO;
import Database.ConnessioneDatabase;
import Model.Compagnia;
import Model.Passeggero;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class ImpLoginPasseggeroDAO implements loginPasseggeroDAO {
    private Connection connection;

    public ImpLoginPasseggeroDAO(){
        try {
            connection = ConnessioneDatabase.getInstance().connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Override
    public Passeggero loginPasseggeroDB(String email, String password) {
        Passeggero res=null;
        try {
            PreparedStatement logPasseggero = connection.prepareStatement("select * from passeggero where email=? and passw=?;");

            logPasseggero.setString(1,email);
            logPasseggero.setString(2,password);
            ResultSet rs = logPasseggero.executeQuery();

            if(rs.next()){
                res = new Passeggero(rs.getString(1),rs.getString(2),rs.getString(3), rs.getDate(4).toLocalDate(),rs.getString(5), rs.getString(6));
            }


            rs.close();
            logPasseggero.close();
            connection.close();

        } catch (SQLException e) {

            // gestisci altri errori SQL
            JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());

        }
        return res;
    }
}
