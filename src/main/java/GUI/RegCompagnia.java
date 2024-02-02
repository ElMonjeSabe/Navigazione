package GUI;

import Controller.Controller;

import Model.Compagnia;
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

/**
 * GUI che permette la registrazione di una nuova compagnia.
 */
public class RegCompagnia {

    private JTextField tFNomeCompagnia;
    private JTextField tfEmail;
    private JTextField tFPassword;
    private JButton confermaButton;
    private JButton indietroButton;
    private JPanel panel;
    private JTextField tfTelefono;
    private JTextField tfSitoWeb;
    private JTextField textNomei;
    private JComboBox CBTipo;
    private JTextField textCodice;
    private JTextField textCapienzaP;
    private JTextField textCapienzaV;
    private JLabel LCV;

    public JFrame frame;
    private JFrame frameChiamante;
    private Controller controller;


    /**
     * Costruttore di RegCompagnia.
     *
     * @param farmeChiamante il farme chiamante
     * @param controller     il controller
     */
    public RegCompagnia(JFrame farmeChiamante, Controller controller) {

        this.frameChiamante = farmeChiamante;
        this.controller = controller;

        frame = new JFrame("Registrazione Compagnia");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CBTipo.addItem("traghetto");
        CBTipo.addItem("motonave");
        CBTipo.addItem("aliscafo");

        frame.pack();
        frame.setResizable(true);

        frame.setLocationRelativeTo(null);
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

                if (tFNomeCompagnia.getText().equals("") || tfEmail.getText().equals("") || tfTelefono.getText().equals("") || tfSitoWeb.getText().equals("") || tFPassword.getText().equals("") ||
                        codice.equals("") || nomei.equals("") || capienzap<=0 ||capienzav<0) {
                    JOptionPane.showMessageDialog(null, "Inserisci tutti i campi!");

                }
                else{

                        Compagnia comp = new Compagnia(tFNomeCompagnia.getText(), tFPassword.getText(), tfTelefono.getText(), tfEmail.getText(), tfSitoWeb.getText());
                        Imbarcazione imb= new Imbarcazione(codice,nomei,(String) CBTipo.getSelectedItem(),capienzap,capienzav,tFNomeCompagnia.getText());
                        if (controller.RegistrazioneCompagnia(comp,imb)) {

                            JOptionPane.showMessageDialog(null, "Registrazione effettuata con successo");
                            controller.setCompagnia(comp);
                            CompagniaGUI frameCompagniaGUI = new CompagniaGUI(frame, controller);
                            frameCompagniaGUI.frame.setVisible(true);
                            frame.setVisible(false);

                    }


                }

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
                    LCV.setVisible(false);
                    textCapienzaV.setText("0");
                }
                else
                {
                    textCapienzaV.setEditable(true);
                    textCapienzaV.setVisible(true);
                    LCV.setVisible(true);
                }
            }
        });






        //CONTROLLI NUMERO MASSIMO DI CARATTERI NEGLI ATTRIBUTI DI COMPAGNIA

        //Definisce il massimo numero di caratteri di NomeCompagnia
        ((AbstractDocument) tFNomeCompagnia.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {

                if (text == null || (fb.getDocument().getLength() + text.length()) <= 50) { // Se il testo è null, l'utente sta cancellando, quindi permetti l'operazione
                    super.replace(fb, offset, length, text, attrs);
                } else {
                    // Altrimenti, l'utente sta cercando di inserire nuovi caratteri, quindi nega l'operazione
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });



        ((AbstractDocument) tFPassword.getDocument()).setDocumentFilter(new DocumentFilter() {
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


        ((AbstractDocument) tfTelefono.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {

                if (text == null || (fb.getDocument().getLength() + text.length()) <= 11) { // Se il testo è null, l'utente sta cancellando, quindi permetti l'operazione
                    super.replace(fb, offset, length, text, attrs);
                } else {
                    // Altrimenti, l'utente sta cercando di inserire nuovi caratteri, quindi nega l'operazione
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });



        ((AbstractDocument) tfEmail.getDocument()).setDocumentFilter(new DocumentFilter() {
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


        ((AbstractDocument) tfSitoWeb.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {

                if (text == null || (fb.getDocument().getLength() + text.length()) <= 50) { // Se il testo è null, l'utente sta cancellando, quindi permetti l'operazione
                    super.replace(fb, offset, length, text, attrs);
                } else {
                    // Altrimenti, l'utente sta cercando di inserire nuovi caratteri, quindi nega l'operazione
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });



        //CONTROLLI INSERIMENTO IMBARCAZIONE

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



        //Permette di inserire solo numeri nel riquadro per i numeri di telefono
        tfTelefono.addKeyListener(new KeyAdapter() {
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
}
