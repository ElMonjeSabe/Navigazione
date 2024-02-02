package GUI;

import Controller.Controller;
import Model.Compagnia;
import Model.Passeggero;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Accesso {
    private JTextField tFEmail;
    private JTextField tFPassword;
    private JPanel panel;
    private JButton confermaButton;
    private JButton indietroButton;
    private JRadioButton rdPasseggero;
    private JRadioButton rdCompagnia;

    public JFrame frame;
    private JFrame frameChiamante;
    private Controller controller;


    public Accesso(JFrame frameChiamante, Controller controller){
        this.frameChiamante = frameChiamante;
        this.controller = controller;


        frame = new JFrame("Accesso");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 270);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        ButtonGroup group = new ButtonGroup();
        group.add(rdCompagnia);
        group.add(rdPasseggero);


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
                if(rdCompagnia.isSelected()){
                    //Compagnia
                    //Se email e password esistono allora vai alla schermata Compagnia

                    Compagnia c = controller.loginCompagnia(tFEmail.getText(),tFPassword.getText());
                    if(c != null){
                        JOptionPane.showMessageDialog(null, "login effettuato con successo.");
                        controller.setCompagnia(c);
                        frameChiamante.dispose();
                        CompagniaGUI frameCompagniaGUI = new CompagniaGUI(frame, controller);
                        frameCompagniaGUI.frame.setVisible(true);
                        frame.setVisible(false);
                    }else{
                        JOptionPane.showMessageDialog(null, "utente non esistente");

                    }



                }else if (rdPasseggero.isSelected()){
                    //Utente
                    //Se email e password esistono allora vai alla schermata Passeggero
                    Passeggero p = controller.loginPasseggero(tFEmail.getText(),tFPassword.getText());
                    if(p != null){
                        JOptionPane.showMessageDialog(null, "login effettuato con successo.");
                        controller.setPasseggero(p);
                        frameChiamante.dispose();
                        PasseggeroGUI framePasseggeroGUI = new PasseggeroGUI(frame, controller);
                        framePasseggeroGUI.frame.setVisible(true);
                        frame.setVisible(false);
                    }else{
                        JOptionPane.showMessageDialog(null, "utente non esistente");

                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Inserisci il tipo di utente");
                }

            }
        });




        //Definisce il massimo numero di caratteri di Email
        ((AbstractDocument) tFEmail.getDocument()).setDocumentFilter(new DocumentFilter() {
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




    }
}
