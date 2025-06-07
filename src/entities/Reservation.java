package entities;

public class Reservation {
    private int reservationNumber;
    private Customer customer;
    private Room room;
    private int checkInDate;
    private int checkOutDate;

    public Reservation(Customer customer, Room room, int checkInDate, int checkOutDate) {
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
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

    public void getTotalPrice() {}

    void displayDetails() {}
}
