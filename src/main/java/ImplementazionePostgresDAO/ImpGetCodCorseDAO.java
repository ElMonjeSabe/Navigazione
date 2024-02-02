package ImplementazionePostgresDAO;

import DAO.GetCodCorseDAO;
import Database.ConnessioneDatabase;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ImpGetCodCorseDAO implements GetCodCorseDAO {

    private Connection connection;

    public ImpGetCodCorseDAO(){
        try {
            connection = ConnessioneDatabase.getInstance().connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ArrayList<String> GetCodCorseDB(String nomeComp) {
        ArrayList<String> codici= new ArrayList<String>();
        try {
            PreparedStatement pstmt = connection.prepareStatement("select codicecorsa from corsa where fkcomp=?;");

            pstmt.setString(1,nomeComp);


            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                codici.add(rs.getString(1));
            }



            rs.close();
            pstmt.close();
            connection.close();

        } catch (SQLException e) {

            // gestisci altri errori SQL
            JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());

        }

        return codici;
    }

    public ArrayList<String> GetCodCorseDB() {
        ArrayList<String> codici= new ArrayList<String>();
        try {
            PreparedStatement pstmt = connection.prepareStatement("select codicecorsa from corsa;");


            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                codici.add(rs.getString(1));
            }



            rs.close();
            pstmt.close();
            connection.close();

        } catch (SQLException e) {

            // gestisci altri errori SQL
            JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());

        }

        return codici;
    }
}
