package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Passeggero {
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/d");
    private JPanel panelDati;
    private JTextField textCognome;
    private JTextField textNome;
    private JTextField textCF;
    private JFormattedTextField textDataNascita = new JFormattedTextField(formatter);
    private JButton aggiungiPasseggeroButton;
    private JLabel labelTitolo;
    private JButton acquistaBigliettoButton;
    private JButton visualizzaCorseButton;
    private JButton visualizzaBigliettiAcquistatiButton;
    private JButton ritornaAllaHomeButton;
    private JPanel panel;
    private JButton loginButton;
    private JPasswordField passwordField;
    private JTextField textEmail;
    private JPanel panelTabella;
    private JPanel panelTitolo;
    private JPanel PanelCampi;
    private JPanel panelAzioni;
    private JPanel panelTitolo2;
    private JPanel PanelBottoni;

    private JFrame frameChiamante;

    public JFrame frame;


    public Passeggero(JFrame frameChiamante) {

        this.frameChiamante = frameChiamante;

        frame = new JFrame("Seconda Finestrs");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        ritornaAllaHomeButton.addActionListener(new ActionListener() {
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
        aggiungiPasseggeroButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textNome.getText();
                String cf = textCF.getText();
                LocalDate datanascita = LocalDate.parse(textDataNascita.getText(), formatter);
                String email = textEmail.getText();
                String password = passwordField.getText();
                if (nome.equals("") || datanascita.equals("") || cf.equals("") || datanascita.equals("")) {
                    JOptionPane.showMessageDialog(null, "Inserisci tutti i campi testa di cazzo");
                    return;
                } else {
                    if (!email.equals(EMAIL_PATTERN) && password.equals(""))
                        JOptionPane.showMessageDialog(null, "inserisci beneee!");
                    else {
                        JOptionPane.showMessageDialog(null, "ok!");
                    }
                }

            }
        });
    }

}
