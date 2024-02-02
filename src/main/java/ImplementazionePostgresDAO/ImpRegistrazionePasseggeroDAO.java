package ImplementazionePostgresDAO;

import DAO.RegistrazionePasseggeroDAO;
import Database.ConnessioneDatabase;
import Model.Passeggero;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImpRegistrazionePasseggeroDAO implements RegistrazionePasseggeroDAO {
    private Connection connection;
    public ImpRegistrazionePasseggeroDAO(){
        try {
            connection = ConnessioneDatabase.getInstance().connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public int AggiungiPasseggeroDB(Passeggero p) {
        try {
            PreparedStatement regUtente = connection.prepareStatement(
                    "Call aggiungiPass(?,?,?,?,?,?)");
            //System.out.println(p.getCf().length()+" "+p.getCf());
            regUtente.setString(1,p.getCf());
            regUtente.setString(2,p.getNome());
            regUtente.setString(3,p.getCognome());
            regUtente.setDate(4, Date.valueOf(p.getDataNascita()));
            regUtente.setString(5,p.getEmail());
            regUtente.setString(6,p.getPassword());

            regUtente.execute();

            regUtente.close();
            connection.close();

        } catch (SQLException e) {
            if (e.getMessage().contains("emailunicap")) {

                JOptionPane.showMessageDialog(null, "Email già utilizzata");
                System.out.println("Email già utilizzata"+e.getMessage());

            } else if(e.getMessage().contains("formatoemail")) {

                JOptionPane.showMessageDialog(null, "Email nel formato sbagliato");
                System.out.println("Email nel formato sbagliato" + e.getMessage());

            }else if(e.getMessage().contains("passeggero_pkey")){

                JOptionPane.showMessageDialog(null, "Già esiste un account con questo codice fiscale");
                System.out.println("Codice fiscale già esistente" + e.getMessage());

            }else{

                JOptionPane.showMessageDialog(null, "Errore sconosciuto, riporva più tardi");
                System.out.println(e.getMessage());

            }
            return 0;
        }
        return 1;
    }
}
