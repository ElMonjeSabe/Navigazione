package Gui;

import Controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CompagniaGUI {
    private JPanel panel1;
    private JPanel panelTesti;
    private JLabel labelTitolo;
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

    private Controller controller;


    public CompagniaGUI(JFrame frameChiamante, Controller controller) {

        this.frameChiamante = frameChiamante;
        this.controller = controller;

        frame = new JFrame("Seconda Finestrs");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        ritornaAllaHomeButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                frameChiamante.setVisible(true);
                frame.setVisible(false);
                frame.dispose();
            }
        });
        aggiungiCompagniaButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textNome.getText();
                String email = textEmail.getText();
                String telefono = textTelefono.getText();
                String sito = textSitoWeb.getText();
                if (nome.equals("") || email.equals("") || telefono.equals("") || sito.equals("")) {
                    JOptionPane.showMessageDialog(null, "Inserisci tutti i campi!");
                    return;
                }
            }
        });
        aggiungiCorsaButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                AggiungiCorsa frameAggiungiCorsa = new AggiungiCorsa(frame);
                frameAggiungiCorsa.getFrame().setVisible(true);

                frame.setVisible(false);
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
                ModificaCorsa frameModificaCorsa = new ModificaCorsa(frame);
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
                AggiungiImbarcazione frameImbarcazione = new AggiungiImbarcazione(frame, controller);
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
