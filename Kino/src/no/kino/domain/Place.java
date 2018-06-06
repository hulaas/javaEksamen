package no.kino.domain;

import java.util.Date;

public class Place {
	private int rowNr;
    private int seatNr;
    private int movieTheaterNr;
    // Konstruktør for Place
    public Place(int rowNr, int seatNr, int movieTheaterNr){
        this.rowNr = rowNr;
        this.seatNr = seatNr;
        this.movieTheaterNr = movieTheaterNr;
        
    }

    
    
    public int getrowNr() { return rowNr; }

    public void setRowNr(int rowNr) { this.rowNr =  rowNr; }

    public int getseatNr() { return seatNr; }

    public void setSeatNr(int seatNr) { this.seatNr = seatNr; }

    public int getMovieTheaterNr() { return movieTheaterNr; }

    public void setMovieTheaterNr(int movieTheaterNr) { this.movieTheaterNr = movieTheaterNr; }
    
    
    
    @Override
    public String toString() {
        return "Place{" +
                "rowNr='" + rowNr + '\'' +
                ", seatNr='" + seatNr + '\'' +
                ", movieTheaterNr='" + movieTheaterNr + '\'' +
                '}';
    }
    
    

}


