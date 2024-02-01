package GUI;

import Controller.Controller;
import Model.BigliettiAcquistati;
import Model.Compagnia;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

public class BigliettiPasseggeriGUI {
    private JTable table;
    private JButton bTIndietro;
    private JButton cercaButton;
    private JSlider sliderPrezzo;
    private JLabel Prezzo;
    private JComboBox CBCorse;
    private JPanel panel;
    JFrame frameChiamante;
    Controller controller;
    JFrame frame;
    private ArrayList<String> codici;
    private ArrayList<BigliettiAcquistati> listaBA;
    private int i;



    public BigliettiPasseggeriGUI(JFrame frameChiamante, Controller controller, Compagnia comp){
        this.frameChiamante = frameChiamante;
        this.controller = controller;




        frame = new JFrame("Biglietti Passeggeri");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(1000, 700);
        frame.setMinimumSize(new Dimension(800, 240));

        //Apre la finestra la centro dello schermo
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        codici=controller.GetCodiceCorse(comp.getNomeCompagnia());
        for(String s: codici){
            CBCorse.addItem(s);
        }

        CBCorse.addItem("tutte");

        sliderPrezzo.setMaximum(10000);
        sliderPrezzo.setMinimum(0);
        sliderPrezzo.setMinorTickSpacing(1);



        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        DefaultTableModel tableModel = new DefaultTableModel(new Object[][]{}, new String[]{"Codice Corsa", "CF","Nome","Cognome","Datanascita","Codice Biglietto","Tipobiglietto","Prezzo","Data Acquisto","Veicolo", "Numbagagli" ,"Prenotazione"}) {
           @Override
            public boolean isCellEditable(int row, int column) {
                // Tutte le celle non sono modificabili
                return false;
            }
        };

        table.setModel(tableModel);

        //Si fa passare la lista dei biglietti dal controller
        listaBA = controller.getBiglietti();


        //Inserisce tutte le righe della tabella utilizzando l'arraylist listaBA
//tipobiglietto,prezzo,dataacquisto,veicolo,numbagagli,prenotazione
        if (listaBA != null) {
            for (i = 0; i < listaBA.size(); i++){
                tableModel.addRow(new Object[]{
                        listaBA.get(i).codicecorsa,
                        listaBA.get(i).cf,
                        listaBA.get(i).nome,
                        listaBA.get(i).cognome,
                        listaBA.get(i).datanascita,
                        listaBA.get(i).codicebiglietto,
                        listaBA.get(i).tipobiglietto,
                        listaBA.get(i).prezzo,
                        listaBA.get(i).dataacquisto,
                        listaBA.get(i).veicolo,
                        listaBA.get(i).numeroBagagli,
                        listaBA.get(i).prenotazione});
            }

        }
        sliderPrezzo.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                Prezzo.setText(Integer.toString(sliderPrezzo.getValue()));
            }
        });



        cercaButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModel.setRowCount(0);

                //Si fa passare la lista di corse dal controller
                controller.leggiBigliettiFiltratiAcquistatiCompagnia(CBCorse.getSelectedItem().toString(), sliderPrezzo.getValue(), comp.getNomeCompagnia());
                listaBA = controller.getBiglietti();



                //Inserisce tutte le righe della tabella utilizzando l'arraylist listaBA
                //tipobiglietto,prezzo,dataacquisto,veicolo,numbagagli,prenotazione
                if (listaBA != null) {
                    for (i = 0; i < listaBA.size(); i++){
                        tableModel.addRow(new Object[]{
                                listaBA.get(i).codicecorsa,
                                listaBA.get(i).cf,
                                listaBA.get(i).nome,
                                listaBA.get(i).cognome,
                                listaBA.get(i).dataacquisto,
                                listaBA.get(i).codicebiglietto,
                                listaBA.get(i).tipobiglietto,
                                listaBA.get(i).prezzo,
                                listaBA.get(i).dataacquisto,
                                listaBA.get(i).veicolo,
                                listaBA.get(i).numeroBagagli,
                                listaBA.get(i).prenotazione});
                    }

                }

            }
        });
        bTIndietro.addActionListener(new ActionListener() {
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
    }
}
