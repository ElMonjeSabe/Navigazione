package Gui;

import Controller.Controller;

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

    public JFrame frame;

    private JFrame frameChiamante;

    private Controller controller;


    public RegCompagnia(JFrame farmeChiamante, Controller controller) {

        this.frameChiamante = farmeChiamante;
        this.controller = controller;

        frame = new JFrame("Registrazione Compagnia");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 350);
        frame.setMinimumSize(new Dimension(340, 240));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);




        indietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

}
}
