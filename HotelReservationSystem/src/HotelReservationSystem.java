import java.util.ArrayList;
import java.util.Scanner;

public class HotelReservationSystem {
    private static ArrayList<Room> rooms = new ArrayList<>();
    private static ArrayList<Reservation> reservations = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeRooms();
        displayMenu();
    }

   
    private static void initializeRooms() {
        rooms.add(new Room(101, "Single", 50.0));
        rooms.add(new Room(102, "Single", 50.0));
        rooms.add(new Room(201, "Double", 80.0));
        rooms.add(new Room(202, "Double", 80.0));
        rooms.add(new Room(301, "Suite", 150.0));
        rooms.add(new Room(302, "Suite", 150.0));
    }

    private static void displayMenu() {
        int choice;
        do {
            System.out.println("\n--- Hotel Reservation System ---");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View Booking Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    viewAvailableRooms();
                    break;
                case 2:
                    makeReservation();
                    break;
                case 3:
                    viewReservations();
                    break;
                case 4:
                    System.out.println("Thank you for using the Hotel Reservation System!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private static void viewAvailableRooms() {
        System.out.println("\nAvailable Rooms:");
        for (Room room : rooms) {
            if (room.isAvailable()) {
                System.out.println(room);
            }
        }
    }

    private static void makeReservation() {
        System.out.print("\nEnter your name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter the category of room (Single/Double/Suite): ");
        String category = scanner.nextLine();
        System.out.print("Enter the number of nights: ");
        int numberOfNights = scanner.nextInt();

        Room selectedRoom = null;
        for (Room room : rooms) {
            if (room.isAvailable() && room.getCategory().equalsIgnoreCase(category)) {
                selectedRoom = room;
                break;
            }
        }

        if (selectedRoom != null) {
            selectedRoom.setAvailable(false); 
            double totalCost = selectedRoom.getPrice() * numberOfNights;
            reservations.add(new Reservation(customerName, selectedRoom.getRoomNumber(), numberOfNights, totalCost));
            System.out.println("Reservation successful! Total cost: $" + totalCost);
        } else {
            System.out.println("No available rooms in the selected category.");
        }
    }

    private static void viewReservations() {
        System.out.println("\nBooking Details:");
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            for (Reservation reservation : reservations) {
                System.out.println(reservation);
                System.out.println("-------------------");
            }
        }
    }
}