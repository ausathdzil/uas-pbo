import entities.Customer;
import entities.Room;
import entities.RoomDeluxe;
import entities.RoomStandard;
import entities.RoomSuite;
import managers.CustomerManagement;
import managers.ReservationManagement;
import managers.RoomManagement;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerManagement customerManager = new CustomerManagement();
        ReservationManagement reservationManager = new ReservationManagement();
        RoomManagement roomManager = new RoomManagement();

        // Tambahkan kamar ke RoomManagement
        roomManager.addRoom(new RoomStandard(101, 500000, 4));
        roomManager.addRoom(new RoomStandard(102, 500000, 2));
        roomManager.addRoom(new RoomDeluxe(201, 1000000, 2));
        roomManager.addRoom(new RoomDeluxe(202, 1000000, 4));
        roomManager.addRoom(new RoomSuite(301, 2000000, 2));

        int choice;
        do {
            System.out.println("=== Hotel Management System ===");
            System.out.println("1. Customer Management");
            System.out.println("2. Reservation Management");
            System.out.println("3. Room Management");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    customerMenu(scanner, customerManager);
                    break;
                case 2:
                    reservationMenu(scanner, customerManager, reservationManager, roomManager);
                    break;
                case 3:
                    roomMenu(scanner, roomManager);
                    break;
            }
        } while (choice != 0);

        scanner.close();
        System.out.println("Exiting system. Goodbye!");
    }

    private static void customerMenu(Scanner scanner, CustomerManagement customerManager) {
        int custChoice;
        do {
            System.out.println("\n--- Customer Management ---");
            System.out.println("1. Add Customer");
            System.out.println("2. Display All Customers");
            System.out.println("3. Update Customer");
            System.out.println("4. Delete Customer");
            System.out.println("5. Find Customer by ID");
            System.out.println("6. Display Customer Count");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");
            custChoice = scanner.nextInt();
            scanner.nextLine();

            switch (custChoice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phone = scanner.nextLine();
                    Customer customer = new Customer(name, email, phone);
                    customerManager.addCustomer(customer);
                    break;
                case 2:
                    customerManager.displayAllCustomers();
                    break;
                case 3:
                    System.out.print("Enter customer ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new email: ");
                    String newEmail = scanner.nextLine();
                    System.out.print("Enter new phone number: ");
                    String newPhone = scanner.nextLine();
                    customerManager.updateCustomer(updateId, newName, newEmail, newPhone);
                    break;
                case 4:
                    System.out.print("Enter customer ID to delete: ");
                    int deleteId = scanner.nextInt();
                    customerManager.deleteCustomer(deleteId);
                    break;
                case 5:
                    System.out.print("Enter customer ID to find: ");
                    int findId = scanner.nextInt();
                    Customer foundCustomer = customerManager.findCustomerById(findId);
                    if (foundCustomer != null) {
                        foundCustomer.displayDetails();
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;
                case 6:
                    customerManager.displayCustomerCount();
                    break;
            }
        } while (custChoice != 0);
    }

    private static void reservationMenu(Scanner scanner, CustomerManagement customerManager, ReservationManagement reservationManager, RoomManagement roomManager) {
        int resChoice;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        do {
            System.out.println("\n--- Reservation Management ---");
            System.out.println("1. Make Reservation");
            System.out.println("2. Display All Reservations");
            System.out.println("3. Update Reservation");
            System.out.println("4. Cancel Reservation");
            System.out.println("5. Display Reservation Count");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");
            resChoice = scanner.nextInt();
            scanner.nextLine();

            switch (resChoice) {
                case 1:
                    System.out.print("Enter customer ID: ");
                    int customerId = scanner.nextInt();
                    Customer customer = customerManager.findCustomerById(customerId);
                    if (customer == null) {
                        System.out.println("Customer not found.");
                        break;
                    }

                    System.out.println("Available Rooms:");
                    var availableRooms = roomManager.getAvailableRooms();
                    if (availableRooms.isEmpty()) {
                        System.out.println("No available rooms.");
                        break;
                    }
                    for (Room r : availableRooms) {
                        System.out.println("Room Number: " + r.getRoomNumber() + ", Type: " + r.getType() + ", Capacity: " + r.getCapacity() + ", Price: Rp." + r.getPricePerNight());
                    }

                    System.out.print("Enter room number to reserve: ");
                    int roomNumber = scanner.nextInt();
                    Room selectedRoom = roomManager.findRoom(roomNumber);

                    if (selectedRoom == null || !selectedRoom.isAvailable()) {
                        System.out.println("Room not available or does not exist.");
                        break;
                    }

                    System.out.print("Enter check-in date (dd-MM-yyyy): ");
                    scanner.nextLine(); // flush newline
                    String inStr = scanner.nextLine();
                    System.out.print("Enter check-out date (dd-MM-yyyy): ");
                    String outStr = scanner.nextLine();

                    LocalDate checkInDate;
                    LocalDate checkOutDate;

                    try {
                        checkInDate = LocalDate.parse(inStr, formatter);
                        checkOutDate = LocalDate.parse(outStr, formatter);
                        if (!checkOutDate.isAfter(checkInDate)) {
                            System.out.println("Check-out date must be after check-in date.");
                            break;
                        }
                    } catch (DateTimeParseException e) {
                        System.out.println("Incorrect date format. Use dd-MM-yyyy.");
                        break;
                    }
                    reservationManager.makeReservation(customer, selectedRoom, checkInDate, checkOutDate);
                    break;

                case 2:
                    reservationManager.displayAllReservations();
                    break;

                case 3:
                    System.out.print("Enter reservation number to update: ");
                    int resNum = scanner.nextInt();

                    System.out.println("Available Rooms:");
                    var rooms = roomManager.getAvailableRooms();
                    for (Room r : rooms) {
                        System.out.println("Room Number: " + r.getRoomNumber() + ", Type: " + r.getType() + ", Capacity: " + r.getCapacity() + ", Price: Rp." + r.getPricePerNight());
                    }

                    System.out.print("Enter new room number: ");
                    int newRoomNum = scanner.nextInt();
                    Room newRoom = roomManager.findRoom(newRoomNum);

                    if (newRoom == null || !newRoom.isAvailable()) {
                        System.out.println("Room not available or does not exist.");
                        break;
                    }

                    System.out.print("Enter new check-in date (dd-MM-yyyy): ");
                    scanner.nextLine(); // flush newline dari input sebelumnya
                    inStr = scanner.nextLine();
                    System.out.print("Enter new check-out date (dd-MM-yyyy): ");
                    outStr = scanner.nextLine();

                    LocalDate newCheckIn;
                    LocalDate newCheckOut;

                    try {
                        newCheckIn = LocalDate.parse(inStr, formatter);
                        newCheckOut = LocalDate.parse(outStr, formatter);
                        if (!newCheckOut.isAfter(newCheckIn)) {
                            System.out.println("Check-out date must be after check-in date.");
                            break;
                        }
                    } catch (DateTimeParseException e) {
                        System.out.println("Incorrect date format. Use dd-MM-yyyy.");
                        break;
                    }
                    reservationManager.updateReservation(resNum, newRoom, newCheckIn, newCheckOut);
                    break;

                case 4:
                    System.out.print("Enter reservation number to cancel: ");
                    int cancelNum = scanner.nextInt();
                    reservationManager.cancelReservation(cancelNum);
                    break;

                case 5:
                    reservationManager.displayReservationCount();
                    break;
            }
        } while (resChoice != 0);
    }

    public static void roomMenu(Scanner scanner, RoomManagement roomManager) {
        int roomChoice;
        do {
            System.out.println("\n--- Room Management ---");
            System.out.println("1. Add Room");
            System.out.println("2. Display All Rooms");
            System.out.println("3. Update Room");
            System.out.println("4. Remove Room");
            System.out.println("5. Display Room Count");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");
            roomChoice = scanner.nextInt();
            scanner.nextLine();

            switch (roomChoice) {
                case 1:
                    System.out.print("Enter room number: ");
                    int roomNum = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter price per night: ");
                    int price = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter capacity: ");
                    int capacity = scanner.nextInt();
                    System.out.print("Room type (1 for standard, 2 for deluxe, 3 for suite): ");
                    int type = scanner.nextInt();
                    scanner.nextLine();
                    switch (type) {
                        case 1:
                            roomManager.addRoom(new RoomStandard(roomNum, price, capacity));
                            break;
                        case 2:
                            roomManager.addRoom(new RoomDeluxe(roomNum, price, capacity));
                            break;
                        case 3:
                            roomManager.addRoom(new RoomSuite(roomNum, price, capacity));
                            break;
                    }
                    break;
                case 2:
                    roomManager.displayRoomList();
                    break;
                case 3:
                    System.out.print("Enter room number to update: ");
                    int updateRoomNum = scanner.nextInt();
                    Room updateRoom = roomManager.findRoom(updateRoomNum);
                    scanner.nextLine();
                    System.out.print("Enter new price per night: ");
                    int newPrice = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new capacity: ");
                    int newCapacity = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter availability (1 for available, 0 for unavailable): ");
                    int availability = scanner.nextInt();
                    switch (availability) {
                        case 1:
                            updateRoom.setAvailable(true);
                            break;
                        case 0:
                            updateRoom.setAvailable(false);
                    }
                    roomManager.updateRoom(updateRoom, newPrice, newCapacity);
                    break;
                case 4:
                    System.out.print("Enter room number to remove: ");
                    int deleteRoomNum = scanner.nextInt();
                    Room selectedRoom = roomManager.findRoom(deleteRoomNum);
                    roomManager.removeRoom(selectedRoom);
                    break;
                case 5:
                    System.out.println("Total number of rooms: " + roomManager.getAllRoomsCount());
                    break;
                case 0:
                    System.out.println("Returning to main menu.");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (roomChoice != 0);
    }
}
