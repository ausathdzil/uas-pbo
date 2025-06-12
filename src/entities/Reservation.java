package entities;

public class Reservation {
    private int reservationNumber;
    private Customer customer;
    private Room room;
    private int checkInDate;
    private int checkOutDate;
    private int totalPrice;

    public Reservation(Customer customer, Room room, int checkInDate, int checkOutDate) {
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalPrice = calculateTotalPrice();
    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(int reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(int checkInDate) {
        this.checkInDate = checkInDate;
    }

    public int getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(int checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
    
    public void displayDetails() {
        System.out.println("Reservation Number: " + reservationNumber);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Room Type: " + room.getRoomNumber());
        System.out.println("Check-In Date: " + checkInDate);
        System.out.println("Check-Out Date: " + checkOutDate);
        System.out.println("Total Price: $" + totalPrice);
    }

    public int calculateTotalPrice() {
        int nights = checkOutDate - checkInDate;
        return nights * room.getPrice();
    }
}
