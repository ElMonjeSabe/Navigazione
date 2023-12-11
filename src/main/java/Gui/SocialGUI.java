package Gui;

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
    public SocialGUI(JFrame frameChiamante) {

        this.frameChiamante = frameChiamante;

        frame = new JFrame("Social");
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
                String nomec = textNomeC.getText();
                String nomes = textNomeS.getText();

                if (url.equals("") || nomec.equals("") ||nomec.equals("") ) {
                    JOptionPane.showMessageDialog(null, "identificati col tuo nome, inserisci \nl'url del social e/o aggiungi il nome per aggiungere il social!");
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
