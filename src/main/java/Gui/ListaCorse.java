package Gui;

import Controller.Controller;
import Model.CorsaTabellone;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListaCorse {
    private JTable table;
    private JPanel panel;
    private JButton btoAcquistaBiglietto;
    private JButton buttonHome;
    private JComboBox cBImbarcazioni;
    private JTextField tFPrezzo;
    private JButton cercaButton;
    private Controller controller;

    private JFrame frameChiamante;

    static JFrame frame;

    public ListaCorse(JFrame frameChiamante, Controller controller) {

        this.frameChiamante = frameChiamante;
        this.controller = controller;
        frame = new JFrame("Lista Corse");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(1000, 700);
        frame.setMinimumSize(new Dimension(800, 240));

        //Apre la finestra la centro dello schermo
        frame.setLocationRelativeTo(null);



        cBImbarcazioni.addItem("Tutte");
        cBImbarcazioni.addItem("Aliscafo");
        cBImbarcazioni.addItem("Motonave");
        cBImbarcazioni.addItem("Traghetto");





        frame.setVisible(true);


        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        DefaultTableModel tableModel = new DefaultTableModel(new Object[][]{}, new String[]{"Codice", "Prezzo","Scali", "Partenza", "Città Partenza", "Nazione Partenza", "Destinazione", "Citta Destinazione", "Nazione Destinazione", "Data Partenza", "Data Arrivo", "Orario Partenza", "Orario Arrivo", "Stato", "Avviso"}) {
            public boolean isCellEditable(int row, int column) {
                // Tutte le celle non sono modificabili
                return false;
            }
        };


        table.setModel(tableModel);

        // Imposta la larghezza preferita per le colonne specifiche
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(60);
        table.getColumnModel().getColumn(2).setPreferredWidth(40);
        table.getColumnModel().getColumn(11).setPreferredWidth(60);

        // Disabilita il ridimensionamento automatico per le colonne specifiche
        table.getColumnModel().getColumn(0).setMaxWidth(50);
        table.getColumnModel().getColumn(1).setMaxWidth(60);
        table.getColumnModel().getColumn(11).setMaxWidth(70);

        //Si fa passare la lista di corse dal controller
        ArrayList<CorsaTabellone> listaCorse = controller.getCorse();

        //Inserisce tutte le righe della tabella utilizzando l'arraylist listaCorse

        if (listaCorse != null) {
            for (int i = 0; i < listaCorse.size(); i++)
                tableModel.addRow(new Object[]{listaCorse.get(i).CodiceCorsa, listaCorse.get(i).costocorsa,listaCorse.get(i).scali, listaCorse.get(i).partenza, listaCorse.get(i).cittapartenza, listaCorse.get(i).nazionepartenza, listaCorse.get(i).destinazione, listaCorse.get(i).cittadestinazione, listaCorse.get(i).nazionedestinazione, listaCorse.get(i).datapartenza, listaCorse.get(i).dataarrivo, listaCorse.get(i).orariopartenza, listaCorse.get(i).orarioarrivo, listaCorse.get(i).stato, listaCorse.get(i).avviso});
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
        btoAcquistaBiglietto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InserimentoBigliettoGUI frameInsBiglietto = new InserimentoBigliettoGUI(frame, controller);
                frame.setEnabled(false);
                frameInsBiglietto.frame.setVisible(true);


            }
        });
/*
        ArrayList<String> listaCodiceCorsa = Controller.getCodiceCorsa();
        ArrayList<Float> listaCosto = Controller.getCostoCorsa();
        ArrayList<String> listaPartenza = controller.getCodiceCorsa();
        ArrayList<String> listaCittaPartenza = controller.getCodiceCorsa();
        ArrayList<String> listaNazionePartenza = controller.getCodiceCorsa();
        ArrayList<String> listaDestinazione = controller.getCodiceCorsa();
        ArrayList<String> listaCittaDestinazione = controller.getCodiceCorsa();
        ArrayList<String> listaNazioneDestinazione = controller.getCodiceCorsa();
        ArrayList<String> listaDataPartenza = controller.getCodiceCorsa();
        ArrayList<String> listaCodiceCorsa = controller.getCodiceCorsa();*/


    }


}

