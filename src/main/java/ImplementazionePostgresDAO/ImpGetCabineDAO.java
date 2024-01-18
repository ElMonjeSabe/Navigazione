package ImplementazionePostgresDAO;

import DAO.GetCabineDAO;
import Database.ConnessioneDatabase;
import Model.Cabina;
import Model.Compagnia;
import Model.Imbarcazione;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ImpGetCabineDAO implements GetCabineDAO {

    private Connection connection;

    public ImpGetCabineDAO() {
        try {
            connection = ConnessioneDatabase.getInstance().connection;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Cabina> GetCabineDB(String CDCorsa) {
        ArrayList<Cabina> cabine= new ArrayList<Cabina>();
        try {
            PreparedStatement pstmt = connection.prepareStatement(
                    "SELECT idCabina, postiletto\n" +
                            "\tFROM Corsa JOIN Imbarcazione ON FKImb = CodiceImbarcazione JOIN Contiene ON CodiceImbarcazione = ImCot JOIN Cabina ON idCont = idCabina\n" +
                            "\tWHERE CodiceCorsa =? AND idCabina NOT IN (SELECT idCabina\n" +
                            "\t\t\t\t\t\t       FROM Biglietto JOIN Cabina ON idConf = idCabina\n" +
                            "\t\t\t\t\t\t       WHERE CorAs =?);");
            pstmt.setString(1,CDCorsa);
            pstmt.setString(2,CDCorsa);
            ResultSet rs = pstmt.executeQuery();


            while (rs.next()) {
                cabine.add(new Cabina(
                        rs.getInt(1),
                        rs.getInt(2)));
            }

            rs.close();
            pstmt.close();
            connection.close();


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());

        }
        return cabine;
    }

    public int GetUltimaCabinaDB(Imbarcazione imb) {
        int risultato=0;
        try {
            PreparedStatement pstmt = connection.prepareStatement(
                    "SELECT MAX(idcabina)\n" +
                            "    FROM (Imbarcazione JOIN Contiene on codiceImbarcazione=imcot) join cabina on idcont=idcabina\n" +
                            "    where codiceimbarcazione=?;");
            pstmt.setString(1,imb.getCodice());
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                risultato=rs.getInt(1);
            }


            rs.close();
            pstmt.close();
            connection.close();


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());


        }
        return risultato;
    }
}
