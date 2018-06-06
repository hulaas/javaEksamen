package no.kino.gui;

import no.kino.control.Control;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Customer extends JDialog implements ActionListener {


    public Customer(String title) throws Exception {
        setTitle(title);
        setLayout(new GridLayout(2, 1));
        JPanel adminPanel = new JPanel();
        add(adminPanel);
        adminPanel.setLayout(new GridLayout(3, 2));
        JPanel buttonPanel = new JPanel();
        add(buttonPanel);
        JButton closeButton = new JButton("Lukk");
        closeButton.addActionListener(this);
        buttonPanel.add(closeButton);
        setLocation(300, 300);

        Control control = new Control();
        control.makeConnection();
//
//        String strSelect = "select * from tblvisning";
//        statement = connection.createStatement();
//        ResultSet rset = connection.executeQuery(strSelect);

        String[] colNames = {"Visningsnummer",
                "Filmnr",
                "Kinosalnr",
                "Dato",
                "Starttid",
                "Pris"};

        Object[][] data = {
                {},

        };

        JTable showingTable = new JTable(data, colNames);
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}