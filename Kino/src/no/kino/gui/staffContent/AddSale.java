package no.kino.gui.staffContent;

import no.kino.control.Control;
import no.kino.domain.Seat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class AddSale extends JDialog implements ActionListener {
    private Control control = new Control();
    private JTextField inputVisningsNr;
    private JButton executeButton, closeButton;
    private ArrayList<Seat> orders = new ArrayList<>();

    public AddSale(String title) throws Exception {
        setTitle(title);
        setLayout(new GridLayout(25, 15));

        //JPanel
        JPanel staffPanel = new JPanel();
        add(staffPanel);
        staffPanel.setLayout(new GridLayout(3, 2));



        //JPanel for buttons
        JPanel buttonPanel = new JPanel();
        add(buttonPanel);

        //VisningNr
        inputVisningsNr = new JTextField("VisningsNr");
        inputVisningsNr.addActionListener(this);
        buttonPanel.add(inputVisningsNr);

        //Execute-button
        executeButton = new JButton("Utfør");
        executeButton.addActionListener(this);
        buttonPanel.add(executeButton);

        //Closing the window
        closeButton = new JButton("Lukk");
        closeButton.addActionListener(this);
        buttonPanel.add(closeButton);
        setLocation(300, 300);
        pack();
        createSeatMap(203);
    }


    public void actionPerformed(ActionEvent event) {
        String choice = event.getActionCommand();
        try {
            if (choice.equals("Utfør")) {
                createOrder();
            } else if (choice.equals("Lukk")) {
                System.exit(0);
            }
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void createOrder() {
        orders.clear();
        ArrayList<Seat> placeList = control.getPlaceList();
        for(Seat p : placeList) {
            if(p.isSet()) {
                orders.add(p);
            }
        }
        System.out.println(orders);
    }

    public void createSeatMap(int cinema) {
        ArrayList<Seat> placeList = control.getPlaceList();
        for(Seat p : placeList) {
            if(p.getMovieTheaterNr() == cinema){
                JCheckBox test = new JCheckBox();
                add(test);
                test.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        p.setSet(!p.isSet());
                        System.out.println(p.getseatNr());
                    }
                });
                /*if(clicked) {
                    p.isSet() != p.isSet();
                }*/

            }
        }
    }
}
