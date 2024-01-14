package Gui;

import Controller.Controller;
import Model.Compagnia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModificaCorsa {
    private JTextField textNomeC;
    private JTextField textAvviso;
    private JButton indietroButton;
    private JButton confermaButton;
    private JComboBox comboBox1;
    private JTextField textCodice;
    private JPanel panel;
    private JButton btoCancella;
    private JFrame frame;





    private Controller controller;
    public JFrame frameChiamante;
    public ModificaCorsa(JFrame frameChiamante, Controller controller, Compagnia c) {

        comboBox1.addItem("regolare");
        comboBox1.addItem("annullato");
        comboBox1.addItem("ritardo");

        this.controller = controller;
        this.frameChiamante = frameChiamante;

        frame = new JFrame("Modifica stato corsa");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


        indietroButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                frameChiamante.setVisible(true);
                frame.setVisible(false);
                frame.dispose();
            }
        });
        btoCancella.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String codice = textCodice.getText();

                if (codice.equals("")) {
                    JOptionPane.showMessageDialog(null, "identificati col tuo nome e inserisci il \ncodice della corsa per eliminarlo!");
                }
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
                String codice = textCodice.getText();
                if (codice.equals("")) {
                    JOptionPane.showMessageDialog(null, "identificati col tuo nome e inserisci il \ncodice della corsa per confermare la modifica!");
                }else{
                    controller.ModificaCorsa(codice,textAvviso.getText(),comboBox1.getSelectedItem().toString(), c.getNomeCompagnia());
                    frameChiamante.setVisible(true);
                    frame.setVisible(false);
                    frame.dispose();
                }

            }
        });
    }

    public JFrame getFrame() {

        return frame;
    }
}
