package Gui;

import Controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Accesso {
    private JTextField tFEmail;
    private JTextField tFPassword;
    private JPanel panel;
    private JButton confermaButton;
    private JButton indietroButton;
    private JRadioButton rdPasseggero;
    private JRadioButton rdCompagnia;

    public JFrame frame;
    private JFrame frameChiamante;
    private Controller controller;

    public Accesso(JFrame frameChiamnte, Controller controller){
        this.frameChiamante = frameChiamnte;
        this.controller = controller;


        frame = new JFrame("Accesso");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 270);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        ButtonGroup group = new ButtonGroup();
        group.add(rdCompagnia);
        group.add(rdPasseggero);


        indietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameChiamante.setVisible(true);
                frame.setVisible(false);
                frame.dispose();
            }
        });
        confermaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(rdCompagnia.isSelected()){
                    //Compagnia
                    //Se email e password esistono allora vai alla schermata Compagnia
                    System.out.println(rdCompagnia.isSelected());
                }else if (rdPasseggero.isSelected()){
                    //Utente
                    //Se email e password esistono allora vai alla schermata Passeggero
                    if(controller.loginPasseggero(tFEmail.getText(),tFPassword.getText())){
                        JOptionPane.showMessageDialog(null, "login effettuato con successo.");
                        //PasseggeroGUI framePasseggeroGUI = new PasseggeroGUI(frame, controller,p);
                        //framePasseggeroGUI.frame.setVisible(true);
                        //frame.setVisible(false);
                    }else{
                        JOptionPane.showMessageDialog(null, "utente non esistente");

                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Inserisci il tipo di utente");
                }

            }
        });
    }
}
