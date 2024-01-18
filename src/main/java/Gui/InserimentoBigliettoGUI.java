package Gui;

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
    private JComboBox cBCabine;
    private JComboBox cBCorse;

    public JFrame frameChiamante;
    JFrame frame;
    Controller controller;


    private ArrayList<Cabina> cabine= new ArrayList<Cabina>();
    private ArrayList<String> codCorse=new ArrayList<String>();
    private boolean ControlloCodCorsa(String cod) {
        for (int i = 0; i < controller.getCorse().size(); i++) {
            if (cod.equals(controller.getCorse().get(i).CodiceCorsa)) {
                return true;
            }
        }
        return false;
    }

    /*
    LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI
    LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI
    LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI
    LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI
    LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI


    Con una textfield per inserire il codice corsa era molto difficile gestirlo, soprattutto quando dovevi recuperare
    le cabine disponibili, quindi non ho eliminato niente, ho solo aggiunto una mia soluzione con la scelta delle cabine
    tramite una checkbox. Vedi se ti piace così.

    Per prendere le cabine purtroppo non sono riuscito a fare una procedura
    in postegresql perche' mi dava un errore strano, quindi l'ho fatto direttamente nella query nell'implementazione
    getCabine. Lascio comunque la procedura che ho scritto in CoseDaAggiungere


    LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI
    LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI
    LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI
    LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI
    LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI LEGGI

    */







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
        for(String s: codCorse){
            cBCorse.addItem(s);
        }
        //essendo che sara' selezionata la prima corsa, prendo tutte le cabine disponibili della prima corsa e li metto
        //nella combobox
        cabine=controller.GetCabine(codCorse.getFirst().toString());
        for(Cabina cab: cabine){
            cBCabine.addItem(cab.getNumero());
        }



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

                if (codCorsa.equals("") || cBCabine.getSelectedItem() == null) {

                    JOptionPane.showMessageDialog(null, "Inserisci il codice della corsa e la cabina");

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

                    ConfermaAcquistoGui frameConfermaAcquisto = new ConfermaAcquistoGui(frame, controller, new Biglietto(bagagli, veicolo, p.getCf(), codCorsa, Integer.parseInt(cBCabine.getSelectedItem().toString())), frameChiamante, prezzo);
                    frameConfermaAcquisto.frame.setVisible(true);
                    frameChiamante.setEnabled(false);
                    frame.setVisible(false);
                }

            }
        });


        tFCodiceCorsa.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                ArrayList<Cabina> cabineDisponibili = controller.GetCabineDisponibili(tFCodiceCorsa.getText());
                if (cabineDisponibili == null) {
                    JOptionPane.showMessageDialog(null, "Biglietti esauriti");

                } else {
                    cBCabine.removeAllItems();
                    while (!cabineDisponibili.isEmpty()) {
                        cBCabine.addItem(Integer.toString(cabineDisponibili.getFirst().getNumero()));
                        cabineDisponibili.removeFirst();
                    }
                }
            }
        });


        cBCorse.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                //ogni volta che cambio e seleziono un'altra corsa, rifaccio il calcolo delle cabine disponibili
                //per quella corsa
                cabine=controller.GetCabine(cBCorse.getSelectedItem().toString());
                cBCabine.removeAllItems();
                for(Cabina cab: cabine){
                    cBCabine.addItem(cab.getNumero());
                }

            }
        });
    }

}