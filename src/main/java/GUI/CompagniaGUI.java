package GUI;

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
    private JButton visualizzaCorseButton;
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
    private JButton aggiungiCabinaButton;

    private Controller controller;

    private ArrayList<Imbarcazione> imbarcazioni= new ArrayList<Imbarcazione>();
    private Compagnia c;

    public CompagniaGUI(JFrame frameChiamante, Controller controller) {

        this.frameChiamante = frameChiamante;
        this.controller = controller;
        c = controller.getCompagnia();

        NomeComp.setText(c.getNomeCompagnia());
        TelefonoComp.setText(c.getTelefono());
        EmailComp.setText(c.getEmailCompagnia());
        SitoWebComp.setText(c.getSitoWeb());

        frame = new JFrame("Schermata Compagnia");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
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

                        AggiungiCorsa frameAggiungiCorsa = new AggiungiCorsa(frame,controller,imbarcazioni, porti, c);
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
                ModificaCorsa frameModificaCorsa = new ModificaCorsa(frame, controller, c);
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
                SocialGUI social = new SocialGUI(frame,controller,c);
                social.getFrame().setVisible(true);

                frame.setVisible(false);
            }
        });
        visualizzaCorseButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.LeggiCorseDAO();
                ListaCorse frameListaCorse = new ListaCorse(frame, controller,null);
                frameListaCorse.frame.setVisible(true);
                frame.setVisible(false);

            }
        });
        aggiungiCabinaButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                AggiungiCabina cabinaGUI = new AggiungiCabina(frame,controller,c);
                cabinaGUI.getFrame().setVisible(true);

                frame.setVisible(false);

            }
        });
    }



}
