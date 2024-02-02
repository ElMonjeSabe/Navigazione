package ImplementazionePostgresDAO;

import DAO.AggiungiSocialDAO;
import Database.ConnessioneDatabase;
import Model.Social;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImpAggiungiSocialDAO implements AggiungiSocialDAO {
    private Connection connection;
    boolean esito=true;

    public ImpAggiungiSocialDAO() {
        try {
            connection = ConnessioneDatabase.getInstance().connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public boolean AggiungiSocialDB(Social soc) {
        try {
            PreparedStatement pstmt = connection.prepareStatement("insert into Social values(?,?,?);");

            pstmt.setString(1,soc.getURL());
            pstmt.setString(2,soc.getNomeSocial());
            pstmt.setString(3,soc.getCompagnia().getNomeCompagnia());
            pstmt.execute();

            pstmt.close();
            connection.close();


        } catch (SQLException e) {


            if(e.getMessage().contains("social_pkey")){
                JOptionPane.showMessageDialog(null, "Questo URL è già utilizzato");
                System.out.println(e.getMessage());

            }else {
                // gestisci altri errori SQL
                JOptionPane.showMessageDialog(null, "Errore sconosciuto, rprova più tardi");
                System.out.println(e.getMessage());
            }
            return false;
        }

        return true;
    }
}
