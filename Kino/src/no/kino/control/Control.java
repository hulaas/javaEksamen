package no.kino.control;

import no.kino.domain.*;

import java.sql.*;
import java.util.ArrayList;

public class Control {
    ArrayList<Movie> movieList = new ArrayList<>();
    ArrayList<Showing> showingList = new ArrayList<>();
    ArrayList<Ticket> ticketList = new ArrayList<>();
    ArrayList<Seat> placeList = new ArrayList<>();
    ArrayList<SeatTicket> seatTicketList = new ArrayList<>();
    ArrayList<Cinema> cinemaList = new ArrayList<>();

    private String databasename = "jdbc:mysql://localhost:3306/kino?useSSL=false";
    private static Connection connection;
    private ResultSet result;
    private Statement statement;

    public Control() throws Exception {
        makeConnection();

        fillMovie();
        fillShowing();
        fillTicket();
        fillPlace();
        fillTicketPlace();
        fillCinema();
    }



    public void makeConnection() throws Exception {
        try{
            connection = DriverManager.getConnection(databasename, "Case", "Esac");
            System.out.println("kontakt med databasen!");
        } catch(Exception e) {
            throw new Exception("Kan ikke oppnå kontakt med databasen");
        }
    }

    private void closeConnection() throws Exception {
        try {
            if(connection != null) {
                connection.close();
                result.close();
                statement.close();
            }
        }catch(Exception e) {
            throw new Exception("Kan ikke lukke databaseforbindelse");
        }
    }

    public static boolean checkLoginAdmin(String username, String password) throws Exception {
        String sqlStatement = "SELECT * FROM tbllogin;";
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sqlStatement);
        while(result.next()) {
            String correctUsernameAdmin = result.getString("l_brukernavn");
            String correctPassordAdmin = result.getString("l_pinkode");
            int isAdmin = result.getInt("l_erPlanlegger");
            if(username.equals(correctUsernameAdmin) && password.equals(correctPassordAdmin) && isAdmin == 1) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkLoginStaff(String username, String password) throws SQLException {
        String sqlStatement = "SELECT * FROM tbllogin;";
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sqlStatement);
        while(result.next()) {
            String correctUsernameStaff = result.getString("l_brukernavn");
            String correctPassordStaff = result.getString("l_pinkode");
            int isAdmin = result.getInt("l_erPlanlegger");
            if(username.equals(correctUsernameStaff) && password.equals(correctPassordStaff) && isAdmin == 0) {
                return true;
            }
        }
        return false;
    }

    public void fillMovie() throws Exception {
        String sqlStatement = "SELECT * FROM tblfilm;";
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sqlStatement);
        while(result.next()) {
            int movieNumber = result.getInt("f_filmnr");
            String movieName = result.getString("f_filmnavn");
            Movie movie = new Movie(movieNumber, movieName);
            movieList.add(movie);
        }
    }

    public void fillShowing() throws Exception {
        String sqlStatement = "SELECT * FROM tblvisning;";
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sqlStatement);
        while(result.next()) {
            int showingNumber = result.getInt("v_visningnr");
            int movieNumber = result.getInt("v_filmnr");
            int cinemaNumber = result.getInt("v_kinosalnr");
            Date date = result.getDate("v_dato");
            Time startingTime = result.getTime("v_starttid");
            double price = result.getDouble("v_pris");

            Showing showing = new Showing(showingNumber, movieNumber, cinemaNumber, date, startingTime, price);
            showingList.add(showing);
        }
    }

    public void fillTicket() throws Exception {
        String sqlStatement = "SELECT * FROM tblbillett;";
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sqlStatement);
        while(result.next()) {
            String ticketCode = result.getString("b_billettkode");
            int showingNumber = result.getInt("b_visningsnr");
            int isPaid = result.getInt("b_erBetalt");

            Ticket ticket = new Ticket(ticketCode, showingNumber, isPaid);
            ticketList.add(ticket);
        }
    }

    public void fillPlace() throws Exception {
        String sqlStatement = "SELECT * FROM tblplass;";
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sqlStatement);
        while(result.next()) {
            int rowNumber = result.getInt("p_radnr");
            int seatNumber = result.getInt("p_setenr");
            int cinemaNumber = result.getInt("p_kinosalnr");

            Seat place = new Seat(rowNumber, seatNumber, cinemaNumber);
            placeList.add(place);
        }
    }

    public void fillTicketPlace() throws Exception {
        String sqlStatement = "SELECT * FROM tblplassbillett;";
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sqlStatement);
        while(result.next()) {
            int rowNumber = result.getInt("pb_radnr");
            int seatNumber = result.getInt("pb_setenr");
            int cinemaNumber = result.getInt("pb_kinosalnr");
            String ticketCode = result.getString("pb_billettkode");

            SeatTicket seatTicket = new SeatTicket(rowNumber, seatNumber, cinemaNumber, ticketCode);
            seatTicketList.add(seatTicket);
        }
    }

    public void fillCinema() throws Exception {
        String sqlStatement = "SELECT * FROM tblkinosal;";
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sqlStatement);
        while(result.next()) {
            int cinemaNumber = result.getInt("k_kinosalnr");
            String cinemaName = result.getString("k_kinonavn");
            String cinemaRoomName = result.getString("k_kinosalnavn");

            Cinema cinema = new Cinema(cinemaNumber, cinemaName, cinemaRoomName);
            cinemaList.add(cinema);
        }
    }

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(ArrayList<Movie> movieList) {
        this.movieList = movieList;
    }

    public ArrayList<Showing> getShowingList() {
        return showingList;
    }

    public void setShowingList(ArrayList<Showing> showingList) {
        this.showingList = showingList;
    }

    public ArrayList<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(ArrayList<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public ArrayList<Seat> getPlaceList() {
        return placeList;
    }

    public void setPlaceList(ArrayList<Seat> placeList) {
        this.placeList = placeList;
    }

    public ArrayList<SeatTicket> getSeatTicketList() {
        return seatTicketList;
    }

    public void setSeatTicketList(ArrayList<SeatTicket> seatTicketList) {
        this.seatTicketList = seatTicketList;
    }

    public ArrayList<Cinema> getCinemaList() {
        return cinemaList;
    }

    public void setCinemaList(ArrayList<Cinema> cinemaList) {
        this.cinemaList = cinemaList;
    }
}


