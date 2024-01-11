package Gui;

import Model.Porto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AggiungiCorsa {
    private JPanel panel;
    private JTextField textNomeC;
    private JTextField textAvviso;
    private JButton aggiungiPortoButton;
    private JButton indietroButton;
    private JButton confermaButton;
    private JLabel countPorti;
    private int num=0;
    private JComboBox comboBox1;
    private JTextField textCodice;
    private JComboBox comboBox2;
    private JFrame frame;

    private ArrayList<Porto> porti= new ArrayList<Porto>();
    private ArrayList<CompagniaGUI> codiceCompagnie= new ArrayList<CompagniaGUI>();



    public JFrame frameChiamante;
    public AggiungiCorsa(JFrame frameChiamante) {

        this.frameChiamante = frameChiamante;

        frame = new JFrame("Aggiungi Corsa");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setSize(400, 250);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        countPorti.setText("Totale porti inseriti: "+num);

        comboBox1.addItem("regolare");
        comboBox1.addItem("annullato");
        comboBox1.addItem("ritardo");

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
        aggiungiPortoButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                num++;
                countPorti.setText("Totale porti inseriti: "+num);
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
                String codice = textCodice.getText();
                String nomec = textNomeC.getText();

                if (codice.equals("") || nomec.equals("") || num<2) {
                    JOptionPane.showMessageDialog(null, "identificati col tuo nome, inserisci il \n codice della corsa o aggiungi almeno \ndue porti per aggiungere la corsa!");
                }
            }
        });
    }

    public JFrame getFrame() {
        return frame;
    }
}
