package ImplementazionePostgresDAO;

import DAO.LoginCompagniaDAO;


import Database.ConnessioneDatabase;
import Model.Compagnia;


import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ImpLoginCompagniaDAO implements LoginCompagniaDAO {
    private Connection connection;
    public ImpLoginCompagniaDAO(){
        try {
            connection = ConnessioneDatabase.getInstance().connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Override
    public Compagnia loginCompagniaDB(String email, String password) {
        Compagnia res=null;
        try {
            PreparedStatement logCompagnia = connection.prepareStatement("select * from compagnia where emailcompagnia=? and passwcompagnia=?;");

            logCompagnia.setString(1,email);
            logCompagnia.setString(2,password);
            ResultSet rs = logCompagnia.executeQuery();

            if(rs.next()){
                res = new Compagnia(rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4),rs.getString(5));
            }


            rs.close();
            logCompagnia.close();
            connection.close();

        } catch (SQLException e) {

            // gestisci altri errori SQL
            JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());

        }
        return res;
    }
}
