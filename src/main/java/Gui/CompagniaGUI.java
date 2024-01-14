package Gui;

import Controller.Controller;
import Model.Compagnia;
import Model.Imbarcazione;
import Model.Porto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class CompagniaGUI {
    private JPanel panel1;
    private JPanel panelTesti;
    private JTextField textEmail;
    public JFrame frame;
    public JFrame frameChiamante;
    private JPanel panel;
    private JButton aggiungiCorsaButton;
    private JButton modificaCorsaButton;
    private JButton aggiungiImbarcazioneButton;
    private JButton visualizzaLeMieCorseButton;
    private JButton aggiungiCompagniaButton;
    private JButton ritornaAllaHomeButton;
    private JTextField textNome;
    private JTextField textTelefono;
    private JTextField textSitoWeb;
    private JPanel panelTabella;
    private JPanel panelAzioni;
    private JPanel panelGridRiferimenti;
    private JPanel panelGridAzioni;
    private JPanel PanelGridRiferimenti2;
    private JLabel labelRiferimenti;
    private JLabel labelAzioni;
    private JPanel labelGridAzioni2;
    private JButton btoSocial;
    private JLabel NomeComp;
    private JLabel EmailComp;
    private JLabel TelefonoComp;
    private JLabel SitoWebComp;

    private Controller controller;

    private ArrayList<Imbarcazione> imbarcazioni= new ArrayList<Imbarcazione>();


    public CompagniaGUI(JFrame frameChiamante, Controller controller, Compagnia c) {

        this.frameChiamante = frameChiamante;
        this.controller = controller;

        NomeComp.setText(c.getNomeCompagnia());
        TelefonoComp.setText(c.getTelefono());
        EmailComp.setText(c.getEmailCompagnia());
        SitoWebComp.setText(c.getSitoWeb());

        frame = new JFrame("Seconda Finestrs");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setSize(400, 250);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        aggiungiCorsaButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<Porto> porti =controller.GetPorti();
                if(porti.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "nessun porto trovato");
                }
                else{
                    imbarcazioni=controller.GetImbarcazioni(NomeComp.getText());
                    if (!imbarcazioni.isEmpty()) {

                        AggiungiCorsa frameAggiungiCorsa = new AggiungiCorsa(frame,controller,imbarcazioni, porti, NomeComp.getText());
                        frameAggiungiCorsa.getFrame().setVisible(true);

                        frame.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Errore durante la lettura di imbarcazioni");

                    }
                }



            }
        });
        modificaCorsaButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                ModificaCorsa frameModificaCorsa = new ModificaCorsa(frame, controller);
                frameModificaCorsa.getFrame().setVisible(true);

                frame.setVisible(false);

            }
        });
        aggiungiImbarcazioneButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                AggiungiImbarcazione frameImbarcazione = new AggiungiImbarcazione(frame, controller, NomeComp.getText());
                frameImbarcazione.getFrame().setVisible(true);

                frame.setVisible(false);
            }
        });
        btoSocial.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                SocialGUI social = new SocialGUI(frame);
                social.getFrame().setVisible(true);

                frame.setVisible(false);
            }
        });
    }



}
