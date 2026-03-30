import java.util.*;

// Booking class
class Booking {
    String guestName;
    String roomType;

    public Booking(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
}

// BookingHistory class
class BookingHistory {
    private List<Booking> bookings = new ArrayList<>();

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public List<Booking> getBookings() {
        return bookings;
    }
}

// BookingReportService class
class BookingReportService {

    public void generateReport(BookingHistory history) {
        System.out.println("\nBooking History Report\n");

        for (Booking b : history.getBookings()) {
            System.out.println("Guest: " + b.guestName + ", Room Type: " + b.roomType);
        }
    }
}

// MAIN CLASS
public class BookMyStayApp {
    public static void main(String[] args) {

        BookingHistory history = new BookingHistory();

        // Adding bookings
        history.addBooking(new Booking("Abhi", "Single"));
        history.addBooking(new Booking("Subha", "Double"));
        history.addBooking(new Booking("Vannathi", "Suite"));

        // Generate report
        BookingReportService reportService = new BookingReportService();

        System.out.println("Booking History and Reporting");
        reportService.generateReport(history);
    }
}