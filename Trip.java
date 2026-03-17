public class Trip implements Trackable {
    private Vehicle vehicle;
    private Driver driver;
    private Passenger passenger;
    private double distanceKm;
    private String status;

    public Trip(Vehicle vehicle, Driver driver, Passenger passenger, double distanceKm) {
        validateTripData(vehicle, driver, passenger, distanceKm);
        this.vehicle = vehicle;
        this.driver = driver;
        this.passenger = passenger;
        this.distanceKm = distanceKm;
        this.status = "CREATED";
    }
    
    private void validateTripData(Vehicle vehicle, Driver driver, Passenger passenger, double distanceKm) {
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle cannot be null");
        }
        if (driver == null) {
            throw new IllegalArgumentException("Driver cannot be null");
        }
        if (passenger == null) {
            throw new IllegalArgumentException("Passenger cannot be null");
        }
        if (distanceKm <= 0) {
            throw new IllegalArgumentException("Distance must be positive");
        }
    }

    public void startTrip() {
        try {
            validateTripStart();
            
            status = "STARTED";
            System.out.println("Trip started...");
            System.out.println("Driver: " + driver.getName() + " (" + driver.getRoleDescription() + ")");
            System.out.println("Passenger: " + passenger.getName() + " (" + passenger.getRoleDescription() + ")");

            vehicle.displayVehicleInfo();

            double fare = vehicle.calculateFare(distanceKm);
            System.out.printf("Distance: %.2f km%n", distanceKm);
            System.out.printf("Fare: KES %.2f%n", fare);

            try {
                passenger.makePayment(fare);
            } catch (Exception e) {
                System.err.println("Payment failed: " + e.getMessage());
                status = "PAYMENT_FAILED";
                throw new RuntimeException("Trip cancelled due to payment failure", e);
            }

            status = "COMPLETED";
            System.out.println("Trip completed successfully.");
            
        } catch (IllegalStateException e) {
            System.err.println("Cannot start trip: " + e.getMessage());
            status = "FAILED";
            throw e;
        } catch (RuntimeException e) {
            System.err.println("Unexpected error during trip: " + e.getMessage());
            status = "ERROR";
            throw new RuntimeException("Trip execution failed", e);
        }
    }
    
    private void validateTripStart() {
        if (!"CREATED".equals(status)) {
            throw new IllegalStateException("Trip can only be started from CREATED status. Current status: " + status);
        }
        if (driver.getAssignedVehicle() == null) {
            throw new IllegalStateException("Driver has no assigned vehicle");
        }
        if (!driver.getAssignedVehicle().equals(vehicle)) {
            throw new IllegalStateException("Driver's assigned vehicle does not match trip vehicle");
        }
    }

    @Override
    public String getStatus() {
        return status;
    }

    // Getters and setters with validation
    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle cannot be null");
        }
        this.vehicle = vehicle;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("Driver cannot be null");
        }
        this.driver = driver;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        if (passenger == null) {
            throw new IllegalArgumentException("Passenger cannot be null");
        }
        this.passenger = passenger;
    }

    public double getDistanceKm() {
        return distanceKm;
    }

    public void setDistanceKm(double distanceKm) {
        if (distanceKm <= 0) {
            throw new IllegalArgumentException("Distance must be greater than 0");
        }
        this.distanceKm = distanceKm;
    }
}
