package Gui;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home {
    private JPanel panel1;
    private JButton btoCompagnia;
    private JButton btoTabellone;
    private JButton btoPasseggero;

    private static JFrame frame;
    private JPanel panel;


    Controller controller = new Controller();

    public Home() {
        btoCompagnia.addActionListener(new ActionListener() {
            /**
             * Invocato durante la pressione del bottone Compagnia.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Compagnia frameCompagnia = new Compagnia(frame);
                frameCompagnia.frame.setVisible(true);
                frame.setVisible(false);

            }
        });
        btoPasseggero.addActionListener(new ActionListener() {
            /**
             * Invocato durante la pressione del bottone Passeggero.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Passeggero framePasseggero = new Passeggero(frame);
                framePasseggero.frame.setVisible(true);

                frame.setVisible(false);

            }
        });
        btoTabellone.addActionListener(new ActionListener() {
            /**
             * Invocato durante la pressione del bottone ListaCorse.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.LeggiCorseDAO();
                ListaCorse frameListaCorse = new ListaCorse(frame, controller);
                frameListaCorse.frame.setVisible(true);
                frame.setVisible(false);

            }
        });

    }

    public static void main(String[] args) {

        frame = new JFrame("Home");
        frame.setContentPane(new Home().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 350);
        frame.setMinimumSize(new Dimension(340, 240));

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}
