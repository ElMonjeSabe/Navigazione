package GUI;

import Controller.Controller;
import Model.*;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * La GUI utilizzata per comprare i biglietti
 */
public class InserimentoBigliettoGUI {
    private JPanel panel;
    private JButton btoAcquista;
    private JButton btoIndietro;
    private JComboBox cBAdulti;
    private JComboBox cBMinorenni;
    private JComboBox cBValige;
    private JComboBox cBVeicoli;
    private JLabel jlPPD;
    private JLabel labelCodCorsa;

    /**
     * The Frame chiamante.
     */
    public JFrame frameChiamante;
    /**
     * The Frame.
     */
    JFrame frame;
    /**
     * The Controller.
     */
    Controller controller;
    /**
     * The P.
     */
    Passeggero p;


    /**
     * Costruttore per la GUI InserimentoBigliettoGUI
     *
     * @param frameChiamante il frame chiamante
     * @param controller     il controller
     */
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

        for (int i=0; i<=40; i++) cBValige.addItem(i);

        for(int i = 0; i<=20;i++){
            cBAdulti.addItem(i);
            cBMinorenni.addItem(i);
        }

        labelCodCorsa.setText(controller.getCodCorsaAcq());
        frame.setVisible(true);




        controller.getPostiDisponibili();
        jlPPD.setText(controller.getPostiPersoneDisp().toString());


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

                if((Integer)cBAdulti.getSelectedItem() == 0 && (Integer)cBMinorenni.getSelectedItem() == 0 ){

                    JOptionPane.showMessageDialog(null, "Devi selezionare almeno un passeggero");

                } else if (((Integer)cBMinorenni.getSelectedItem()+(Integer)cBAdulti.getSelectedItem()) > controller.getPostiPersoneDisp()) {

                    JOptionPane.showMessageDialog(null, "Persone inserite più di quelle disponibili");

                } else{

                    CorsaTabellone corsa = controller.GetCorsa(labelCodCorsa.getText());
                    float prezzo = corsa.costocorsa;
                    int numMinorenni = (int) cBMinorenni.getSelectedItem();
                    int numAdulti = (int) cBAdulti.getSelectedItem();
                    float prezzoTotale = 0;
                    ArrayList<Biglietto> biglietti = new ArrayList<Biglietto>();
                    Integer NumVeicoli= (Integer) cBVeicoli.getSelectedItem();


                    //definire il costo totale del biglietto
                    //Calcola se è una prenotazione
                    if(LocalDate.now().isBefore(corsa.datapartenza)) {
                        prezzoTotale = 2*(numAdulti+numMinorenni)+(numAdulti*prezzo)+(numMinorenni*(prezzo/2))+ (5*(int)cBValige.getSelectedItem());

                    }else{
                        prezzoTotale = (numAdulti*prezzo)+(numMinorenni*(prezzo/2))+ (5*(int)cBValige.getSelectedItem());
                    }


                    //per quando i biglietti sono solo minorenni e non si selezionano veicoli
                    if( NumVeicoli == null )NumVeicoli=0;


                    //serve per assegnare tutte le valige ad il primo passeggero
                    if(NumVeicoli!=0){
                        biglietti.add(new Biglietto((Integer) cBValige.getSelectedItem(),"intero", true, p.getCf(), labelCodCorsa.getText()));
                        NumVeicoli--;

                    } else if ((Integer) cBAdulti.getSelectedItem()==0) {
                        biglietti.add(new Biglietto((Integer) cBValige.getSelectedItem(),"ridotto", false, p.getCf(), labelCodCorsa.getText()));
                        numMinorenni--;
                    } else {
                        biglietti.add(new Biglietto((Integer) cBValige.getSelectedItem(),"intero", false, p.getCf(), labelCodCorsa.getText()));
                    }


                    //Crea tutti i biglietti adulti e li aggiunge all'arrayList biglietti
                    for(int i = 1; i < numAdulti; i++){


                        //Verifica se deve distribuire i veicoli per i magiorenni ancora disponibili
                        if(NumVeicoli==0) {
                            biglietti.add(new Biglietto(0,"intero", false, p.getCf(), labelCodCorsa.getText()));
                        }else{
                            NumVeicoli--;
                            biglietti.add(new Biglietto(0, "intero",true, p.getCf(), labelCodCorsa.getText()));
                        }

                    }


                    //Crea tutti i biglietti minorenni e li aggiunge all'arrayList biglietti
                    for(int i = 0; i < numMinorenni;i++){
                        biglietti.add(new Biglietto(0, "ridotto", false, p.getCf(), labelCodCorsa.getText()));
                    }


                    //Messaggio di conferma dell'acquisto con prezzo totale
                    int risposta = JOptionPane.showConfirmDialog(null, "Il prezzo totale è di "+prezzoTotale+"€. Vuoi procedere all'acquisto?", "Conferma Acquisto", JOptionPane.YES_NO_OPTION);

                    //controllo risposta utente
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


        //inserisce i numeri possibili di veicoli selezionabili tenendo conto degli adulti inseriti e veicoli ancora disponibili per quella corsa
        cBAdulti.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                cBVeicoli.removeAllItems();
                for(int i = 0; i <= (Integer) cBAdulti.getSelectedItem() && i<=controller.getPostiVeicoliDisp(); i++){
                    cBVeicoli.addItem(i);
                }
            }
        });

    }

}