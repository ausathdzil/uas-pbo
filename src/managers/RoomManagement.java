package managers;

import entities.Room;
import java.util.ArrayList;

public class RoomManagement {
    private ArrayList<Room> roomList = new ArrayList<>();

    public void addRoom(Room room) {
        roomList.add(room);
    }

    public void displayRoomList() {
        if (roomList.isEmpty()) {
            System.out.println("Daftar kamar kosong.");
        } else {
            for (Room room : roomList) {
                room.displayDetails();
                System.out.println("--------------------------");
            }
        }
    }

    public Room findRoom(int roomNumber) {
        for (Room room : roomList) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    public void updateRoom(Room room, int newRoomNumber, int newPricePerNight, int newCapacity, boolean newAvailability) {
        room.setRoomNumber(newRoomNumber);
        room.setPricePerNight(newPricePerNight); // diperbaiki dari setPrice → setPricePerNight
        room.setCapacity(newCapacity);
        room.setAvailable(newAvailability);
    }

    public void removeRoom(Room room) {
        roomList.remove(room);
    }

    public ArrayList<Room> getAllRooms() {
        return roomList;
    }

    public ArrayList<Room> getAvailableRooms() {
        ArrayList<Room> availableRooms = new ArrayList<>();
        for (Room room : roomList) {
            if (room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }
}
