public class BookMyStayApp{

    // Abstract Class
    static abstract class Room {
        protected int numberOfBeds;
        protected int squareFeet;
        protected double pricePerNight;
        protected int availableRooms;   // NEW in version 3

        public Room(int numberOfBeds, int squareFeet, double pricePerNight, int availableRooms) {
            this.numberOfBeds = numberOfBeds;
            this.squareFeet = squareFeet;
            this.pricePerNight = pricePerNight;
            this.availableRooms = availableRooms;
        }

        public void displayRoomDetails() {
            System.out.println("Beds: " + numberOfBeds);
            System.out.println("Size: " + squareFeet + " sqft");
            System.out.println("Price per night: " + pricePerNight);
            System.out.println("Available Rooms: " + availableRooms);
        }
    }

    // SingleRoom
    static class SingleRoom extends Room {
        public SingleRoom() {
            super(1, 250, 1500.0, 5);
        }
    }

    // DoubleRoom
    static class DoubleRoom extends Room {
        public DoubleRoom() {
            super(2, 400, 2500.0, 3);
        }
    }

    // SuiteRoom
    static class SuiteRoom extends Room {
        public SuiteRoom() {
            super(3, 750, 5000.0, 2);
        }
    }

    // Main Method
    public static void main(String[] args) {

        System.out.println("Hotel Room Inventory Status\n");

        SingleRoom single = new SingleRoom();
        DoubleRoom doubleRoom = new DoubleRoom();
        SuiteRoom suite = new SuiteRoom();

        System.out.println("Single Room:");
        single.displayRoomDetails();
        System.out.println();

        System.out.println("Double Room:");
        doubleRoom.displayRoomDetails();
        System.out.println();

        System.out.println("Suite Room:");
        suite.displayRoomDetails();
    }
}