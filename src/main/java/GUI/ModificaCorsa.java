package GUI;

import Controller.Controller;
import Model.Compagnia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ModificaCorsa {
    private JTextField textAvviso;
    private JButton indietroButton;
    private JButton confermaButton;
    private JComboBox CBStato;
    private JPanel panel;
    private JButton btoCancella;
    private JComboBox CBCodice;
    private JFrame frame;


    private ArrayList<String> codici;
    private Controller controller;
    public JFrame frameChiamante;
    public ModificaCorsa(JFrame frameChiamante, Controller controller, Compagnia c) {

        CBStato.addItem("regolare");
        CBStato.addItem("annullato");
        CBStato.addItem("ritardo");

        codici=controller.GetCodiceCorse(c.getNomeCompagnia());
        for(String s: codici){
            CBCodice.addItem(s);
        }

        this.controller = controller;
        this.frameChiamante = frameChiamante;

        frame = new JFrame("Modifica stato corsa");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        //Apre la finestra la centro dello schermo
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


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
        btoCancella.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                int conferma=JOptionPane.showConfirmDialog(null, "Conferma la cancellazione della corsa: "+CBCodice.getSelectedItem().toString());

                /*
                   -1 se si chiude la finestra
                    0 se si preme Sì
                    1 se si preme No
                    2 se si preme Annulla*/
                if(conferma==0){
                    if(controller.CancellaCorsa(CBCodice.getSelectedItem().toString())){
                        JOptionPane.showMessageDialog(null, "modifica avvenuta correttamente");
                        frameChiamante.setVisible(true);
                        frame.setVisible(false);
                        frame.dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "errore durante la modifica");
                    }

                }

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

                if(controller.ModificaCorsa(
                        CBCodice.getSelectedItem().toString(),
                        textAvviso.getText(),
                        CBStato.getSelectedItem().toString(),
                        c.getNomeCompagnia()))
                {
                    JOptionPane.showMessageDialog(null, "modifica avvenuta correttamente");
                    frameChiamante.setVisible(true);
                    frame.setVisible(false);
                    frame.dispose();

                }
                else{
                    JOptionPane.showMessageDialog(null, "errore durante la modifica");

                }



            }
        });
    }

    public JFrame getFrame() {

        return frame;
    }
}
