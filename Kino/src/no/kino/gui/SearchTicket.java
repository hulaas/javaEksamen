package no.kino.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import no.kino.control.Control;

public class SearchTicket extends JDialog implements ActionListener {
    DefaultTableModel tableModel;
    JTable searchtable;
    JScrollPane scrollPane;
    private JFrame frame;
    private JTextField txtTicket;
    private JButton search, avbryt;
    private final String[] kolonnenavn = {"Ticket:","VisningsNr:","ErBetalt:"};
    private final Object[][] defaulttabell = new Object[2][3];
    private JPanel tableWindow, searchPanel, buttonpanel;
    Staff parentwindow;


    public void Search() {
        setLayout(new GridLayout(3,1));
        tableWindow = new JPanel();
        add(tableWindow, BorderLayout.NORTH);//
        searchPanel = new JPanel();
        add(searchPanel, BorderLayout.CENTER);
        buttonpanel = new JPanel();
        add(buttonpanel, BorderLayout.SOUTH);
        searchPanel.setLayout(new GridLayout(5,1));
        tableModel = new DefaultTableModel(defaulttabell, kolonnenavn);
        searchtable = new JTable(tableModel);
        scrollPane = new JScrollPane(searchtable);
        tableWindow.add(scrollPane);
        searchPanel.add(new JLabel("Billett Nummer:"));
        txtTicket = new JTextField();
        searchPanel.add(txtTicket);
        search = new JButton("Søk");
        search.addActionListener(this);
        buttonpanel.add(search);
        avbryt = new JButton("Avbryt");
        avbryt.addActionListener(this);
        buttonpanel.add(avbryt);
        pack();
        setSize(470, 400);
    }

    public void actionPerformed(ActionEvent evt) {
        String valg = evt.getActionCommand();
        if(valg.equals("Søk")) fillSearch();
        else setVisible(false);
    }


    public void fillSearch(){
        Object[][] tabell = searchList();
        searchtable.setModel(new DefaultTableModel(tabell,kolonnenavn));
    }

    public Object[][] searchList() {
        Object[][] innhold = new Object[1][3];
        int teller = 0;
        String epost = txtTicket.getText();
        try {
            ResultSet list = Control.searchTicket(ticketNumber);
            while(list.next()) {
                String ticketNumber = list.getString(1);
                String showNumber = list.getString(2);
                String isPaid = list.getString(3);
                innhold[teller][0] = ticketNumber;
                innhold[teller][1] = showNumber;
                innhold[teller][2] = isPaid;
                teller++;
            }
        }catch(Exception e){JOptionPane.showMessageDialog(null, "Klarte ikke opprette tabell");}
        return innhold;
    }


}
