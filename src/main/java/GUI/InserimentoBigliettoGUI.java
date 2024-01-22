package GUI;

import Controller.Controller;
import Model.*;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class InserimentoBigliettoGUI {
    private JPanel panel;
    private JButton btoAcquista;
    private JCheckBox veicoloCheckBox;
    private JTextField tFCodeceFiscale;
    private JTextField tFCodiceCorsa;
    private JSpinner spinnerNumeroBagagli;
    private JButton btoIndietro;

    private JComboBox cBCorse;

    public JFrame frameChiamante;
    JFrame frame;
    Controller controller;


    private ArrayList<String> codCorse=new ArrayList<String>();
    private boolean ControlloCodCorsa(String cod) {
        for (int i = 0; i < controller.getCorse().size(); i++) {
            if (cod.equals(controller.getCorse().get(i).CodiceCorsa)) {
                return true;
            }
        }
        return false;
    }









    InserimentoBigliettoGUI(JFrame frameChiamante, Controller controller, Passeggero p) {
        this.frameChiamante = frameChiamante;
        this.controller = controller;
        frame = new JFrame("Acquisto Biglietto");

        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        frame.setSize(1050, 280);
        frame.setResizable(false);

        //Apre la finestra la centro dello schermo
        frame.setLocationRelativeTo(null);


        frame.setVisible(true);
        //prima di tutto vado a prelevarmi tutti la lista di codici e li metto nella combobox
        codCorse=controller.GetCodiceCorse();
        //



        btoIndietro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameChiamante.setVisible(true);
                frameChiamante.setEnabled(true);
                frame.setVisible(false);
                frame.dispose();
            }
        });


        btoAcquista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int bagagli = (int) spinnerNumeroBagagli.getValue();
                boolean veicolo = veicoloCheckBox.isSelected();

                String codCorsa = tFCodiceCorsa.getText();

                if (codCorsa.equals("")) {

                    JOptionPane.showMessageDialog(null, "Inserisci il codice");

                } else if (!ControlloCodCorsa(codCorsa)) {

                    JOptionPane.showMessageDialog(null, "Codice corsa non valido");

                } else {
                    //definire il costo totale del biglietto

                    CorsaTabellone corsa = controller.GetCorsa(tFCodiceCorsa.getText());
                    float prezzo = corsa.costocorsa;

                    if(Period.between(controller.getPasseggero().getDataNascita(),LocalDate.now()).getYears() <16) {
                        prezzo = corsa.costocorsa/ 2;
                    }else {
                        if (LocalDate.now().isBefore(corsa.datapartenza) && (Integer) spinnerNumeroBagagli.getValue()>0){
                            prezzo = (float) (corsa.costocorsa * 1.3);
                        }else if(LocalDate.now().isBefore(corsa.datapartenza)){
                            prezzo = (float) (corsa.costocorsa * 1.1);
                        }else if ((Integer) spinnerNumeroBagagli.getValue()>0) {
                            prezzo = (float) (corsa.costocorsa * 1.2);
                            }
                    }

                    ConfermaAcquistoGui frameConfermaAcquisto = new ConfermaAcquistoGui(frame, controller, new Biglietto(bagagli, veicolo, p.getCf(), codCorsa), frameChiamante, prezzo);
                    frameConfermaAcquisto.frame.setVisible(true);
                    frameChiamante.setEnabled(false);
                    frame.setVisible(false);
                }

            }
        });


    }

}