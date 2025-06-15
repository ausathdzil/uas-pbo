package entities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reservation {
    private static int counter = 1;

    private int reservationNumber;
    private Customer customer;
    private Room room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int totalPrice;

    public Reservation(Customer customer, Room room, LocalDate checkInDate, LocalDate checkOutDate) {
        this.reservationNumber = counter++;
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalPrice = calculateTotalPrice();
    }

    public int calculateTotalPrice() {
        long nights = ChronoUnit.DAYS.between(checkInDate, checkOutDate);
        return (int) nights * room.getPricePerNight();
    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
        this.totalPrice = calculateTotalPrice();
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
        this.totalPrice = calculateTotalPrice();
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
        this.totalPrice = calculateTotalPrice();
    }

    public void displayDetails() {
        System.out.println("Reservation Number : " + reservationNumber);
        System.out.println("Customer Name      : " + customer.getName());
        System.out.println("Room Number        : " + room.getRoomNumber());
        System.out.println("Room Type          : " + room.getType());
        System.out.println("Check-in Date      : " + checkInDate);
        System.out.println("Check-out Date     : " + checkOutDate);
        System.out.println("Total Price        : Rp. " + totalPrice);
    }
}
