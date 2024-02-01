package GUI;

import Controller.Controller;
import Model.Compagnia;
import Model.CorsaTabellone;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

public class ListaCorseCompagnia {
    private JTable table;
    private JButton buttonHome;
    private JComboBox cBImbarcazioni;
    private JButton cercaButton;
    private JSlider sliderPrezzo;
    private JLabel Prezzo;
    private JPanel panel;
    private Controller controller;

    private JFrame frameChiamante;

    static JFrame frame;


    public ListaCorseCompagnia(JFrame frameChiamante, Controller controller, Compagnia comp) {

        this.frameChiamante = frameChiamante;
        this.controller = controller;



        frame = new JFrame("Lista Corse Compagnia");
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


        sliderPrezzo.setMaximum(10000);
        sliderPrezzo.setMinimum(0);
        sliderPrezzo.setMinorTickSpacing(1);



        frame.setVisible(true);


        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        DefaultTableModel tableModel = new DefaultTableModel(new Object[][]{}, new String[]{"Codice", "Prezzo","Scali","Nome Compagnia", "Partenza", "Città Partenza", "Nazione Partenza", "Destinazione", "Citta Destinazione", "Nazione Destinazione", "Data Partenza", "Data Arrivo", "Orario Partenza", "Orario Arrivo", "Stato", "Avviso"}) {
            @Override
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
                controller.LeggiCorseCompagniaFiltrateDAO(cBImbarcazioni.getSelectedItem().toString(), sliderPrezzo.getValue(), comp.getNomeCompagnia());

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
    }
    public JFrame getFrame() {
        return frame;
    }
}
