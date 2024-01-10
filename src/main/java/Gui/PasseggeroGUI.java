package Gui;

import Controller.Controller;
import Model.Passeggero;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PasseggeroGUI {
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/d");
    private JPanel panelDati;
    private JTextField textNome;
    private JTextField textCF;
    private JFormattedTextField textDataNascita = new JFormattedTextField(formatter);
    private JButton aggiungiPasseggeroButton;
    private JLabel labelTitolo;
    private JButton visualizzaCorseButton;
    private JButton visualizzaBigliettiAcquistatiButton;
    private JButton ritornaAllaHomeButton;
    private JPanel panel;
    private JPasswordField passwordField;
    private JTextField textEmail;
    private JPanel panelTabella;
    private JPanel panelTitolo;
    private JPanel PanelCampi;
    private JPanel panelAzioni;
    private JPanel panelTitolo2;
    private JPanel PanelBottoni;
    private JLabel NomePass;
    private JLabel CongPass;
    private JLabel CFPass;
    private JLabel DaNaPass;
    private JLabel EmailPass;

    private JFrame frameChiamante;

    public JFrame frame;

    Controller controller;

    private Passeggero p;


    public PasseggeroGUI(JFrame frameChiamante, Controller controller, Passeggero p) {

        this.frameChiamante = frameChiamante;
        this.controller = controller;
        this.p =p;


        NomePass.setText(p.getNome());
        CongPass.setText(p.getCognome());
        EmailPass.setText(p.getEmail());
        CFPass.setText(p.getCf());
        DaNaPass.setText(String.valueOf(p.getDataNascita()));

        frame = new JFrame("Passeggero");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


       /* aggiungiPasseggeroButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */ /*
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textNome.getText();
                String cf = textCF.getText();
                LocalDate datanascita = LocalDate.parse(textDataNascita.getText(), formatter);
                String email = textEmail.getText();
                String password = passwordField.getText();
                if (nome.equals("") || datanascita.equals("") || cf.equals("") || datanascita.equals("")) {
                    JOptionPane.showMessageDialog(null, "Inserisci tutti i campi testa di cazzo");
                    return;
                } else {
                    if (!email.equals(EMAIL_PATTERN) && password.equals(""))
                        JOptionPane.showMessageDialog(null, "inserisci beneee!");
                    else {
                        JOptionPane.showMessageDialog(null, "ok!");
                    }
                }

            }
        });*/
        visualizzaCorseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.LeggiCorseDAO();
                ListaCorse frameListaCorse = new ListaCorse(frame, controller,p);
                frameListaCorse.frame.setVisible(true);
                frame.setVisible(false);
            }
        });
    }



}
