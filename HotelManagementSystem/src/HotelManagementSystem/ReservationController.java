package HotelManagementSystem;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


public class ReservationController {
    private static DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void createNewReservation(ArrayList<Guest>guests,ArrayList<Room>rooms, ArrayList<Reservation>reservations, Scanner scanner){
        System.out.println("Enter arrival date (yyyy-MM-dd) :");
        String arrDate = scanner.next();
        System.out.println("Enter Departure date (yyyy-MM-dd)");
        String depDate = scanner.next();
        System.out.println("Enter guest Id (int) : \n TO Search guest by name");
        int guestId = scanner.nextInt();
        if (guestId==-1){
            GuestController.searchGuestByName(guests,scanner);
            System.out.println("Enter guest Id (int) :");
            guestId = scanner.nextInt();
        }
        System.out.println("Enter Room Id (int) : \n -1 To Show All Room");
        int roomId =  scanner.nextInt();
        if (roomId == -1){
            RoomsCotroller.showAllRooms(rooms);
            System.out.println("Enter Room Id (int) :");
            roomId =scanner.nextInt();
        }
        LocalDate arrivalDate = LocalDate.parse(arrDate,formatter);
        LocalDate depertureDate = LocalDate.parse(depDate,formatter);

        Room room = RoomsCotroller.getRoomById(roomId,rooms);
        Guest guest = guests.get(guestId);
        if (room.isReseved(arrivalDate,depertureDate)){
            System.out.println("This room is reserved !");
            return;
        }
        else  {
            int day = Period.between(arrivalDate,depertureDate).getDays();
            double sum = day*room.getPrice();
            double total = sum - sum*guest.getDiscount()/100;
            System.out.println("Total before discount == " +sum);
            System.out.println("Total after discount == " + total);
            System.out.println("Will you pay now ? \n 1 Yas ----- 2 No");
            int j = scanner.nextInt();
            String status ;
            if (j==1){
                status = "Paid";
            }
            else {
                status = "Reserves";
            }
            Reservation r = new Reservation(arrivalDate,depertureDate,total,status,guest,room);

            reservations.add(r);
            r.print();
            System.out.println();
        }
    }

    public static void showAllReservation (ArrayList<Reservation>reservations , Scanner scanner){
        for (Reservation r : reservations) {
            System.out.println("\n ----------------------- \n");
            System.out.println("Id --= " + reservations.indexOf(r));
            System.out.println(" Arrival Date --= " + r.getArrivalDateToString());
            System.out.println(" Departure Date --= " + r.getDepatureDateToString());
            System.out.println("Guest Name --= " + r.getGuest().getName());
            System.out.println("Room Id --= " + r.getRoom().getId());
            System.out.println("Prie --="  + r.getPrice());
            System.out.println("Stutus -= "+r.getStatus());
            System.out.println("\n ------------------------------\n");
        }
    }
    public static  void  getReservationByGuestName (ArrayList<Reservation>reservations,Scanner scanner){
        System.out.println("Enter Guest Name ");
        String guestName =  scanner.next();
        for(Reservation r : reservations){
            String name = r.getGuest().getName();
            if (guestName.equals(name))r.print();
        }
    }

    public static  void  getReservationByGuestId (ArrayList<Reservation>reservations,Scanner scanner){
        System.out.println("Enter Guest Id ");
        int guestId =  scanner.nextInt();
        for(Reservation r : reservations){
            int Id = r.getGuest().getId();
            if (guestId==Id)r.print();
        }
    }
    public static void editReservatin (ArrayList<Guest>guests,ArrayList<Room>rooms,ArrayList<Reservation>reservations, Scanner scanner){
        System.out.println("Enter reservation id (int): \n -1 to show all reservation ids");
        int id = scanner.nextInt();
        if (id==-1){
            showAllReservation(reservations,scanner);
            System.out.println("Enter reservation id (int): ");
            id = scanner.nextInt();
        }
        Reservation reservation = reservations.get(id);

        System.out.println("Enter arrival date (yyyy-MM-dd) : \n -1 to keep it");
        String arrDate =scanner.next();
        if (arrDate.equals(-1))arrDate=reservation.getArrivalDateToString();

        System.out.println("Enter Departure date (yyyy-MM-dd) : \n -1 to keep it");
        String depDate =scanner.next();
        if (depDate.equals(-1))depDate=reservation.getDepatureDateToString();

        System.out.println("Enter room id (int) : \n -1 to keep it \n -2 to show all rooms");
        int roomId =scanner.nextInt();
        if (roomId==-1)roomId=reservation.getRoom().getId();
        else if (roomId==-2) {
            RoomsCotroller.showAllRooms(rooms);
            System.out.println("Enter room (int) :");
            roomId = scanner.nextInt();
        }

        LocalDate arrivalDate = LocalDate.parse(arrDate,formatter);
        LocalDate depertureDate = LocalDate.parse(depDate,formatter);

        Room room = RoomsCotroller.getRoomById(roomId,rooms);
        Guest guest= reservation.getGuest();
        if (room.isReseved(arrivalDate,depertureDate)){
            System.out.println("This room is reserved !");
            return;
        }
        else  {
            int day = Period.between(arrivalDate,depertureDate).getDays();
            double sum = day*room.getPrice();
            double total = sum - sum*guest.getDiscount()/100;
            System.out.println("Total before discount == " +sum);
            System.out.println("Total after discount == " + total);
            System.out.println("Will you pay now ? \n 1 Yas ----- 2 No");
            int j = scanner.nextInt();
            String status ;
            if (j==1){
                status = "Paid";
            }
            else {
                status = "Reserves";
            }
            reservation.setArrivalDate(arrivalDate);
            reservation.setDepartureDate(depertureDate);
            reservation.setRoom(room);
            reservation.setStatus(status);
            reservation.setPrice(total);
            reservations.set(id,reservation);
            reservation.print();
            System.out.println();
        }
    }

    public static void payReservation (ArrayList<Reservation>reservations, Scanner scanner){
        System.out.println("Enter reservation id (int) : \n -1 to show all reservation id ");
        int reservationId = scanner.nextInt();
        if (reservationId == -1 ){
            showAllReservation(reservations,scanner);
            System.out.println("Enter reservation id (int) :");
            reservationId = scanner.nextInt();
        }
        Reservation reservation = reservations.get(reservationId);
        if (reservation.getStatus().equals("Reserves")){
            reservation.setStatus("Paid");
            System.out.println("Reservation paid successfully!");
        }else {
            System.out.println("This reservation is already paid ");
        }
    }

}
