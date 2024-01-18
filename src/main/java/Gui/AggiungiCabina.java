package Gui;

import Controller.Controller;
import Model.Cabina;
import Model.Compagnia;
import Model.Imbarcazione;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AggiungiCabina {
    private JTextField TFLetti;
    private JButton indietroButton;
    private JButton confermaButton;
    private JComboBox CBImbarcazione;
    private JLabel lbCabine;
    private Controller controller;
    private JFrame frameChiamante;

    private JFrame frame;
    private JPanel panel;
    private JComboBox CBLetti;
    private ArrayList<Imbarcazione> imbarcazioni;
    public AggiungiCabina(JFrame frameChiamante, Controller controller, Compagnia c) {


        imbarcazioni = controller.GetImbarcazioni(c.getNomeCompagnia());
        for (Imbarcazione imb: imbarcazioni){
            CBImbarcazione.addItem(imb.getNome()+", "+imb.getCodice());
        }

        lbCabine.setText("Cabine Disponibili: ");
        //implementare funzione che mi restituisce il numero di cabine di una imbarcazione

        this.controller = controller;
        this.frameChiamante = frameChiamante;

        frame = new JFrame("Aggiungi Cabina");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        CBLetti.addItem("1");
        CBLetti.addItem("2");

        indietroButton.addActionListener(new ActionListener() {
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
        confermaButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                //idea aggiungi cabina, insert dove gli passo il codice dell'imbarcazione, il numero di posti letto
                //e per l'id prendo l'ultimo più grande

                String codImb  = CBImbarcazione.getSelectedItem().toString();



                        Cabina cabina = new Cabina(controller.GetUltimaCabina(imbarcazioni.get(CBImbarcazione.getSelectedIndex()))+1,CBLetti.getSelectedIndex());
                        if(controller.AggiungiCabina(cabina,imbarcazioni.get(CBImbarcazione.getSelectedIndex()))){
                            JOptionPane.showMessageDialog(null, "Cabina aggiunta correttamente");
                            frameChiamante.setVisible(true);
                            frame.setVisible(false);
                            frame.dispose();
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "errore durante l'aggiunta di cabina");
                        }


                }


        });
    }


    public JFrame getFrame() {

        return frame;
    }
}
