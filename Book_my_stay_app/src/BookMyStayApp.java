import java.util.*;

// Custom Exception
class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);
    }
}

// Room Inventory Class
class RoomInventory {
    public boolean isValidRoomType(String type) {
        return type.equals("Single") || type.equals("Double") || type.equals("Suite");
    }
}

// Booking Request Queue (Dummy for structure)
class BookingRequestQueue {
    public void addRequest(String name, String roomType) {
        System.out.println("Booking request added for " + name + " (" + roomType + ")");
    }
}

// Reservation Validator
class ReservationValidator {
    public void validate(String name, String roomType, RoomInventory inventory)
            throws InvalidBookingException {

        if (name == null || name.trim().isEmpty()) {
            throw new InvalidBookingException("Guest name cannot be empty.");
        }

        if (!inventory.isValidRoomType(roomType)) {
            throw new InvalidBookingException("Invalid room type selected.");
        }
    }
}

// Main Class
public class BookMyStayApp{

    public static void main(String[] args) {

        // Display application header
        System.out.println("Booking Validation");

        Scanner scanner = new Scanner(System.in);

        // Initialize required components
        RoomInventory inventory = new RoomInventory();
        ReservationValidator validator = new ReservationValidator();
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        try {
            // Accept user input
            System.out.print("Enter guest name: ");
            String name = scanner.nextLine();

            System.out.print("Enter room type (Single/Double/Suite): ");
            String roomType = scanner.nextLine();

            // Validate input
            validator.validate(name, roomType, inventory);

            // Add booking request
            bookingQueue.addRequest(name, roomType);

            System.out.println("Booking successful!");

        } catch (InvalidBookingException e) {
            // Handle domain-specific validation errors
            System.out.println("Booking failed: " + e.getMessage());

        } finally {
            scanner.close();
        }
    }
}