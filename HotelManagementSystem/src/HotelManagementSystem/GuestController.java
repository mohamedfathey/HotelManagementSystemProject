package HotelManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class GuestController {
    public static void addGuest (ArrayList<Guest>guests , Scanner scanner){
        System.out.println("Enter guest name ==");
        String name = scanner.next();
        System.out.println("Enter guest email ==");
        String email = scanner.next();
        System.out.println("Enter discount (int)");
        int discount = scanner.nextInt();
        int id = guests.size();
        Guest guest = new Guest(id,name,email,discount);
        guests.add(guest);
        System.out.println("Guest added successfully - _ -");
        System.out.println();
    }

    public static void showGuest (ArrayList<Guest>guests){
        for (Guest g :guests){
            System.out.println("__________________");
            g.print();
            System.out.println("____________________");
        }
    }

    public static void searchGuestByName(ArrayList<Guest>guests,Scanner scanner){
        System.out.println("Enter Your Name");
        String name = scanner.next();
        for (Guest guest : guests){
            if (guest.getName().equals(name)) guest.print();
        }
    }

    public static void editGuest (ArrayList<Guest>guests ,Scanner scanner){
        System.out.println("Enter id (int) : \n -1 to search by name");
        int id = scanner.nextInt();
        if (id == -1 ){
            searchGuestByName(guests,scanner);
            System.out.println("Enter id (int) :");
            id = scanner.nextInt();
        }
        Guest guest = guests.get(id);
        System.out.println("Enter Name : \n -1 to Keep is");
        String name = scanner.next();
        if (name.equals(-1)) name=guest.getName();

        System.out.println("Enter Email : \n -1 to Keep it ");
        String  email = scanner.next();
        if (email.equals(-1))email=guest.getEmail();

        System.out.println("Enter Discount : \n -1 to Keep it");
        int discount = scanner.nextInt();
        if (discount==-1)discount=guest.getDiscount();

        guest.setName(name);
        guest.setEmail(email);
        guest.setDiscount(discount);
        guests.set(id,guest);

    }



}
