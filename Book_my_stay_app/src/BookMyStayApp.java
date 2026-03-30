import java.util.*;

class Service {
    String name;
    double cost;

    public Service(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }
}

class ReservationService {
    private Map<String, List<Service>> reservationMap = new HashMap<>();

    public void addService(String reservationId, Service service) {
        reservationMap.putIfAbsent(reservationId, new ArrayList<>());
        reservationMap.get(reservationId).add(service);
    }

    public double calculateTotalServiceCost(String reservationId) {
        double total = 0;
        if (reservationMap.containsKey(reservationId)) {
            for (Service s : reservationMap.get(reservationId)) {
                total += s.cost;
            }
        }
        return total;
    }
}

public class BookMyStayApp {
    public static void main(String[] args) {

        ReservationService rs = new ReservationService();

        String reservationId = "Single-1";

        // Adding services
        rs.addService(reservationId, new Service("Breakfast", 500));
        rs.addService(reservationId, new Service("Spa", 700));
        rs.addService(reservationId, new Service("Airport Pickup", 300));

        // Calculate total cost
        double totalCost = rs.calculateTotalServiceCost(reservationId);

        // Output
        System.out.println("Add-On Service Selection");
        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Total Add-On Cost: " + totalCost);
    }
}