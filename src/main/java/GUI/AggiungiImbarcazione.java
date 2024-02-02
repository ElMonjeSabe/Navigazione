package GUI;

import Controller.Controller;
import Model.Imbarcazione;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AggiungiImbarcazione {
    private JTextField textNomei;
    private JButton indietroButton;
    private JButton confermaButton;
    private JComboBox CBTipo;
    private JTextField textCodice;
    private JPanel panel;
    private JTextField textCapienzaP;
    private JTextField textCapienzaV;
    private JLabel CVL;
    private JFrame frame;

    public JFrame frameChiamante;
    private Controller controller;



    public AggiungiImbarcazione(JFrame frameChiamante, Controller controller, String nomeComp) {
        //aggiorna la lista di Compangie nel controller

        this.controller = controller;
        this.frameChiamante = frameChiamante;

        CBTipo.addItem("traghetto");
        CBTipo.addItem("motonave");
        CBTipo.addItem("aliscafo");



        frame = new JFrame("Aggiungi Imbarcazione");
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
                String codice = textCodice.getText();
                String nomei = textNomei.getText();
                int capienzap = Integer.parseInt(textCapienzaP.getText());
                int capienzav = Integer.parseInt(textCapienzaV.getText());

                if (codice.equals("") || nomei.equals("") || capienzap<=0 ||capienzav<0) {

                    JOptionPane.showMessageDialog(null, "Identificati col tuo nome, inserisci il \n codice dell'imbarcazione o aggiungi la capienza per aggiungere l'imbarcazione!");

                }else{

                    //messaggio di conferma

                    Imbarcazione im = new Imbarcazione(codice, nomei, CBTipo.getSelectedItem().toString(),capienzap,capienzav,nomeComp);
                    if(controller.AggiungiImbarcazione(im))
                    {
                        JOptionPane.showMessageDialog(null, "Imbarcazione aggiunta correttamente");
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



        CBTipo.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if(CBTipo.getSelectedItem()!="traghetto")
                {
                    textCapienzaV.setEditable(false);
                    textCapienzaV.setVisible(false);
                    CVL.setVisible(false);
                    textCapienzaV.setText("0");
                }
                else
                {
                    textCapienzaV.setEditable(true);
                    textCapienzaV.setVisible(true);
                    CVL.setVisible(true);
                }
            }
        });


        ((AbstractDocument) textCodice.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {

                if (text == null || (fb.getDocument().getLength() + text.length()) <= 5) { // Se il testo è null, l'utente sta cancellando, quindi permetti l'operazione
                    super.replace(fb, offset, length, text, attrs);
                } else {
                    // Altrimenti, l'utente sta cercando di inserire nuovi caratteri, quindi nega l'operazione
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });

        ((AbstractDocument) textNomei.getDocument()).setDocumentFilter(new DocumentFilter() {
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

        ((AbstractDocument) textCapienzaP.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {

                if (text == null || (fb.getDocument().getLength() + text.length()) <= 5) { // Se il testo è null, l'utente sta cancellando, quindi permetti l'operazione
                    super.replace(fb, offset, length, text, attrs);
                } else {
                    // Altrimenti, l'utente sta cercando di inserire nuovi caratteri, quindi nega l'operazione
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });

        ((AbstractDocument) textCapienzaV.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {

                if (text == null || (fb.getDocument().getLength() + text.length()) <= 4) { // Se il testo è null, l'utente sta cancellando, quindi permetti l'operazione
                    super.replace(fb, offset, length, text, attrs);
                } else {
                    // Altrimenti, l'utente sta cercando di inserire nuovi caratteri, quindi nega l'operazione
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });







        //Permette di inserire solo numeri come capienza persone di un'imbarcazione
        textCapienzaP.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();  // Ignora l'evento del tasto
                }

            }
        });


        //Permette di inserire solo numeri come capienza veicoli di un'imbarcazione
        textCapienzaV.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();  // Ignora l'evento del tasto
                }

            }
        });

    }




   public JFrame getFrame() {
        return frame;
    }


}
