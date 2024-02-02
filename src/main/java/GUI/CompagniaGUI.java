package GUI;

import Controller.Controller;
import Model.Compagnia;
import Model.Imbarcazione;
import Model.Porto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/**
 * La GUI che rappresenta la schermata principale della compagnia con tutte le sue operazioni utili per operare i suoi dati
 */
public class CompagniaGUI {

    /**
     * The Frame.
     */
    public JFrame frame;

    /**
     * The Frame chiamante.
     */
    public JFrame frameChiamante;
    private JPanel panel;
    private JButton aggiungiCorsaButton;
    private JButton modificaCorsaButton;
    private JButton aggiungiImbarcazioneButton;
    private JButton visualizzaCorseButton;
    private JButton btoSocial;
    private JLabel NomeComp;
    private JLabel EmailComp;
    private JLabel TelefonoComp;
    private JLabel SitoWebComp;
    private JButton bigliettiPasseggeriButton;
    private Controller controller;
    private ArrayList<Imbarcazione> imbarcazioni= new ArrayList<Imbarcazione>();
    private Compagnia c;


    /**
     * Costruttore per CompagniaGUI
     *
     * @param frameChiamante il frame chiamante
     * @param controller     il controller
     */
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
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */

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
                controller.LeggiCorseCompagniaDAO(c.getNomeCompagnia());
                ListaCorseCompagnia frameListaCorseCompagnia = new ListaCorseCompagnia(frame, controller,c);
                frame.setVisible(false);

            }
        });


        bigliettiPasseggeriButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.leggiBigliettiAcquistatiCompagnia(c.getNomeCompagnia());
                BigliettiPasseggeriGUI frameListaBA = new BigliettiPasseggeriGUI(frame, controller, c);
                frameListaBA.frame.setVisible(true);
                frame.setVisible(false);
            }
        });
    }

}
