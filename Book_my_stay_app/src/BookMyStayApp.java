import java.util.*;

// Room Inventory Class (Shared Resource)
class RoomInventory {
    private int availableRooms = 1; // Only 1 room to show race condition clearly

    // Synchronized method to avoid race condition
    public synchronized boolean bookRoom(String user) {
        if (availableRooms > 0) {
            System.out.println(user + " is trying to book...");

            try {
                Thread.sleep(1000); // simulate delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            availableRooms--;
            System.out.println(user + " successfully booked the room.");
            return true;
        } else {
            System.out.println(user + " failed to book. No rooms available.");
            return false;
        }
    }
}

// User Thread Class
class BookingThread extends Thread {
    private RoomInventory inventory;
    private String userName;

    public BookingThread(RoomInventory inventory, String userName) {
        this.inventory = inventory;
        this.userName = userName;
    }

    public void run() {
        inventory.bookRoom(userName);
    }
}

// Main Class
public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Concurrent Booking Simulation\n");

        RoomInventory inventory = new RoomInventory();

        // Multiple users (threads)
        Thread user1 = new BookingThread(inventory, "User1");
        Thread user2 = new BookingThread(inventory, "User2");
        Thread user3 = new BookingThread(inventory, "User3");

        // Start threads simultaneously
        user1.start();
        user2.start();
        user3.start();
    }
}