package ImplementazionePostgresDAO;

import DAO.GetImbarcazioniDAO;
import Database.ConnessioneDatabase;
import Model.Imbarcazione;

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
            e.printStackTrace();
        }

    }
    @Override
    public ArrayList<Imbarcazione> GetImbarcazioniDB(String nomeComp) {
        ArrayList<Imbarcazione> imbarcazioni= new ArrayList<Imbarcazione>();
        try {
            PreparedStatement imbLista = connection.prepareStatement("select * from Imbarcazione where compposs=?;");

            imbLista.setString(1,nomeComp);

            ResultSet rs = imbLista.executeQuery();

            while(rs.next()){
                imbarcazioni.add(new Imbarcazione(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(5),rs.getInt(6),rs.getString(4)));
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
