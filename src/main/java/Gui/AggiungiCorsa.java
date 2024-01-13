package Gui;

import Controller.Controller;
import Model.Compagnia;
import Model.Imbarcazione;
import Model.Percorso;
import Model.Porto;


import javax.naming.ldap.Control;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class AggiungiCorsa {
    private JPanel panel;
    private JTextField textAvviso;
    private JButton aggiungiPortoButton;
    private JButton indietroButton;
    private JButton confermaButton;
    private JLabel countPorti;
    private int num=0;
    private JComboBox comboBox1;
    private JTextField textCodice;
    private JComboBox CBImbarcazioni;
    private JComboBox CBGiornoIn;
    private JComboBox CBMeseIn;
    private JComboBox CBAnnoIn;
    private JCheckBox lunediCheckBox;
    private JCheckBox martediCheckBox;
    private JCheckBox mercolediCheckBox;
    private JCheckBox giovediCheckBox;
    private JCheckBox venerdiCheckBox;
    private JCheckBox sabatoCheckBox;
    private JCheckBox domenicaCheckBox;
    private JComboBox CBGiornoOut;
    private JComboBox CBMeseOut;
    private JComboBox CBAnnoOut;
    private JComboBox CBNomeIn;
    private JComboBox CBCittaIn;
    private JComboBox CBNazioneIn;
    private JComboBox CBArrivoOraIn;
    private JComboBox CBArrivoMinIn;
    private JComboBox CBPartenzaOraIn;
    private JComboBox CBPartenzaMinIn;
    private JLabel txtPortoIn;
    private JComboBox CBNomeOut;
    private JComboBox CBCittaOut;
    private JComboBox CBNazioneOut;
    private JComboBox CBPartenzaOraOut;
    private JComboBox CBPartenzaMinOut;
    private JComboBox CBArrivoOraOut;
    private JComboBox CBArrivoMinOut;
    private JPanel panelScalo;
    private JComboBox CBNomeScalo;
    private JComboBox CBCittaScalo;
    private JComboBox CBNazioneScalo;
    private JComboBox CBPartenzaOraScalo;
    private JComboBox CBPartenzaMinScalo;
    private JComboBox CBArrivoOraScalo;
    private JComboBox CBArrivoMinScalo;
    private JCheckBox scaloCheckBox;
    private JTextField tfCosto;

    private int codPortIn;
    private int codPortOut;
    private int codPortScalo;
    private JFrame frame;

    private ArrayList<CompagniaGUI> codiceCompagnie= new ArrayList<CompagniaGUI>();

    private int i;
    private LocalDate dataIn;
    private LocalDate dataOut;
    private LocalTime timePIn;
    private LocalTime timePOut;
    private LocalTime timePScalo;

    private LocalTime timeAIn;
    private LocalTime timeAOut;
    private LocalTime timeAScalo;

    public JFrame frameChiamante;
    private Controller controller;
    private Porto portoiniziale;
    private Porto portofinale;
    private Porto portoscalo;

    private LocalDate giorno;

    public AggiungiCorsa(JFrame frameChiamante, Controller controller,  ArrayList<String> imbarcazioni, ArrayList<Porto> porti, String nomeComp) {
        panelScalo.setVisible(false);

        CBCittaIn.setEnabled(false);
        CBCittaOut.setEnabled(false);
        CBCittaScalo.setEnabled(false);

        CBNazioneScalo.setEnabled(false);
        CBNazioneIn.setEnabled(false);
        CBNazioneOut.setEnabled(false);
        for(Porto p: porti)
        {
            CBNomeIn.addItem(p.getNomePorto());
            CBNomeOut.addItem(p.getNomePorto());
            CBNomeScalo.addItem(p.getNomePorto());

            CBCittaIn.addItem(p.getCitta());
            CBCittaOut.addItem(p.getCitta());
            CBCittaScalo.addItem(p.getCitta());

            CBNazioneIn.addItem(p.getNazione());
            CBNazioneOut.addItem(p.getNazione());
            CBNazioneScalo.addItem(p.getNazione());
        }
        codPortIn=porti.getFirst().getIdPorto();
        codPortOut=porti.getFirst().getIdPorto();
        codPortScalo=porti.getFirst().getIdPorto();

        for(i=0;i<=23;i++)
        {
            CBPartenzaOraIn.addItem(i);
            CBPartenzaOraOut.addItem(i);
            CBPartenzaOraScalo.addItem(i);

            CBArrivoOraIn.addItem(i);
            CBArrivoOraOut.addItem(i);
            CBArrivoOraScalo.addItem(i);
        }
        for(i=0;i<=59;i++)
        {
            CBPartenzaMinIn.addItem(i);
            CBPartenzaMinOut.addItem(i);
            CBPartenzaMinScalo.addItem(i);

            CBArrivoMinIn.addItem(i);
            CBArrivoMinOut.addItem(i);
            CBArrivoMinScalo.addItem(i);
        }

        this.frameChiamante = frameChiamante;
        this.controller=controller;

        frame = new JFrame("Aggiungi Corsa");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(true);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        comboBox1.addItem("regolare");
        comboBox1.addItem("annullato");
        comboBox1.addItem("ritardo");

        CBAnnoOut.setEnabled(false);
        //va scelto prima l'anno, poi il mese e poi il giorno, in modo che la data d'inizio venga prima di quella di fine
        //CBGiornoIn.setEnabled(false);
        //CBMeseIn.setEnabled(false);
        //ComboBox Giorno per la data d'inizio
        for ( i = 1; i <= 31; i++) {
            CBGiornoIn.addItem(i);
            CBGiornoOut.addItem(i);
        }

        //ComboBox Mese per la data d'inizio
        for (i = 1; i <= 12; i++) {
            CBMeseIn.addItem(i);
            CBMeseOut.addItem(i);
        }

        //ComboBox Anno per la data d'inizio
        for (i = 2000; i <= 2050; i++) {
            CBAnnoIn.addItem(i);
        }


        for(String i : imbarcazioni){
            CBImbarcazioni.addItem(i);
        }


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
                //String codice = textCodice.getText();
                int codice=0;
                if (!textCodice.getText().equals("")) {
                    try {
                        codice = Integer.parseInt(textCodice.getText());
                    } catch(NumberFormatException err){
                        JOptionPane.showMessageDialog(null, "inserisci un codice numerico");
                    }
                    if(CBAnnoOut.isEnabled() && CBMeseOut.isEnabled() && CBGiornoOut.isEnabled() && CBAnnoIn.isEnabled() && CBMeseIn.isEnabled() && CBGiornoIn.isEnabled()){
                        dataIn=LocalDate.of((int) CBAnnoIn.getSelectedItem(), (int) CBMeseIn.getSelectedItem(), (int) CBGiornoIn.getSelectedItem());
                        dataOut=LocalDate.of((int) CBAnnoOut.getSelectedItem(), (int) CBMeseOut.getSelectedItem(), (int) CBGiornoOut.getSelectedItem());
                        if(dataIn.isBefore(dataOut) || dataIn.equals(dataOut)){
                            ArrayList<LocalDate> giorni=calcoloDate();

                            if(!giorni.isEmpty()){
                                portoiniziale=new Porto((String) CBNomeIn.getSelectedItem(), (String) CBCittaIn.getSelectedItem(), (String) CBNazioneIn.getSelectedItem(),codPortIn);
                                portofinale=new Porto((String) CBNomeOut.getSelectedItem(), (String) CBCittaOut.getSelectedItem(), (String) CBNazioneOut.getSelectedItem(),codPortOut);
                                portoscalo=new Porto((String) CBNomeScalo.getSelectedItem(), (String) CBCittaScalo.getSelectedItem(), (String) CBNazioneScalo.getSelectedItem(),codPortScalo);
                                timePIn=LocalTime.of((int) CBPartenzaOraIn.getSelectedItem(),(int) CBPartenzaMinIn.getSelectedItem());
                                timePOut=LocalTime.of((int) CBPartenzaOraOut.getSelectedItem(),(int) CBPartenzaMinOut.getSelectedItem());
                                timeAIn=LocalTime.of((int) CBArrivoOraIn.getSelectedItem(),(int) CBArrivoMinIn.getSelectedItem());
                                timeAOut=LocalTime.of((int) CBArrivoOraOut.getSelectedItem(),(int) CBArrivoMinOut.getSelectedItem());
                                if(scaloCheckBox.isSelected())
                                {
                                    timePScalo=LocalTime.of((int) CBPartenzaOraScalo.getSelectedItem(),(int) CBPartenzaMinScalo.getSelectedItem());
                                    timeAScalo=LocalTime.of((int) CBArrivoOraScalo.getSelectedItem(),(int) CBArrivoMinScalo.getSelectedItem());
                                    //System.out.println(dataIn.getDayOfWeek());

                                    i=1;
                                    ArrayList<Percorso> percorsi = new ArrayList<Percorso>();
                                    for(LocalDate l : giorni){
                                        //System.out.println(l.toString());

                                        percorsi.add(new Percorso(timePIn,timePOut,l,l.plusDays(2),1,portoiniziale.getIdPorto(),"C"+codice));
                                        percorsi.add(new Percorso(timePScalo,timeAScalo,l,l.plusDays(2),2,portoscalo.getIdPorto(),"C"+codice));
                                        percorsi.add(new Percorso(timeAIn,timeAOut,l,l.plusDays(2),3,portofinale.getIdPorto(),"C"+codice));
                                        codice++;

                                    }
                                    //Compagnia c = controller.loginCompagnia(tFEmail.getText(),tFPassword.getText());
                                    if(controller.AggiungiCorse(percorsi)){
                                        JOptionPane.showMessageDialog(null, "corse aggiunte con successo");
                                        frameChiamante.setVisible(true);
                                        frame.setVisible(false);
                                        frame.dispose();
                                    }else{
                                        JOptionPane.showMessageDialog(null, "utente non esistente");

                                    }

                                }
                                else{

                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "inserisci almeno un giorno");
                            }

                           /* frameChiamante.setVisible(true);
                            frame.setVisible(false);*/
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "inserisci le date correttamente");
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "inserisci le date");
                    }

                }
                else{
                    JOptionPane.showMessageDialog(null, "inserisci il codice della corsa!");
                }


            }
        });
        CBAnnoIn.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                CBAnnoOut.removeAllItems();
                CBAnnoOut.setEnabled(true);
                for (i = (int) CBAnnoIn.getSelectedItem(); i <= 2050; i++) {
                    CBAnnoOut.addItem(i);
                }

            }
        });


        scaloCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if(scaloCheckBox.isSelected()){
                    panelScalo.setVisible(true);
                }
                else{
                    panelScalo.setVisible(false);
                }
                frame.pack();
                frame.setVisible(true);
            }
        });
        CBNomeOut.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                CBCittaOut.setSelectedIndex(CBNomeOut.getSelectedIndex());
                CBNazioneOut.setSelectedIndex(CBNomeOut.getSelectedIndex());
                codPortOut=porti.get(CBNomeOut.getSelectedIndex()).getIdPorto();
            }
        });
        CBNomeScalo.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                CBCittaScalo.setSelectedIndex(CBNomeScalo.getSelectedIndex());
                CBNazioneScalo.setSelectedIndex(CBNomeScalo.getSelectedIndex());
                codPortScalo=porti.get(CBNomeScalo.getSelectedIndex()).getIdPorto();
            }
        });
        CBNomeIn.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                CBCittaIn.setSelectedIndex(CBNomeIn.getSelectedIndex());
                CBNazioneIn.setSelectedIndex(CBNomeIn.getSelectedIndex());
                codPortIn=porti.get(CBNomeIn.getSelectedIndex()).getIdPorto();
            }
        });
    }

    public JFrame getFrame() {
        return frame;
    }
    public ArrayList<LocalDate> calcoloDate(){

        ArrayList<LocalDate> days=new ArrayList<>();
        if(lunediCheckBox.isSelected()){
            if(dataIn.with(DayOfWeek.MONDAY).isBefore(dataIn))
            {
                days.add((dataIn.with(DayOfWeek.MONDAY)).plusDays(7));
            }
            else{
                days.add((dataIn.with(DayOfWeek.MONDAY)));
            }
            while ((giorno=days.getLast().plusDays(7)).isBefore(dataOut)) {
                days.add(giorno);
            }
        }
        if(martediCheckBox.isSelected()){
            if(dataIn.with(DayOfWeek.TUESDAY).isBefore(dataIn))
            {
                days.add((dataIn.with(DayOfWeek.TUESDAY)).plusDays(7));
            }
            else{
                days.add((dataIn.with(DayOfWeek.TUESDAY)));
            }
            while ((giorno=days.getLast().plusDays(7)).isBefore(dataOut)) {
                days.add(giorno);
            }

        }
        if(mercolediCheckBox.isSelected()){
            if(dataIn.with(DayOfWeek.WEDNESDAY).isBefore(dataIn))
            {
                days.add((dataIn.with(DayOfWeek.WEDNESDAY)).plusDays(7));
            }
            else{
                days.add((dataIn.with(DayOfWeek.WEDNESDAY)));
            }
            while ((giorno=days.getLast().plusDays(7)).isBefore(dataOut)) {
                days.add(giorno);
            }

        }
        if(giovediCheckBox.isSelected()){
            if(dataIn.with(DayOfWeek.THURSDAY).isBefore(dataIn))
            {
                days.add((dataIn.with(DayOfWeek.THURSDAY)).plusDays(7));
            }
            else{
                days.add((dataIn.with(DayOfWeek.THURSDAY)));
            }
            while ((giorno=days.getLast().plusDays(7)).isBefore(dataOut)) {
                days.add(giorno);
            }

        }
        if(venerdiCheckBox.isSelected()){
            if(dataIn.with(DayOfWeek.FRIDAY).isBefore(dataIn))
            {
                days.add((dataIn.with(DayOfWeek.FRIDAY)).plusDays(7));
            }
            else{
                days.add((dataIn.with(DayOfWeek.FRIDAY)));
            }
            while ((giorno=days.getLast().plusDays(7)).isBefore(dataOut)) {
                days.add(giorno);
            }

        }
        if(sabatoCheckBox.isSelected()){
            if(dataIn.with(DayOfWeek.SATURDAY).isBefore(dataIn))
            {
                days.add((dataIn.with(DayOfWeek.SATURDAY)).plusDays(7));
            }
            else{
                days.add((dataIn.with(DayOfWeek.SATURDAY)));
            }
            while ((giorno=days.getLast().plusDays(7)).isBefore(dataOut)) {
                days.add(giorno);
            }
        }
        if(domenicaCheckBox.isSelected()){
            if(dataIn.with(DayOfWeek.SUNDAY).isBefore(dataIn))
            {
                days.add((dataIn.with(DayOfWeek.SUNDAY)).plusDays(7));
            }
            else{
                days.add((dataIn.with(DayOfWeek.SUNDAY)));
            }
            while ((giorno=days.getLast().plusDays(7)).isBefore(dataOut)) {
                days.add(giorno);
            }
        }
        return days;
    }




}


