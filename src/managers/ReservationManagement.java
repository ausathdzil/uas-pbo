package managers;

import entities.Reservation;
import entities.Customer;
import entities.Room;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class ReservationManagement {
    private ArrayList<Reservation> reservationList = new ArrayList<>();

    public boolean makeReservation(Customer customer, Room room, LocalDate checkInDate, LocalDate checkOutDate) {
        if (!room.isAvailable()) {
            System.out.println("Room is not available.");
            return false;
        }

        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        reservationList.add(reservation);
        room.setAvailable(false);
        System.out.println("Reservation made successfully.");
        return true;
    }

    public void displayAllReservations() {
        if (reservationList.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            for (Reservation reservation : reservationList) {
                reservation.displayDetails();
                System.out.println("-----------------------------");
            }
        }
    }

    public Reservation findReservationByNumber(int reservationNumber) {
        for (Reservation reservation : reservationList) {
            if (reservation.getReservationNumber() == reservationNumber) {
                return reservation;
            }
        }
        return null;
    }

    public boolean updateReservation(int reservationNumber, Room newRoom, LocalDate newCheckInDate, LocalDate newCheckOutDate) {
        Reservation reservation = findReservationByNumber(reservationNumber);
        if (reservation == null) {
            System.out.println("Reservation not found.");
            return false;
        }

        // Bebaskan kamar lama
        reservation.getRoom().setAvailable(true);

        if (!newRoom.isAvailable()) {
            System.out.println("New room is not available.");
            reservation.getRoom().setAvailable(false); // revert
            return false;
        }

        // Set kamar baru & tanggal baru
        reservation.setRoom(newRoom);
        reservation.setCheckInDate(newCheckInDate);
        reservation.setCheckOutDate(newCheckOutDate);
        newRoom.setAvailable(false);

        System.out.println("Reservation updated successfully.");
        return true;
    }

    public boolean cancelReservation(int reservationNumber) {
        Iterator<Reservation> iterator = reservationList.iterator();
        while (iterator.hasNext()) {
            Reservation reservation = iterator.next();
            if (reservation.getReservationNumber() == reservationNumber) {
                reservation.getRoom().setAvailable(true);
                iterator.remove();
                System.out.println("Reservation cancelled successfully.");
                return true;
            }
        }
        System.out.println("Reservation not found.");
        return false;
    }

    public int getReservationCount() {
        return reservationList.size();
    }

    public void displayReservationCount() {
        System.out.println("Total Reservations: " + getReservationCount());
    }

    public boolean isReservationListEmpty() {
        return reservationList.isEmpty();
    }
}
