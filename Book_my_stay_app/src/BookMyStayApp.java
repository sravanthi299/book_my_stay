import java.util.*;

// Room Inventory Class
class RoomInventory {
    private Map<String, Integer> rooms = new HashMap<>();

    public RoomInventory() {
        rooms.put("Single", 5);
        rooms.put("Double", 3);
        rooms.put("Suite", 2);
    }

    public void restoreRoom(String type) {
        rooms.put(type, rooms.getOrDefault(type, 0) + 1);
    }

    public int getAvailability(String type) {
        return rooms.getOrDefault(type, 0);
    }
}

// Booking Manager Class
class BookingManager {
    private Stack<String> rollbackStack = new Stack<>();

    public void cancelBooking(String reservationId, RoomInventory inventory) {
        // Extract room type from reservation ID (e.g., Single-1)
        String roomType = reservationId.split("-")[0];

        // Restore inventory
        inventory.restoreRoom(roomType);

        // Push to rollback history
        rollbackStack.push(reservationId);

        System.out.println("Booking cancelled successfully. Inventory restored for room type: " + roomType);
    }

    public void showRollbackHistory() {
        System.out.println("\nRollback History (Most Recent First):");
        for (int i = rollbackStack.size() - 1; i >= 0; i--) {
            System.out.println("Released Reservation ID: " + rollbackStack.get(i));
        }
    }
}

// Main Class
public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Booking Cancellation");

        RoomInventory inventory = new RoomInventory();
        BookingManager manager = new BookingManager();

        // Example reservation ID (as shown in output)
        String reservationId = "Single-1";

        // Cancel booking
        manager.cancelBooking(reservationId, inventory);

        // Show rollback history
        manager.showRollbackHistory();

        // Show updated availability
        String roomType = reservationId.split("-")[0];
        System.out.println("\nUpdated " + roomType + " Room Availability: "
                + inventory.getAvailability(roomType));
    }
}