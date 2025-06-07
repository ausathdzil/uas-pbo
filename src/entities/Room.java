package entities;

public abstract class Room {
    private int roomNumber;
    private int price;
    private int capacity;
    private boolean isAvailable;

    public Room(int roomNumber, int price, int capacity, boolean isAvailable) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.capacity = capacity;
        this.isAvailable = isAvailable;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    abstract void displayDetails();
}
