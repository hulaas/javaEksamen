package no.kino.gui.staffContent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetPayment extends JDialog implements ActionListener {
    private JTextField inputBillettNr;
    private JButton executeButton, closeButton;
    private JRadioButton isPaid, notPaid;

    public SetPayment(String title) {
        setTitle(title);
        setLocation(300, 300);
        setLayout(new FlowLayout());

        //JPanel for "inputBillettNr"
        JPanel showingPanel = new JPanel();
        add(showingPanel);
        showingPanel.setLayout(new GridLayout(3, 2));

        //Radiobutton
        ButtonGroup group = new ButtonGroup();
        isPaid = new JRadioButton("Betalt");
        isPaid.addActionListener(this);
        group.add(isPaid);
        notPaid = new JRadioButton("Ikke betalt");
        notPaid.addActionListener(this);
        group.add(notPaid);
        add(isPaid);
        add(notPaid);

        //JPanel for buttons
        JPanel buttonPanel = new JPanel();
        add(buttonPanel);

        //JLabel, JTextfield, Layout for "BillettNr"
        showingPanel.add(new JLabel("BillettNr:"));
        inputBillettNr = new JTextField();
        inputBillettNr.addActionListener(this);
        showingPanel.add(inputBillettNr);
        showingPanel.setLayout(new GridLayout(2,2));

        //Execute button
        executeButton = new JButton("Utfør");
        executeButton.addActionListener(this);
        buttonPanel.add(executeButton);

        //Close this child window
        closeButton = new JButton("Lukk");
        closeButton.addActionListener(this);
        buttonPanel.add(closeButton);
        buttonPanel.setLayout(new GridLayout(2,2));

        pack();
    }

    public void actionPerformed(ActionEvent event) {
        String choice = event.getActionCommand();
        try {
            if (choice.equals("Utfør")) {
                System.out.println("halla");
            } else if (choice.equals("Lukk")) {
                System.exit(0);
            }
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
