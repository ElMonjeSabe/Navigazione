package ImplementazionePostgresDAO;

import DAO.AggiungiCabinaDAO;
import Database.ConnessioneDatabase;
import Model.Cabina;
import Model.Corsa;
import Model.Imbarcazione;
import Model.Percorso;

import javax.swing.*;
import java.sql.*;


public class ImpAggiungiCabinaDAO implements AggiungiCabinaDAO {
    private Connection connection;
    private boolean esito=true;
    private PreparedStatement pstmt;

    public ImpAggiungiCabinaDAO() {
        try {
            connection = ConnessioneDatabase.getInstance().connection;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public boolean AggiungiCabinaDB(Cabina cab, Imbarcazione imb) {
        try {
            pstmt=connection.prepareStatement("begin;");
            pstmt.execute();
            pstmt.close();




                pstmt = connection.prepareStatement("insert into contiene values(?,?);");

                pstmt.setInt(1, cab.getNumero());
                pstmt.setString(2,imb.getCodice());



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
