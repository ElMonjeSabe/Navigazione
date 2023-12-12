package Gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AggiungiImbarcazione {
    private JTextField textNomeC;
    private JTextField textNomei;
    private JButton indietroButton;
    private JButton confermaButton;
    private JComboBox comboBox1;
    private JTextField textCodice;
    private JPanel panel;
    private JTextField textCapienzaP;
    private JTextField textCapienzaV;

    private JFrame frame;
    public JFrame frameChiamante;
    public AggiungiImbarcazione(JFrame frameChiamante) {
        comboBox1.addItem("traghetto");
        comboBox1.addItem("motonave");
        comboBox1.addItem("aliscafo");

        this.frameChiamante = frameChiamante;

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
                String nomec = textNomeC.getText();
                String nomei = textNomei.getText();
                String capienzap = textCapienzaP.getText();
                String capienzav = textCapienzaV.getText();

                if (codice.equals("") || nomec.equals("") || nomei.equals("") || capienzap.equals("") || capienzav.equals("")) {
                    JOptionPane.showMessageDialog(null, "identificati col tuo nome, inserisci il \n codice dell'imbarcazione o aggiungi la capienza per aggiungere l'imbarcazione!");
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
