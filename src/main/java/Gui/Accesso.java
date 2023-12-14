package Gui;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Accesso {
    private JTextField tFEmail;
    private JTextField tFPassword;
    private JCheckBox cBCompagnia;
    private JPanel panel;
    private JButton confermaButton;
    private JButton indietroButton;

    public JFrame frame;
    private JFrame frameChiamante;
    private Controller controller;

    public Accesso(JFrame frameChiamnte, Controller controller){
        this.frameChiamante = frameChiamnte;
        this.controller = controller;


        frame = new JFrame("Accesso");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 270);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
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
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cBCompagnia.isSelected()){
                    //Compagnia
                    //Se email è password esistono allora vai alla schermata Compagnia
                }else{
                    //Utente
                    //Se email è password esistono allora vai alla schermata Passeggero
                }
                System.out.println(cBCompagnia.isSelected());
            }
        });
    }
}
