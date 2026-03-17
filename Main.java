import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.println("=== VEHICLE TRIP MANAGEMENT SYSTEM ===\n");
            
            
            Vehicle bus = createBus(scanner);
            Vehicle taxi = createTaxi(scanner);
            
            
            Driver driver = createDriver(scanner);
            Passenger passenger = createPassenger(scanner);
            
            System.out.println("\n=== SYSTEM INFORMATION ===");
            System.out.println("Driver role: " + driver.getRoleDescription());
            System.out.println("Passenger role: " + passenger.getRoleDescription());
            
            // Assign vehicle to driver
            assignVehicleWithHandling(scanner, driver, taxi, bus);
            
            // Create and manage trips
            manageTrips(scanner, driver, passenger, taxi, bus);
            
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            System.out.println("\n=== SYSTEM SHUTDOWN ===");
            System.out.println("Total Vehicles Created: " + Vehicle.getTotalVehicles());
            scanner.close();
            System.out.println("Scanner closed. Program terminated.");
        }
    }
    
    private static Bus createBus(Scanner scanner) {
        System.out.println("--- Create Bus ---");
        try {
            System.out.print("Enter Vehicle ID: ");
            String vehicleId = scanner.nextLine();
            
            System.out.print("Enter Plate Number: ");
            String plateNumber = scanner.nextLine();
            
            System.out.print("Enter Capacity: ");
            int capacity = Integer.parseInt(scanner.nextLine());
            
            System.out.print("Enter Fare per Km: ");
            double farePerKm = Double.parseDouble(scanner.nextLine());
            
            return new Bus(vehicleId, plateNumber, capacity, farePerKm);
            
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format. Using default values.");
            return new Bus("BUS001", "KDA 123A", 45, 30.0);
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid input: " + e.getMessage());
            return new Bus("BUS001", "KDA 123A", 45, 30.0);
        }
    }
    
    private static Taxi createTaxi(Scanner scanner) {
        System.out.println("\n--- Create Taxi ---");
        try {
            System.out.print("Enter Vehicle ID: ");
            String vehicleId = scanner.nextLine();
            
            System.out.print("Enter Plate Number: ");
            String plateNumber = scanner.nextLine();
            
            System.out.print("Enter Capacity: ");
            int capacity = Integer.parseInt(scanner.nextLine());
            
            System.out.print("Enter Base Fare: ");
            double baseFare = Double.parseDouble(scanner.nextLine());
            
            System.out.print("Enter Rate per Km: ");
            double ratePerKm = Double.parseDouble(scanner.nextLine());
            
            return new Taxi(vehicleId, plateNumber, capacity, baseFare, ratePerKm);
            
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format. Using default values.");
            return new Taxi("TAXI001", "KBC 456B", 4, 150.0, 60.0);
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid input: " + e.getMessage());
            return new Taxi("TAXI001", "KBC 456B", 4, 150.0, 60.0);
        }
    }
    
    private static Driver createDriver(Scanner scanner) {
        System.out.println("\n--- Create Driver ---");
        try {
            System.out.print("Enter Driver ID: ");
            String driverId = scanner.nextLine();
            
            System.out.print("Enter Driver Name: ");
            String name = scanner.nextLine();
            
            System.out.print("Enter License Number: ");
            String licenseNumber = scanner.nextLine();
            
            return new Driver(driverId, name, licenseNumber);
            
        } catch (Exception e) {
            System.err.println("Error creating driver. Using default.");
            return new Driver("D001", "Francis", "DL-778899");
        }
    }
    
    private static Passenger createPassenger(Scanner scanner) {
        System.out.println("\n--- Create Passenger ---");
        try {
            System.out.print("Enter Passenger ID: ");
            String passengerId = scanner.nextLine();
            
            System.out.print("Enter Passenger Name: ");
            String name = scanner.nextLine();
            
            return new Passenger(passengerId, name);
            
        } catch (Exception e) {
            System.err.println("Error creating passenger. Using default.");
            return new Passenger("P001", "Jermaine");
        }
    }
    
    private static void assignVehicleWithHandling(Scanner scanner, Driver driver, Vehicle taxi, Vehicle bus) {
        System.out.println("\n=== VEHICLE ASSIGNMENT ===");
        System.out.println("Select vehicle to assign:");
        System.out.println("1. Taxi");
        System.out.println("2. Bus");
        System.out.print("Choice: ");
        
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            
            switch (choice) {
                case 1 -> driver.assignVehicle(taxi);
                case 2 -> driver.assignVehicle(bus);
                default -> {
                    System.out.println("Invalid choice. Defaulting to Taxi.");
                    driver.assignVehicle(taxi);
                }
            }
        } catch (NumberFormatException e) {
            System.err.println("Invalid input. Defaulting to Taxi.");
            driver.assignVehicle(taxi);
        } catch (Exception e) {
            System.err.println("Error assigning vehicle: " + e.getMessage());
            driver.assignVehicle(taxi);
        }
    }
    
    private static void manageTrips(Scanner scanner, Driver driver, Passenger passenger, Vehicle taxi, Vehicle bus) {
        System.out.println("\n=== TRIP MANAGEMENT ===");
        
        try {
            // First trip with Taxi
            System.out.println("\n--- Trip 1 (Taxi) ---");
            System.out.print("Enter distance for taxi trip (km): ");
            double distance1 = Double.parseDouble(scanner.nextLine());
            
            Trip trip1 = new Trip(taxi, driver, passenger, distance1);
            executeTripSafely(trip1);
            
            // Second trip with Bus
            System.out.println("\n--- Trip 2 (Bus) ---");
            driver.assignVehicle(bus);
            System.out.print("Enter distance for bus trip (km): ");
            double distance2 = Double.parseDouble(scanner.nextLine());
            
            Trip trip2 = new Trip(bus, driver, passenger, distance2);
            executeTripSafely(trip2);
            
        } catch (NumberFormatException e) {
            System.err.println("Invalid distance input. Using default distances.");
            Trip trip1 = new Trip(taxi, driver, passenger, 12.5);
            Trip trip2 = new Trip(bus, driver, passenger, 10.0);
            executeTripSafely(trip1);
            executeTripSafely(trip2);
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid trip data: " + e.getMessage());
        }
    }
    
    private static void executeTripSafely(Trip trip) {
        try {
            System.out.println("Trip status: " + trip.getStatus());
            trip.startTrip();
            System.out.println("Trip status: " + trip.getStatus());
        } catch (Exception e) {
            System.err.println("Error during trip execution: " + e.getMessage());
        } finally {
            System.out.println("----------------------------------");
        }
    }
}
