package Gui;

import Controller.Controller;
import Model.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;

public class AggiungiCorsa {
    private JPanel panel;
    private JTextField textAvviso;
    private JButton aggiungiPortoButton;
    private JButton indietroButton;
    private JButton confermaButton;
    private JLabel countPorti;
    private int num=0;
    private JComboBox CBStato;
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
    private JComboBox CBPortoIn;
    private JComboBox CBArrivoOraIn;
    private JComboBox CBArrivoMinIn;
    private JComboBox CBPartenzaOraIn;
    private JComboBox CBPartenzaMinIn;
    private JLabel txtPortoIn;
    private JComboBox CBPortoOut;
    private JComboBox CBArrivoOraOut;
    private JComboBox CBArrivoMinOut;
    private JPanel panelScalo;
    private JComboBox CBPortoScalo;
    private JComboBox CBPartenzaOraScalo;
    private JComboBox CBPartenzaMinScalo;
    private JCheckBox scaloCheckBox;
    private JTextField tfCosto;
    private JSpinner spGiorniPartenza;
    private JSpinner spGiorniScalo;
    private JLabel labelScalo;
    private JLabel lbGiorni;
    private JPanel panelPartenza;
    private JLabel labelGiorniPartenza;
    private JSpinner spGiorniAttesa;
    private JLabel labelArrivoPartenza;
    private JPanel panelArrivoPartenza;

    private JFrame frame;

    private ArrayList<CompagniaGUI> codiceCompagnie= new ArrayList<CompagniaGUI>();

    private int i;
    private LocalDate dataIn;
    private LocalDate dataOut;
    private LocalTime timePIn;
    private LocalTime timePOut;
    private LocalTime timePScalo;
    private LocalTime timeAOut;

    public JFrame frameChiamante;
    private Controller controller;
    private Porto portoiniziale;
    private Porto portofinale;
    private Porto portoscalo;

    private LocalDate giorno;

