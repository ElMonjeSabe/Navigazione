package GUI;

import Controller.Controller;
import Model.Compagnia;
import Model.CorsaTabellone;
import Model.Passeggero;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ListaCorse {
    private JTable table;
    private JPanel panel;
    private JButton buttonHome;
    private JComboBox cBImbarcazioni;
    private JButton cercaButton;
    private JSlider sliderPrezzo;
    private JLabel Prezzo;
    private JComboBox CBCompagnie;
    private Controller controller;
    private JFrame frameChiamante;
    static JFrame frame;
    private ArrayList<Compagnia> compagnie;


    public ListaCorse(JFrame frameChiamante, Controller controller, Passeggero p) {

        this.frameChiamante = frameChiamante;
        this.controller = controller;

        frame = new JFrame("Lista Corse");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(1000, 700);
        frame.setMinimumSize(new Dimension(800, 240));

        //Apre la finestra la centro dello schermo
        frame.setLocationRelativeTo(null);

        cBImbarcazioni.addItem("tutte");
        cBImbarcazioni.addItem("aliscafo");
        cBImbarcazioni.addItem("motonave");
        cBImbarcazioni.addItem("traghetto");
        compagnie = controller.CaricaCompagnie();

        CBCompagnie.addItem("tutte");
        for (Compagnia c : compagnie) {
            CBCompagnie.addItem(c.getNomeCompagnia());
        }

        sliderPrezzo.setMaximum(10000);
        sliderPrezzo.setMinimum(0);
        sliderPrezzo.setMinorTickSpacing(1);

        frame.setVisible(true);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);


        DefaultTableModel tableModel = new DefaultTableModel(new Object[][]{}, new String[]{"Codice", "Prezzo", "Scali", "Nome Compagnia", "Partenza", "Città Partenza", "Nazione Partenza", "Destinazione", "Citta Destinazione", "Nazione Destinazione", "Data Partenza", "Data Arrivo", "Orario Partenza", "Orario Arrivo", "Stato", "Avviso"}) {
            public boolean isCellEditable(int row, int column) {
                // Tutte le celle non sono modificabili
                return false;
            }
        };


        table.setModel(tableModel);

        //Si fa passare la lista di corse dal controller
        ArrayList<CorsaTabellone> listaCorse = controller.getCorse();


        //Inserisce tutte le righe della tabella utilizzando l'arraylist listaCorse
        if (listaCorse != null) {
            for (int i = 0; i < listaCorse.size(); i++)
                tableModel.addRow(new Object[]{
                        listaCorse.get(i).CodiceCorsa,
                        listaCorse.get(i).costocorsa,
                        listaCorse.get(i).scali,
                        listaCorse.get(i).nomeCompagnia,
                        listaCorse.get(i).partenza,
                        listaCorse.get(i).cittapartenza,
                        listaCorse.get(i).nazionepartenza,
                        listaCorse.get(i).destinazione,
                        listaCorse.get(i).cittadestinazione,
                        listaCorse.get(i).nazionedestinazione,
                        listaCorse.get(i).datapartenza,
                        listaCorse.get(i).dataarrivo,
                        listaCorse.get(i).orariopartenza,
                        listaCorse.get(i).orarioarrivo,
                        listaCorse.get(i).stato,
                        listaCorse.get(i).avviso});
        }


        buttonHome.addActionListener(new ActionListener() {
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


        sliderPrezzo.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                Prezzo.setText(Integer.toString(sliderPrezzo.getValue()));
            }
        });


        cercaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Si fa passare la lista di corse dal controller
                controller.LeggiCorseFiltrateDAO(cBImbarcazioni.getSelectedItem().toString(), sliderPrezzo.getValue(), CBCompagnie.getSelectedItem().toString());

                ArrayList<CorsaTabellone> listaCorse = controller.getCorse();

                //Inserisce tutte le righe della tabella utilizzando l'arraylist listaCorse
                tableModel.setRowCount(0);
                if (listaCorse != null) {
                    for (int i = 0; i < listaCorse.size(); i++)
                        tableModel.addRow(new Object[]{
                                listaCorse.get(i).CodiceCorsa,
                                listaCorse.get(i).costocorsa,
                                listaCorse.get(i).scali,
                                listaCorse.get(i).nomeCompagnia,
                                listaCorse.get(i).partenza,
                                listaCorse.get(i).cittapartenza,
                                listaCorse.get(i).nazionepartenza,
                                listaCorse.get(i).destinazione,
                                listaCorse.get(i).cittadestinazione,
                                listaCorse.get(i).nazionedestinazione,
                                listaCorse.get(i).datapartenza,
                                listaCorse.get(i).dataarrivo,
                                listaCorse.get(i).orariopartenza,
                                listaCorse.get(i).orarioarrivo,
                                listaCorse.get(i).stato,
                                listaCorse.get(i).avviso});
                }
            }
        });


        //Permette di selezionare una riga con un click del mouse
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if(p != null){
                    if (!event.getValueIsAdjusting() && table.getSelectedRow() != -1) {
                        // Ottieni l'indice della riga selezionata
                        int selectedRow = table.getSelectedRow();

                        // Ottieni il valore della cella alla colonna 0 (Dato1) della riga selezionata e
                        //invia il codice della corsa al controller
                        controller.setCodCorsaAcq(table.getValueAt(selectedRow, 0).toString());
                        InserimentoBigliettoGUI frameInsBiglietto = new InserimentoBigliettoGUI(frame, controller);
                        frame.setEnabled(false);
                        frameInsBiglietto.frame.setVisible(true);

                        // Deseleziona la riga
                        table.clearSelection();
                    }
                }
            }
        });
    }
}

