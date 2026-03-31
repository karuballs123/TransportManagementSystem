import java.util.*;
import java.io.*;

public class TransportSystem {

    private List<Vehicle> vehicles = new ArrayList<>();
    private List<Driver> drivers = new ArrayList<>();
    private List<Passenger> passengers = new ArrayList<>();
    private List<Trip> trips = new ArrayList<>();

    // ADD METHODS
    public void addVehicle(Vehicle v) { vehicles.add(v); }
    public void addDriver(Driver d) { drivers.add(d); }
    public void addPassenger(Passenger p) { passengers.add(p); }
    public void addTrip(Trip t) { trips.add(t); }

    // DISPLAY
    public void displayAll() {
        System.out.println("\n=== VEHICLES ===");
        vehicles.forEach(Vehicle::displayVehicleInfo);

        System.out.println("\n=== DRIVERS ===");
        drivers.forEach(d -> System.out.println(d.getName()));

        System.out.println("\n=== PASSENGERS ===");
        passengers.forEach(p -> System.out.println(p.getName()));

        System.out.println("\n=== TRIPS ===");
        trips.forEach(Trip::displayTrip);
    }

    // SAVE
    public void saveToFile(String file) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {

            bw.write("VEHICLES\n");
            for (Vehicle v : vehicles) {
                bw.write(v.getVehicleId() + "," + v.getPlateNumber() + "," + v.getCapacity());
                bw.newLine();
            }

            bw.write("DRIVERS\n");
            for (Driver d : drivers) {
                bw.write(d.getId() + "," + d.getName() + "," + d.getLicenseNumber());
                bw.newLine();
            }

            bw.write("PASSENGERS\n");
            for (Passenger p : passengers) {
                bw.write(p.getId() + "," + p.getName());
                bw.newLine();
            }

            bw.write("TRIPS\n");
            for (Trip t : trips) {
                bw.write(t.toFileString());
                bw.newLine();
            }

            System.out.println("Saved successfully.");

        } catch (IOException e) {
            System.out.println("Save error: " + e.getMessage());
        }
    }

    // LOAD (basic read)
    public void loadFromFile(String file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            System.out.println("\n--- FILE CONTENT ---");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Load error: " + e.getMessage());
        }
    }
}
