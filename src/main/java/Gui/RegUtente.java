package Gui;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegUtente {
    private JPanel panel1;
    private JTextField tfEmail;
    private JTextField tfNome;
    private JTextField tfCognome;
    private JTextField tfPassword;
    private JTextField tfCF;
    private JComboBox cBGiorno;
    private JComboBox cBMese;
    private JComboBox cBAnno;
    private JButton confermaButton;
    private JButton indietroButton;

    public JFrame frame;

    private Controller controller;

    public JFrame frameChiamante;

    public RegUtente(JFrame frameChiamante, Controller controller){
        this.controller = controller;
        this.frameChiamante = frameChiamante;


        frame = new JFrame("Registrazione Utente");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 350);
        frame.setMinimumSize(new Dimension(340, 240));
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
    }



}
