package no.kino.gui.adminContent;

import no.kino.domain.Movie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewMovie extends JDialog implements ActionListener {


    public NewMovie(String title) {
        setTitle(title);
        setLayout(new GridLayout(2, 1));
        JPanel newMoviePanel = new JPanel();
        add(newMoviePanel);
        newMoviePanel.setLayout(new GridLayout(3, 2));
        JLabel heading = new JLabel("Legg til en film i systemet.");
        newMoviePanel.add(heading);
        JLabel movieNameLabel = new JLabel("Navn på film:");
        newMoviePanel.add(movieNameLabel);
        JTextField movieName = new JTextField();
        newMoviePanel.add(movieName);

        JPanel buttonPanel = new JPanel();
        add(buttonPanel);
        JButton addMovieButton = new JButton("Legg til film");
        addMovieButton.addActionListener(this);
        buttonPanel.add(addMovieButton);
        JButton closeButton = new JButton("Lukk");
        closeButton.addActionListener(this);
        buttonPanel.add(closeButton);
        setLocation(300, 300);
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void addMovieArrayList(String movieName) {

    }
}