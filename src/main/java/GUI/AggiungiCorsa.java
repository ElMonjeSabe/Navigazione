package GUI;

import Controller.Controller;
//importo tutte le classi nel model
import Model.*;


import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;

public class AggiungiCorsa {
    //elementi della gui
    private JPanel panel;
    private JTextField textAvviso;
    private JButton indietroButton;
    private JButton confermaButton;
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
    private JLabel labelArrivoPartenza;
    private JLabel txtPortoIn;
    private JLabel labelGiorniPartenza;
    private JSpinner spGiorniAttesa;
    private JPanel panelArrivoPartenza;

    //costanti che mi serviranno per indicare il tipo di percorso durante la creazioni di oggetti Percorso
    private static final String PARTENZA= "partenza";
    private static final String SCALO = "scalo";
    private static final String DESTINAZIONE = "destinazione";

    //creo l'oggetto JFrame per settare alcune configurazione quali ad esempio la dimensione
    private JFrame frame;
    private Controller controller;
    private int i;

    //sono variabili che mi serviranno per memorizzare tutti le dati che mi servono:
    //dataIn rappresenta la data d'inizio dell'intervello di date per inserire le corse
    private LocalDate dataIn;
    //dataIn rappresenta la data di fine dell'intervello di date per inserire le corse
    private LocalDate dataOut;
    //rappresenta l'orario di partenza dal porto di partenza
    private LocalTime timePIn;
    //rappresenta l'orario di arrivo dal porto di partenza al porto di scalo
    private LocalTime timePOut;
    //rappresenta l'orario di partenza dal porto di scalo
    private LocalTime timePScalo;
    //rappresenta l'orario di arrivo al porto di arrivo, dal porto di partenza/scalo
    private LocalTime timeAOut;

    public JFrame frameChiamante;
    private Porto portoiniziale;
    private Porto portofinale;
    private Porto portoscalo;



