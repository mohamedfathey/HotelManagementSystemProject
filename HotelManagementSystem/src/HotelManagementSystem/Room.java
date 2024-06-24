package HotelManagementSystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Room {

    private int id ;
    private int floor ;
    private int capacity ;
    private String type ;
    private String description ;
    private double price ;
    private ArrayList<String>reservedDates;

    public Room(int id, int floor, int capacity, String type, String description, double price) {
        this.id = id;
        this.floor = floor;
        this.capacity = capacity;
        this.type = type;
        this.description = description;
        this.price = price;
        reservedDates = new ArrayList<>();
    }

    public Room() {
        reservedDates = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public void Reserve (LocalDate startDate , LocalDate finishDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (LocalDate date= startDate ; date.isBefore(finishDate); date=date.plusDays(1)){
            String d =date.format(formatter);
            reservedDates.add(d);
        }
    }
    public  boolean isReseved(LocalDate startDate , LocalDate finishDate){
        boolean b= false ;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (LocalDate date= startDate ; date.isBefore(finishDate); date=date.plusDays(1)){
            String d =date.format(formatter);
            if (reservedDates.contains(d)){
                b= true;
                break;
            }
        }
        return  b;

    }
    public void print (){
        System.out.println("id ->> "+ id
        +"\n Floor ->> " + floor +
                "\n Capacity ->> " +capacity+
                "\n Type ->> " +type+
                "\n Description ->> " +description+
                "\n Price ->> "+price
        );

    }
//    rivate int id ;
//    private int floor ;
//    private int capacity ;
//    private String type ;
//    private String description ;
//    private double price ;

}
