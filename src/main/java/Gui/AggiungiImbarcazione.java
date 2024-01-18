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
    private JComboBox CBTipo;
    private JTextField textCodice;
    private JPanel panel;
    private JTextField textCapienzaP;
    private JTextField textCapienzaV;

    private JFrame frame;
    public JFrame frameChiamante;
    private Controller controller;



    public AggiungiImbarcazione(JFrame frameChiamante, Controller controller, String nomeComp) {
        //aggiorna la lista di Compangie nel controller

        this.controller = controller;
        this.frameChiamante = frameChiamante;

        CBTipo.addItem("traghetto");
        CBTipo.addItem("motonave");
        CBTipo.addItem("aliscafo");



        frame = new JFrame("Aggiungi Imbarcazione");
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

                    Imbarcazione im = new Imbarcazione(codice, nomei, CBTipo.getSelectedItem().toString(),capienzap,capienzav,nomeComp);
                    if(controller.AggiungiImbarcazione(im))
                    {
                        JOptionPane.showMessageDialog(null, "Imbarcazione aggiunta correttamente");
                        frameChiamante.setVisible(true);
                        frame.setVisible(false);
                        frame.dispose();
                    }



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



        CBTipo.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if(CBTipo.getSelectedItem()!="traghetto")
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
