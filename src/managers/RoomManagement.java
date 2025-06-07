package managers;

import entities.Room;
import java.util.ArrayList;

public class RoomManagement {
    ArrayList<Room> roomList = new ArrayList<>();

    public void addRoom(Room room) {
        roomList.add(room);
    }

    public void displayRoomList() {
        if (roomList.isEmpty()) {
            System.out.println("Room List is Empty");
        } else {
            for (Room room : roomList) {
                room.displayDetails();
            }
        }
    }

    public void findRoom(int roomNumber) {
        for (Room room : roomList) {
            if (room.getRoomNumber() == roomNumber) {
                room.displayDetails();
            }
        }
    }

    public void updateRoom(Room room, int newRoomNumber, int newPrice, int newCapacity, boolean newAvailability) {
        room.setRoomNumber(newRoomNumber);
        room.setPrice(newPrice);
        room.setCapacity(newCapacity);
        room.setAvailable(newAvailability);
    }

    public void removeRoom(Room room) {
        roomList.remove(room);
    }
}