    public AggiungiCorsa(JFrame frameChiamante, Controller controller,  ArrayList<Imbarcazione> imbarcazioni, ArrayList<Porto> porti, Compagnia compagnia) {
        //parto con la finestra senza le scelte per aggiungere il porto di scalo
        panelScalo.setVisible(false);
        spGiorniScalo.setVisible(false);
        labelScalo.setVisible(false);
        panelArrivoPartenza.setVisible(false);
        panelPartenza.setVisible(false);
        for(Porto p: porti)
        {
            CBPortoIn.addItem(p.getNomePorto()+", "+p.getCitta()+", "+p.getNazione());
            CBPortoOut.addItem(p.getNomePorto()+", "+p.getCitta()+", "+p.getNazione());
            CBPortoScalo.addItem(p.getNomePorto()+", "+p.getCitta()+", "+p.getNazione());
        }
        /*codPortIn=porti.getFirst().getIdPorto();
        codPortOut=porti.getFirst().getIdPorto();
        codPortScalo=porti.getFirst().getIdPorto();*/

        for(i=0;i<=23;i++)
        {
            CBPartenzaOraIn.addItem(i);
            CBPartenzaOraScalo.addItem(i);

            CBArrivoOraIn.addItem(i);
            CBArrivoOraOut.addItem(i);
        }
        for(i=0;i<=59;i++)
        {
            CBPartenzaMinIn.addItem(i);

            CBPartenzaMinScalo.addItem(i);

            CBArrivoMinIn.addItem(i);
            CBArrivoMinOut.addItem(i);
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

        CBStato.addItem("regolare");
        CBStato.addItem("annullato");
        CBStato.addItem("ritardo");

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


        for(Imbarcazione i : imbarcazioni){
            CBImbarcazioni.addItem(i.getNome()+", "+i.getCodice());
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
                double costo=0.0;
                //indica i giorni che devono passare dal porto di partenza per arrivare a quello di arrivo/scalo
                int giorniPartenza=0;
                //questo tra scalo-arrivo, se scalo è selezionato
                int giorniScalo=0;
                //indica i giorni di attesa dalla partenza di scalo per arrivare al porto di arrivo, dopo essere arrivato, dal porto di partenza, a quello di scalo
                int giorniAttesa=0;

                if (!textCodice.getText().equals("") || !tfCosto.getText().equals("") || spGiorniPartenza.equals("") || spGiorniScalo.equals("") || spGiorniAttesa.equals("") ) {
                    try {
                        codice = Integer.parseInt(textCodice.getText());
                        costo= Double.parseDouble(tfCosto.getText());
                        giorniPartenza= (int) spGiorniPartenza.getValue();
                        giorniScalo= (int) spGiorniScalo.getValue();
                        giorniAttesa= (int) spGiorniAttesa.getValue();
                    } catch(NumberFormatException err){
                        JOptionPane.showMessageDialog(null, "inserisci un codice, un giorno o un prezzo numerico");
                    }
                    if(costo<0 || giorniPartenza<0 || giorniScalo<0 || giorniAttesa<0)
                    {
                        JOptionPane.showMessageDialog(null, "inserisci un codice, un giorno o un prezzo numerico positivo");
                    }
                    else if (CBAnnoOut.isEnabled() && CBMeseOut.isEnabled() && CBGiornoOut.isEnabled() && CBAnnoIn.isEnabled() && CBMeseIn.isEnabled() && CBGiornoIn.isEnabled()){
                        //vado a crearmi le due date che rappresentano il range di dati in cui vanno create le corse in base ai giorni settiminali che ho scelto
                        dataIn=LocalDate.of((int) CBAnnoIn.getSelectedItem(), (int) CBMeseIn.getSelectedItem(), (int) CBGiornoIn.getSelectedItem());
                        dataOut=LocalDate.of((int) CBAnnoOut.getSelectedItem(), (int) CBMeseOut.getSelectedItem(), (int) CBGiornoOut.getSelectedItem());

                        if(dataIn.isBefore(dataOut)){
                            //chiamo una funzione in cui mi calcolo tutte le date in base al range delle date e ai giorni selezionati
                            ArrayList<LocalDate> giorni=calcoloDate();
                            //se non c'è nessuna data valida, interrompo, sennò continuo
                            if(!giorni.isEmpty()){
                                portoiniziale=new Porto(
                                        (String) porti.get(CBPortoIn.getSelectedIndex()).getNomePorto(),
                                        (String) porti.get(CBPortoIn.getSelectedIndex()).getCitta(),
                                        (String) porti.get(CBPortoIn.getSelectedIndex()).getNazione(),
                                        porti.get(CBPortoIn.getSelectedIndex()).getIdPorto());

                                portofinale=new Porto(
                                        (String) porti.get(CBPortoOut.getSelectedIndex()).getNomePorto(),
                                        (String) porti.get(CBPortoOut.getSelectedIndex()).getCitta(),
                                        (String) porti.get(CBPortoOut.getSelectedIndex()).getNazione(),
                                        porti.get(CBPortoOut.getSelectedIndex()).getIdPorto());

                                i=1;
                                ArrayList<Percorso> percorsi = new ArrayList<Percorso>();
                                ArrayList<Corsa> corse=new ArrayList<Corsa>();
                                if(scaloCheckBox.isSelected())
                                {
                                    portoscalo=new Porto(
                                            (String) porti.get(CBPortoScalo.getSelectedIndex()).getNomePorto(),
                                            (String) porti.get(CBPortoScalo.getSelectedIndex()).getCitta(),
                                            (String) porti.get(CBPortoScalo.getSelectedIndex()).getNazione(),
                                            porti.get(CBPortoScalo.getSelectedIndex()).getIdPorto());
                                    //essendo uno scalo, dal porto di partenza devo sapere la partenza e arrivo. La partenza dallo scalo può anche essere il giorno dopo
                                    //perciò arrivo di partenza può essere diverso da quello di scalo
                                    timePIn=LocalTime.of((int) CBPartenzaOraIn.getSelectedItem(),(int) CBPartenzaMinIn.getSelectedItem());
                                    timePOut=LocalTime.of((int) CBArrivoOraOut.getSelectedItem(),(int) CBArrivoMinOut.getSelectedItem());

                                    timePScalo=LocalTime.of((int) CBPartenzaOraScalo.getSelectedItem(),(int) CBPartenzaMinScalo.getSelectedItem());

                                    timeAOut=LocalTime.of((int) CBArrivoOraOut.getSelectedItem(),(int) CBArrivoMinOut.getSelectedItem());


                                    //System.out.println(dataIn.getDayOfWeek());

                                    for(LocalDate l : giorni){
                                        //creo la corsa partenza-arrivo
                                        corse.add(new Corsa("C"+codice,costo,textAvviso.getText(),(String) CBStato.getSelectedItem(),imbarcazioni.get(CBImbarcazioni.getSelectedIndex()),compagnia));
                                        //percorso partenza-scalo
                                        percorsi.add(new Percorso(timePIn,timePOut,l,l.plusDays(giorniPartenza),"partenza",portoiniziale,corse.getLast()));
                                        //percorso scalo-arrivo (tenendo conto anche il tempo di attesa)
                                        percorsi.add(new Percorso(timePScalo,timeAOut,l.plusDays(giorniAttesa),l.plusDays(giorniScalo+giorniAttesa),"scalo",portoscalo,corse.getLast()));
                                        //percorso arrivo-arrivo
                                        percorsi.add(new Percorso(timeAOut,timeAOut,l.plusDays(giorniScalo+giorniAttesa),l.plusDays(giorniScalo+giorniAttesa),"arrivo",portofinale,corse.getLast()));

                                        codice++;

                                        //creo la corsa partenza-scalo (con costo dimezzato)
                                        corse.add(new Corsa("C"+codice,costo/2,textAvviso.getText(),(String) CBStato.getSelectedItem(),imbarcazioni.get(CBImbarcazioni.getSelectedIndex()),compagnia));
                                        //percorso partenza-scalo
                                        percorsi.add(new Percorso(timePIn,timePOut,l,l.plusDays(giorniPartenza),"partenza",portoiniziale,corse.getLast()));
                                        //percorso scalo-scalo
                                        percorsi.add(new Percorso(timePScalo,timePScalo,l.plusDays(giorniAttesa),l.plusDays(giorniAttesa),"arrivo",portoscalo,corse.getLast()));

                                        codice++;

                                        //creo la corsa scalo-arrivo (con costo dimezzato)
                                        corse.add(new Corsa("C"+codice,costo/2,textAvviso.getText(),(String) CBStato.getSelectedItem(),imbarcazioni.get(CBImbarcazioni.getSelectedIndex()),compagnia));
                                        //percorso scalo-arrivo
                                        percorsi.add(new Percorso(timePScalo,timeAOut,l.plusDays(giorniAttesa),l.plusDays(giorniScalo+giorniAttesa),"partenza",portoscalo,corse.getLast()));
                                        //percorso arrivo-arrivo
                                        percorsi.add(new Percorso(timeAOut,timeAOut,l.plusDays(giorniScalo+giorniAttesa),l.plusDays(giorniScalo+giorniAttesa),"arrivo",portofinale,corse.getLast()));

                                        codice++;

                                    }
                                    //Compagnia c = controller.loginCompagnia(tFEmail.getText(),tFPassword.getText());

                                    if(controller.AggiungiCorse(percorsi,corse)){
                                        JOptionPane.showMessageDialog(null, "corse aggiunte con successo");
                                        frameChiamante.setVisible(true);
                                        frame.setVisible(false);
                                        frame.dispose();
                                    }else{
                                        JOptionPane.showMessageDialog(null, "errore durante l'inserimento delle corse");

                                    }

                                }
                                else{
                                    timePIn=LocalTime.of((int) CBPartenzaOraIn.getSelectedItem(),(int) CBPartenzaMinIn.getSelectedItem());

                                    timeAOut=LocalTime.of((int) CBArrivoOraOut.getSelectedItem(),(int) CBArrivoMinOut.getSelectedItem());
                                    for(LocalDate l : giorni){
                                        //creo la corsa partenza-arrivo
                                        corse.add(new Corsa("C"+codice,costo,textAvviso.getText(),(String) CBStato.getSelectedItem(),imbarcazioni.get(CBImbarcazioni.getSelectedIndex()),compagnia));
                                        //percorso partenza-arrivo
                                        percorsi.add(new Percorso(timePIn,timeAOut,l,l.plusDays(giorniPartenza),"partenza",portoiniziale,corse.getLast()));
                                        //percorso arrivo-arrivo
                                        percorsi.add(new Percorso(timeAOut,timeAOut,l.plusDays(giorniPartenza),l.plusDays(giorniPartenza),"arrivo",portofinale,corse.getLast()));
                                        codice++;
                                    }
                                    //Compagnia c = controller.loginCompagnia(tFEmail.getText(),tFPassword.getText());
                                    if(controller.AggiungiCorse(percorsi,corse)){
                                        JOptionPane.showMessageDialog(null, "corse aggiunte con successo");
                                        frameChiamante.setVisible(true);
                                        frame.setVisible(false);
                                        frame.dispose();
                                    }else{
                                        JOptionPane.showMessageDialog(null, "errore durante l'inserimento delle corse");
                                    }
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "inserisci almeno un giorno");
                            }

                           /* frameChiamante.setVisible(true);
                            frame.setVisible(false);*/
                        }
                        else if(dataIn.equals(dataOut))
                        {
                            dataIn=LocalDate.of((int) CBAnnoIn.getSelectedItem(), (int) CBMeseIn.getSelectedItem(), (int) CBGiornoIn.getSelectedItem());
                            int conferma=JOptionPane.showConfirmDialog(null, "Attenzione! le due date coincidono, e la giornata inizierà la corse e' "
                                            + dataIn.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ITALIAN)+". \nConfermi lo stesso?");
                            /*
                            -1 se si chiude la finestra
                            0 se si preme Sì
                            1 se si preme No
                            2 se si preme Annulla*/
                            if(conferma==0){
                                portoiniziale=new Porto(
                                        (String) porti.get(CBPortoIn.getSelectedIndex()).getNomePorto(),
                                        (String) porti.get(CBPortoIn.getSelectedIndex()).getCitta(),
                                        (String) porti.get(CBPortoIn.getSelectedIndex()).getNazione(),
                                        porti.get(CBPortoIn.getSelectedIndex()).getIdPorto());

                                portofinale=new Porto(
                                        (String) porti.get(CBPortoOut.getSelectedIndex()).getNomePorto(),
                                        (String) porti.get(CBPortoOut.getSelectedIndex()).getCitta(),
                                        (String) porti.get(CBPortoOut.getSelectedIndex()).getNazione(),
                                        porti.get(CBPortoOut.getSelectedIndex()).getIdPorto());

                                i=1;
                                ArrayList<Percorso> percorsi = new ArrayList<Percorso>();
                                ArrayList<Corsa> corse=new ArrayList<Corsa>();
                                if(scaloCheckBox.isSelected()) {
                                    portoscalo = new Porto(
                                            (String) porti.get(CBPortoScalo.getSelectedIndex()).getNomePorto(),
                                            (String) porti.get(CBPortoScalo.getSelectedIndex()).getCitta(),
                                            (String) porti.get(CBPortoScalo.getSelectedIndex()).getNazione(),
                                            porti.get(CBPortoScalo.getSelectedIndex()).getIdPorto());
                                    //essendo uno scalo, dal porto di partenza devo sapere la partenza e arrivo. La partenza dallo scalo può anche essere il giorno dopo
                                    //perciò arrivo di partenza può essere diverso da quello di scalo
                                    timePIn = LocalTime.of((int) CBPartenzaOraIn.getSelectedItem(), (int) CBPartenzaMinIn.getSelectedItem());
                                    timePOut = LocalTime.of((int) CBArrivoOraOut.getSelectedItem(), (int) CBArrivoMinOut.getSelectedItem());

                                    timePScalo = LocalTime.of((int) CBPartenzaOraScalo.getSelectedItem(), (int) CBPartenzaMinScalo.getSelectedItem());

                                    timeAOut = LocalTime.of((int) CBArrivoOraOut.getSelectedItem(), (int) CBArrivoMinOut.getSelectedItem());

                                    corse.add(new Corsa("C"+codice,costo,textAvviso.getText(),(String) CBStato.getSelectedItem(),imbarcazioni.get(CBImbarcazioni.getSelectedIndex()),compagnia));
                                    //percorso partenza-scalo
                                    percorsi.add(new Percorso(timePIn,timePOut,dataIn,dataIn.plusDays(giorniPartenza),"partenza",portoiniziale,corse.getLast()));
                                    //percorso scalo-arrivo (tenendo conto anche il tempo di attesa)
                                    percorsi.add(new Percorso(timePScalo,timeAOut,dataIn.plusDays(giorniAttesa),dataIn.plusDays(giorniScalo+giorniAttesa),"scalo",portoscalo,corse.getLast()));
                                    //percorso arrivo-arrivo
                                    percorsi.add(new Percorso(timeAOut,timeAOut,dataIn.plusDays(giorniScalo+giorniAttesa),dataIn.plusDays(giorniScalo+giorniAttesa),"arrivo",portofinale,corse.getLast()));

                                    codice++;

                                    //creo la corsa partenza-scalo (con costo dimezzato)
                                    corse.add(new Corsa("C"+codice,costo/2,textAvviso.getText(),(String) CBStato.getSelectedItem(),imbarcazioni.get(CBImbarcazioni.getSelectedIndex()),compagnia));
                                    //percorso partenza-scalo
                                    percorsi.add(new Percorso(timePIn,timePOut,dataIn,dataIn.plusDays(giorniPartenza),"partenza",portoiniziale,corse.getLast()));
                                    //percorso scalo-scalo
                                    percorsi.add(new Percorso(timePScalo,timePScalo,dataIn.plusDays(giorniAttesa),dataIn.plusDays(giorniAttesa),"arrivo",portoscalo,corse.getLast()));

                                    codice++;

                                    //creo la corsa scalo-arrivo (con costo dimezzato)
                                    corse.add(new Corsa("C"+codice,costo/2,textAvviso.getText(),(String) CBStato.getSelectedItem(),imbarcazioni.get(CBImbarcazioni.getSelectedIndex()),compagnia));
                                    //percorso scalo-arrivo
                                    percorsi.add(new Percorso(timePScalo,timeAOut,dataIn.plusDays(giorniAttesa),dataIn.plusDays(giorniScalo+giorniAttesa),"partenza",portoscalo,corse.getLast()));
                                    //percorso arrivo-arrivo
                                    percorsi.add(new Percorso(timeAOut,timeAOut,dataIn.plusDays(giorniScalo+giorniAttesa),dataIn.plusDays(giorniScalo+giorniAttesa),"arrivo",portofinale,corse.getLast()));

                                    if(controller.AggiungiCorse(percorsi,corse)){
                                        JOptionPane.showMessageDialog(null, "corse aggiunte con successo");
                                        frameChiamante.setVisible(true);
                                        frame.setVisible(false);
                                        frame.dispose();
                                    }else{
                                        JOptionPane.showMessageDialog(null, "errore durante l'inserimento delle corse");
                                    }
                                }
                                else{
                                    timePIn=LocalTime.of((int) CBPartenzaOraIn.getSelectedItem(),(int) CBPartenzaMinIn.getSelectedItem());

                                    timeAOut=LocalTime.of((int) CBArrivoOraOut.getSelectedItem(),(int) CBArrivoMinOut.getSelectedItem());

                                    corse.add(new Corsa("C"+codice,costo,textAvviso.getText(),(String) CBStato.getSelectedItem(),imbarcazioni.get(CBImbarcazioni.getSelectedIndex()),compagnia));
                                    //percorso partenza-arrivo
                                    percorsi.add(new Percorso(timePIn,timeAOut,dataIn,dataIn.plusDays(giorniPartenza),"partenza",portoiniziale,corse.getLast()));
                                    //percorso arrivo-arrivo
                                    percorsi.add(new Percorso(timeAOut,timeAOut,dataIn.plusDays(giorniPartenza),dataIn.plusDays(giorniPartenza),"arrivo",portofinale,corse.getLast()));

                                    if(controller.AggiungiCorse(percorsi,corse)){
                                        JOptionPane.showMessageDialog(null, "corse aggiunte con successo");
                                        frameChiamante.setVisible(true);
                                        frame.setVisible(false);
                                        frame.dispose();
                                    }else{
                                        JOptionPane.showMessageDialog(null, "errore durante l'inserimento delle corse");
                                    }
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Inserimento corsa cancellato.");
                                frameChiamante.setVisible(true);
                                frame.setVisible(false);
                                frame.dispose();
                            }
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "inserisci le date correttamente");

                        }

                    }
                    else{
                        JOptionPane.showMessageDialog(null, "inserisci le date");
                    }

                }
                else{
                    JOptionPane.showMessageDialog(null, "inserisci il codice o il prezzo della corsa!");
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
                    spGiorniScalo.setVisible(true);
                    labelScalo.setVisible(true);
                    panelArrivoPartenza.setVisible(true);
                    panelPartenza.setVisible(true);
                    lbGiorni.setForeground(Color.RED);
                    lbGiorni.setText("Quanti giorni devono passare dal porto di PARTENZA a quello di SCALO?");
                }
                else{
                    panelScalo.setVisible(false);
                    spGiorniScalo.setVisible(false);
                    labelScalo.setVisible(false);
                    panelArrivoPartenza.setVisible(false);
                    panelPartenza.setVisible(false);
                    lbGiorni.setForeground(Color.getColor("E9FAFF"));
                    lbGiorni.setText("Quanti giorni devono passare dal porto di PARTENZA a quello di ARRIVO?");
                }
                frame.pack();
                frame.setVisible(true);
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


