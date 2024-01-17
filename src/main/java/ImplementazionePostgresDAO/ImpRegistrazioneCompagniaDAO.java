package ImplementazionePostgresDAO;

import DAO.RegistrazioneCompagniaDAO;
import Database.ConnessioneDatabase;
import Model.Compagnia;
import Model.Corsa;
import Model.Imbarcazione;
import Model.Percorso;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class ImpRegistrazioneCompagniaDAO implements RegistrazioneCompagniaDAO {
    private Connection connection;
    boolean esito=true;
    private PreparedStatement pstmt;

    public ImpRegistrazioneCompagniaDAO() {
        try {
            connection = ConnessioneDatabase.getInstance().connection;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public boolean RegistrazioneCompagniaDB(Compagnia comp, Imbarcazione imb) {

        //avvio una transazione

        // TODO Auto-generated method stub
        try {
            pstmt=connection.prepareStatement("begin;");
            pstmt.execute();
            pstmt.close();

            pstmt = connection.prepareStatement("insert into Compagnia values(?,?,?,?,?);");

            pstmt.setString(1,comp.getNomeCompagnia());
            pstmt.setString(2,comp.getPasswCompagnia());
            pstmt.setString(3,comp.getTelefono());
            pstmt.setString(4,comp.getEmailCompagnia());
            pstmt.setString(5,comp.getSitoWeb());


            pstmt.execute();

            pstmt.close();



            PreparedStatement pstmt = connection.prepareStatement("call AggiungiImbarcazione( ?,?,?,?,?,?);");

            pstmt.setString(1,imb.getCodice());
            pstmt.setString(2, imb.getNome());
            pstmt.setString(3, imb.getTipo());
            pstmt.setString(4, imb.getNomeCompagniaPoss());
            pstmt.setInt(5, imb.getMaxPass());
            pstmt.setInt(6, imb.getMaxVei());

            pstmt.execute();
            pstmt.close();


            pstmt=connection.prepareStatement("commit;");
            pstmt.execute();
            pstmt.close();


            connection.close();

        } catch (SQLException e) {
            // gestisci altri errori SQL
            JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());

            try{
                pstmt=connection.prepareStatement("rollback ;");
                pstmt.execute();
                pstmt.close();
                connection.close();
            }
            catch (SQLException ee){
                JOptionPane.showMessageDialog(null, "Errore: " + ee.getMessage());
            }


            esito=false;
        }

        return esito;
    }
}
