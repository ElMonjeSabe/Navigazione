package Gui;

import Controller.Controller;

import Model.Compagnia;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegCompagnia {
    private JTextField tFNomeCompagnia;
    private JTextField tfEmail;
    private JTextField tFPassword;
    private JButton confermaButton;
    private JButton indietroButton;
    private JPanel panel;
    private JTextField tfTelefono;
    private JTextField tfSitoWeb;

    public JFrame frame;

    private JFrame frameChiamante;

    private Controller controller;



    public RegCompagnia(JFrame farmeChiamante, Controller controller) {

        this.frameChiamante = farmeChiamante;
        this.controller = controller;

        frame = new JFrame("Registrazione Compagnia");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(340, 240);

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
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Compagnia c= new Compagnia(tFNomeCompagnia.getText(),tFPassword.getText(),tfTelefono.getText(),tfEmail.getText(),tfSitoWeb.getText());
                if(controller.AggiungiCompagnia(c)==1){
                    JOptionPane.showMessageDialog(null, "Registrazione effettuata con successo");
                    CompagniaGUI frameCompagniaGUI = new CompagniaGUI(frame, controller);
                    frameCompagniaGUI.frame.setVisible(true);
                    frame.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "Errore durante la registrazione");

                }

            }
        });
    }
}
