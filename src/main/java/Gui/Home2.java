package Gui;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home2 {
    private JButton btCompagnia;
    private JButton btUtente;
    private JButton btAccedi;

    private static JFrame frame;
    private JPanel panel;
    private JButton visualizzaCorseButton;


    Controller controller = new Controller();

    public Home2() {


        btUtente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegUtente frameRegPass = new RegUtente(frame, controller);
                frameRegPass.frame.setVisible(true);
                frame.setVisible(false);
            }
        });
        btCompagnia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegCompagnia frameRegComp = new RegCompagnia(frame, controller);
                frameRegComp.frame.setVisible(true);
                frame.setVisible(false);
            }
        });
        btAccedi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Accesso frameAcc = new Accesso(frame, controller);
                frameAcc.frame.setVisible(true);
                frame.setVisible(false);

            }
        });
        visualizzaCorseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.LeggiCorseDAO();
                ListaCorse frameListaCorse = new ListaCorse(frame, controller,null);
                frameListaCorse.frame.setVisible(true);
                frame.setVisible(false);
            }
        });
    }

    public static void main(String[] args) {

        frame = new JFrame("Schermata Principale");
        frame.setContentPane(new Home2().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 350);
        frame.setMinimumSize(new Dimension(340, 240));

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }




}
