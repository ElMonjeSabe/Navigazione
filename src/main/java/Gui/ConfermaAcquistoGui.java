package Gui;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;
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

    public ConfermaAcquistoGui(JFrame frameChiamante, Controller controller){
        this.frameChiamante = frameChiamante;
        this.controller = controller;
        frame = new JFrame("Lista Corse");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);


        //setta il prezzo
        prezzo.setText(String.valueOf(2344)+"E");
        frame.setVisible(true);


        btoAnnulla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameChiamante.setVisible(true);
                frame.setVisible(false);
                frame.dispose();
            }
        });
    }
}
