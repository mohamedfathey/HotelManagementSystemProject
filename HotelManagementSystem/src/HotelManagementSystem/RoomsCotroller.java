package HotelManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class RoomsCotroller {

        public static void AddNewRoom (ArrayList<Room> rooms , Scanner scanner){
            System.out.println("Enter Floor (int)");
            int floor = scanner.nextInt();
            System.out.println("Enter capacity (int)");
            int capacity = scanner.nextInt();
            System.out.println("enter type (String)");
            String type = scanner.next();
            System.out.println("Enter description (String)");
            String description = scanner.next();
            System.out.println("Enter price (Double)");
            double price = scanner.nextDouble();
            int id = 1000+rooms.size();
            Room room= new Room(id,floor,capacity,type,description,price);
            rooms.add(room);
            System.out.println("Room added successfully - _ -");
            System.out.println();
        }
        public static void showAllRooms (ArrayList<Room>rooms){
            for (Room room:rooms){
                System.out.println("___________________");
                room.print();
                System.out.println("___________________");
                System.out.println();
            }
        }
        public static void editroom ( ArrayList<Room>rooms , Scanner scanner){
            System.out.println("Enter room id \n -1 to Show all rooms");
            int id = scanner.nextInt();

            if (id ==-1){
                showAllRooms(rooms);
                System.out.println("Enter room id \n -1 to Show all rooms");
                int j = scanner.nextInt();
                id = j ;
            }
            Room room = getRoomById(id , rooms);

            System.out.println("Enter floor (int) : \n -1 to kee it");
            int floor = scanner.nextInt();
            if (floor==-1) floor=room.getFloor();

            System.out.println("Enter Capacity(int) : \n -1 to kee it");
            int capacity = scanner.nextInt();
            if (capacity==-1) capacity=room.getCapacity();

            System.out.println("Enter room type (String)  : \n done to kee it");
            String type = scanner.next();
            if (type=="done")  type = room.getType();

            System.out.println("Enter room desception (String) : \n done to kee it");
            String description= scanner.next();
            if (description =="done") description=room.getDescription();

            System.out.println("Enter room price (int) : \n" +
                    " -1 to kee it");
            double price = scanner.nextDouble();
            if (price==-1) price=room.getPrice();

            room.setFloor(floor);
            room.setCapacity(capacity);
            room.setType(type);
            room.setDescription(description);
            room.setPrice(price);
            for (Room r : rooms) {
                if (r.getId()==id){
                    r=room;
                    break;
                }
            }
            }

        public static Room getRoomById (int id , ArrayList<Room>rooms){
            Room room = new Room();
            for (Room r : rooms){
                if (r.getId() == id){
                    room = r ;
                    break;
                }
            }
            return room;
        }

    }


