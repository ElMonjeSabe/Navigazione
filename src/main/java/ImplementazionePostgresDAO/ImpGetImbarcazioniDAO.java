package ImplementazionePostgresDAO;

import DAO.GetImbarcazioniDAO;
import Database.ConnessioneDatabase;
import Model.Compagnia;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ImpGetImbarcazioniDAO implements GetImbarcazioniDAO {

    private Connection connection;
    public ImpGetImbarcazioniDAO(){
        try {
            connection = ConnessioneDatabase.getInstance().connection;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    @Override
    public ArrayList<String> GetImbarcazioniDB(String nomeComp) {
        ArrayList<String> imbarcazioni= new ArrayList<String>();
        try {
            PreparedStatement imbLista = connection.prepareStatement("select nomeimbarcazione from Imbarcazione where compposs=?;");

            imbLista.setString(1,nomeComp);

            ResultSet rs = imbLista.executeQuery();

            while(rs.next()){
                imbarcazioni.add(rs.getString(1));
            }



            rs.close();
            imbLista.close();
            connection.close();

        } catch (SQLException e) {

            // gestisci altri errori SQL
            JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());

        }
        return imbarcazioni;
    }
}
