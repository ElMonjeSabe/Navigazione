package ImplementazionePostgresDAO;

import DAO.CabineDisponibiliDAO;
import DAO.CorseDAO;
import Database.ConnessioneDatabase;
import Model.Cabina;
import Model.CorsaTabellone;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ImpCabineDisponibiliDAO implements CabineDisponibiliDAO {

        private Connection connection;

        public ImpCabineDisponibiliDAO() {
            try {
                connection = ConnessioneDatabase.getInstance().connection;
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


        @Override
        public ArrayList<Cabina> CabineDisponibiliDB(String CodiceCorsa) {
            // TODO Auto-generated method stub
            try {
                PreparedStatement CabineDispPS = connection.prepareStatement(
                        "SELECT idCabina, postiletto\n" +
                                "\tFROM Corsa JOIN Imbarcazione ON FKImb = CodiceImbarcazione JOIN Contiene ON CodiceImbarcazione = ImCot JOIN Cabina ON idCont = idCabina\n" +
                                "\tWHERE CodiceCorsa = ? AND idCabina NOT IN (SELECT idCabina\n" +
                                "\t\t\t\t\t\t\t\t\t\t  FROM Biglietto JOIN Cabina ON idConf = idCabina\n" +
                                "\t\t\t\t\t\t\t\t\t\t\tWHERE CorAs = ?  )");

                CabineDispPS.setString(1, CodiceCorsa);
                CabineDispPS.setString(2, CodiceCorsa);


                ResultSet rs = CabineDispPS.executeQuery();

                ArrayList<Cabina> cabDis = new ArrayList<Cabina>();
                while (rs.next()) {

                    cabDis.add(new Cabina(rs.getInt(1), rs.getInt(2)));

                }

                rs.close();
                CabineDispPS.close();
                connection.close();

                return cabDis;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Errore: " + e.getMessage());

            }

            return null;
    }

}
