package GUI;

import Controller.Controller;
import Model.*;

import javax.swing.*;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class InserimentoBigliettoGUI {
    private JPanel panel;
    private JButton btoAcquista;
    private JTextField tFCodeceFiscale;
    private JTextField tFCodiceCorsa;

    private JButton btoIndietro;
    private JComboBox cBAdulti;
    private JComboBox cBMinorenni;
    private JComboBox cBValige;
    private JComboBox cBVeicoli;
    private JLabel jlPPD;

    private JComboBox cBCorse;

    public JFrame frameChiamante;
    JFrame frame;
    Controller controller;

    Passeggero p;

    private ArrayList<String> codCorse=new ArrayList<String>();
    private boolean ControlloCodCorsa(String cod) {
        for (int i = 0; i < controller.getCorse().size(); i++) {
            if (cod.equals(controller.getCorse().get(i).CodiceCorsa)) {
                return true;
            }
        }
        return false;
    }









    InserimentoBigliettoGUI(JFrame frameChiamante, Controller controller) {
        this.frameChiamante = frameChiamante;
        this.controller = controller;

        p = controller.getPasseggero();

        frameChiamante.setEnabled(false);

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



                String codCorsa = tFCodiceCorsa.getText();

                if (codCorsa.equals("")) {

                    JOptionPane.showMessageDialog(null, "Inserisci il codice");

                } else if (!ControlloCodCorsa(codCorsa)) {

                    JOptionPane.showMessageDialog(null, "Codice corsa non valido");

                } else if((Integer)cBAdulti.getSelectedItem() == 0 && (Integer)cBMinorenni.getSelectedItem() == 0 ){

                    JOptionPane.showMessageDialog(null, "Devi selezionare almeno un passeggero");

                } else if (((Integer)cBMinorenni.getSelectedItem()+(Integer)cBAdulti.getSelectedItem()) > controller.getPostiPersoneDisp()) {

                    JOptionPane.showMessageDialog(null, "Persone inserite più di quelle disponibili");

                } else{
                    //definire il costo totale del biglietto

                    CorsaTabellone corsa = controller.GetCorsa(tFCodiceCorsa.getText());
                    float prezzo = corsa.costocorsa;
                    float prezzoTotale = 0;
                    ArrayList<Biglietto> biglietti = new ArrayList<Biglietto>();
                    Integer NumVeicoli= (Integer) cBVeicoli.getSelectedItem();






                    //Calcola se è una prenotazione
                    if(LocalDate.now().isBefore(corsa.datapartenza)) {
                        prezzoTotale += prezzo + 2;
                    }else{
                        prezzoTotale += prezzo;
                    }

                    if(NumVeicoli!=0){
                        biglietti.add(new Biglietto((Integer) cBValige.getSelectedItem(),"intero", true, p.getCf(), codCorsa));
                        NumVeicoli--;
                    }else{
                        biglietti.add(new Biglietto((Integer) cBValige.getSelectedItem(),"intero", false, p.getCf(), codCorsa));
                    }

                    for(int i = 1; i<(Integer)cBAdulti.getSelectedItem();i++){

                        //Calcola se è una prenotazione
                        if(LocalDate.now().isBefore(corsa.datapartenza)) {
                            prezzoTotale += prezzo + 2;
                        }else{
                            prezzoTotale += prezzo;
                        }

                        //Verifica se deve distribuire i veicoli per i magiorenni ancora disponibili
                        if(NumVeicoli==0) {
                            biglietti.add(new Biglietto(0,"intero", false, p.getCf(), codCorsa));
                        }else{
                            NumVeicoli--;
                            biglietti.add(new Biglietto(0, "intero",true, p.getCf(), codCorsa));
                        }

                    }

                    //Aggiunta prezzo valige
                    prezzoTotale += 5 * (Integer) cBValige.getSelectedItem();


                    for(int i = 0; i<(Integer)cBMinorenni.getSelectedItem();i++){

                        //Calcola se è una prenotazione
                        if(LocalDate.now().isBefore(corsa.datapartenza)) {
                            prezzoTotale += (prezzo/2) + 2;
                        }else{
                            prezzoTotale += prezzo/ 2;
                        }

                        biglietti.add(new Biglietto(0, "ridotto", false, p.getCf(), codCorsa));

                    }

                    //Con l'acquisto
                    int risposta = JOptionPane.showConfirmDialog(null, "Il prezzo totale è di "+prezzoTotale+"€. Vuoi procedere all'acquisto?", "Conferma Acquisto", JOptionPane.YES_NO_OPTION);
                    if (risposta == JOptionPane.YES_OPTION) {
                        if(controller.AcquistaBigliettoDAO(biglietti)==1) {
                            JOptionPane.showMessageDialog(null, "Acquisto effettuato con successo");

                            frameChiamante.setEnabled(true);

                        }else{
                            JOptionPane.showMessageDialog(null, "Problema durante l'acquisto");
                        }

                        frameChiamante.setVisible(true);
                        frameChiamante.setEnabled(true);
                        frame.setVisible(false);
                        frame.dispose();

                    }


                }

            }
        });


        cBAdulti.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                cBVeicoli.removeAllItems();
                for(int i = 0; i <= (Integer) cBAdulti.getSelectedItem(); i++){
                    cBVeicoli.addItem(i);
                }
            }
        });


 


        tFCodiceCorsa.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if(ControlloCodCorsa(tFCodiceCorsa.getText())){
                    
                    controller.getPostiDisponibili(tFCodiceCorsa.getText());
                    jlPPD.setText(controller.getPostiPersoneDisp().toString());
                    for(int i = 0; i<20;i++){
                        cBAdulti.addItem(i);
                        cBMinorenni.addItem(i);
                    }
                    for(int i = 0; i<controller.getPostiVeicoliDisp();i++){
                        cBValige.addItem(i);
                    }
                }
            }

        });
    }

}