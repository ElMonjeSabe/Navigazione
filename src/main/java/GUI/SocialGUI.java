package GUI;

import Model.Compagnia;
import Controller.Controller;
import Model.Social;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SocialGUI {

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
        //Apre la finestra la centro dello schermo
        frame.setLocationRelativeTo(null);
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




        ((AbstractDocument) textURL.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {

                if (text == null || (fb.getDocument().getLength() + text.length()) <= 100) { // Se il testo è null, l'utente sta cancellando, quindi permetti l'operazione
                    super.replace(fb, offset, length, text, attrs);
                } else {
                    // Altrimenti, l'utente sta cercando di inserire nuovi caratteri, quindi nega l'operazione
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });

        ((AbstractDocument) textNomeS.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {

                if (text == null || (fb.getDocument().getLength() + text.length()) <= 30) { // Se il testo è null, l'utente sta cancellando, quindi permetti l'operazione
                    super.replace(fb, offset, length, text, attrs);
                } else {
                    // Altrimenti, l'utente sta cercando di inserire nuovi caratteri, quindi nega l'operazione
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });





    }


    public JFrame getFrame() {
        return frame;
    }

}
