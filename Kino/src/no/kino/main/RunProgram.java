package no.kino.main;

import no.kino.control.Control;
import no.kino.domain.Movie;
import no.kino.gui.Gui;

public class RunProgram {
    public static void main(String[] args) throws Exception {
        Control control = new Control();





        String film = "GOT";

        System.out.println(control.getMovieList());

        Gui window = new Gui("Kinosystem");
        window.setLocation(300,300);
        window.setVisible(true);




    }
}
