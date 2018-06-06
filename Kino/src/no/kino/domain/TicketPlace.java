package no.kino.domain;

public class TicketPlace {
    private int rowNr;
    private int seatNr;
    private int moviePlaceNr;
    private String ticketCode;

    public TicketPlace(int rowNr, int seatNr, int moviePlaceNr, String ticketCode) {
        this.rowNr = rowNr;
        this.seatNr = seatNr;
        this.moviePlaceNr = moviePlaceNr;
        this.ticketCode = ticketCode;
    }

    private TicketPlace newTicketplace(int rowNr, int seatNr, int moviePlaceNr, String ticketCode){
        return new TicketPlace(rowNr, seatNr, moviePlaceNr, ticketCode);
    }

    public int getRowNr() {
        return rowNr;
    }

    public void setRowNr(int rowNr) {
        this.rowNr = rowNr;
    }

    public int getSeatNr() {
        return seatNr;
    }

    public void setSeatNr(int seatNr) {
        this.seatNr = seatNr;
    }

    public int getMoviePlaceNr() {
        return moviePlaceNr;
    }

    public void setMoviePlaceNr(int moviePlaceNr) {
        this.moviePlaceNr = moviePlaceNr;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;

    }

    @Override
    public String toString() {
        return "ticketPlace{" +
                "rowNr=" + rowNr +
                ", seatNr=" + seatNr +
                ", moviePlaceNr=" + moviePlaceNr +
                ", ticketCode='" + ticketCode + '\'' +
                '}';
    }
}