    public AggiungiCorsa(JFrame frameChiamante, Controller controller,  ArrayList<Imbarcazione> imbarcazioni, ArrayList<Porto> porti, Compagnia compagnia) {

        this.frameChiamante = frameChiamante;
        this.controller=controller;

        //parto con la finestra senza le scelte per aggiungere il porto di scalo
        panelScalo.setVisible(false);
        spGiorniScalo.setVisible(false);
        labelScalo.setVisible(false);
        panelArrivoPartenza.setVisible(false);
        panelPartenza.setVisible(false);

        //vado a riempire i combobox per selezionare i porti
        for(Porto p: porti)
        {
            CBPortoIn.addItem(p.getNomePorto()+", "+p.getCitta()+", "+p.getNazione());
            CBPortoOut.addItem(p.getNomePorto()+", "+p.getCitta()+", "+p.getNazione());
            CBPortoScalo.addItem(p.getNomePorto()+", "+p.getCitta()+", "+p.getNazione());
        }

        //formatto anche i combobox per gli orari
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

        //configuro il frame
        frame = new JFrame("Aggiungi Corsa");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        //combobox per lo stato della corsa
        CBStato.addItem("regolare");
        CBStato.addItem("annullato");
        CBStato.addItem("ritardo");

        //formatto anche i combobox per selezionare il periodo di date
        CBAnnoOut.setEnabled(false);
        //va scelto prima l'anno, poi il mese e poi il giorno, in modo che la data d'inizio venga prima di quella di fine

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

        //formatto anche il combobox degli imbarcazioni disponibile della compagnia utilizzante
        for(Imbarcazione imb : imbarcazioni){
            CBImbarcazioni.addItem(imb.getNome()+", "+imb.getCodice());
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
                        //controllo se questi valori sono interi
                        codice = Integer.parseInt(textCodice.getText());
                        costo= Double.parseDouble(tfCosto.getText());
                        giorniPartenza= (int) spGiorniPartenza.getValue();
                        giorniScalo= (int) spGiorniScalo.getValue();
                        giorniAttesa= (int) spGiorniAttesa.getValue();
                    } catch(NumberFormatException err){
                        JOptionPane.showMessageDialog(null, "inserisci un codice, un giorno o un prezzo numerico");
                    }
                    if(costo<=0 || giorniPartenza<0 || giorniScalo<0 || giorniAttesa<0 || codice>9999999 || codice<0) //controllo se sono positivi (codice di max 7 cifre)
                    {
                        JOptionPane.showMessageDialog(null, "inserisci un codice, un giorno o un prezzo numerico positivo");
                    }
                    else if (CBAnnoOut.isEnabled() && CBMeseOut.isEnabled() && CBGiornoOut.isEnabled() && CBAnnoIn.isEnabled() && CBMeseIn.isEnabled() && CBGiornoIn.isEnabled()){

                        //vado a crearmi le due date che rappresentano il range di dati in cui vanno create le corse in base ai giorni settiminali che ho scelto nei combobox
                        dataIn=LocalDate.of((int) CBAnnoIn.getSelectedItem(), (int) CBMeseIn.getSelectedItem(), (int) CBGiornoIn.getSelectedItem());
                        dataOut=LocalDate.of((int) CBAnnoOut.getSelectedItem(), (int) CBMeseOut.getSelectedItem(), (int) CBGiornoOut.getSelectedItem());
                        //se l'intervallo comprendo più di un giorno
                        if(dataIn.isBefore(dataOut)){

                            //chiamo una funzione in cui mi calcolo tutte le date in base al range delle date e ai giorni selezionati
                            ArrayList<LocalDate> giorni=calcoloDate();

                            //se non c'è nessuna data valida, interrompo, sennò continuo creando dichiarando il porto iniziale e finale
                            if(!giorni.isEmpty()){
                                portoiniziale=new Porto(
                                        porti.get(CBPortoIn.getSelectedIndex()).getNomePorto(),
                                        porti.get(CBPortoIn.getSelectedIndex()).getCitta(),
                                        porti.get(CBPortoIn.getSelectedIndex()).getNazione(),
                                        porti.get(CBPortoIn.getSelectedIndex()).getIdPorto());

                                portofinale=new Porto(
                                        porti.get(CBPortoOut.getSelectedIndex()).getNomePorto(),
                                        porti.get(CBPortoOut.getSelectedIndex()).getCitta(),
                                        porti.get(CBPortoOut.getSelectedIndex()).getNazione(),
                                        porti.get(CBPortoOut.getSelectedIndex()).getIdPorto());

                                ArrayList<Percorso> percorsi = new ArrayList<Percorso>();
                                ArrayList<Corsa> corse=new ArrayList<Corsa>();
                                //se viene selezionato anche lo scalo, alloco anche il porto di scalo
                                if(scaloCheckBox.isSelected())
                                {
                                    portoscalo=new Porto(
                                            porti.get(CBPortoScalo.getSelectedIndex()).getNomePorto(),
                                            porti.get(CBPortoScalo.getSelectedIndex()).getCitta(),
                                            porti.get(CBPortoScalo.getSelectedIndex()).getNazione(),
                                            porti.get(CBPortoScalo.getSelectedIndex()).getIdPorto());

                                    //essendo uno scalo, dal porto di partenza devo sapere la partenza e arrivo. La partenza dallo scalo può anche essere il giorno dopo
                                    //perciò arrivo di partenza può essere diverso da quello di scalo
                                    timePIn=LocalTime.of((int) CBPartenzaOraIn.getSelectedItem(),(int) CBPartenzaMinIn.getSelectedItem());

                                    timePOut=LocalTime.of((int) CBArrivoOraIn.getSelectedItem(),(int) CBArrivoMinIn.getSelectedItem());
                                    timePScalo=LocalTime.of((int) CBPartenzaOraScalo.getSelectedItem(),(int) CBPartenzaMinScalo.getSelectedItem());

                                    timeAOut=LocalTime.of((int) CBArrivoOraOut.getSelectedItem(),(int) CBArrivoMinOut.getSelectedItem());

                                    for(LocalDate l : giorni){
                                        /*

                                            il codice è formato dall'inizio C, un codice numerico(sempre di 7 caratteri) e un identificativo nel quale:
                                                S0=Indentifica Corsa con partenza-scalo-destinazione (o semplicemente partenza-scalo)
                                                S1=Identifica Sotto-Corsa con partenza-scalo nel caso che S0 indica una corsa con scalo
                                                S2=Identifica sotto-corsa con scalo-destinazione nel caso che S0 indica una corsa con scalo

                                            creo la corsa (con scalo) partenza-arrivo (ovviamente con i relativi percorsi):
                                        */
                                        corse.add(new Corsa("C"+String.format("%07d", codice)+"S0",costo,textAvviso.getText(),(String) CBStato.getSelectedItem(),imbarcazioni.get(CBImbarcazioni.getSelectedIndex()),compagnia));
                                        //percorso partenza-scalo
                                        percorsi.add(new Percorso(timePIn,timePOut,l,l.plusDays(giorniPartenza),PARTENZA,portoiniziale,corse.getLast()));
                                        //percorso scalo-arrivo (tenendo conto anche il tempo di attesa)
                                        percorsi.add(new Percorso(timePScalo,timeAOut,l.plusDays(giorniAttesa),l.plusDays(giorniScalo+giorniAttesa),SCALO,portoscalo,corse.getLast()));
                                        //percorso arrivo-arrivo
                                        percorsi.add(new Percorso(timeAOut,timeAOut,l.plusDays(giorniScalo+giorniAttesa),l.plusDays(giorniScalo+giorniAttesa),DESTINAZIONE,portofinale,corse.getLast()));


                                        //creo la corsa partenza-scalo (con costo dimezzato)
                                        corse.add(new Corsa("C"+String.format("%07d", codice)+"S1",costo/2,textAvviso.getText(),(String) CBStato.getSelectedItem(),imbarcazioni.get(CBImbarcazioni.getSelectedIndex()),compagnia));
                                        //percorso partenza-scalo
                                        percorsi.add(new Percorso(timePIn,timePOut,l,l.plusDays(giorniPartenza),PARTENZA,portoiniziale,corse.getLast()));
                                        //percorso scalo-scalo
                                        percorsi.add(new Percorso(timePScalo,timePScalo,l.plusDays(giorniAttesa),l.plusDays(giorniAttesa),DESTINAZIONE,portoscalo,corse.getLast()));


                                        //creo la corsa scalo-arrivo (con costo dimezzato)
                                        corse.add(new Corsa("C"+String.format("%07d", codice)+"S2",costo/2,textAvviso.getText(),(String) CBStato.getSelectedItem(),imbarcazioni.get(CBImbarcazioni.getSelectedIndex()),compagnia));
                                        //percorso scalo-arrivo
                                        percorsi.add(new Percorso(timePScalo,timeAOut,l.plusDays(giorniAttesa),l.plusDays(giorniScalo+giorniAttesa),PARTENZA,portoscalo,corse.getLast()));
                                        //percorso arrivo-arrivo
                                        percorsi.add(new Percorso(timeAOut,timeAOut,l.plusDays(giorniScalo+giorniAttesa),l.plusDays(giorniScalo+giorniAttesa),DESTINAZIONE,portofinale,corse.getLast()));

                                        //incremento il codice numerico di 1, per la data successiva
                                        codice++;

                                    }
                                    if(controller.AggiungiCorse(percorsi,corse)){
                                        //chiamando il controller per aggiungere le corse e i percorsi nel database,
                                        // se è stato inserito tutto correttamente, procedo e ritorno alla schermata di Compagnia
                                        JOptionPane.showMessageDialog(null, "corse aggiunte con successo");
                                        frameChiamante.setVisible(true);
                                        frame.setVisible(false);
                                        frame.dispose();
                                    }else{
                                        //altrimenti segnalo un avviso (nel metodo aggiungicorse faccio un rollback), e rimango nella schermata di aggiungi corse
                                        JOptionPane.showMessageDialog(null, "errore durante l'inserimento delle corse");
                                    }
                                }
                                else{
                                    //caso in cui non ho selezionato il porto di scalo
                                    timePIn=LocalTime.of((int) CBPartenzaOraIn.getSelectedItem(),(int) CBPartenzaMinIn.getSelectedItem());
                                    timeAOut=LocalTime.of((int) CBArrivoOraOut.getSelectedItem(),(int) CBArrivoMinOut.getSelectedItem());

                                    for(LocalDate l : giorni){
                                        //creo la corsa partenza-arrivo
                                        corse.add(new Corsa("C"+String.format("%07d", codice)+"S0",costo,textAvviso.getText(),(String) CBStato.getSelectedItem(),imbarcazioni.get(CBImbarcazioni.getSelectedIndex()),compagnia));
                                        //percorso partenza-arrivo
                                        percorsi.add(new Percorso(timePIn,timeAOut,l,l.plusDays(giorniPartenza),PARTENZA,portoiniziale,corse.getLast()));
                                        //percorso arrivo-arrivo
                                        percorsi.add(new Percorso(timeAOut,timeAOut,l.plusDays(giorniPartenza),l.plusDays(giorniPartenza),DESTINAZIONE,portofinale,corse.getLast()));
                                        codice++;
                                    }
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
                                        porti.get(CBPortoIn.getSelectedIndex()).getNomePorto(),
                                        porti.get(CBPortoIn.getSelectedIndex()).getCitta(),
                                        porti.get(CBPortoIn.getSelectedIndex()).getNazione(),
                                        porti.get(CBPortoIn.getSelectedIndex()).getIdPorto());

                                portofinale=new Porto(
                                        porti.get(CBPortoOut.getSelectedIndex()).getNomePorto(),
                                        porti.get(CBPortoOut.getSelectedIndex()).getCitta(),
                                        porti.get(CBPortoOut.getSelectedIndex()).getNazione(),
                                        porti.get(CBPortoOut.getSelectedIndex()).getIdPorto());

                                ArrayList<Percorso> percorsi = new ArrayList<Percorso>();
                                ArrayList<Corsa> corse=new ArrayList<Corsa>();

                                if(scaloCheckBox.isSelected()) {

                                    portoscalo = new Porto(
                                            porti.get(CBPortoScalo.getSelectedIndex()).getNomePorto(),
                                            porti.get(CBPortoScalo.getSelectedIndex()).getCitta(),
                                            porti.get(CBPortoScalo.getSelectedIndex()).getNazione(),
                                            porti.get(CBPortoScalo.getSelectedIndex()).getIdPorto());

                                    //essendo uno scalo, dal porto di partenza devo sapere la partenza e arrivo. La partenza dallo scalo può anche essere il giorno dopo
                                    //perciò arrivo di partenza può essere diverso da quello di scalo
                                    timePIn = LocalTime.of((int) CBPartenzaOraIn.getSelectedItem(), (int) CBPartenzaMinIn.getSelectedItem());

                                    timePOut=LocalTime.of((int) CBArrivoOraIn.getSelectedItem(),(int) CBArrivoMinIn.getSelectedItem());
                                    timePScalo = LocalTime.of((int) CBPartenzaOraScalo.getSelectedItem(), (int) CBPartenzaMinScalo.getSelectedItem());

                                    timeAOut = LocalTime.of((int) CBArrivoOraOut.getSelectedItem(), (int) CBArrivoMinOut.getSelectedItem());

                                    corse.add(new Corsa("C"+String.format("%07d", codice)+"S0",costo,textAvviso.getText(),(String) CBStato.getSelectedItem(),imbarcazioni.get(CBImbarcazioni.getSelectedIndex()),compagnia));
                                    //percorso partenza-scalo
                                    percorsi.add(new Percorso(timePIn,timePOut,dataIn,dataIn.plusDays(giorniPartenza),PARTENZA,portoiniziale,corse.getLast()));
                                    //percorso scalo-arrivo (tenendo conto anche il tempo di attesa)
                                    percorsi.add(new Percorso(timePScalo,timeAOut,dataIn.plusDays(giorniAttesa),dataIn.plusDays(giorniScalo+giorniAttesa),SCALO,portoscalo,corse.getLast()));
                                    //percorso arrivo-arrivo
                                    percorsi.add(new Percorso(timeAOut,timeAOut,dataIn.plusDays(giorniScalo+giorniAttesa),dataIn.plusDays(giorniScalo+giorniAttesa),DESTINAZIONE,portofinale,corse.getLast()));


                                    //creo la corsa partenza-scalo (con costo dimezzato)
                                    corse.add(new Corsa("C"+String.format("%07d", codice)+"S1",costo/2,textAvviso.getText(),(String) CBStato.getSelectedItem(),imbarcazioni.get(CBImbarcazioni.getSelectedIndex()),compagnia));
                                    //percorso partenza-scalo
                                    percorsi.add(new Percorso(timePIn,timePOut,dataIn,dataIn.plusDays(giorniPartenza),PARTENZA,portoiniziale,corse.getLast()));
                                    //percorso scalo-scalo
                                    percorsi.add(new Percorso(timePScalo,timePScalo,dataIn.plusDays(giorniAttesa),dataIn.plusDays(giorniAttesa),DESTINAZIONE,portoscalo,corse.getLast()));

                                    //creo la corsa scalo-arrivo (con costo dimezzato)
                                    corse.add(new Corsa("C"+String.format("%07d", codice)+"S2",costo/2,textAvviso.getText(),(String) CBStato.getSelectedItem(),imbarcazioni.get(CBImbarcazioni.getSelectedIndex()),compagnia));
                                    //percorso scalo-arrivo
                                    percorsi.add(new Percorso(timePScalo,timeAOut,dataIn.plusDays(giorniAttesa),dataIn.plusDays(giorniScalo+giorniAttesa),PARTENZA,portoscalo,corse.getLast()));
                                    //percorso arrivo-arrivo
                                    percorsi.add(new Percorso(timeAOut,timeAOut,dataIn.plusDays(giorniScalo+giorniAttesa),dataIn.plusDays(giorniScalo+giorniAttesa),DESTINAZIONE,portofinale,corse.getLast()));

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

                                    corse.add(new Corsa("C"+String.format("%07d", codice)+"S0",costo,textAvviso.getText(),(String) CBStato.getSelectedItem(),imbarcazioni.get(CBImbarcazioni.getSelectedIndex()),compagnia));
                                    //percorso partenza-arrivo
                                    percorsi.add(new Percorso(timePIn,timeAOut,dataIn,dataIn.plusDays(giorniPartenza),PARTENZA,portoiniziale,corse.getLast()));
                                    //percorso arrivo-arrivo
                                    percorsi.add(new Percorso(timeAOut,timeAOut,dataIn.plusDays(giorniPartenza),dataIn.plusDays(giorniPartenza),DESTINAZIONE,portofinale,corse.getLast()));

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
                //appena aggiorno l'anno della data d'inizio dell'intervallo per le corse, la data di fine non potrà ovviamente
                //avere un'anno prima di quella selezionata
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
                    //se spunto la checkbox scalo, attivo tutti gli elementi che mi servono per inserire tutti i dati
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
                //ridimensiono il frame
                frame.pack();
                frame.setVisible(true);
            }
        });




        ((AbstractDocument) textAvviso.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {

                if (text == null || (fb.getDocument().getLength() + text.length()) <= 40) { // Se il testo è null, l'utente sta cancellando, quindi permetti l'operazione
                    super.replace(fb, offset, length, text, attrs);
                } else {
                    // Altrimenti, l'utente sta cercando di inserire nuovi caratteri, quindi nega l'operazione
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });





        ((AbstractDocument) textCodice.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {

                if (text == null || (fb.getDocument().getLength() + text.length()) <= 7) { // Se il testo è null, l'utente sta cancellando, quindi permetti l'operazione
                    super.replace(fb, offset, length, text, attrs);
                } else {
                    // Altrimenti, l'utente sta cercando di inserire nuovi caratteri, quindi nega l'operazione
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });

        //Permette di inserire solo numeri nel codce corsa
        textCodice.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();  // Ignora l'evento del tasto
                }

            }
        });






