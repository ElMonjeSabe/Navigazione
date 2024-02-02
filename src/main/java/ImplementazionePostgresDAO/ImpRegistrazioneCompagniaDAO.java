package ImplementazionePostgresDAO;

import DAO.RegistrazioneCompagniaDAO;
import Database.ConnessioneDatabase;
import Model.Compagnia;
import Model.Imbarcazione;

import javax.swing.*;
import java.sql.*;

public class ImpRegistrazioneCompagniaDAO implements RegistrazioneCompagniaDAO {
    private Connection connection;
    boolean esito=true;
    private PreparedStatement pstmt;

    public ImpRegistrazioneCompagniaDAO() {
        try {
            connection = ConnessioneDatabase.getInstance().connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public boolean RegistrazioneCompagniaDB(Compagnia comp, Imbarcazione imb) {

        //avvio una transazione
        try {


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




            connection.close();

        } catch (SQLException e) {

            if (e.getMessage().contains("emailunicac")) {

                JOptionPane.showMessageDialog(null, "Email già utilizzata");
                System.out.println("Email già utilizzata"+e.getMessage());

            } else if(e.getMessage().contains("formatoemail")) {

                JOptionPane.showMessageDialog(null, "Email nel formato sbagliato");
                System.out.println("Email nel formato sbagliato" + e.getMessage());

            }else if(e.getMessage().contains("compagnia_pkey")){

                JOptionPane.showMessageDialog(null, "Esiste già una compagnia con questo nome");
                System.out.println("Nome compagnia già utilizzato" + e.getMessage());

            } else if (e.getMessage().contains("imbarcazione_pkey")) {

                JOptionPane.showMessageDialog(null, "Codice imbarcazione non valido");
                System.out.println("Codice imbarcazione già in uso" + e.getMessage());

            }else{

                JOptionPane.showMessageDialog(null, "Errore sconosciuto, riporva più tardi");
                System.out.println(e.getMessage());

            }
            return false;
        }



        return true;
    }
}
