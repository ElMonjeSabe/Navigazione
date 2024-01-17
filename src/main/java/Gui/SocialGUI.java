package Gui;

import Model.Compagnia;
import Controller.Controller;
import Model.Social;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SocialGUI {
    private JTextField textNomeC;
    private JTextField textURL;
    private JButton indietroButton;
    private JButton confermaButton;
    private JTextField textNomeS;
    private JPanel panel;
    private JFrame frame;
    public JFrame frameChiamante;
    public SocialGUI(JFrame frameChiamante, Controller controller,Compagnia comp) {

        this.frameChiamante = frameChiamante;


        frame = new JFrame("Aggiungi Social");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        confermaButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = textURL.getText();
                String nomes = textNomeS.getText();

                if (url.equals("") || nomes.equals("") ) {
                    JOptionPane.showMessageDialog(null, "inserisci l'url del social e/o aggiungi " +
                            "\nil nome valdi per aggiungere il social!");
                }
                else{
                    Social social = new Social( url, nomes,comp);
                    if(controller.AggiungiSocial(social)){
                        JOptionPane.showMessageDialog(null, "Social aggiunto correttamente");
                        frameChiamante.setVisible(true);
                        frame.setVisible(false);
                        frame.dispose();
                    }

                }
            }
        });


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
    }

    public JFrame getFrame() {
        return frame;
    }

}
