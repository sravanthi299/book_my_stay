class Room {
    String type;
    int beds;
    int size;
    double price;
    int available;

    Room(String type, int beds, int size, double price, int available) {
        this.type = type;
        this.beds = beds;
        this.size = size;
        this.price = price;
        this.available = available;
    }

    void display() {
        System.out.println(type + ":");
        System.out.println("Beds: " + beds);
        System.out.println("Size: " + size + " sqft");
        System.out.println("Price per night: " + price);
        System.out.println("Available: " + available);
        System.out.println();
    }
}

public class BookMyStayApp{
    public static void main(String[] args) {
        System.out.println("Room Search\n");

        Room r1 = new Room("Single Room", 1, 250, 1500.0, 5);
        Room r2 = new Room("Double Room", 2, 400, 2500.0, 3);
        Room r3 = new Room("Suite Room", 3, 750, 5000.0, 2);

        r1.display();
        r2.display();
        r3.display();
    }
}