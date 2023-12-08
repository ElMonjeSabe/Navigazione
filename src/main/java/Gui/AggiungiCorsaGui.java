package Gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AggiungiCorsaGui  extends JFrame{
    public JPanel mainPanel;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    private JComboBox comboBox6;
    private JButton aggiungiScaloButton;
    private JButton indietroButton;
    private JButton creaCorsaButton;
    private JPanel panelRIp;
    private JScrollPane scrollPane;
    JPanel frame;

    public AggiungiCorsaGui (){
    frame = new JPanel();
    frame.setLayout(mainPanel.getLayout());

    scrollPane = new JScrollPane(frame);

    aggiungiScaloButton = new JButton("Aggiungi JPanel");



      aggiungiScaloButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
           @Override
            public void actionPerformed(ActionEvent e) {
                JPanel newPanel = new JPanel();
                newPanel.add(new JLabel("Nuovo JPanel"));

                frame.add(newPanel);
                frame.revalidate();
                frame.repaint();
            }

        });

        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AggiungiCorsaGui();
            }
        });}

}
