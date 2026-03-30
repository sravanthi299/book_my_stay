import java.util.HashMap;
import java.util.Map;

// Reservation class
class Reservation {
    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }
}

// Room Inventory
class RoomInventory {
    private Map<String, Integer> availableRooms = new HashMap<>();

    public RoomInventory() {
        availableRooms.put("Single", 2);
        availableRooms.put("Double", 2);
        availableRooms.put("Suite", 1);
    }

    public boolean isAvailable(String roomType) {
        return availableRooms.getOrDefault(roomType, 0) > 0;
    }

    public void reduceRoom(String roomType) {
        availableRooms.put(roomType, availableRooms.get(roomType) - 1);
    }
}

// Allocation Service
class RoomAllocationService {
    private Map<String, Integer> roomCounters = new HashMap<>();

    public void allocateRoom(Reservation reservation, RoomInventory inventory) {
        String type = reservation.getRoomType();

        if (inventory.isAvailable(type)) {
            String roomId = generateRoomId(type);
            inventory.reduceRoom(type);

            System.out.println("Booking confirmed for Guest: "
                    + reservation.getGuestName()
                    + ", Room ID: " + roomId);
        } else {
            System.out.println("No rooms available for " + type);
        }
    }

    private String generateRoomId(String roomType) {
        int count = roomCounters.getOrDefault(roomType, 0) + 1;
        roomCounters.put(roomType, count);
        return roomType + "-" + count;
    }
}

// Main Class
public class BookMyStayApp{

    public static void main(String[] args) {

        System.out.println("Room Allocation Processing");

        RoomInventory inventory = new RoomInventory();
        RoomAllocationService service = new RoomAllocationService();

        Reservation r1 = new Reservation("Abhi", "Single");
        Reservation r2 = new Reservation("Subha", "Double");
        Reservation r3 = new Reservation("Vanmathi", "Suite");

        service.allocateRoom(r1, inventory);
        service.allocateRoom(r2, inventory);
        service.allocateRoom(r3, inventory);
    }
}