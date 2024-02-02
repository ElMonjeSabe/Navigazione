package GUI;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La Schermata Principale Del Programma. Puoi registrari, accedere e visualizzare le corse entro 24 ore
 */
public class Home {
    private JButton btCompagnia;
    private JButton btUtente;
    private JButton btAccedi;
    private static JFrame frame;
    private JPanel panel;
    private JButton visualizzaCorseButton;


    /**
     * Il Controller
     */
    Controller controller = new Controller();

    /**
     * Gets frame.
     *
     * @return the frame
     */
    public static JFrame getFrame() {

        return frame;
    }


    /**
     * Costruttore per la GUI Home
     */
    public Home() {

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


    /**
     * Il punto d'inizio del programma
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        frame = new JFrame("Schermata Principale");
        frame.setContentPane(new Home().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 350);
        frame.setMinimumSize(new Dimension(340, 240));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
