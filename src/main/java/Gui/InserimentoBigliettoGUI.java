package Gui;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InserimentoBigliettoGUI {
    private JPanel panel;
    private JButton btoAcquista;
    private JCheckBox veicoloCheckBox;
    private JTextField tFCodeceFiscale;
    private JTextField tFCodiceCorsa;
    private JSpinner spinnerNumeroBagagli;
    private JButton btoIndietro;
    private JFrame frameChiamante;
    JFrame frame;
    Controller controller;

    InserimentoBigliettoGUI(JFrame frameChimante, Controller controller){
        this.frameChiamante = frameChimante;
        this.controller = controller;
        frame = new JFrame("Lista Corse");

        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        frame.setSize(900, 150);
        //frame.setResizable(false);

        //Apre la finestra la centro dello schermo
        frame.setLocationRelativeTo(null);




        frame.setVisible(true);

        btoIndietro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameChiamante.setVisible(true);
                frameChimante.setEnabled(true);
                frame.setVisible(false);
                frame.dispose();
            }
        });
        btoAcquista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConfermaAcquistoGui frameConfermaAcquisto = new ConfermaAcquistoGui(frame, controller);
                frameConfermaAcquisto.frame.setVisible(true);
                frameChimante.setEnabled(false);
                frame.setVisible(false);
            }
        });
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
