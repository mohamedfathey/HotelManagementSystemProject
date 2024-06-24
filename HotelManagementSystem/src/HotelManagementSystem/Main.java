package HotelManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Room> rooms ;
    private static ArrayList<Guest>guests;
    private static ArrayList<Employee>employees;
    private static ArrayList<Reservation>reservations;
    public static void main(String[] args) {
        System.out.println("Welcome to Hotel Management System");
        rooms = new ArrayList<>();
        guests = new ArrayList<>();
        employees = new ArrayList<>();
        reservations = new ArrayList<>();
        int i =0;
        while (i!=17){
            System.out.println("1. Add new room ");
            System.out.println("2. Show all rooms ");
            System.out.println("3. Edit room data");

            System.out.println("4. Add new guest");
            System.out.println("5. Show all guests");
            System.out.println("6. Search guest by name");
            System.out.println("7. Edit guest data");

            System.out.println("8. Create new reservation");
            System.out.println("9. Show all reservation");
            System.out.println("10. Get reservation by guest name");
            System.out.println("11. Get reservation by guest id");
            System.out.println("12. Edit reservation data");
            System.out.println("13. Pay reservation");

            System.out.println("14. Add new Employee");
            System.out.println("15. Show all Employee");
            System.out.println("16. Edit Employee data");

            System.out.println("17. Quit");

            Scanner scanner = new Scanner(System.in);
             i = scanner.nextInt();
            switch (i){
                case 1 :
                    RoomsCotroller.AddNewRoom(rooms,scanner);
                    break;
                case 2 :
                    RoomsCotroller.showAllRooms(rooms);
                    break;
                case 3:
                    RoomsCotroller.editroom(rooms,scanner);
                    break;
                case 4 :
                    GuestController.addGuest(guests,scanner);
                    break;
                case 5 :
                    GuestController.showGuest(guests);
                    break;
                case 6:
                    GuestController.searchGuestByName(guests,scanner);
                    break;
                case 7:
                    GuestController.editGuest(guests,scanner);
                    break;
                case 8:
                    ReservationController.createNewReservation(guests,rooms, reservations,scanner);
                    break;
                case 9:
                    ReservationController.showAllReservation(reservations,scanner);
                    break;
                case 10 :
                    ReservationController.getReservationByGuestName(reservations,scanner);
                    break;
                case 11 :
                    ReservationController.getReservationByGuestId(reservations,scanner);
                    break;
                case 12 :
                    ReservationController.editReservatin(guests,rooms,reservations,scanner);
                    break;
                case 13 :
                    ReservationController.payReservation(reservations,scanner);
                    break;
                case 14 :
                    EmployeeController.addNewEmployee(employees,scanner);
                    break;
                case 15 :
                    EmployeeController.showAllEmployee(employees);
                    break;
                case 16 :
                    EmployeeController.editEmployeeData(employees,scanner);
                    break;

            }

        }



    }
}