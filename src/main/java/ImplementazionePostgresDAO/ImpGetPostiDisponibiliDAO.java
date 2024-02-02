package ImplementazionePostgresDAO;

import DAO.GetPostiDisponibiliDAO;
import Database.ConnessioneDatabase;


import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ImpGetPostiDisponibiliDAO implements GetPostiDisponibiliDAO {
    private Connection connection;

    public ImpGetPostiDisponibiliDAO(){
        try {
            connection = ConnessioneDatabase.getInstance().connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Override
    public int[] getPostiDisponibiliDB(String codCorsa) {
        int[] posti= new int[2];
        try {
            PreparedStatement pstmt = connection.prepareStatement("select * FROM getPostiDisponibili(?);");
            pstmt.setString(1,codCorsa);


            ResultSet rs = pstmt.executeQuery();

            rs.next();
            posti[0] = rs.getInt(1);
            posti[1] = rs.getInt(2);

            rs.close();
            pstmt.close();
            connection.close();

        } catch (SQLException e) {

            // gestisci altri errori SQL
            JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());

        }
        return posti;
    }
}
