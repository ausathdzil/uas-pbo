package entities;

public class RoomStandard extends Room {
    public RoomStandard(int roomNumber, int price, int capacity) {
        super(roomNumber, price, capacity);
    }

    @Override
    public void displayDetails() {
        System.out.println("Room Standard");
        System.out.println("Room Number: " + getRoomNumber());
        System.out.println("Price: " + getPrice());
        System.out.println("Capacity: " + getCapacity());
        System.out.println("Is Available: " + isAvailable());
        System.out.println("Extra Fasilities: None");
    }
}
