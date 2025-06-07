package entities;

public class RoomSuite extends Room {
    public RoomSuite(int roomNumber, int price, int capacity) {
        super(roomNumber, price, capacity);
    }

    @Override
    public void displayDetails() {
        System.out.println("Room Suite");
        System.out.println("Room Number: " + getRoomNumber());
        System.out.println("Price: " + getPrice());
        System.out.println("Capacity: " + getCapacity());
        System.out.println("Is Available: " + isAvailable());
        System.out.println("Extra Fasilities: Sauna, Pool");
    }
}
