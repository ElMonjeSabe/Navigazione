package Gui;

import Controller.Controller;

import Model.Compagnia;
import Model.Imbarcazione;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public JFrame frame;

    private JFrame frameChiamante;

    private Controller controller;



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
        //frame.setSize(400, 250);
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

                    Compagnia c = new Compagnia(tFNomeCompagnia.getText(), tFPassword.getText(), tfTelefono.getText(), tfEmail.getText(), tfSitoWeb.getText());

                    if (controller.AggiungiCompagnia(c) == 1) {
                        Imbarcazione imb= new Imbarcazione(codice,nomei,(String) CBTipo.getSelectedItem(),capienzap,capienzav,tFNomeCompagnia.getText());
                        controller.AggiungiImbarcazione(imb);
                        JOptionPane.showMessageDialog(null, "Registrazione effettuata con successo");
                        CompagniaGUI frameCompagniaGUI = new CompagniaGUI(frame, controller, c);
                        frameCompagniaGUI.frame.setVisible(true);
                        frame.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Errore durante la registrazione");

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
                    textCapienzaV.setText("0");
                }
                else
                {
                    textCapienzaV.setEditable(true);
                    textCapienzaV.setVisible(true);
                }
            }
        });
    }
}
