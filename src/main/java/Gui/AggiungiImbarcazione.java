package Gui;

import Controller.Controller;
import Model.Compagnia;
import Model.Imbarcazione;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AggiungiImbarcazione {
    private JTextField textNomei;
    private JButton indietroButton;
    private JButton confermaButton;
    private JComboBox comboBox1;
    private JTextField textCodice;
    private JPanel panel;
    private JTextField textCapienzaP;
    private JTextField textCapienzaV;
    private JComboBox cBCompagnie;

    private JFrame frame;
    public JFrame frameChiamante;
    private Controller controller;



    public AggiungiImbarcazione(JFrame frameChiamante, Controller controller) {
        //aggiorna la lista di Compangie nel controller
        controller.CaricaCompagnie();

        this.controller = controller;
        this.frameChiamante = frameChiamante;

        comboBox1.addItem("traghetto");
        comboBox1.addItem("motonave");
        comboBox1.addItem("aliscafo");


        //Mette i nomi delle Compagnie nella comboBox Compagnie
        for(Compagnia Comp: controller.getCompagnie()) {
            cBCompagnie.addItem(Comp.getNomeCompagnia());
        }


        frame = new JFrame("Aggiungi Corsa");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);







        confermaButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String codice = textCodice.getText();
                String nomei = textNomei.getText();
                int capienzap = Integer.parseInt(textCapienzaP.getText());
                int capienzav = Integer.parseInt(textCapienzaV.getText());

                if (codice.equals("") || nomei.equals("") || capienzap<=0 ||capienzav<0) {

                    JOptionPane.showMessageDialog(null, "Identificati col tuo nome, inserisci il \n codice dell'imbarcazione o aggiungi la capienza per aggiungere l'imbarcazione!");

                }else{

                    //messaggio di conferma

                    Imbarcazione im = new Imbarcazione(codice, nomei,comboBox1.getSelectedItem().toString(),capienzap,capienzav,cBCompagnie.getSelectedItem().toString());
                    controller.AggiungiImbarcazioneDAO(im);


                }
            }
        });




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



        comboBox1.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if(comboBox1.getSelectedItem()!="traghetto")
                {
                    textCapienzaV.setEditable(false);
                    textCapienzaV.setVisible(false);
                    textCapienzaV.setText("0");
                }
                else
                {
                    textCapienzaV.setEditable(true);
                    textCapienzaV.setVisible(true);
                }
            }
        });
    }


    public JFrame getFrame() {
        return frame;
    }
}
