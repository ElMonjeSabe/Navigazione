package Gui;

import Controller.Controller;
import Model.Biglietto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class InserimentoBigliettoGUI {
    private JPanel panel;
    private JButton btoAcquista;
    private JCheckBox veicoloCheckBox;
    private JTextField tFCodeceFiscale;
    private JTextField tFCodiceCorsa;
    private JSpinner spinnerNumeroBagagli;
    private JButton btoIndietro;
    public JFrame frameChiamante;
    JFrame frame;
    Controller controller;


    private boolean ControlloCodCorsa(String cod) {
        for (int i = 0; i < controller.getCorse().size(); i++) {
            if (cod.equals(controller.getCorse().get(i).CodiceCorsa)) {
                return true;
            }
        }
        return false;
    }









    InserimentoBigliettoGUI(JFrame frameChimante, Controller controller){
        this.frameChiamante = frameChimante;
        this.controller = controller;
        frame = new JFrame("Lista Corse");

        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        frame.setSize(900, 150);
        //frame.setResizable(false);

        //Apre la finestra la centro dello schermo
        frame.setLocationRelativeTo(null);




        frame.setVisible(true);


        btoIndietro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameChiamante.setVisible(true);
                frameChimante.setEnabled(true);
                frame.setVisible(false);
                frame.dispose();
            }
        });


        btoAcquista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int bagagli = (int) spinnerNumeroBagagli.getValue();
                boolean veicolo = veicoloCheckBox.isSelected();
                String cfposs = tFCodeceFiscale.getText();
                String codCorsa = tFCodiceCorsa.getText();

                if(cfposs.equals("") || codCorsa.equals("")){

                    JOptionPane.showMessageDialog(null,"Inserire codice fiscale e il codice della corsa");

                }else if(!ControlloCodCorsa(codCorsa)){

                    JOptionPane.showMessageDialog(null,"Codice corsa non valido");

                }else{

                    ConfermaAcquistoGui frameConfermaAcquisto = new ConfermaAcquistoGui(frame, controller,new Biglietto(bagagli,veicolo,cfposs,codCorsa));
                    frameConfermaAcquisto.frame.setVisible(true);
                    frameChimante.setEnabled(false);
                    frame.setVisible(false);
                }

            }
        });
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }





}