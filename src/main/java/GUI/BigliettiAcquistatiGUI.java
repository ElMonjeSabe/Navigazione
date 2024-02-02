package GUI;

import Controller.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BigliettiAcquistatiGUI {
    private JButton bTIndietro;
    private JTable table;
    private JPanel panel;
    JFrame frameChiamante;
    Controller controller;
    JFrame frame;


    public BigliettiAcquistatiGUI(JFrame frameChiamante, Controller controller){
        this.frameChiamante = frameChiamante;
        this.controller = controller;



        frame = new JFrame("Biglietti Acquistati");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(1000, 700);
        frame.setMinimumSize(new Dimension(800, 240));

        //Apre la finestra la centro dello schermo
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);





        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        DefaultTableModel tableModel = new DefaultTableModel(new Object[][]{}, new String[]{"Codice Corsa", "Codice Biglietto","Tipobiglietto","Prezzo","Data Acquisto","Veicolo", "Numbagagli" ,"Prenotazione"}) {
           @Override
            public boolean isCellEditable(int row, int column) {
                // Tutte le celle non sono modificabili
                return false;
            }
        };

        table.setModel(tableModel);


        //Si fa passare la lista dei biglietti dal controller
        ArrayList<Model.BigliettiAcquistati> listaBA = controller.getBiglietti();

        //Inserisce tutte le righe della tabella utilizzando l'arraylist listaBA
//tipobiglietto,prezzo,dataacquisto,veicolo,numbagagli,prenotazione
        if (listaBA != null) {
            for (int i = 0; i < listaBA.size(); i++)
                tableModel.addRow(new Object[]{
                        listaBA.get(i).codicecorsa,
                        listaBA.get(i).codicebiglietto,
                        listaBA.get(i).tipobiglietto,
                        listaBA.get(i).prezzo,
                        listaBA.get(i).dataacquisto,
                        listaBA.get(i).veicolo,
                        listaBA.get(i).numeroBagagli,
                        listaBA.get(i).prenotazione});
        }


        bTIndietro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameChiamante.setVisible(true);
                frame.setVisible(false);
                frame.dispose();
            }
        });
    }

}
