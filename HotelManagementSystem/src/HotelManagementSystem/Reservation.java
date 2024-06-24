package HotelManagementSystem;

import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Reservation {
    private LocalDate arrivalDate ;
    private LocalDate departureDate;
    private double price;
    private String status ;
    private Guest guest ;
    private Room room;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd");

    public Reservation(LocalDate arrivalDate, LocalDate departureDate, double price, String status, Guest guest, Room room) {
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.price = price;
        this.status = status;
        this.guest = guest;
        this.room = room;
    }

    public Reservation() {
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }
    public  String getArrivalDateToString(){
        return arrivalDate.format(formatter);
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }
    public String getDepatureDateToString(){
        return  departureDate.format(formatter);
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public Guest getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
    public void print (){
        int days = Period.between(arrivalDate,departureDate).getDays();
        System.out.println("\n ----------------------"+
        "Arrival Date -= " +arrivalDate +"\n"+
                "Departure Date -= "+departureDate + "\n"+
                  days+ " Days" + "\n");
        System.out.println("%%%%  Guest Information   %%%% ");
        guest.print();
        System.out.println(" $$$$   Room Information   $$$$");
        room.print();
        System.out.println("********************\n");
        double price =  days*room.getPrice();
        System.out.println("Price -= " + price);
        System.out.println("------------------------------");
        System.out.println("Total after discount -= " +this.price);
        System.out.println("--------------------------------\n");

    }
}
