package GUI;

import Controller.Controller;
import Model.Passeggero;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;

/**
 * GUI che permette la registrazione di un nuovo utente
 */
public class RegUtente {

    private JPanel panel1;
    private JTextField tfEmail;
    private JTextField tfNome;
    private JTextField tfCognome;
    private JTextField tfPassword;
    private JTextField tfCF;
    private JButton confermaButton;
    private JButton indietroButton;
    private JComboBox<Integer> comboBoxGiorno;
    private JComboBox<Integer> comboBoxMese;
    private JComboBox<Integer> comboBoxAnno;

    public JFrame frame;
    private Controller controller;

    public JFrame frameChiamante;


    /**
     * Costruttore di RegUtente
     *
     * @param frameChiamante il frame chiamante
     * @param controller     il controller
     */
    public RegUtente(JFrame frameChiamante, Controller controller) {
        this.controller = controller;
        this.frameChiamante = frameChiamante;

        //ComboBox Giorno
        for (Integer i = 1; i <= 31; i++) {
            comboBoxGiorno.addItem(i);
        }

        //ComboBox Mese
        for (Integer i = 1; i <= 12; i++) {
            comboBoxMese.addItem(i);
        }

        //ComboBox Anno
        for (Integer i = 1920; i <= 2006; i++) {
            comboBoxAnno.addItem(i);
        }



        frame = new JFrame("Registrazione Utente");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 330);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        indietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameChiamante.setVisible(true);
                frame.setVisible(false);
                frame.dispose();
            }
        });


        confermaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (tfCF.getText().equals("") || tfNome.getText().equals("") || tfCognome.getText().equals("") || tfEmail.getText().equals("") || tfPassword.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Inserisci tutti i campi!");

                } else if(tfCF.getText().length()!=16){
                    JOptionPane.showMessageDialog(null, "Codice fiscale non valido!");
                }else {

                    LocalDate data = LocalDate.of((Integer) comboBoxAnno.getSelectedItem(), (Integer) comboBoxMese.getSelectedItem(), (Integer) comboBoxGiorno.getSelectedItem());
                    if( Period.between(data, LocalDate.now()).getYears() >= 18) {
                        Passeggero p = new Passeggero(tfCF.getText(), tfNome.getText(), tfCognome.getText(), data, tfEmail.getText(), tfPassword.getText());
                        if (controller.AggiungiPasseggero(p) == 1) {

                            JOptionPane.showMessageDialog(null, "Registrazione effettuata con successo");
                            controller.setPasseggero(p);
                            PasseggeroGUI framePasseggeroGUI = new PasseggeroGUI(frame, controller);
                            framePasseggeroGUI.frame.setVisible(true);
                            frame.setVisible(false);

                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Devi essere maggiorenne per poterti inscrivere");
                    }
                }
            }
        });



        //Definisce il massimo numero di caratteri di Nome
        ((AbstractDocument) tfNome.getDocument()).setDocumentFilter(new DocumentFilter() {
               @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {

                if (text == null || (fb.getDocument().getLength() + text.length()) <= 20) { // Se il testo è null, l'utente sta cancellando, quindi permetti l'operazione
                    super.replace(fb, offset, length, text, attrs);
                } else {
                    // Altrimenti, l'utente sta cercando di inserire nuovi caratteri, quindi nega l'operazione
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });


        //Definisce il massimo numero di caratteri di Cognome
        ((AbstractDocument) tfCognome.getDocument()).setDocumentFilter(new DocumentFilter() {
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



        //Definisce il massimo numero di caratteri di Email
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

        //Definisce il massimo numero di caratteri di Password
        ((AbstractDocument) tfPassword.getDocument()).setDocumentFilter(new DocumentFilter() {
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


        //Definisce il massimo numero di caratteri di CF
        ((AbstractDocument) tfCF.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {

                if (text == null || (fb.getDocument().getLength() + text.length()) <= 16) { // Se il testo è null, l'utente sta cancellando, quindi permetti l'operazione
                    super.replace(fb, offset, length, text, attrs);
                } else {
                    // Altrimenti, l'utente sta cercando di inserire nuovi caratteri, quindi nega l'operazione
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });




    }


}
