package managers;

import entities.Room;
import java.util.ArrayList;

public class RoomManagement {
    ArrayList<Room> roomList = new ArrayList<>();

    void addRoom(Room room) {
        roomList.add(room);
    }

    void displayRoomList() {
        for (Room room : roomList) {
            System.out.println(room.getRoomNumber());
        }
    }

    void findRoom(int roomNumber) {

    }

    void updateRoom(Room room, int newRoomNumber, int newPrice, int newCapacity, boolean newAvailability) {
        room.setRoomNumber(newRoomNumber);
        room.setPrice(newPrice);
        room.setCapacity(newCapacity);
        room.setAvailable(newAvailability);
    }

    void removeRoom(Room room) {
        roomList.remove(room);
    }
}