        //limito i numeri di cifre del prezzo
        ((AbstractDocument) tfCosto.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {

                if (text == null || (fb.getDocument().getLength() + text.length()) <= 5) { // Se il testo è null, l'utente sta cancellando, quindi permetti l'operazione
                    super.replace(fb, offset, length, text, attrs);
                } else {
                    // Altrimenti, l'utente sta cercando di inserire nuovi caratteri, quindi nega l'operazione
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });

        //Permette di inserire solo numeri nel prezzo
        tfCosto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();  // Ignora l'evento del tasto
                }

            }
        });

    }

    public JFrame getFrame() {
        return frame;
    }

    //funzione per riempire e calcolare le date in baso al periodo selezionato e alle giornate scelte
    public ArrayList<LocalDate> calcoloDate(){

        ArrayList<LocalDate> days=new ArrayList<LocalDate>();
        LocalDate giorno;
        //vado a controllare ogni checkbox dei giorni della settimana, e in ogni checkbox attivata vado a creare tutte
        //le date, all'interno dell'intervallo di date, nel giorno indicato
        if(lunediCheckBox.isSelected()){
            //se la prima data nella prima settimana col giorno lunedì è al di fuori dell'intervallo, considerando la data della settimana successiva
            if(dataIn.with(DayOfWeek.MONDAY).isBefore(dataIn))
            {
                days.add((dataIn.with(DayOfWeek.MONDAY)).plusDays(7));
            }
            else{
                //altrimenti se è compreso, lo aggiungo semplicemente
                days.add((dataIn.with(DayOfWeek.MONDAY)));
            }
            while ((giorno=days.getLast().plusDays(7)).isBefore(dataOut)) {
                //aggiungo tutti i giorni incrementando di 7 fino a quando supera la data di fine
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


