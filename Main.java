import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TransportSystem system = new TransportSystem();

        // SAMPLE DATA
        Vehicle bus = new Vehicle("V001", "KDA123A", 45);
        Vehicle taxi = new Vehicle("V002", "KBC456B", 4);

        Driver driver = new Driver("D001", "Francis", "DL12345");
        Passenger passenger = new Passenger("P001", "Jermaine");

        // ADD TO SYSTEM
        system.addVehicle(bus);
        system.addVehicle(taxi);
        system.addDriver(driver);
        system.addPassenger(passenger);

        // TRIPS
        Trip trip1 = new Trip(driver, passenger, bus);
        trip1.startTrip();
        trip1.completeTrip();

        Trip trip2 = new Trip(driver, passenger, taxi);

        system.addTrip(trip1);
        system.addTrip(trip2);

        // DISPLAY
        system.displayAll();

        // FILE OPERATIONS
        system.saveToFile("transport_data.txt");
        system.loadFromFile("transport_data.txt");

        scanner.close();
    }
}
