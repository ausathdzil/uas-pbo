//disini harusnya ada package src, cuma pas gue pake gatau knp error

import entities.*;
import managers.*;
import java.util.ArrayList;

public class Main {
    private static CustomerManagement customerManager = new CustomerManagement();
    private static RoomManagement roomManager = new RoomManagement();
    private static ReservationManagement reservationManager = new ReservationManagement();
    
    public static void main(String[] args) {
        System.out.println("Hotel Management System");
        
        initializeSampleData();
        displaySystemStatus();
    }
    
    private static void initializeSampleData() {
        // Ini sample data room
        roomManager.addRoom(new RoomStandard(101, 500000, 2));
        roomManager.addRoom(new RoomStandard(102, 500000, 2));
        roomManager.addRoom(new RoomDeluxe(201, 1000000, 2));
        roomManager.addRoom(new RoomDeluxe(202, 1000000, 4));
        roomManager.addRoom(new RoomSuite(301, 2000000, 4));
        
        ArrayList<Room> rooms = new ArrayList<>();
        roomManager.displayRoomList();
        
        for (int roomNumber : new int[]{101, 102, 201, 202, 301}) {
            Room room = findRoomByNumber(roomNumber);
            if (room != null) {
                room.setAvailable(true);
            }
        }
        
        //ini sample data customer
        Customer customer1 = new Customer("John Doe", "john@example.com", "1234567890");
        Customer customer2 = new Customer("Jane Smith", "jane@example.com", "0987654321");
        customerManager.addCustomer(customer1);
        customerManager.addCustomer(customer2);
    }
    
    private static Room findRoomByNumber(int roomNumber) {
        for (Room room : getRoomsFromManager()) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }
    
    private static ArrayList<Room> getRoomsFromManager() {
        try {
            java.lang.reflect.Field field = RoomManagement.class.getDeclaredField("roomList");
            field.setAccessible(true);
            return (ArrayList<Room>) field.get(roomManager);
        } catch (Exception e) {
            System.out.println("Error accessing roomList: " + e.getMessage());
            return new ArrayList<>();
        }
    }
    
    private static void displaySystemStatus() {
        System.out.println("\n--- System Status ---");
        System.out.println("Total Customers: " + customerManager.getCustomerCount());
        
        int roomCount = getRoomsFromManager().size();
        System.out.println("Total Rooms: " + roomCount);
        
        System.out.println("Total Reservations: " + reservationManager.getReservationCount());
    }
    
    public static boolean isValidDate(int date) {
        String dateStr = String.valueOf(date);
        if (dateStr.length() != 8) return false;
        
        int year = Integer.parseInt(dateStr.substring(0, 4));
        int month = Integer.parseInt(dateStr.substring(4, 6));
        int day = Integer.parseInt(dateStr.substring(6, 8));
        
        if (year < 2020 || year > 2100) return false;
        if (month < 1 || month > 12) return false;
        
        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            daysInMonth[2] = 29;
        }
        
        return day >= 1 && day <= daysInMonth[month];
    }
    
    public static int calculateDaysBetween(int checkInDate, int checkOutDate) {
        if (checkOutDate <= checkInDate) return 0;
        
        String inStr = String.valueOf(checkInDate);
        String outStr = String.valueOf(checkOutDate);
        
        int inYear = Integer.parseInt(inStr.substring(0, 4));
        int inMonth = Integer.parseInt(inStr.substring(4, 6));
        int inDay = Integer.parseInt(inStr.substring(6, 8));
        
        int outYear = Integer.parseInt(outStr.substring(0, 4));
        int outMonth = Integer.parseInt(outStr.substring(4, 6));
        int outDay = Integer.parseInt(outStr.substring(6, 8));
        
        int yearDiff = outYear - inYear;
        int monthDiff = outMonth - inMonth;
        int dayDiff = outDay - inDay;
        
        return yearDiff * 365 + monthDiff * 30 + dayDiff;
    }
    
    public static String formatDate(int date) {
        String dateStr = String.valueOf(date);
        if (dateStr.length() != 8) return "Invalid date";
        
        String year = dateStr.substring(0, 4);
        String month = dateStr.substring(4, 6);
        String day = dateStr.substring(6, 8);
        
        return year + "-" + month + "-" + day;
    }
    
    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }
    
    public static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber != null && phoneNumber.matches("\\d{10,15}");
    }
    
    public static boolean isValidRoomNumber(int roomNumber) {
        return roomNumber >= 100 && roomNumber < 1000;
    }
    
    public static boolean isValidPrice(int price) {
        return price > 0;
    }
    
    public static boolean isValidCapacity(int capacity) {
        return capacity > 0 && capacity <= 10;
    }
    
    public static CustomerManagement getCustomerManager() {
        return customerManager;
    }
    
    public static RoomManagement getRoomManager() {
        return roomManager;
    }
    
    public static ReservationManagement getReservationManager() {
        return reservationManager;
    }
}