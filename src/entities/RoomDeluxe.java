package entities;

public class RoomDeluxe extends Room {
    public RoomDeluxe(int roomNumber, int price, int capacity) {
        super(roomNumber, price, capacity);
    }

    @Override
    public String getType() {
    return "Deluxe";
    }

    public void displayDetails() {
        System.out.println("===== Room Deluxe =====");
        System.out.println("Room Number: " + getRoomNumber());
        System.out.println("Price: " + getPricePerNight());
        System.out.println("Capacity: " + getCapacity());
        System.out.println("Available: " + isAvailable());
        System.out.println("Extra Fasilities: Sauna");
    }
}
