package entities;

public class RoomDeluxe extends Room {
    public RoomDeluxe(int roomNumber, int price, int capacity, boolean isAvailable) {
        super(roomNumber, price, capacity);
    }

    @Override
    public void displayDetails() {
        System.out.println("Room Deluxe");
        System.out.println("Room Number: " + getRoomNumber());
        System.out.println("Price: " + getPrice());
        System.out.println("Capacity: " + getCapacity());
        System.out.println("Is Available: " + isAvailable());
        System.out.println("Extra Fasilities: Sauna");
    }
}
