package Gui;

import Controller.Controller;
import Model.Passeggero;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class RegUtente {
    private JPanel panel1;
    private JTextField tfEmail;
    private JTextField tfNome;
    private JTextField tfCognome;
    private JTextField tfPassword;
    private JTextField tfCF;
    private JButton confermaButton;
    private JButton indietroButton;
    private JComboBox<Integer> comboBoxGiorno;
    private JComboBox<Integer> comboBoxMese;
    private JComboBox<Integer> comboBoxAnno;

    public JFrame frame;

    private Controller controller;

    public JFrame frameChiamante;

    public RegUtente(JFrame frameChiamante, Controller controller) {
        this.controller = controller;
        this.frameChiamante = frameChiamante;

        //ComboBox Giorno
        for (Integer i = 1; i <= 31; i++) {
            comboBoxGiorno.addItem(i);
        }

        //ComboBox Mese
        for (Integer i = 1; i <= 12; i++) {
            comboBoxMese.addItem(i);
        }

        //ComboBox Anno
        for (Integer i = 1920; i <= 2023; i++) {
            comboBoxAnno.addItem(i);
        }


        frame = new JFrame("Registrazione Utente");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 330);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        indietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameChiamante.setVisible(true);
                frame.setVisible(false);
                frame.dispose();
            }
        });
        confermaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (tfCF.getText().equals("") || tfNome.getText().equals("") || tfCognome.getText().equals("") || tfEmail.getText().equals("") || tfPassword.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Inserisci tutti i campi!");

                } else {
                    LocalDate data = LocalDate.of((Integer) comboBoxAnno.getSelectedItem(), (Integer) comboBoxMese.getSelectedItem(), (Integer) comboBoxGiorno.getSelectedItem());
                    Passeggero p = new Passeggero(tfCF.getText(), tfNome.getText(), tfCognome.getText(), data, tfEmail.getText(), tfPassword.getText());
                    if (controller.AggiungiPasseggero(p) == 1) {
                        JOptionPane.showMessageDialog(null, "Registrazione effettuata con successo");
                        PasseggeroGUI framePasseggeroGUI = new PasseggeroGUI(frame, controller, p);
                        framePasseggeroGUI.frame.setVisible(true);
                        frame.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Errore durante la registrazione");

                    }
                }
            }
        });
    }


}
