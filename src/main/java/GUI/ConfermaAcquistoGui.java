package GUI;

import Controller.Controller;
import Model.Biglietto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfermaAcquistoGui {
    private JButton btoConferma;
    private JButton btoAnnulla;
    private JLabel prezzo;
    private JPanel panel;
    JFrame frame;
    JFrame frameChiamante;
    Controller controller;
    Biglietto biglietto;

    JFrame corse;

    public ConfermaAcquistoGui(JFrame frameChiamante, Controller controller, Biglietto biglietto, JFrame frameCorse, float prezzoDef){
        this.frameChiamante = frameChiamante;
        this.controller = controller;
        this.biglietto= biglietto;
        this.corse = frameCorse;
        frame = new JFrame("Conferma Acquisto");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);






        prezzo.setText(String.valueOf(prezzoDef)+"€");
        frame.setVisible(true);


        btoAnnulla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameChiamante.setVisible(true);
                frame.setVisible(false);
                frame.dispose();
            }
        });
        btoConferma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(controller.AcquistaBigliettoDAO(biglietto)==1) {
                    JOptionPane.showMessageDialog(null, "Acquisto effettuato con successo");
                    frameChiamante.setVisible(false);
                    corse.setEnabled(true);
                    frame.setVisible(false);
                    frame.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Problema durante l'acquisto");
                }
            }
        });
    }
}
