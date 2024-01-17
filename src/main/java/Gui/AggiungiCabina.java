package Gui;

import Controller.Controller;
import Model.Compagnia;
import Model.Imbarcazione;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AggiungiCabina {
    private JTextField textAvviso;
    private JButton indietroButton;
    private JButton confermaButton;
    private JComboBox CBImbarcazione;
    private JLabel lbCabine;
    private Controller controller;
    private JFrame frameChiamante;

    private JFrame frame;
    private JPanel panel;
    private ArrayList<Imbarcazione> imbarcazioni;
    public AggiungiCabina(JFrame frameChiamante, Controller controller, Compagnia c) {


        imbarcazioni = controller.GetImbarcazioni(c.getNomeCompagnia());
        for (Imbarcazione imb: imbarcazioni){
            CBImbarcazione.addItem(imb.getNome()+", "+imb.getCodice());
        }

        lbCabine.setText("Cabine Disponibili: ");
        //implementare funzione che mi restituisce il numero di cabine di una imbarcazione

        this.controller = controller;
        this.frameChiamante = frameChiamante;

        frame = new JFrame("Aggiungi Cabina");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        indietroButton.addActionListener(new ActionListener() {
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
        confermaButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }


    public JFrame getFrame() {

        return frame;
    }
}
