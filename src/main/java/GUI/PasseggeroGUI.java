package GUI;

import Controller.Controller;
import Model.Passeggero;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;

/**
 * GUI che permette di svolgere le operaioni di passeggero,
 * come comprare un biglietto, visualizzare le corse o i biglietti precedentemente acquistati
 */
public class PasseggeroGUI {
    private JButton visualizzaCorseButton;
    private JButton visualizzaBigliettiAcquistatiButton;
    private JPanel panel;
    private JLabel NomePass;
    private JLabel CongPass;
    private JLabel CFPass;
    private JLabel DaNaPass;
    private JLabel EmailPass;
    private JFrame frameChiamante;

    public JFrame frame;
    Controller controller;
    private Passeggero p;


    /**
     * Costruttore di PasseggeroGUI
     *
     * @param frameChiamante il frame chiamante
     * @param controller     il controller
     */
    public PasseggeroGUI(JFrame frameChiamante, Controller controller) {

        this.frameChiamante = frameChiamante;
        this.controller = controller;

        p = controller.getPasseggero();

        NomePass.setText(p.getNome());
        CongPass.setText(p.getCognome());
        EmailPass.setText(p.getEmail());
        CFPass.setText(p.getCf());
        DaNaPass.setText(String.valueOf(p.getDataNascita()));

        frame = new JFrame("Passeggero");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(600, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        visualizzaCorseButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.LeggiCorseDAO();
                ListaCorse frameListaCorse = new ListaCorse(frame, controller,p);
                frameListaCorse.frame.setVisible(true);
                frame.setVisible(false);
            }
        });


        visualizzaBigliettiAcquistatiButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.leggiBigliettiAcquistatiUtente();
                BigliettiAcquistatiGUI frameListaBA = new BigliettiAcquistatiGUI(frame, controller);
                frameListaBA.frame.setVisible(true);
                frame.setVisible(false);
            }
        });
    }
}
